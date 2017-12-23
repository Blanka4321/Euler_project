import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmithNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int digitTotal = digitSum(number);
        int factorsSum = 0;
        ArrayList<Integer> factors = primeFactorSums(number);
        
        if(number == 1){
            System.out.println("1");
            System.exit(0);
        }
           

        for(int fac: factors)
            factorsSum+= digitSum(fac);
        
        int result = factorsSum == digitTotal?1:0;
        System.out.println(result);


    }

    public static int digitSum(int num){

        int tmp = num;
        int total = 0;

        while(tmp!=0){

            if(tmp < 10){

                total+= tmp;
                break;

            }

            total+= tmp%10;
            tmp/= 10;
            
        }

        return total;

    }

    public static ArrayList<Integer> primeFactorSums(int num){

        ArrayList<Integer> factors = new ArrayList<Integer>();
        int tmp = num;

        if(isPrime(tmp)){
            factors.add(tmp);
            return factors;
        }

        while(tmp%2 == 0){
            factors.add(2);
            tmp/= 2;
        }



        for(int i = 3; i < Math.sqrt(num); i+=2){

            if(isPrime(tmp)){
                factors.add(tmp);
                break;
            }

            if(isPrime(i) && tmp%i == 0){

                while(tmp%i == 0){

                    factors.add(i);
                    tmp/= i;

                }
            }

        }

        return factors;
    }

    private static boolean isPrime(int num) {
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}

