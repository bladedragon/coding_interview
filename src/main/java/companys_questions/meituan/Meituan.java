package companys_questions.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan {
    //扎金花是一种非常受欢迎的纸牌游戏。而在游戏界有一种于扎金花类似的玩法，叫做扎银花。
    //
    //      相比于扎金花的牌型多变，扎银花就简单多了，虽然同样是三张牌比大小，在扎银花的规则里只需要把三张牌的点数相加再进行大小比较即可，点数大的人获胜。
    //
    //      今天我们玩的不是扑克牌，而是一种取值范围在1-10^9以内的简单牌，两个人一开始各自有n张牌，他们会想办法组合出最大的牌，请你计算出获胜的一方的三张牌的点数之和。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        int i=0,j =0;
        while(scanner.hasNextLine()){
            if(i == n){
                break;
            }
                p1[i] = scanner.nextInt();
                i++;
        }
        while(scanner.hasNextLine()){
            if(j == n){
                break;
            }
            p2[j] = scanner.nextInt();
            j++;
        }
        boolean flag = true;
        Arrays.sort(p1);
        Arrays.sort(p2);
        i = j =n-1;
                int sum1 = p1[i] + p1[i - 1] + p1[i - 2];
                int sum2 = p2[j]+p2[j-1]+p2[j-2];
                if(sum1 < sum2){
                    System.out.println(sum2);
                }else{
                    System.out.println(sum2);
                }
    }
}
