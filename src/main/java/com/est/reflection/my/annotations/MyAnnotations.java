package com.est.reflection.my.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class MyAnnotations {

    private final String LOGIN_ANNOTTION ="@com.est.reflection.my.annotations.Login()";


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
                if (sn.toString().equals(LOGIN_ANNOTTION)) {
                    System.out.println("My annotion was called!");
                }
            }
        }

    }
/**
    private Method getCurrentMethod() {
        try {
            final StackTraceElement[] stes = Thread.currentThread().getStackTrace();
            final StackTraceElement ste = stes[stes.length - 1];
            final String methodName = ste.getMethodName();
            final String className = ste.getClassName();
            final Class<?> currentClass = Class.forName(className);
            return currentClass.getDeclaredMethod(methodName);
        } catch (Exception cause) {
            throw new UnsupportedOperationException(cause);
        }
    }

    private Object getArgumentFromMethodWithAnnotation(Method method, Class<?> annotation) {
        final Annotation[][] paramAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotations : paramAnnotations) {
            for (Annotation an : annotations) {
                System.out.println(an.toString());
            }
        }
        return null;
    }
*/
}
