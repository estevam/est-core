/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.language;

import com.est.db.ConnectionDbException;
import com.est.db.LanguageReader;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author estevam
 */
public class LoadLanguage {

    private ResourceBundle iLanguage;

    public ResourceBundle getLanguage() {
        return iLanguage;
    }

    public void initLanguage() throws SQLException {

        LanguageReader lan = new LanguageReader();

        String boxlanguage = "";
        String boxCountry = "";

        try {
            boxlanguage = lan.getLanguage();
        } catch (ConnectionDbException ex) {
        } catch (SQLException ex) {
        }

        if ("en".equals(boxlanguage)) {

            boxCountry = "UK";

        } else if ("es".equals(boxlanguage)) {

            boxCountry = "ES";
        }

        Locale languageTarget = new Locale(boxlanguage, boxCountry);

        iLanguage = ResourceBundle.getBundle("com.est.language."
                + "language.Language", languageTarget);
    }
}
