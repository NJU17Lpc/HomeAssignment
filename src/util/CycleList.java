package util;

public class CycleList<T> {
    //舍弃ListNode的pre域
    ListNode<T> head;//头结点作为正常节点使用
    ListNode<T> last;//方便添加节点，用最后一个
    int size=0;
    public CycleList (ListNode<T> node){
        size++;
        if(head==null){
            head = node;
            head.next = head;
            last=head;
        } else{
            last.next = node;
            node.next = head;
        }
    }
    public CycleList(){}

    public int getSize(){return this.size;}

    public ListNode<T> getHead(){return this.head;}

    public ListNode<T> getLast() {
        return last;
    }

    public void add(ListNode<T> newNode){
        last.next = newNode;
        newNode.next = head;
        last = newNode;
        size++;
    }
    public void delete(ListNode<T> node){//要求待删除的Node必须在链表中
        T temp = node.getData();
        node.setData((T)node.next.getData());
        node.next = node.next.next;
        if(head.getData().equals(temp))
            head=node;
        if(last.getData().equals(temp))
            last=node;
        size--;
    }
    /**
     *
     * @param m 1到m分别作为ListNode的数据，构建新的CycList
     */
    public void makeList(int m){

        for(int i=1; i<=m; i++){

        }
    }
}

