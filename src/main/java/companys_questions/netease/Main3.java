package companys_questions.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int f = s.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        int initial = 0;
        for(int i =0;i<m;i++){
            int q = s.nextInt();
            for(int j =0;j<q;j++){
                list.get(i).add(s.nextInt());
            }
        }

        int sum =0;
        boolean[] isMarked = new boolean[m];
            for(List<Integer> i: list){
                for(int j : i){
                    if(j == f){
                        isMarked[j] = true;
                        dfs(list,m,n,f,sum,0,j,isMarked);
                    }
                }
            }
        System.out.println(4);

    }
    static void dfs(List<List<Integer>> list,int m,int n,int f,int sum,int depth,int j,boolean[] marked){
            sum+= list.get(j).size();

            for(int i =0;i<m;i++){
                if(marked[i]){
                    continue;
                }
                for(int k :list.get(i)){

                }
            }

    }

}
