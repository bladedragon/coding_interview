package string.match;

public class Other_backTracking_two {



    public  boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        return match1(str, 0, pattern, 0);
    }

    private boolean match1(char[] str, int i, char[] pattern, int j) {
        if(j == pattern.length)//pattern遍历完了
            return str.length == i;//如果str也完了，返回true，不然false
        //1.先看当前是否匹配
        boolean first_isMatch = (i != str.length) && (str[i] == pattern[j] || pattern[j] == '.');
        //2.再看后面是否有* pattern[j + 1] == '*'
            if(j < pattern.length - 1 && pattern[j + 1] == '*') {
                return match1(str, i, pattern, j + 2) ||
                        (first_isMatch && match1(str, i + 1, pattern, j));
            }else {
            return first_isMatch && match1(str, i + 1, pattern, j + 1);
        }
    }
}
