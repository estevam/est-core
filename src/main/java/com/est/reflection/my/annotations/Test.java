package com.est.reflection.my.annotations;

/**
 *
 * @author estevam
 */
public class Test extends MyAnnotations {

    public Test() {
       startAnnottion(this);
    }

    public static void main(String[] args) {

        Test a = new Test();
        a.getList();

    }

    @Login
    public void getList() {
        System.out.println("end...");
    }

}
