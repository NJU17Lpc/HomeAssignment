import util.CycleList;
import util.ListNode;
import util.NormalList;

public class Chapter3 {

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

    //这个用非数学方法写
    //设置标签0，增加了一些遍历过程，但是只有多余的判断操作
    //相比大面积赋值，效率应该好很多
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

    //这个是用数学公式写的，递归公式为f(M,N)=(f(M-1,N)+N)%M，然后递归转递推
    public int math_josephus(int m, int n){
        int result = 0;
        for(int i=2; i<=m; i++)
            result = (result+n)%i;
        return result+1;
    }

    //用循环链表实现

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
//            ListNode showNode = list.getHead();
//            for(int i=1; i<=20; i++){
//                System.out.print(showNode.getData()+" ");
//                showNode = showNode.next;
//            }
//            System.out.print(" "+list.getHead()+" "+list.getLast());
//            System.out.println();
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
