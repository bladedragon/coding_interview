package companys_questions.baidu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        if(n ==2){

        }
        PriorityQueue<Long> queue = new PriorityQueue<>((o1,o2) -> {
            if(o2 >o1){
                return 1;
            }else if(o2 <o1){
                return -1;
            }
            return 0;
        });
        for(int i =0;i<n;i++){
            a[i] = scanner.nextLong();
            queue.offer(a[i]);
        }

        int opereate =0;
        int index = 0;
        int remain = 0;
        while(queue.peek()+remain >= n && queue.size() !=1){
            Long first = queue.poll();
            Long second = queue.poll();
            if(first + remain - second >n){
                long div = first /n;
                System.out.println(div);
                opereate += div;
                index += div;
            }
            remain++;
            remain += index;
            index = 0;
            opereate++;
            queue.offer(second);
        }
        if(queue.peek() +remain >=n){
            long div = queue.peek()/n;
            opereate+=div;
        }
        System.out.println(opereate);
    }

}
