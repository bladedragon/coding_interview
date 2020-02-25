package tree.heap.getMidian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private int cnt = 0;
    private PriorityQueue<Integer> largerHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private PriorityQueue<Integer> smallerHeap = new PriorityQueue<>();
    public void Insert(Integer num){
        // 数量++
        cnt++;
        // 如果为奇数的话
        if ((cnt & 1) == 1) {
            // 由于奇数，需要存放在大顶堆上
            // 但是呢，现在你不知道num与小顶堆的情况
            // 小顶堆存放的是后半段大的数
            // 如果当前值比小顶堆上的那个数更大
            if (!smallerHeap.isEmpty() && num > smallerHeap.peek()) {
                // 存进去
                smallerHeap.offer(num);
                // 然后在将那个最小的吐出来
                num = smallerHeap.poll();
            } // 最小的就放到大顶堆，因为它存放前半段
            largerHeap.offer(num);
        } else {
            // 偶数的话，此时需要存放的是小的数
            // 注意无论是大顶堆还是小顶堆，吐出数的前提是得有数
            if (!largerHeap.isEmpty() && num < largerHeap.peek()) {
                largerHeap.offer(num);
                num = largerHeap.poll();
            } // 大数被吐出，小顶堆插入
            smallerHeap.offer(num);
        }
    }

    public Double GetMedian() {// 表明是偶数
        double res = 0;
        // 奇数
        if ((cnt & 1) == 1) {
            res = largerHeap.peek();
        } else {
            res = (largerHeap.peek() + smallerHeap.peek()) / 2.0;
        }
        return res;
    }
}
