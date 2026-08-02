package LeetCode_Revice3.zhan;

import java.util.Stack;

/*
* 每日温度
* */
public class p739 {
   public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
       Stack<Integer> stack = new Stack<>();
       int[] res = new int[n];
       for(int i = 0;i<n;i++){
           if(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
               int index = stack.pop();
               res[index] = i-index;
           }
           stack.push(i);
       }
       return res;
    }
}
