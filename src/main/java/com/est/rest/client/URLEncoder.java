package com.est.rest.client;

/**
 *
 * @author estevam
 */
import com.est.entity.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLEncoder {

//Usar o URL encoder para codificar String quando fazer o POST no REST porque na String pode ter caracteres como:
// = [ { } ] \ | !@#$%^&*
//
//ele vai codificar a url
    public  static void main(String[] args) {
     
        boolean status = HttpActionSimples.checkHTTPstatus(UserModel.ROOT_URL + UserModel.SERVICE_URL_USER);
        System.out.print(status);
        UserModel u = new UserModel();
        try {
            List<User>  test = u.getUser();
            System.out.println(test);
        } catch (IOException ex) {
            Logger.getLogger(URLEncoder.class.getName()).log(Level.SEVERE, ex.toString());
        }

    }

    public String urlEncoder(String aUrl) {
        String url = "";
        try {
            url = java.net.URLEncoder.encode(aUrl, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(URLEncoder.class.getName()).log(Level.SEVERE, ex.toString());
        }

        return url;
    }
    public String urlDecoder(String aUrl) {
        String url = "";
        try {
            url = java.net.URLDecoder.decode(aUrl, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(URLEncoder.class.getName()).log(Level.SEVERE, ex.toString());
        }

        return url;
    }
}
