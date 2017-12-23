package com.est.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author estevam
 */
public class SSLTrustManager {

    /**
     * Trust all Certificate SSL
     */
    public HttpURLConnection addTrustAllCertificate(String aURL) {

        URL url;
        HttpsURLConnection con = null;

        try {

            SSLContext ssl_ctx = SSLContext.getInstance("TLS");
            TrustManager[] trust_mgr = getTrustMgr();

            ssl_ctx.init(null, // key manager
                    trust_mgr, // trust manager
                    new SecureRandom()); // random number generator
            HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());

            url = new URL(aURL);
            con = (HttpsURLConnection) url.openConnection();
            con.setSSLSocketFactory(ssl_ctx.getSocketFactory());

            con.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String host, SSLSession sess) {
                    return true;
                }
            });
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyManagementException e) {
        }

        return con;
    }

    private TrustManager[] getTrustMgr() {
        TrustManager[] certs = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String t) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String t) {
                }
            }
        };

        return certs;
    }
}
