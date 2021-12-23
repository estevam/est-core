/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.download_manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;


/**
 *
 * @author estevam
 */
@SuppressWarnings("deprecation")
public class Download extends Observable implements Runnable {

    private static final int MAX_BUFFER_SIZE = 1024;
    public static final String STATUSES[] = {"Downloading", "Pause", "Complete", "Cancelled", "Error"};
    public static final int DOWNLOADING = 0;
    public static final int PAUSED = 1;
    public static final int COMPLETE = 2;
    public static final int CANCELLED = 3;
    public static final int ERROR = 4;
    private URL url;
    private int size;
    private int downloaded;
    private int status;

    public Download(URL url) {
        this.url = url;
        size = -1;
        downloaded = 0;
        status = DOWNLOADING;


        download();

    }

    public String getUrl() {
        return url.toString();
    }

    public int getSize() {
        return size;
    }

    public float getProcess() {
        return ((float) downloaded / size) * 1000;
    }

    public int getStatus() {
        return status;
    }

    public void pause() {
        status = PAUSED;
        stateChanged();
    }

    public void resume() {
        status = DOWNLOADING;
        stateChanged();
        download();

    }

    public void cancel() {
        status = CANCELLED;
        stateChanged();
    }

    private void error() {
        status = CANCELLED;
        stateChanged();

    }

    private void download() {
        Thread thread = new Thread(this);
        thread.start();
    }

    private String getFileName(URL url) {
        String fileName = url.getFile();
        return fileName.substring(fileName.lastIndexOf("/"), +1);

    }

    @Override
    public void run() {
        RandomAccessFile file = null;
        InputStream stream = null;

        try {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("range", "bytes=" + downloaded + "-");
            connection.connect();
            // make sure response code is in the 200 range
            if (connection.getResponseCode() / 100 != 2) {
                error();
            }

            int contentLength = connection.getContentLength();
            // check for valid content lenght.
            if (contentLength < 1) {
                error();
            }
            // set the size for this download if it
            if (size == -1) {
                size = contentLength;
                stateChanged();
            }

            // Open file and seek to the end of it

            file = new RandomAccessFile(getFileName(url), "rw");
            file.seek(downloaded);

            stream = connection.getInputStream();

            while (status == DOWNLOADING) {
                // buffer according to how much of the file left to download
                byte buffer[];
                if (size - downloaded > MAX_BUFFER_SIZE) {
                    buffer = new byte[MAX_BUFFER_SIZE];
                } else {
                    buffer = new byte[size - downloaded];
                }
                // read from server into buffer
                int read = stream.read(buffer);

                if (read == -1) {
                    break;
                }
                // write buffer to file
                file.write(buffer, 0, read);
                downloaded += read;
                stateChanged();


            }



            /* 
             * Change status to complete if this point was reached because 
             * downloading has finished
             */

            if (status == DOWNLOADING) {
                status = COMPLETE;
                stateChanged();
            }


        } catch (IOException ex) {
            error();
        } finally {
            // close file
            if (file != null) {
                try {
                    file.close();
                } catch (Exception e) {}
            }
        }
    }

    // notify obeservers that this download's status has changed
    private void stateChanged() {
        setChanged();
        notifyObservers();
    }
}
