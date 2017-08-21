package net.dvt32.regexandvalidation.task4;

/**
 * This program sorts objects 
 * of child classes of AnnotationSorter,
 * according to their value attribute and 
 * by using the Sort annotation
 * and the Arrays.sort() method.
 * 
 * If the annotation's order attribute:
 * 
 * -> ... is set to "ascending" (case insensitive), 
 * the objects will be sorted in ascending order 
 * (the objects with the lowest value will be first)
 * 
 * -> ... is set to "descending" (case insensitive), 
 * the objects will be sorted in descending order 
 * (the objects with the highest value will be first).
 * 
 * -> ... is set to something else (or not set to anything), 
 * the objects will not be sorted
 * 
 * The program implements the Comparable interface,
 * in order to override the default way Arrays.sort() sorts.
 * 
 * The AnnotationSorter class is abstract, 
 * because we're only sorting its child class objects.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
@Sort(order = "descending")
public abstract class AnnotationSorter 
	implements Comparable<AnnotationSorter> 
{
	private int value;
	private final String SORT_ORDER = getSortOrderFromAnnotation();
	
	/**
	 * Constructor for every child class, 
	 * which requires them to specify an integer value,
	 * which will be used for sorting.
	 * 
	 * @param value The value used for sorting the objects.
	 */
	public AnnotationSorter(int value) {
		this.value = value;
	}
	
	/*
	 * Getters/setters
	 */
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * This method retrieves the Sort annotation's 'order' attribute value.
	 * 
	 * This value is later used to determine 
	 * how to sort the AnnotationSorter child class objects.
	 * 
	 * @return The value of the Sort class annotation's 'order' attribute in String form
	 */
	public static String getSortOrderFromAnnotation() {
		Sort sortAnnotation = AnnotationSorter.class.getAnnotation(Sort.class);
		String orderAttributeValue = sortAnnotation.order();
		return orderAttributeValue;
	}
	
	/**
	 * This method overrides the default compareTo() function,
	 * so that it is possible for Arrays.sort() 
	 * to sort the AnnotationSorter child class objects.
	 *
	 * The sort order is determined by the Sort class annotation.
	 * If it's "ascending" -> objects will be sorted in ascending value order.
	 * If it's "descending" -> objects will be sorted in descending value order.
	 * Otherwise they will not be sorted.
	 * 
	 * The caller of this method is the object, 
	 * which we're comparing to the parameter object.
	 * 
	 * @param obj The object we're comparing values with
	 */
	@Override
	public int compareTo(AnnotationSorter obj) {
		int callerObjectValue = this.getValue();
		int paramObjectValue = obj.getValue();

		if (SORT_ORDER.equalsIgnoreCase("ascending")) {
			return callerObjectValue - paramObjectValue;
		}
		else if (SORT_ORDER.equalsIgnoreCase("descending")){
			return paramObjectValue - callerObjectValue;
		}
		else {
			return 0;
		}
	}
}