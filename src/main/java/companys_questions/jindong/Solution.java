package companys_questions.jindong;

import java.util.*;

public class Solution {

    static boolean make(int[][] paper) {
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<6;i++){
            set.add(paper[i][0]);
            set.add(paper[i][1]);
        }



        if(set.size() == 3){
            for(int j =0;j<6;j+=2){
                if(paper[j][1] != paper[j+1][1]){
                    return false;
                }
                if(!set.contains(paper[j][1])){
                    return false;
                }
            }
            return true;
        }
        if(set.size() == 2){
            for(int s : set){
               int f = 0;
               for(int i =0;i<6;i++){
                   if(s == paper[i][1]){
                       f++;
                   }
               }
               if(f != 2 && f != 4){
                   return false;
               }
            }
            return true;
        }

        if(set.size() == 1){
            for(int i =0;i < 6;i++){
                if(!set.contains(paper[i][1])){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] paper = new int[6][2];
        for(int i =0;i<t;i++){
            for(int j =0;j<6;j++){
                    paper[j][0] = in.nextInt();
                    paper[j][1] = in.nextInt();
                System.out.println(Arrays.toString(paper[j]));
                Arrays.sort(paper[j]);
            }

            Arrays.sort(paper,(o1,o2)-> {return o1[0]-o2[0];});

            boolean res = make(paper);
            System.out.println(res ? "POSSIBLE" : "IMPOSSIBLE");
        }
    }
}
