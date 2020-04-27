package companys_questions.qianxin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] tri = s.split(",");
        for(int i =0;i<9;i++){
        tri[i].trim();
        }

        int sum1 = 0;
        for(int i =0;i<4;i++){
            sum1 += Integer.valueOf(tri[i]);
        }
        int sum2 = 0;
        for(int i =4;i<tri.length;i++){
            sum2 += Integer.valueOf(tri[i]);
        }
        System.out.println("yes");
    }
}
