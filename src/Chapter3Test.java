import util.ListNode;
import util.NormalList;

public class Chapter3Test {
    Chapter3 ex = new Chapter3();
    public void polynomial_add_Test(){
        NormalList<Number> list1 = new NormalList<>();
        NormalList<Number> list2 = new NormalList<>();

        list1.add(new ListNode(new Number(1,1)));
        list1.add(new ListNode(new Number(1,2)));
        list1.add(new ListNode(new Number(1,3)));
        list1.add(new ListNode(new Number(1,6)));
        list1.add(new ListNode(new Number(1,7)));

        list2.add(new ListNode(new Number(1,1)));
        list2.add(new ListNode(new Number(1,2)));
        list2.add(new ListNode(new Number(1,3)));
        list2.add(new ListNode(new Number(1,4)));
        list2.add(new ListNode(new Number(1,5)));
        list2.add(new ListNode(new Number(1,7)));
        NormalList<Number> result = ex.polynomial_add(list1,list2);

        ListNode<Number> node = result.getFirstNode();
        System.out.println(result.getSize());
        while(node!=null){
            System.out.print(node.getData().coefficient+"*X^"+node.getData().index);
            if(node.next!=null)
                System.out.print("+");
            node = node.next;
        }

    }

    public void array_josephusTest() {
        System.out.println(ex.array_josephus(11,3));
        System.out.println(ex.array_josephus(13,5));
        System.out.println(ex.array_josephus(1,3));
    }

    public void math_josephusTest(){
        System.out.println(ex.math_josephus(11,3));
        System.out.println(ex.math_josephus(13,5));
        System.out.println(ex.math_josephus(2,3));
    }

    public void list_josephusTest(){
        System.out.println(ex.list_josephus(11,3));
        System.out.println(ex.list_josephus(13,5));
        System.out.println(ex.list_josephus(2,3));
    }

    public static void main(String[] args){
        Chapter3Test t = new Chapter3Test();
       // t.polynomial_add_Test();
       // t.array_josephusTest();
        t.math_josephusTest();
        t.list_josephusTest();

    }

}
