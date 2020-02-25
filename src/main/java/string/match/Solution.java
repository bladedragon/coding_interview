package string.match;

public class Solution {
    boolean flag = false;

    /**
     * 失败方法
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern){

        if(str.length ==0){
            if(pattern.length ==0){
                return true;
            }else{
                match_r(str,pattern,str.length,pattern.length-1);

            }
        }else{
            match_r(str,pattern,str.length-1,pattern.length-1);
        }
        return flag;
    }

    private void match_r(char[] str,char[] patten,int i,int j){

        if(flag == true){
            return;
        }
        if(i==0){
            if(j<=0){
                flag  =true;
            }
            return;
        }
        if(patten[j] == '.'){
            match_r(str,patten,i-1,j-1);
        }else if(patten[j] == '*'){
            for(int k = 0;k<i;k++){
                match_r(str,patten,i-k,j-1);
            }
        }else{
            if(i>0 && str[i] == patten[j]){
                match_r(str,patten,i-1,j-1);
            }
        }

    }

    /**
     * 另外的尝试
     */
    boolean flag2 = false;
    public boolean match2(char[] str, char[] pattern){
        if(pattern.length == 0){
            if(str.length == 0){
                return true;
            }
            return false;
        }
        match_r2(str,pattern,0,0);
        return flag2;

    }

    public void match_r2(char[] str,char[] pattern,int i,int j){

        if(flag2 == true){
            return;
        }
        if(str.length == i && j == pattern.length){
            flag2 = true;
            return;
        }else if(j ==pattern.length){
            flag2 = false;
            return;
        }


        if(j+1 > pattern.length){
            return;
        }

        if(j+1 < pattern.length && pattern[j+1] == '*' ){
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {
                match_r2(str,pattern,i,j+2);
                match_r2(str,pattern,i+1,j);
            }else{
                match_r2(str,pattern,i,j+2);
            }
        }else {
            if (i < str.length &&( pattern[j] == '.' || pattern[j] == str[i] )) {
                match_r2(str, pattern, i + 1, j + 1);
            }
        }


//        if(j+1 < pattern.length && pattern[j+1] != '*' ) {
//            if (i < str.length &&( pattern[j] == '.' || pattern[j] == str[i] )) {
//                match_r2(str, pattern, i + 1, j + 1);
//            }
//        }else{
//            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {
//                match_r2(str,pattern,i,j+2);
//                match_r2(str,pattern,i+1,j);
//            }else{
//                match_r2(str,pattern,i,j+2);
//            }
//        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] str = "a".toCharArray();
        char[] pattern = ".".toCharArray();
        System.out.println(solution.match2(str,pattern));

    }


}