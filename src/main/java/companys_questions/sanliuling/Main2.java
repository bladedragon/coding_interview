package companys_questions.sanliuling;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    private static double youLose;
    private static double  myWin = 0.0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double res = prize(n,m);
        DecimalFormat df = new DecimalFormat("0.0000");

        System.out.println(df.format(res));
    }

    public static double prize(double n,double m){
        if(n>0 && m<=0){
            return 1;
        }
        if(n<=0){
            return 0;
        }
         myWin =  n/(m+n);
        if( n>=1 && m+n>1){
            youLose = ((m)/(n+m))*((m-1)/(n+m-1));
            return myWin+youLose*prize(n-1,m-2)+youLose*prize(n,m-2);
        }else{
            return myWin;
        }

    }

}
