package num.Power;

public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            if(exponent <=0){
                return 0;
            }
            return 0;
        }
        return exponent >0 ? getPower(base,exponent) : 1/(getPower(base,exponent));

    }

    public double getPower(double base, int exp){
        if(exp  == 0){
            return 1;
        }
        if((exp & 1 )== 1){
            return base * getPower(base,exp-1);
        }else{
            double num =  getPower(base,exp>>1);
            return num * num;
        }
    }

    //因为jvm是值传递不是引用传递
    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double num = solution.power2(2,-3);
        System.out.println(num);
//            int[] a  = {1,2,3,4,5};
//        System.out.println(a[1]+"--"+ a[4]);
//        solution.swap(a[1],a[4]);
//        System.out.println(a[1]+"---"+a[4]);

    }

    public double power2(int base, int exponemt){
        int n=0;
        if (exponemt > 0) {
            n = exponemt;
        }else if(exponemt < 0){
            if(base ==0){
                return Double.NaN;
            }
            n = -exponemt;
        }else{
            if(base == 0){
                return Double.NaN;
            }
            return 0;
        }

        double result = 1;
        double current = base;
        while(n!=0){
            if((n&1)==1)
                result*=current;
            current*=current;// 翻倍
            n>>=1;// 右移一位
        }
        return exponemt>=0?result:(1/result);

    }
}