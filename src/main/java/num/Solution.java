package num;

public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            if(exponent <=0){
                return 0;
            }
            return 0;
        }

        return getPower(base,exponent);

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
//        double num = solution.Power(2,3);
//        System.out.println(num);
            int[] a  = {1,2,3,4,5};
        System.out.println(a[1]+"--"+ a[4]);
        solution.swap(a[1],a[4]);
        System.out.println(a[1]+"---"+a[4]);

    }
}