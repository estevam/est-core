package com.est.http;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author estevam
 */
public class HttpUrlConnection {

    public static void main(String args[]) {

        String url = "http://www.google.ca/";
        @SuppressWarnings("unused")
		String status = checkRemoteImageServer(url);

    }

    /**
     * @param aURLName
     * @return
     */
    public static String checkRemoteImageServer(String aURLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con =
                    (HttpURLConnection) new URL(aURLName).openConnection();
            con.setRequestMethod("HEAD");

            System.out.println(con.getConnectTimeout());
            System.out.println(con.getErrorStream());
            System.out.println("test: " + con.getResponseCode());

            int response = con.getResponseCode();
            System.out.println("-->" + con.getResponseCode());
            switch (response) {
                case 200:
                    System.out.println("Http status: " + HttpURLConnection.HTTP_OK);

                    break;
                case 202:
                    System.out.println("HTTP status accepted code:" + HttpURLConnection.HTTP_ACCEPTED);
                    break;
                case 400:
                    System.out.println("HTTP bad request code: " + HttpURLConnection.HTTP_BAD_REQUEST);
                    break;
                case 401:
                    System.out.println("HTTP  Unauthorized: " + HttpURLConnection.HTTP_UNAUTHORIZED);
                    break;
                case 402:
                    System.out.println("HTTP  Payment Required: " + HttpURLConnection.HTTP_PAYMENT_REQUIRED);
                    break;
                case 403:
                    System.out.println("HTTP forbidden code: " + HttpURLConnection.HTTP_FORBIDDEN);
                    break;
                case 404:
                    System.out.println("HTTP not found code: " + HttpURLConnection.HTTP_NOT_FOUND);
                    break;
                case 405:
                    System.out.println("HTTP Method Not Allowed: " + HttpURLConnection.HTTP_BAD_METHOD);
                    break;
                case 406:
                    System.out.println("HTTP Not Acceptable: " + HttpURLConnection.HTTP_NOT_ACCEPTABLE);
                    break;
                case 409:
                    System.out.println("HTTP conflict: " + HttpURLConnection.HTTP_CONFLICT);
                    break;
                case 415:
                    System.out.println("HTTP Unsupported Media Type: " + HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
                    break;
                case 500:
                    System.out.println("HTTP Internal Server Error: " + HttpURLConnection.HTTP_INTERNAL_ERROR);
                    break;
                case 501:
                    System.out.println("HTTP Not Implemented: " + HttpURLConnection.HTTP_NOT_IMPLEMENTED);
                    break;
                case 504:
                    System.out.println("HTTPGateway Timeout: " + HttpURLConnection.HTTP_GATEWAY_TIMEOUT);
                    break;
                default:
                    System.out.println("Serach for code HTTP: " + response);
                    break;

            }
            return "";
            //return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            System.out.println(e);
            return "erro";
        }
    }
}
