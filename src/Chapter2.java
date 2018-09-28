import util.ListNode;
import util.NormalList;

import java.util.List;

public class Chapter2 {
    /**
     * Swap two adjacent elements by adjusting only the links(and not the data)  using:
     a. Singly linked lists.
     b. Doubly linked lists.

     * @param pre
     */
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

    /**
     * Given two sorted lists L1 and L2,write a procedure to compute L1∩ L2
     using only the basic list operations
     * @param list1
     * @param list2
     * @return
     */
    public NormalList listIntersection(NormalList<Integer> list1, NormalList<Integer> list2){
        ListNode<Integer> node1 = list1.getFirstNode();
        ListNode<Integer> node2 = list2.getFirstNode();
        NormalList targetList = new NormalList();

        while(node1!=null&&node2!=null){
            if(node1.getData()==node2.getData()){
                targetList.add(node1);
                node1=node1.next;
                node2=node2.next;
            }else if(node1.getData()<node2.getData()){
                node1=node1.next;
            }else {
                node2=node2.next;
            }
        }
        return targetList;
    }

    /**
     * Given two sorted lists, L1 and L2, write a procedure to compute L1ᴜ L2
     using only the basic list operations.
     * @param list1
     * @param list2
     * @return
     */

    public NormalList lisitUnion(NormalList<Integer> list1, NormalList<Integer> list2){
        ListNode<Integer> node1 = list1.getFirstNode();
        ListNode<Integer> node2 = list2.getFirstNode();
        NormalList targetList = new NormalList();

        while(node1!=null&&node2!=null){
            if(node1.getData()==node2.getData()){
                targetList.add(node1);
                node1=node1.next;
                node2=node2.next;
            }else if(node1.getData()<node2.getData()){
                targetList.add(node1);
                node1=node1.next;
            }else {
                targetList.add(node2);
                node2=node2.next;
            }
        }
        while(node1==null&&node2!=null){
            targetList.add(node2);
            node2=node2.next;
        }
        while(node2==null&&node1!=null){
            targetList.add(node1);
            node1=node1.next;
        }
        return targetList;
    }

    public NormalList reverseList(NormalList list){
        ListNode node1=list.getFirstNode();
        if(node1==null)
            return null;
        ListNode node2=node1.next;
        if(node2==null)
            return list;
        ListNode node3=node2.next;
        node1.next=null;//将第一个节点的Next域指向空
        while(node3!=null){
            node2.next=node1;
            node1=node2;
            node2=node3;
            node3=node3.next;
        }
        node2.next=node1;
        list.setFirstNode(node2);
        return list;
    }
}
