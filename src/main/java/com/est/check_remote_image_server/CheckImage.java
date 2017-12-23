package com.est.check_remote_image_server;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author estevam
 */
public class CheckImage {

    /**
     * @param aURLName
     * @return
     */
    public static boolean checkRemoteImageServer(String aURLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(aURLName).openConnection();
            con.setRequestMethod("HEAD");
            System.out.println(HttpURLConnection.HTTP_OK);
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean imageExists(URL url) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
            if (image == null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (image != null) {
                image.flush();
            }
        }

        return true;
    }
}
