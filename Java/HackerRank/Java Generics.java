// https://www.hackerrank.com/challenges/java-generics

public static <E> void printArray(E[] inputArray) {
  for (int i = 0; i < inputArray.length; ++i) {
      System.out.println(inputArray[i]);
  }
}
