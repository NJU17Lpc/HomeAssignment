public class Chapter1Test {

    public void combina_r_from_nTest(){
        Chapter1.combina_r_from_n(5,3);
       // Chapter1.combina_r_from_n(8,4);
    }

    public void HanoiTowerTest(){
        Chapter1.HanoiTower(4,'A','B','C');
    }

    public static void main(String[] args){
        Chapter1Test t = new Chapter1Test();
        t.combina_r_from_nTest();
        t.HanoiTowerTest();
    }
}
