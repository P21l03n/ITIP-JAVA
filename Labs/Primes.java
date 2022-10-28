public class Primes {
    public static void main(String[] args) {
        for(int i=2; i<100; i++){
            if (isPrime(i))
            System.out.print(i+" - это число простое");
            else
            System.out.println(i);
        }
    }
    public static boolean isPrime(int n){
        int k=0;
        for(int j=2; j<n; j++){
            if (n%j==0)
            k+=1;
            }
        if (k==0)
        return true;
        else
        return false;
        }
    }

