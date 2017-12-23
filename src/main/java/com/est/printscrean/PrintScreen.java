/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.printscrean;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * @author estevam
 */
public class PrintScreen {

    
     public static void main(String[] args) {
        try{
            BufferedImage imagem = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
            String data = dateFormat.format(new Date());
            
            File file = new File("/home/estevam/" + data + ".jpg");
            ImageIO.write(imagem, "jpg", file);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            System.out.println("Erro: " + e);
        }
    }
    
    
}

