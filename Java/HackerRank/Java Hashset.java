// https://www.hackerrank.com/challenges/java-hashset

Set<String> mySet = new HashSet<String>();

for (int i = 0; i < pair_left.length /* or pair_right.length */; ++i) {
  mySet.add(new String(pair_left[i] + " " + pair_right[i]));
  int numberOfUniquePairs = mySet.size();
  System.out.println(numberOfUniquePairs);
}
