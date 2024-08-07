package com.comst.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.hilt.GeneratesRootInput;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@GeneratesRootInput
public @interface InstallBinding {

    Class<?> component();
}
