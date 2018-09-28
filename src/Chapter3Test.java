import util.ListNode;
import util.NormalList;

public class Chapter3Test {
    Chapter3 ex = new Chapter3();
    public void polynomial_add_Test(){
        NormalList<Number> list1 = new NormalList<>();
        NormalList<Number> list2 = new NormalList<>();

        list1.add(new ListNode(new Number(3,0)));
        list1.add(new ListNode(new Number(6,4)));
        list1.add(new ListNode(new Number(7,8)));
        list1.add(new ListNode(new Number(-1,12)));
       // list1.add(new ListNode(new Number(1,7)));

        list2.add(new ListNode(new Number(-1,1)));
        list2.add(new ListNode(new Number(-5,3)));
        list2.add(new ListNode(new Number(-7,8)));
        list2.add(new ListNode(new Number(3,12)));
      //  list2.add(new ListNode(new Number(1,5)));
        //list2.add(new ListNode(new Number(1,7)));
        NormalList<Number> result = ex.polynomial_add(list1,list2);

        ListNode<Number> node = result.getFirstNode();
        System.out.println(result.getSize());
        while(node!=null){
            System.out.print(node.getData().coefficient+"*X^"+node.getData().index);
            if(node.next!=null&&node.next.getData().coefficient>=0){
                System.out.print("+");
            }
            node = node.next;
        }

    }

    public void array_josephusTest() {
        System.out.println(ex.array_josephus(199,13));
        System.out.println(ex.array_josephus(531,27));
        System.out.println(ex.array_josephus(200,17));
        System.out.println();
    }

    public void math_josephusTest(){
        System.out.println(ex.math_josephus(199,13));
        System.out.println(ex.math_josephus(531,27));
        System.out.println(ex.math_josephus(200,17));
        System.out.println();
    }

    public void list_josephusTest(){
        System.out.println(ex.list_josephus(199,13));
        System.out.println(ex.list_josephus(531,27));
        System.out.println(ex.list_josephus(200,17));
        System.out.println();
    }

    public static void main(String[] args){
        Chapter3Test t = new Chapter3Test();
        t.polynomial_add_Test();
        System.out.println();
        t.array_josephusTest();
        t.math_josephusTest();
        t.list_josephusTest();

    }

}
