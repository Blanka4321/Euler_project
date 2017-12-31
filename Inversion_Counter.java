import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    
  public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int d = input.nextInt();

        for(int i = 0; i < d; i++){

            int n = input.nextInt();
            int[] unsorted =  new int[n];

            for(int j =  0; j < n; j++)
                unsorted[j] = input.nextInt();

            long inv = inversions_count(unsorted);
            
            System.out.println(inv);
        }

    }

    public static long merge(int[] unsorted, int[] left, int[] right) {

        int i = 0, j = 0;
        long inversions = 0l;

        while (i < left.length || j < right.length) {

            if (i == left.length) {

                unsorted[i+j] = right[j];
                j++;

            } else if (j == right.length) {

                unsorted[i+j] = left[i];
                i++;

            } else if (left[i] <= right[j]) {

                unsorted[i+j] = left[i];
                i++;

            } else {

                // we have an inversion
                unsorted[i+j] = right[j];
                inversions += left.length-i;
                j++;

            }

        }
        
        return inversions;
    }

    public static long inversions_count (int[] arr) {

        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);

        return inversions_count(left) + inversions_count(right) + merge(arr, left, right);
    }

}
