
package com.est.token;

//import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
/**
 * ==>> Base64 Encoding Example in Java you need to download and add
 * commons-codec-1.9.jar token format :ZSBiYXNlNjQgZW5jb2RpbmcgaW4gSmF2YQ==
 *
 * @author estevam
 */
public class TestBase64 {

    public static void main(String args[]) throws Exception {
        TestBase64 test = new TestBase64();
        System.out.println("Endoce:" + test.encodeBase64("User:Estevam Meneses"));
        System.out.println("Decode:" + test.decodeBase64(test.encodeBase64("User:Estevam Meneses")));
    }

    public String encodeBase64(String aTest) {

        // Get bytes from string
        byte[] byteArray = Base64.encodeBase64(aTest.getBytes());

        // Print the encoded byte array
        //System.out.println(Arrays.toString(byteArray));
        // Print the encoded string
        String encodedString = new String(byteArray);

        return encodedString;

    }

    public String decodeBase64(String aTest) {

      // Get bytes from string
        byte[] byteArray = Base64.decodeBase64(aTest.getBytes());

  // Print the decoded array
       // System.out.println(Arrays.toString(byteArray));

  // Print the decoded string 
        String decodedString = new String(byteArray);

       // System.out.println(aTest + " = " + decodedString);

        return decodedString;
    }
}
