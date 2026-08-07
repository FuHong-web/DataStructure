package LeetCode_Revice3.dui;

import java.util.PriorityQueue;

/*数组中第k大的元素*/
public class p215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            if(heap.size() > k) {
                heap.add(num);
                heap.poll();
            }
        }
        return heap.peek();
    }
}
