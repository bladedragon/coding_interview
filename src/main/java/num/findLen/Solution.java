package num.findLen;

/**
 * 一个直角三角形的周长是120的话，那么它的三边可以是20，48，52，或者24，45，51，还有30，40，50，有3种不同的解。
 * 现在你想知道如果给定一个直角三角形的周长，那么这个周长最多能有多少解呢？假设边长为整数。
 *
 * 输入：120
 * 输出：3
 */
public class Solution {
    public int findLen(int len){
        int count =  0;
        for(int i =1;i<len/3;i++){
            for(int j =i;j<len/2;j++){
                int k = len -i-j;
                if(i*i+j*j == k*k){
                count++;
                    System.out.println("i="+i+"; j="+j+"; k="+k);
                }
            }
        }
        return count;
    }

    /**
     * 通过数学方法，我们获得了j的表达式，再判断一下j小于l并且j是整数便可。
     * 这样的程序只有一重循环了，我们将程序从一开始的超时优化到了1ms，这是枚举常见的优化方法——利用数学方法来减少循环次数。
     * @param len
     */
    public static void findNum3(int len){
        int count=0;
        for(int i=1;i<len/3;i++){
            double j = len - (double) len * len/ (2 * len - 2 * i);
            if (i < j && j - (int) j < 1e-5) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLen(120));
    }
}
