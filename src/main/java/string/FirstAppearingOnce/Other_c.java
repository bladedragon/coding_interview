package string.FirstAppearingOnce;

public class Other_c {


        int[] count = new int[256]; // 字符出现的次数
        int[] index = new int[256]; // 字符出现的顺序
        int number = 0;


        public void Insert(char ch) {
            count[ch]++;
            index[ch] = number++;
        }

        public char FirstAppearingOnce() {
            int minIndex = number;
            char ch = '#';
            for (int i = 0; i < 256; i++) {  // !!!
                if (count[i] == 1 && index[i] < minIndex) {
                    ch = (char) i;
                    minIndex = index[i];
                }
            }
            return ch;
        }

}
