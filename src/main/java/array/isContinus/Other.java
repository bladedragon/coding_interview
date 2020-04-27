package array.isContinus;

import java.util.Arrays;

public class Other {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5){
            return false;
        }
        Arrays.sort(numbers);

       int zeroCount = 0;
       int pre = -1;
       int count = 0;
       for(int number: numbers){
           //1.添加大小王
           if(number == 0){
               zeroCount++;
               continue;
           }
           //2. 保留上一个数
           if(pre == -1){
               pre = number;
           }else{
               //3. 每次和上一个数进行比较，去重并计算空余值
               int t = number-pre-1;
               if(t >0){
                   count+= t;
                   //如果出现重复，这里就会变成负数
               }else{
                   return false;
               }
           }
           pre  = number;
       }
       if(count == 0){
           return true;
       }else{
           return zeroCount==count;
       }
    }
}
