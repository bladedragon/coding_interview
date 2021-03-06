package string.isNumberic;

import java.util.regex.Pattern;

public class Other_regex {
    /**
     * ^ 和 美元符号框定正则表达式，它指引这个正则表达式对文本中的所有字符都进行匹配。
     * 如果省略这些标识，那么只要一个字符串中包含一个数字这个正则表达式就会进行匹配。如果仅包含 ^ ，它将匹配以一个数字开头的字符串。
     * 如果仅包含$ ，则匹配以一个数字结尾的字符串。
     *
     * 正负号后面的 ? 后缀表示这个负号是可选的,表示有0到1个负号或者正号
     *
     * \d的含义和[0-9]一样。它匹配一个数字。后缀 * 指引它可匹配零个或者多个数字。
     *
     * (?: …)?表示一个可选的非捕获型分组。* 指引这个分组会匹配后面跟随的0个或者多个数字的小数点。
     *
     *
     * @param str
     * @return
     */
        public static boolean isNumeric(char[] str) {
            String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
            String s = new String(str);
            return Pattern.matches(pattern,s);
    }
}
