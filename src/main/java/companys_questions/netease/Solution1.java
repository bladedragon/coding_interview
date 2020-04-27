package companys_questions.netease;

import java.util.Scanner;

//长度是n的数组a，找到一个数d使得所有i，ai+1-ai都是d的倍数
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner. nextInt();
        long[] a = new long[n];
        for(int i =0;i<n;i++){
            a[i] = scanner.nextLong();
        }
        long[]  b = new long[n-1];

        for(int i =1;i<n;i++){
            b[i-1] = a[i] - a[i-1];
        }
        for(int i =0;i<n-2;i++){
            long temp = getGcd(b[i],b[i+1]);
            b[i+1] = temp;
        }
       if(a[n-1] - a[n-2] != b[n-2]){
           System.out.println(b[n-2]);
       }else{
           System.out.println(-1);
       }
    }

    public static long getGcd(long m,long n){
        while(n > 0){
            long temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    public static long getLcm(long m,long n){
        long gcd = getGcd(m,n);
        long result = m*n / gcd;
        return result;
    }
}
