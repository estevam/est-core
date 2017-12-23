

package com.est.reflection.my.annotations.parameter;

/**
 *
 * @author estevam
 */


public class Test extends ActionAnnotation{
    
    
    public Test(){
       startAnnottion(this);
    }
    public static void main(String[] args) {
        Test  a = new Test();
        a.getList();
    }
    
    @Login(name ="test", pass="test")
    public void getList(){
        
        System.out.println("end ...");
    }
}
