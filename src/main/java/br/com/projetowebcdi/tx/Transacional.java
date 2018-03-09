package br.com.projetowebcdi.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * 
 * Ela deve interceptar metodo e tambem devera ter o retention de class,
 * em cima de class é chamado de type, 
 * pois na classe será informado sua função
 *
 */

@InterceptorBinding //diz que esta anotação será usada para interceptar
@Target( { ElementType.METHOD, ElementType.TYPE } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Transacional {

}
