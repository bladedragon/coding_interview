package companys_questions.kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String[] c=s.split("\\s+");
        ArrayList<Long> list = new ArrayList<Long>();
        for(int i=0;i<c.length;i++) {
            list.add(Long.parseLong(c[i]));
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        long maxValue = list.get(0);
        long secMaxValue = 0;
        for(int i =1;i<list.size();i++){
            if(list.get(i) >= maxValue){

                secMaxValue = maxValue;
                maxValue = list.get(i);

            }else{
                if(list.get(i) >= secMaxValue){
                    secMaxValue = list.get(i);
                    res.add(i);
                }
            }
        }

        if(res.isEmpty()){
            System.out.println(-1);
        }
        for (int i:res) {
            System.out.print(i+ " ");
        }
    }
}
