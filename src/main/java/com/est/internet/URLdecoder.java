 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.internet;

import java.net.URLDecoder;

/**
 *
 * @author estevam
 */
public class URLdecoder {
    public static void main(String[] args) throws Exception {
    String url = "http://www.%20test.com/";
    String decoded = URLDecoder.decode(url, "UTF-8");
    System.out.println(decoded);
  }
}
