package net.dvt32.regexandvalidation.task4;

import java.lang.annotation.*;

/**
 * This annotation is used to determine 
 * how to sort AnnotationSorter child class objects.
 * 
 * It has the Inherited annotation, so that every child class object
 * knows what the determined sort order is (it inherits the annotation + its values)
 * 
 * It has a RUNTIME retention, so that the annotation's 
 * significance remains when the program has been compiled and started.
 * 
 * In order for it to be possible to entirely skip entering a value for 'order'
 * when using the annotation, there needs to be a default value specified.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Sort {
	String order() default "";
}