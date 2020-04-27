package string.translateNumToStr;

public class Solution {
    public int translateNumToStr(int num){
        char[] str = String.valueOf(num).toCharArray();
        int res[] = new int[str.length];

        for(int i  = str.length;i>=0;i++){
            if (i + 1 >= str.length) {
            res[i] = 1;
                continue;
            }
            res[i] = res[i+1];

            if(i+2 < str.length && str[i] <= '2' && str[i] >= '1' && str[i+1] <= '5'){
                res[i] += res[i+2];
            }
        }
        return res[0];

    }

}
