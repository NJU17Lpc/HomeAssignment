import util.ListNode;

public class Chapter3P1 {
    /**
     * 设将n(n,1)个整数存放到一维数组R中，
     * 试设计一个在时间和空间两方面尽可能有效的算法，
     * 将R中保有的序列循环左移P（0﹤P﹤n）个位置，
     * 即将R中的数据由（X0 X1 ……Xn-1）变换为（Xp Xp+1 ……Xn-1  X0  X1 …Xp-1)
     * @param arr
     * @param begin
     * @param end
     */
    private void reverse(int[] arr, int begin, int end){
        for(;begin<end;begin++,end--){
            arr[begin]=arr[begin]^arr[end];
            arr[end]=arr[begin]^arr[end];
            arr[begin]=arr[begin]^arr[end];
        }
    }

    public void P_reverse(int[] arr, int p){
        reverse(arr, 0, p-1);
        reverse(arr, p, arr.length-1);
        reverse(arr, 0, arr.length-1);
        for(int a:arr)
            System.out.print(a);
        System.out.println();
    }

    /**
     * Suppose that a singly list is implemented with both a header and tail node.
     Describe contant-time algorithms to
     a. Insert item x before position  p ( given by an iterator ).
     b. Remove the item stored at position  p ( given by an iterator )

     *由于不方便写一个实现了head和tail还有迭代器的链表
     * 主要我自己想法是  这是单链表  同时默认迭代器给的节点是常数时间
     * 这样就省去了遍历用的O（n）时间
     * 只需要插入一个同前的节点   后修改data域的内容就能实现在前面插入
     *
     *
     * 删除同理
     * 但是这个边界情况，即给的节点为head或者tail时，要考虑清楚
     */

}
