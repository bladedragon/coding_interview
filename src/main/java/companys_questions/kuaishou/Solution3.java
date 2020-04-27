package companys_questions.kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String[] c=s.split(",");

        if(c.length <1){
            System.out.println("null");
        }

        ArrayList<String> res = new ArrayList<String>();

        for(int i=0; i<c.length;i++){
            int shun = isShun(c[i]);
            int bao = isBao(c[i]);
            int slen = shun > bao ? shun :bao;
            if(slen >0){
                res.add(c[i]);
            }
        }
        String[] ress = (String[]) res.toArray(new String[0]);
        for(int i=0; i<ress.length;i++){
            int minIndex = i;
            int shun = isShun(c[i]);
            int bao = isBao(c[i]);
            int slen = shun > bao ? shun :bao;
            for(int j =i+1;j<ress.length;j++){
                int shun2 = isShun(c[i]);
                int bao2 = isBao(c[i]);
                int slen2 = shun2 > bao2 ? shun2 :bao2;
                if(slen < slen2){
                    minIndex = j;
                }
            }

            String temp = ress[i];
            ress[i] = ress[minIndex];
            ress[minIndex] = temp;
        }
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for(String num : ress){
            if(isFirst){
                builder.append(num);
                isFirst = !isFirst;
            }else{
                builder.append(",");
                builder.append(num);
            }
        }
        System.out.println(builder.toString());
    }

    public static int isShun(String num){
        int count =0;
        int flag = 0;
        char[] c = num.toCharArray();
        for(int i =4;i<c.length;i++){
            if(c[i]-c[i-1] == 1){
                count++;
            }else{
                count = 0;
            }
            if(count>=2){
                flag = Math.max(flag,count);
            }
        }
        if(flag != 0){
            return flag;
        }
        return -1;

    }

    public static int isBao(String num) {
        int count = 0;
        int flag = 0;
        char[] c = num.toCharArray();
        for (int i = 4; i < c.length; i++) {
            if (c[i] - c[i - 1] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count >= 2) {
                flag = Math.max(flag, count);
            }
        }
        if (flag != 0) {
            return flag;
        }
        return -1;
    }

    public int compare(String s1,String s2){
        int isShun1 = isShun(s1);
        int isBao1 = isBao(s1);

        int isBao2 = isBao(s2);
        int isShun2 = isShun(s2);
        return -1;

    }

}
