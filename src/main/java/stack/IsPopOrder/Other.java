package stack.IsPopOrder;

import java.util.Arrays;

public class Other {

    /**
     * 未成功，就算不用栈也只是拿数组去模拟栈
     * @param pushA
     * @param pushB
     * @return
     */
    public boolean IsPopOrder2(int[] pushA,int[] pushB){
        if(pushA.length != pushB.length){
            return false;
        }
        int indexA = pushA.length-1;
        int indexB = 0;
        int flag = pushB[0];
        Arrays.copyOfRange(pushB,1,pushB.length);
        int i;
        for( i =0;i<pushA.length;i++){
            if(pushA[i] == flag){
                break;
            }
        }
        //选取pushB数组的弹出点在pushA中的位置
        int pointer =i;

        if(i == pushA.length){
            return false;
        }
        for(int j =0;j<pushB.length;j++){
            //弹出第一个元素
            int element = pushB[0];
            if(pushB.length >1) {
                Arrays.copyOfRange(pushB, 1, pushB.length);
            }else{
                break;
            }
            //找到pushA中的相应位置
            int k;
            for(k = 0;k<pushA.length;k++){
                if(pushA[k] == element){
                    break;
                }
            }
            if(k == pushA.length){
                return false;
            }

            //理论上讲弹出元素在poushA中的位置应该是上一个弹出点的前面一个压入元素（或者是之后被压入的）
            if(pushA[k]  < pointer -1){
                return false;
            }
            //此处需要删除数组pushA中的pushA[pointer]元素

            pointer = k;

        }
        return true;
    }

    /**
     *
     * 假设pushA中的元素为Xi，popA被X0分割成两个序列p1和p2，因为X0是第一个入栈的元素，所以p1中的元素必定比p2中的元素先入栈，则这两个序列必然都满足弹出序列。
     * 设p1长度为m，则p1对应的入栈序列为X[1:m+1]，p2对应X[m+1:n]，n是原来序列的长度。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int length=popA.length;
        if(length==0)
            return true;
        if(pushA.length == 0){
            return false;
        }
        if(length==1)
            return popA[0]==pushA[0];
        int i;
        for (i = 0; i < popA.length; i++) {
            //注意是得到弹出数组中第一个被压入元素的位置
            if(popA[i]==pushA[0]){
                break;
            }
        }
        if(i == popA.length){
            return false;
        }
        //保持长度的一致性，弹出的数组中压入元素前面的元素一定之后弹出的
        return IsPopOrder(Arrays.copyOfRange(pushA, 1, i+1),Arrays.copyOfRange(popA, 0, i)) &&
                IsPopOrder(Arrays.copyOfRange(pushA, i+1, length),Arrays.copyOfRange(popA, i+1,length));
    }
    public static void main(String[] args) {
        int[] pushA = new int[]{1,2};
        int[] pushB = new int[]{2,0};
        Other o = new Other();
        System.out.println(o.IsPopOrder(pushA,pushB));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(pushA,1,1)));
    }

}
