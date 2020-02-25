package tree.heap.getMidian;

import java.util.PriorityQueue;

public class Other {
    private PriorityQueue<Integer> firstBigHeap =
            new PriorityQueue<>(

                    (o1, o2) -> {
                        if (o1 < o2) {
                            return 1;
                        } else if (o1 > o2) {
                            return -1;
                        }
                        return 0;
                    });

    /** 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100 */
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>();

    private int count;

    public void Insert(Integer num){
        count++;
        if(firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()){
            firstBigHeap.offer(num);
            return;
        }

        if(firstBigHeap.peek() < num){
            afterLittleHeap.offer(num);
        }else{
            firstBigHeap.offer(num);
        }

        int countValue = count/2;


        if(firstBigHeap.size()> countValue){
            move(firstBigHeap,afterLittleHeap,firstBigHeap.size()-countValue);
//注意这里不能return，必须经过下面遍历
        }
        if (afterLittleHeap.size() > countValue) {
            move(afterLittleHeap, firstBigHeap, afterLittleHeap.size() - countValue);
            return;
        }
    }
    private void move(PriorityQueue<Integer> firstBigHeap, PriorityQueue<Integer> afterLittleHeap, int runNum) {
        for(int i=0 ;i<runNum;i++){
            afterLittleHeap.offer(firstBigHeap.poll());
        }
    }

    public  Double GetMedian(){

        double res = 0;
        // 奇数
        if ((count & 1) == 1) {
            res = firstBigHeap.peek();
        } else {
            res = (firstBigHeap.peek() + afterLittleHeap.peek()) / 2.0;
        }
        return res;

    }
}
