package companys_questions.netease;

import java.util.*;

public class Main2 {
    static List<Integer>  list = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int D = scanner.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for(int i =0;i<n;i++){
            b[i] = scanner.nextInt();
        }

        int sum = 0;
        boolean[] attacked = new boolean[n];
        Arrays.fill(attacked,false);

        Arrays.sort(a);
        int i;
        for( i =0;i<n;i++){
            if(D >= a[i]){
                D++;
                attacked[i] = true;
            }else{
                break;
            }
        }
        for(int j =i;j<n;j++){
         //   System.out.println("i"+i);
            dfs(sum,D,a,b,attacked,i,n,i);
        }
        int result = Integer.MAX_VALUE;
        for(int res : list){
        //    System.out.println("res"+res);
            result = Math.min(res,result);
        }
        if(result == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(result);
        }

    }

    private static void dfs(int sum, int D, int[] a, int[] b,boolean[] attacked,int index,int n,int depth) {
        //System.out.println(depth);
        if(attacked[index]){
            return;
        }


        attacked[index] = true;
        sum+=b[index];
        D++;
        if(depth==n-1){
            list.add(sum);
            return;
        }
        for(int i =0;i<n;i++){
            if(attacked[i]){
                continue;
            }
            depth++;
            dfs(sum,D,a,b,attacked,i,n,depth);
        }
    }
}
