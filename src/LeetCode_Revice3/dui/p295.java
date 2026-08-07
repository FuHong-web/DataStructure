package LeetCode_Revice3.dui;
/*数据流的中位数*/
import java.util.PriorityQueue;

public class p295 {
    class MedianFinder {
        private PriorityQueue<Integer> left;
        private PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((a,b)->b-a);
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            }else {
                right.offer(num);
            }
            if(left.size() - right.size() > 1) {
                right.offer(left.poll());
            }else if(right.size() > left.size()){
                left.offer(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()){
                return (left.peek()+ right.peek()) / 2.0;
            }else {
                return left.peek();
            }
        }
    }
}
