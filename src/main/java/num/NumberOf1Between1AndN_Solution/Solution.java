package num.NumberOf1Between1AndN_Solution;

public class Solution {

    int NumberOf1Between1AndN_Solution(int n){

        int ones = 0;
        for(int m= 1;m <= n;m*=10){
            int a = m/n;
            int b = m%n;
            if(a %10 == 0){
                ones += a/10*m;
            }else if(a%10 ==1){
                ones += (a/10*m) + (b+1);
            }else{
                ones += (a/10+1)*m;
            }
        }
        return ones;
    }

    public int numberOfOneBetweenOneAndN(int n){
        int ones = 0;
        for(int i =1;i<n;i*=10){
            int a = n/i;
            int b = n%i;
            if(a %10 == 0){
                ones+= (a/10)*i;
            }else if(a %10 == 1){
                ones += (a/10)*i +(b+1);
            }else{
                ones += (a/10+1)*i;
            }
        }
        return ones;
    }


}
