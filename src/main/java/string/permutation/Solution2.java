package string.permutation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public ArrayList<String> Permutation(String str) {
        //注意这里进行了去重处理
        Set<String> res = new HashSet<>();

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        //回溯
        Permutation(res, str.toCharArray(), 0);

        ArrayList<String> list = new ArrayList<>(res);

        //字符串排序
        list.sort(String::compareTo);
        return list;
    }

    private void Permutation(Set<String> res, char[] chars, int start) {
        if (start == chars.length) {
            res.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);

            Permutation(res, chars, start + 1);

            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

//    public ArrayList<String> Permutation2(String str){
//        Set<String> res = new HashSet<>();
//        per(res,str.toCharArray(),0);
//        ArrayList<String> list = new ArrayList<>(res);
//        list.sort(String::compareTo);
//        return list;
//    }
//
//    private void per(Set<String> res, char[] chars,int start){
//        if (start == chars.length) {
//            res.add(new String(chars));
//            return;
//        }
//        for(int i =start;i<chars.length;i++){
//            swap(chars,start,i);
//            per(res,chars,start+1);
//            swap(chars,start,i);
//        }
//    }
}
