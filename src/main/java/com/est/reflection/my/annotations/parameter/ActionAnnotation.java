package com.est.reflection.my.annotations.parameter;

import com.est.reflection.my.annotations.MyAnnotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class ActionAnnotation {

    private final String LOGIN_ANNOTTION = "@com.est.reflection.my.annotations.parameter.Login";

    public ActionAnnotation() {

    }

    public void startAnnottion(Object aObject) {

        Method[] methods = null;

        try {
            methods = Class.forName(aObject.getClass().getName()).getMethods();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyAnnotations.class.getName()).log(Level.SEVERE, ex.toString());
        }

        for (Method method : methods) {
            Annotation[] anno = method.getAnnotations();

            for (Annotation sn : anno) {
                System.out.println(sn);
                if (sn.toString().startsWith(LOGIN_ANNOTTION)) {
                       Login m = (Login) sn;
                       
                    System.out.println("My annotion was called!");
                    System.out.println("name: " +m.name());
                    System.out.println("pass: " +m.pass());
                }
            }
        }

    }

    public void show() {
        System.out.println("Show !");
    }

}
