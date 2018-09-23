import util.ListNode;
import util.NormalList;

public class Chapter2 {
    public void SinglySwap(ListNode pre){
        ListNode node1=pre.next;
        ListNode node2=node1.next;
        pre.next = node2;
        node1.next = node2.next;
        node2.next = node1;

    }

    public void DoublySwap(ListNode before){
        ListNode node1=before.next;
        ListNode node2=node1.next;
        before.next=node2;
        node2.pre=before;
        node1.next=node2.next;
        node2.next.pre=node1;
        node2.next=node1;
        node1.pre=node2;
    }

    public NormalList listIntersection(NormalList list1, NormalList list2){
        ListNode node1 = list1.getFirstNode();
        ListNode node2 = list2.getFirstNode();
        NormalList targetList = new NormalList();

        return targetList;
    }

    public static void main(String[] args){
        ListNode<String> node1 = new ListNode("a");
        ListNode<String> node2 = new ListNode("b");
        ListNode<String> node3 = new ListNode("c");
        ListNode<String> node4 = new ListNode("d");

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.pre=node3;
        node3.pre=node2;
        node2.pre=node1;

        Chapter2 ex = new Chapter2();
        ex.DoublySwap(node1);
        System.out.println(node1.next.getData());
        System.out.println(node1.next.next.getData());

    }


}

class Node<T> {
    T data;
    Node pre;
    Node next;
    Node(T data){this.data=data;}
    Node(){}
}
