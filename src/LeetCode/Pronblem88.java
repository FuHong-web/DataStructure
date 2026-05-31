package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/8 18:43
 * @desc:力扣第88题合并两个有序数组（双指针）
 */
public class Pronblem88 {
    public static void main(String[] args) {
        int[] a={1,2,3,0,0,0};
        int[] b={2,5,6};
        Pronblem88 p88 = new Pronblem88();
        System.out.println(Arrays.toString(p88.merge1(a, 3, b, 3)));//方法一测试
        System.out.println(Arrays.toString(p88.merge2(a,3,b,3)));//方法二测试
        System.out.println(Arrays.toString(p88.merge3(a,3,b,3)));
    }
    //方法一
    public int[] merge1(int[] a,int m,int[] b,int n){
        System.arraycopy(b,0,a,m,n);
        return a;
    }
    //方法二：直接合并后排序
    public int[] merge2(int[] a,int m,int[] b,int n){
        for (int i=0;i<n;i++){
            a[m+i]=b[i];
        }
        return a;
    }
    //方法三:双指针
    public int[] merge3(int[] a,int m,int[] b,int n){
        int[] sorted=new int[m+n];//新数组存储排序后的元素
        int p1=0;//指针1指向数组a
        int p2=0;//指针1指向数组b
        int cur;//选择当前最小的元素
        while (p1<m||p2<n){
            //先处理“某一数组遍历完的情况”（避免越界）
           if (p1==m){//当遍历到数组a的末尾直接将p2所指元素赋值给当前最小元素
               cur=b[p2++];
           }else if (p2==n){//当遍历到数组a的末尾直接将p2所指元素赋值给当前最小元素
               cur=a[p1++];
           }else if (a[p1]<b[p2]){//两边都有剩余元素取较小的那个
               cur=a[p1++];
           }else {
               cur=b[p2++];
           }
           //将当前较小的元素放进新建的排序数组
            sorted[p1+p2-1]=cur;//p1+p2表示已经处理的元素总数，-1是为了满足数组索引从0开始
    }
        return sorted;

}
}
