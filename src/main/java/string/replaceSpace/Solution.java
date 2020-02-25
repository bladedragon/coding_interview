package string.replaceSpace;

public class Solution {
    /**
     * 暴力方法
     * 底层的实现是会执行多次resize操作。因此在数据量大的情况下，性能会降低。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != ' '){
                builder.append(str.charAt(i));
            }else{
                builder.append("%20");
            }
        }

        return builder.toString();

    }

    public String replaceSpace2(StringBuffer str){
        String specifiedChars = "%20";
        int isr = 0;
        //执行一次N的遍历
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                isr++;
            }
        }
        //最后的新数组的大小
        int newCapacity = str.length() + (isr * specifiedChars.length());
        char[] newChars = new char[newCapacity];
        for (int i = 0, j = 0; i < newCapacity && j < str.length(); i++) {
            if (str.charAt(j) == ' ') {
                for (int t = 0; t < specifiedChars.length(); t++) {
                    newChars[i++] = specifiedChars.charAt(t);
                }
                j++;
                continue;
            }
            //正常迁移
            newChars[i] = str.charAt(j++);
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "hello world";
        StringBuffer buffer = new StringBuffer(str);
        String ret = solution.replaceSpace(buffer);
        System.out.println(ret);
    }
}
