package num.countOfNumbers;

public class Solution {
    public int nOfNumberSerialize(int n) {
        int i = 1;
        int count = 0;
        int nLeft = n;

        while (true) {
            nLeft -= count;
            count = countOfIntegers(i) * i;

            if (nLeft < count) {
                break;
            }
            i++;
        }

        int a = nLeft / i;
        String s = String.valueOf(a);

        return s.charAt(nLeft % i) - '0';
    }

    private int countOfIntegers(int n) {
        int sum = 0;

        if (n == 1) {
            sum = 10;
        } else {
            sum = (int) (9 * Math.pow(10, n - 1));
        }

        return sum;
    }

}
