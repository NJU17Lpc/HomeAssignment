
public class Chapter3P1Test {

    Chapter3P1 ex = new Chapter3P1();

    public void P_reverse_Test(int[] arr, int p){
        ex.P_reverse(arr, p);
    }

    public void expression_evaluationTest(){
        System.out.println(ex.expression_evaluation("1 * 2 + 3 * 4"));
        System.out.println(ex.expression_evaluation("1 * 3 * 4"));
        System.out.println(ex.expression_evaluation("3 + ( 2 - 5 ) * 6 / 3"));
        System.out.println(ex.expression_evaluation("3 + ( 6 - 4 / 2 ) * 5"));
    }


    public static void main(String[] args){
        Chapter3P1Test t = new Chapter3P1Test();
        t.P_reverse_Test(new int[]{1,2,3,4,5,6},4);
        t.expression_evaluationTest();
    }
}
