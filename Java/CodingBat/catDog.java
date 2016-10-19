// http://codingbat.com/prob/p111624

public boolean catDog(String str) {
  int numberOfCatInstances = 0;
  int numberOfDogInstances = 0;
  for (int i = 0; i < str.length()-2; ++i) {
    if (str.substring(i, i+3).equals("cat")) {
      numberOfCatInstances++;
    }
    else if (str.substring(i, i+3).equals("dog")) {
      numberOfDogInstances++;
    }
  }
  return (numberOfCatInstances == numberOfDogInstances);
}
