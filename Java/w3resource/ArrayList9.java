// 9. Write a Java program to copy one array list into another.

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> list1 = new ArrayList<String>();
    list1.add("Element 1");
    list1.add("Element 2");
    list1.add("Element 3");
    list1.add("Element 4");
    
    List<String> list2 = new ArrayList<String>();
    list2.add("Element 5");
    
    System.out.println("List 1 (before copy): " + list1);
    System.out.println("List 2 (before copy): " + list2);
    
    Collections.copy(list1, list2);
    
    System.out.println("List 1 (after copy): " + list1);
    System.out.println("List 2 (after copy): " + list2);
 }
}
