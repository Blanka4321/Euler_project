import java.util.*;
import java.math.BigInteger;

// This solution is sound I just need to work out the hashtable factor values
//https://www.youtube.com/watch?v=OnfYqzsQGfU
//https://www.youtube.com/watch?v=I-N8oQmeXwU

public class Primitive_Problem{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        BigInteger modulo = new BigInteger(p+"");
        HashMap<Integer, Integer> pfactors = primeFactors(p - 1);
        ArrayList<BigInteger> exponents = new ArrayList<>();
        BigInteger _1 = new BigInteger("1");
        int smallest_root = -1;

        // calculate exponents

       for(int factor: pfactors.keySet()){
           
            int expo = (p-1)/factor;
            exponents.add(new BigInteger(expo + ""));

       }

        // calculate first prime root of p - 1

        for(int i = 2; i <= p - 1; i++){

            boolean isPrimeRoot = true;
            BigInteger a = new BigInteger(i + "");

            for(BigInteger exp: exponents){

                if(a.modPow(exp, modulo).equals(_1)){

                    isPrimeRoot = false;
                    break;
                }

            }

            // if isPrimeRoot == true then we have found the smallest primitive root

            if(isPrimeRoot == true){
                smallest_root = i;
                break;
            }

        }

        // time to calculate the total number of primitve roots that exist for the prime p

        double numberOfRoots = 1.0;



        for (Map.Entry<Integer, Integer> entry : pfactors.entrySet()) {

             int factor = entry.getKey();
             int exp    = entry.getValue();

             numberOfRoots*= factor - 1;
             numberOfRoots*= Math.pow(factor, exp - 1);

        }

        System.out.println(smallest_root + " " + (long)numberOfRoots);

    }


    public static HashMap<Integer, Integer> primeFactors(int num){

        HashMap<Integer, Integer> factors = new HashMap<>();
        int tmp = num;

        while(tmp%2 == 0){

            if(factors.containsKey(2))
              factors.put(2, factors.get(2) + 1);
            else
              factors.put(2,1);

            tmp/= 2;

        }

        for(int i = 3; i < num; i+=2){

            if(isPrime(tmp)){
                factors.put(tmp,1);
                break;
            }

            if(isPrime(i) && tmp%i == 0){

                while(tmp%i == 0){

                   if(factors.containsKey(i))
                    factors.put(i, factors.get(i) + 1);
                   else
                    factors.put(i, 1);

                   tmp/= i;

                }
            }

        }

        return factors;
    }

    private static boolean isPrime(int num) {
        if (num % 2 == 0 || num == 1)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

}
