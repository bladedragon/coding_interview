package queue.maxInWindows;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Other_heap {


    //大顶堆，从大到小的排列
    private PriorityQueue<Integer> heap=new PriorityQueue<Integer>((o1,o2)->o2-o1);
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        //存放结果集
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num==null||num.length==0||num.length<size||size<=0){
            return result;
        }
        for(int i=0;i<size;i++){
            heap.offer(num[i]);
        }
        result.add(heap.peek());
        //i从1到num.length-size
        for(int i=1;i<num.length+1-size;i++){
            heap.remove(num[i-1]);
            heap.offer(num[i+size-1]);
            result.add(heap.peek());
        }
        return result;
    }
}
