// https://leetcode.com/problems/convert-the-temperature/

class Solution {

    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15d;
        double fahrenheit = celsius * 1.80d + 32.00d;
        return new double[] { kelvin, fahrenheit };
    }
    
}
