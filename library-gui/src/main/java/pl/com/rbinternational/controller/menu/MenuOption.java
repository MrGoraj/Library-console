package pl.com.rbinternational.controller.menu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Component
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MenuOption {

    String code() default "";

    String description() default "";

    String parent() default "";
}
