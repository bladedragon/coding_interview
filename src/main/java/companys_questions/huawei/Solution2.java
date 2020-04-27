package companys_questions.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
    private static String a = "addr=0x";
    private static String b = "mask=0x";
    private static String c = "val=0x";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] strs = in.split(" ");
        if(strs.length != 2){
            System.out.println("FAIL");
            return ;
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        int index = 0;
        int i = 0;
        for( i =0;i<strs[1].length();i++){

            if(strs[1].charAt(i+1) == '['){

                if(index != strs[0].length()-1){
                    System.out.println("FAIL");
                    return;
                }

                stack.push(i+1);
                while(strs[1].charAt(i) != ']'){
                    i++;
                }
                int pushI = stack.pop();
                list.add(strs[1].substring(pushI+1,i));
                if(i+1 <strs[1].length() && strs[1].charAt(i+1) != ','){
                    System.out.println("FAIL");
                    return;
                }else{
                    index = 0;
                    i+=2;

                }

            }else{
//                if(index < strs[0].length() && strs[0].charAt(index) != strs[1].charAt(i)){
//                    System.out.println("FAIL");
//                    return;
//                }
            }

            index++;

        }

        if(i < strs.length){
            System.out.println("FAIL");
            return;
        }
        if(!stack.isEmpty()){
            System.out.println("FAIL");
            return;
        }
        System.out.println(list);

        match(list);
    }

    private static void match(ArrayList<String> list) {

        for(String str :list){
            String[] res = new String[3];
            String[] ss = str.split(",");
            if(ss.length != 3){
                System.out.println("FAIL");
                return;
            }


            if(ss[0].length() < a.length() || !ss[0].substring(0,a.length()).equals(a)){
                System.out.println("FAIL");
                return;
            }
            if(isHex(ss[0].substring(a.length(),ss[0].length()))){
                res[0] = ss[0].substring(a.length()-2,ss[0].length());
            }else{

                System.out.println("FAIL");
                return;
            }

            if(ss[1].length() < b.length() || !ss[1].substring(0,b.length()).equals(b)){
                System.out.println("FAIL");
                return;
            }
            if(isHex(ss[1].substring(b.length(),ss[1].length()))){
                res[1] = ss[1].substring(b.length()-2,ss[1].length());
            }else{
                System.out.println("FAIL");
                return;
            }

            if(ss[2].length() < c.length() || !ss[2].substring(0,c.length()).equals(c)){
                System.out.println("FAIL");
                return;
            }
            if(isHex(ss[2].substring(c.length(),ss[2].length()))){
                res[2] = ss[2].substring(c.length()-2,ss[2].length());
            }else{
                System.out.println("FAIL");
                return;
            }
            System.out.println(res[0]+" "+res[1]+" "+res[2]+" ");
        }
    }

    private static boolean isHex(String substring) {
        int flag = 0;
        for(char ch : substring.toCharArray()){
            if ( ch >='0' && ch <='9' ) {
                flag++;
                continue;
            }
            if ( ch >='A' && ch <='F' ){
             flag++;
             continue;
            }
            if ( ch >='a' && ch <='f' ){
                flag++;
                continue;
            }
        }
        if(flag == substring.length()){
            return true;
        }else{
            return false;
        }
    }

//    public static void main(String[] args) {
//        ArrayList<String> list=  new ArrayList<>();
//        list.add("addr=0xff,mask=0x12,,val=0x12");
//        match(list);
//
//    }


}
