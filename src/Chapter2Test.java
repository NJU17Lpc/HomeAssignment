
import util.ListNode;
import util.NormalList;

public class Chapter2Test {
    Chapter2 ex=new Chapter2();

    public void SinglySwapTest(){
        ListNode<String> node1 = new ListNode("a");
        ListNode<String> node2 = new ListNode("b");
        ListNode<String> node3 = new ListNode("c");
        ListNode<String> node4 = new ListNode("d");

        ex.SinglySwap(node1);
        System.out.println(node1.next.getData());
        System.out.println(node1.next.next.getData());
    }

    public void DoublySwapTest(){
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

        ex.DoublySwap(node1);
        System.out.println(node1.next.getData());
        System.out.println(node1.next.next.getData());
    }

    public void listIntersectionTest(){
        NormalList<Integer> list1 = NormalList.makeConvenientList(new int[]{1,2,3,4,5});
        NormalList<Integer> list2 = NormalList.makeConvenientList(new int[]{1,2,3,4,5,6,7});
        NormalList result = ex.listIntersection(list1,list2);
        showList(result);
    }

    public void listUnionTest(){
        NormalList<Integer> list1 = NormalList.makeConvenientList(new int[]{1,2,3,4,5});
        NormalList<Integer> list2 = NormalList.makeConvenientList(new int[]{1,2,3,4,5,6,7});
        NormalList result = ex.lisitUnion(list1,list2);
        showList(result);
    }

    public void showList(NormalList list){
        ListNode node = list.getFirstNode();
        while(node!=null){
            System.out.print(node.getData());
            node=node.next;
        }
        System.out.println();
    }

    public void reverseListTest(){
        NormalList<Integer> list = NormalList.makeConvenientList(new int[]{1,2,3,4,5,6,7});
        ex.reverseList(list);
        showList(list);
    }

    public static void main(String[] args){
        Chapter2Test chapter2Test = new Chapter2Test();
        //chapter2Test.listIntersectionTest();
        chapter2Test.listUnionTest();
    }
}
