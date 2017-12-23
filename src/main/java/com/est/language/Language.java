/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.language;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author estevam
 */
public class Language {

   @SuppressWarnings("unused")
   private ResourceBundle iLanguage;
   private LoadLanguage iLoadLanguage;
  
   public void  loadLanguage() throws SQLException{

     iLoadLanguage.initLanguage();
     iLanguage = iLoadLanguage.getLanguage();
   
   }

}
