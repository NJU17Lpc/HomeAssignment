import util.CycleList;
import util.ListNode;
import util.NormalList;

public class Chapter3 {
    /**
     * 用链表实现多项式相加
     * 实际上就是在实现两个链表并集的基础上加上一个数据域的运算
     * @param list1
     * @param list2
     * @return
     */
    public NormalList<Number> polynomial_add(NormalList<Number> list1, NormalList<Number> list2) {
        ListNode<Number> node1 = list1.getFirstNode();
        ListNode<Number> node2 = list2.getFirstNode();
        NormalList<Number> targetList = new NormalList<>();

        if (node1 == null)
            return list2;
        if (node2 == null)
            return list1;
        while (node1 != null && node2 != null) {
            if (node1.getData().index == node2.getData().index) {
                targetList.add(new ListNode<Number>(new Number(node1.getData().coefficient
                        + node2.getData().coefficient, node1.getData().index)));
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.getData().index < node2.getData().index) {
                targetList.add(new ListNode<Number>(new Number(node1.getData().coefficient, node1.getData().index)));
                node1 = node1.next;
            } else {
                targetList.add(new ListNode<Number>(new Number(node2.getData().coefficient, node2.getData().index)));
                node2 = node2.next;
            }
        }

        while(node1==null&&node2!=null){
            targetList.add(new ListNode<Number>(new Number(node2.getData().coefficient, node2.getData().index)));
            node2 = node2.next;
        }
        while(node2==null&&node1!=null){
            targetList.add(new ListNode<Number>(new Number(node1.getData().coefficient, node1.getData().index)));
            node1 = node1.next;
        }

        return targetList;
    }

    /**
     * 非数学方法数组实现约瑟夫环
     * 删除操作考虑到数组大面积移动相对耗时，于是将删除元素设置成一个标记位0
     * 遍历的时候只要忽略0就行了，多的一个if判断操作，且if的后续多余操作可忽略不计
     *
     * 但是当n报号数很大时，会多出来许多不必要的0判断
     * 我觉得可以设置一个填充因子，当含0的比例到达50%时，将剩余非0元素填充到新的数组中
     * 再次执行原方法，进行删除标号
     * @param m
     * @param n
     * @return
     */
    public int array_josephus(int m, int n){//按照ppt上的josephus图示写
        int[] array = new int[m+1];
        int size=m;
        for(int i=0; i<m+1; i++){//填充数组，数组内序号表示每个人原先的号码
            array[i]=i;
        }
        int index = n%m==0?m:n%m;
        if(size==1)
            return index;
        else
            array[index]=0;
        while(true){
            if(size==1){
                return index-1;
            }
            for(int i=0; i<n;){
                if(array[index]!=0){
                   i++;
                }
                if(i==n)
                    break;
                index = (index+1)%(m+1);
            }
            array[index]=0;
            index = (index+1)%(m+1);
            size--;
        }
    }

    /**
     * 约瑟夫环的数学实现
     * 递归公式为f(M,N)=(f(M-1,N)+N)%M，递推
     *
     * 公式理解：
     *     取人数m=8,报号数n=3            1 2 3 4 5 6 7 8
     *     取第一次    3号没了            1 2 4 5 6 7 8
     *     换一个角度,将元素的排列与位置对应起来,即把第一个位置作为本次循环第一个报号的成员，即：
     *                            1 2 |4 5 6 7 8（1 2）
     *                       于是我们可以认为 删除一个元素的操作，等价于把后面的元素 前移3位
     *                       同时把前面的元素 移到后面，可以看成，前面的元素本来就会在后续操作中被读取，因此相对来说也是向前移动了3位
     *                       这一点认知和实际的循环读取操作符合，非常重要！！！
     *                       记f(M，N)为最后被删除元素的   位置  记住是位置!!!!
     *                       f(M-1, N)就是  在一个非常大的循环中  f(M, N)前移了N位  即f(M, N) = f(M-1, N) + N
     *                       由于逻辑数组长度足够大，而实际数组长度为M
     *                       因此f(M, N) = (f(M-1, N) + N) mod M
     *      递推关系：f(1, N)=1   f(2, N) = (f(1, N) + N) mod 2   f(3, N) = (f(2, N) + N) mod 3   f(M, N) = (f(M-1, N) + N) mod M
     * @param m
     * @param n
     * @return
     */

    public int math_josephus(int m, int n){
        int result = 0;
        for(int i=2; i<=m; i++)
            result = (result+n)%i;
        return result+1;
    }


    /**
     * 约瑟夫环的循环链表实现
     * 为了减少删除操作的麻烦，我只使用节点的next域
     * 普通单链表也可以实现，循环链表可以减少回头遍历使用的时间
     * 但是我这个实现里面对链表head和last方面的实现会有一些边界情况没有考虑进去，可以改进
     * @param m
     * @param n
     * @return
     */
    public int list_josephus(int m, int n){
        CycleList<Integer> list = new CycleList<>(new ListNode<>(1));
        ListNode<Integer> node = list.getHead();
        for(int i=2; i<=m; i++)
            list.add(new ListNode<>(i));
        if(m==1)
            return 1;
        while(true) {
            for (int i = 0; i < n-1; i++) {
                node = node.next;
            }
            list.delete(node);
            if(list.getSize()==1)
                break;
        }
        return list.getLast().getData();
    }

}

class Number{
    double coefficient;
    int index;

    public Number(double coefficient, int index){
        this.coefficient = coefficient;
        this.index = index;
    }
}
