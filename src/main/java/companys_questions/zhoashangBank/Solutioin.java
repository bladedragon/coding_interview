package companys_questions.zhoashangBank;

import java.util.*;

public class Solutioin {
    public static void main(String[] args) {
        Map<Character,Character> map = new HashMap<>();
        map.put('1','1');
        map.put('2','5');
        map.put('3','8');
        map.put('4','7');
        map.put('6','9');
        map.put('5','2');
        map.put('8','3');
        map.put('7','4');
        map.put('9','6');

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
            int test = scanner.nextInt();
            for(int i =0;i<test;i++){
                long input = scanner.nextLong();
                String str = String.valueOf(input);
                char[] cs = str.toCharArray();
                boolean res = IsMirror(cs, map);
                if (res) {
//                    System.out.println("YES");
                    list.add("YES");

                } else {
//                    System.out.println("NO");
                    list.add("NO");
                }
            }
            for(String l :list){
                System.out.println(l);
            }
    }

    public static  boolean IsMirror(char[] cs,Map<Character,Character> map){
        boolean isMirror = true;

        if(cs.length == 1){
           return false;
        }else{
            int left = 0;
            int right = cs.length-1;
            while(left <right){
                if(!map.containsKey(cs[left])){
                    return false;
                }
                if(map.get(cs[left]) != cs[right]){
                    isMirror = false;
                    break;
                }
                left++;
                right--;
            }
            if(isMirror){
                return true;
            }else{
                return false;
            }
        }

    }
}
