package companys_questions.alibaba;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            int sum = 0;
            long muti1 = 1;
            long muti2 = n;
            for (long i = 1; i <= n; i++) {
                sum += i * muti2 / muti1;
                muti2 *= (n - i);
                muti1 *= (i + 1);

            }
            int x = 1;
            for (int i = 0; i < 9; i++) {
                x *= 10;
            }
            System.out.println(sum % (x + 7));
        }
    }
}
