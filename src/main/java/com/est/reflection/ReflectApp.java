package com.est.reflection;

/**
 *
 * @author estevam
 */
import java.lang.reflect.Method;

/**
 * Java Reflection makes it possible to inspect classes, interfaces, fields and
 * methods at runtime, without knowing the names of the classes, methods etc. at
 * compile time. It is also possible to instantiate new objects, invoke methods
 * and get/set field values using reflection.
 *
 * @author estevam
 */
public class ReflectApp {

    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {

        //no paramater

		Class noparams[] = {};

        //String parameter
      
		Class[] paramString = new Class[1];
        paramString[0] = String.class;

        //int parameter

		Class[] paramInt = new Class[1];
        paramInt[0] = Integer.TYPE;

        try {
            //load the AppTest at runtime
            Class cls = Class.forName("com.est.reflection.AppTest");
            Object obj = cls.newInstance();

            //call the printIt method
            Method method = cls.getDeclaredMethod("printIt", noparams);
           // method.invoke(obj, null);

            //call the printItString method, pass a String param 
            method = cls.getDeclaredMethod("printItString", paramString);
            method.invoke(obj, new String("Estevam"));

            //call the printItInt method, pass a int param
            method = cls.getDeclaredMethod("printItInt", paramInt);
            method.invoke(obj, 123);

            //call the setCounter method, pass a int param
            method = cls.getDeclaredMethod("setCounter", paramInt);
            method.invoke(obj, 999);

            //call the printCounter method
            method = cls.getDeclaredMethod("printCounter", noparams);
          //  method.invoke(obj, null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
