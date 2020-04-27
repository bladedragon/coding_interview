package num.printBigN;

public class Solutioin {

    //Bad way
    public void PrintN(int n) {
        long number = 1;
        int i = 0;
        while (i < n) { //利用while循环计算出比n位十进制多1的数
            number *= 10;
            ++i;
        }
        for (long j = 1; j < number; j++) { //利用for循环输出从1到最大的n位数
            System.out.print(j + " ");
            if (j % 5 == 0) {
                System.out.println();
            }
        }
    }

    public void printMaxOfDigit(int n){
        if( n<=0 ){
            return ;
        }
        char number[] = new char[n];
        for(int i =0;i<number.length;i++){
            number[i] = '0';
        }
        int index = 0;
        while(!incrementNumber(number)){
            if(index == 5){
                System.out.println();
                index = 0;
            }
            printNumber(number);
            index++;

        }
    }


    //将数字自增+1
    private boolean incrementNumber(char[] number) {
        boolean isOverFlow = false;
        int nTakeover = 0;
        int nLength = number.length;
        for(int i =nLength-1;i>=0;i--){
            //取到第i位的字符转换为数字 +进位符
            //这里存在一个强制转换
            int nSum = number[i] - '0' +nTakeover;
            //末尾自增
            if(i == nLength-1){
                nSum++;
            }
            //说明存在进位关系
            if(nSum >= 10){
                    //首位出现进位说明溢出，
                if(i == 0){
                    isOverFlow = true;
                }else{
                    nSum -= 10;
                    nTakeover = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }else{
                number[i] = (char) ('0'+nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for(int i =0;i<nLength;i++){
            //开头的0不打印
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.print(" ");
    }


    public static void main(String[] args) {
        Solutioin s = new Solutioin();
//        s.PrintN(6);
        s.printMaxOfDigit(10);
    }
}
