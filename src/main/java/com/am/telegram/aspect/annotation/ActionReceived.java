package com.am.telegram.aspect.annotation;

import com.am.telegram.aspect.action.MessageReceived;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionReceived {

    MessageReceived value();

}
