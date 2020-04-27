package num.printBigN;

public class Others {
    public void PrintN(int n) {
        if (n <= 0) {
            return;
        }

        String res = "0";

        while (true) {
            boolean all9 = true;

            res = Plus(res, 1);
            System.out.println(res);

            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) != '9') {
                    all9 = false;
                    break;
                }
            }

            if (all9 && res.length() == n) {
                break;
            }
        }
    }

    private String Plus(String t, int i) {
        char[] chars = t.toCharArray();
        StringBuilder res = new StringBuilder();
        //末尾+1
        chars[chars.length - 1] += i;

        boolean flag = false;
        for (int j = chars.length - 1; j >= 0; j--) {
            int a = chars[j];
            if (flag) {
                a++;
                flag = false;
            }
            //如果该位需要进位了就设置进位标识符为truw
            if (a > '9') {
                flag = true;
                a = a - '9' + '0' - 1;
            }

            res.append((char) a);
        }
        //最后如果还有进位就溢出
        if (flag) {
            res.append('1');
        }

        return res.reverse().toString();
    }
}
