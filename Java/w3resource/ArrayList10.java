// 10. Write a Java program to shuffle elements in a array list.

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("Element 1");
    list.add("Element 2");
    list.add("Element 3");
    
    Collections.shuffle(list);
    
    System.out.println(list);
 }
}
