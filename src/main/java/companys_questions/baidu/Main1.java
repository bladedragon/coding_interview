package companys_questions.baidu;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long max = 0;
        if(gcd(n,n-1) !=1) {
            for (long i = n-1; i >=1; i--) {
                for (long j = i+1; j >=1; j--) {
                    long res = lcm(i, j) - gcd(i, j);
                    max = max > res ? max : res;
                }
            }
        }else{
            max = lcm(n-1,n)-gcd(n-1,n);
        }
        System.out.println(max);


    }
    private static long lcm(long a,long b){
        long gcd=gcd(a, b);
        long result=(a*b)/gcd;
        return result;
    }

    private static long gcd(long a, long b) {
         if (b == 0) return a;
         return a % b == 0 ? b : gcd(b, a % b);
    }
}
