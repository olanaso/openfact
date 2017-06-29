package org.openfact.testsuite.arquillian.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author mhajas
 */
@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface UseServletFilter {

    String filterDependency();
    String filterName();
    String filterClass();
    String filterPattern() default "/*";
    String dispatcherType() default "";
    String skipPattern() default "";
}
