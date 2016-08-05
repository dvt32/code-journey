// https://www.hackerrank.com/challenges/simple-array-sum

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Solution {

    static void Main(String[] args) {
        int N = Convert.ToInt32(Console.ReadLine());
        String[] numbers = Console.ReadLine().Split(' ');
        int[] arr = new int[N];
        int sum = 0;
        
        // Enter elements & calculate sum
        for (int i = 0; i < arr.Length; ++i) {
            arr[i] = Convert.ToInt32(numbers[i]);
            sum += arr[i];
        }
        
        // Print sum
        Console.WriteLine(sum);
    }
}
