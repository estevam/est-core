package com.est.reflection.my.annotations.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author estevam
 */
//@Documented // -> indicates that elements using this annotation should be documented by javadoc and similar tools.
//@Target(ElementType.METHOD) // --> indicates the kinds of program element to which an annotation type is applicable. Some possible values are TYPE, METHOD, CONSTRUCTOR, FIELD etc. 
//@Inherited // -> indicates that an annotation type is automatically inherited.@NameBinding


// A anotação @Target serve para indicar o alvo desta anotação:
// ElementType.TYPE -> será uma anotação de classe, interface ou enum;
// ElementType.FIELD -> será uma anotação de atributo;
// ElementType.METHOD -> será uma anotação de método;
// ElementType.CONSTRUCTOR -> será uma anotação de construtor;
// ElementType.ANNOTATION_TYPE -> será uma anotação de anotação;
// ElementType.LOCAL_VARIABLE -> será uma anotação de variável local;
// ElementType.PACKAGE -> será uma anotação de pacote;
// ElementType.PARAMETER -> será uma anotação de parâmetro.

//A anotação @Retention indica quando que esta anotação será usada:
//RetentionPolicy.SOURCE -> será utilizada apenas no código fonte: é descartada pelo compilador e pela VM;
//RetentionPolicy.CLASS -> será gravada na classe, mas não será utilizada pela VM;
//RetentionPolicy.RUNTIME -> será gravada na classe e utilizada pela VM, assim, pode ser lida por reflexão

@Target(ElementType.METHOD) //on class level
@Retention(RetentionPolicy.RUNTIME) // -->  indicates how long annotations with the annotated type are to be retained. It takes RetentionPolicy argument whose Possible values are SOURCE, CLASS and RUNTIME
public @interface Login {

    String name();
    String pass();
    
    boolean compareSources() default true;
    
    //int num();
}
