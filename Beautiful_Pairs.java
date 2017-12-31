import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.HashSet;
import java.util.Scanner;


public class Solution
{
    public static void main(String[] args){

        int beautiful_pairs = 0;
        boolean change = false;
        int differences = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        
        HashSet<Integer> A_used_indices = new HashSet<>();
        HashSet<Integer> B_used_indices = new HashSet<>();

        for(int i = 0; i < n; i++)
          A[i] = input.nextInt();

        for(int j = 0; j < n; j++)
           B[j] = input.nextInt();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        if(n == 1 && A[0] == B[0]){
            System.out.println("0");
            System.exit(0);
        }
        

        for(int i = 0; i < n; i++){
            
            if(A[i] != B[i])
                differences++;
            
        }
        
        
       // System.out.println("They're " + differences + " between A[] and B[]");
        
        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){
                
              if(!B_used_indices.contains(j) && !A_used_indices.contains(i)){
                
                   if(A[i] == B[j]){
                     
                    A_used_indices.add(i);  
                    B_used_indices.add(j);  
                    beautiful_pairs++;  
                    break;
                 
                  } 
                  
              }
                
            }    
        }
        
        if(differences >= 1)
            beautiful_pairs++;
        else if(differences == 0)
            beautiful_pairs--;
        
        System.out.println(beautiful_pairs);

    }
}

