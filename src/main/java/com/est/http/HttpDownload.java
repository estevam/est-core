package com.est.http;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/**
 * This class downloads a file from a URL.
 * @author Jeremy Hsu
 */
public class HttpDownload extends Observable implements Runnable {

    // Max size of download buffer.
    private static final int MAX_BUFFER_SIZE = 1024;
    // These are the status names.
    public static final String STATUSES[] = {"Downloading",
        "Paused", "Complete", "Cancelled", "Error"};
    // These are the status codes.
    public static final int DOWNLOADING = 0;
    public static final int PAUSED = 1;
    public static final int COMPLETE = 2;
    public static final int CANCELLED = 3;
    public static final int ERROR = 4;
    private URL url; // download URL
    private int iSize; // size of download in bytes
    private int downloaded; // number of bytes downloaded
    private int status; // current status of download
    private String iFilePath; // the saved path;
    private String iFilePathCached;

    private static final String TAG_DOWNLOAD = ".cache";
      
    public HttpDownload(URL url, String aFilePath) {
        iFilePath = aFilePath;
        this.url = url;
        
        init();
    }
    
    private void init() {
        iSize = -1;
        downloaded = 0;
        status = DOWNLOADING;
        iFilePathCached = iFilePath + TAG_DOWNLOAD;
    }

    // Get this download's URL.
    public String getUrl() {
        return url.toString();
    }
    
    public String getFilePath() {
        return iFilePath.toString();
    }

    // Get this download's size.
    public int getSize() {
        return iSize;
    }

    // Get this download's progress.
    public float getProgress() {
        return ((float) downloaded / iSize) * 100;
    }

    // Get this download's status.
    public int getStatus() {
        return status;
    }

    // Pause this download.
    public void pause() {
        status = PAUSED;
        stateChanged();
    }

    // Resume this download.
    public void resume() {
        status = DOWNLOADING;
        stateChanged();
        download();
    }
    
    // Cancel this download.
    public void cancel() {
        status = CANCELLED;
        stateChanged();
    }

    // Mark this download as having an error.
    private void error() {
        status = ERROR;
        stateChanged();
    }

    // Start or resume downloading.
    public void download() {
        Thread thread = new Thread(this);
        thread.start();
    }

    // Download file.
    @Override
    public void run() {
        RandomAccessFile file = null;
        InputStream stream = null;

        try {
            // Open connection to URL.
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            // Specify what portion of file to download.
            connection.setRequestProperty("Range",
                    "bytes=" + downloaded + "-");

            // Connect to server.
            connection.connect();

            // Make sure response code is in the 200 range.
            if (connection.getResponseCode() / 100 != 2) {
                error();
            }

            // Check for valid content length.
            int contentLength = connection.getContentLength();
            if (contentLength < 1) {
                System.out.println("no content length: " + url.toString());
                //error();
                contentLength = -2;
            }

            /*
             * Set the size for this download if it hasn't been already set.
             */
            if (iSize == -1) {
                iSize = contentLength;
                stateChanged();
            }

            // Open file and seek to the end of it.
            file = new RandomAccessFile(iFilePathCached, "rw");
            file.seek(downloaded);

            stream = connection.getInputStream();
            byte buffer[] = new byte[MAX_BUFFER_SIZE];
            while (status == DOWNLOADING) {
               
                int read = stream.read(buffer);
                if (read == -1) {
                    break;
                }

                file.write(buffer, 0, read);
                downloaded += read;
                stateChanged();
            }

            /*
             * Change status to complete if this point was reached because
             * downloading has finished.
             */
            if (status == DOWNLOADING) {
                status = COMPLETE;
                stateChanged();
            }
        }
        catch (Exception e) {
            error();
        }
        finally {
            // Close file.
            if (file != null) {
                try {
                    file.close();
                }
                catch (Exception e) {
                }
            }

            // Close connection to server.
            if (stream != null) {
                try {
                    stream.close();
                }
                catch (Exception e) {
                }
            }
        }
    }

    // Notify observers that this download's status has changed.
    private void stateChanged() {
        
        if (status == COMPLETE) {
            String old = iFilePathCached;
            String filename = iFilePath;
            
            File oldf = new File(old);
            File newf = new File(filename);
            oldf.renameTo(newf);
        }
        
        setChanged();
        notifyObservers();
    }
}
