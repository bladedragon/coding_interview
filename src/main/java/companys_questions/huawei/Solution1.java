package companys_questions.huawei;


import java.util.*;

public class Solution1 {
    private static String ERROR = "error.0001";

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        if(s.length() <1){
//            System.out.println(ERROR);
//            return;
//        }
//        String[] names = s.split(",");
//        if(names.length <1){
//            System.out.println(ERROR);
//            return;
//        }
//        Map<String,Integer> set = new HashMap<>();
//        String res = judgeTomorrow(names,set);
//        if(res != ""){
//            System.out.println(res);;
//        }else{
//            System.out.println(ERROR);
//        }
//    }

    private static String judgeTomorrow(String[] names,Map<String,Integer> set) {
        for(String name : names){
            if(set.containsKey(name)){
                int score = set.get(name);
                set.put(name,score+1);
            }else{
                set.put(name,1);
            }
        }

        int currentScore = 0;
        String currentName = "";
        for(String name : set.keySet()){
                int score = set.get(name);
                if(currentScore < score){
                    currentName = name;
                    currentScore = score;
                }else if(score == currentScore){
                    int res = isFirst(name,currentName);
                    if(res == 1){
                        currentName =name;
                        currentScore  = score;
                    }else if (res == -1){
                        return "";
                    }
                }
        }
        return currentName;
    }

    private static int  isFirst(String name, String currentName) {
        int index = 0;
        char c1 = 'A';
        char c2 = 'Z';

        while(index < name.length() && index < currentName.length()){
            System.out.println("this");
            System.out.println(currentName.charAt(index) > c2);
                if(name.charAt(index) > c2 || name.charAt(index) < c1 || currentName.charAt(index) > c2 || currentName.charAt(index) < c1){
                    return -1;
                }

                if(name.charAt(index) - c1 < currentName.charAt(index) - c1){
                    return 1;
                }else if(name.charAt(index)-c1 > currentName.charAt(index) - c1){
                    return 0;
                }

            if(index == 0){
                c1 = 'a';
                c2 = 'z';
            }
            index++;
        }

        if(name.length() < currentName.length()){
            return 1;
        }
        return 0;
    }


    //Tom,Lucy,Tom,Lcuy,Lucy,Jack,a
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println( isFirst("Tom","a"));
//        System.out.println('a'>'Z');
    }

}
