import java.util.LinkedList;

public class Chapter1 {
    public static int count_of_one (int num){
        if(num==0)
            return 0;
        else
            return count_of_one(num/2)+num%2;
    }

    public void permute(String str){
        char[] temp = str.toCharArray();
        permute(temp, 0, temp.length-1);
    }

    private void permute(char[] str, int low, int high){
        String result = "";
        if(low==high){
            for(char c:str)
                result += c;
            System.out.println(result);
        }
        for(int i=low; i<=high; i++){
            swap(str, i, low);
            permute(str, low+1, high);
            swap(str, i, low);
        }
    }

    private static void swap(char[] str, int a, int b){
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }


    public static int maxNum(int[] a){
        int max;
        if(a.length==0)
            return Integer.MIN_VALUE;
        else
            max=a[0];
        return maxNum(a, max, 0);
    }

    private static int maxNum(int[] a, int max, int index){
        if(index==a.length)
            return max;
        else{
            if(a[index]>max)
                max=a[index];
            return maxNum(a,max,index+1);
        }
    }

    public static double averageNum(int[] a){
        if(a.length==0)
            return Integer.MIN_VALUE;
        return averageNum(a, 0, 0);
    }

    private static double averageNum(int[] a, int average, int index){
        if(index==a.length)
            return average/(double)a.length;
        else{
            average += a[index];
            return averageNum(a, average, index+1);
        }
    }

    public static int length_of_list(LinklistNode listNode){
        if(listNode==null)
            return 0;
        else
            return length_of_list(listNode.next)+1;
    }

    public static boolean wordPalindromes(String word){
        if(word.equals(""))
            return true;
        int low=0;
        int high=word.length()-1;
        return wordPalindromes(word.toCharArray(), low, high);
    }

    private static boolean wordPalindromes(char[] word, int low, int high){
        if(low>=high)
            return true;
        else if(word[low]==word[high]||Character.toUpperCase(word[low])==Character.toUpperCase(word[high]))
            return wordPalindromes(word, low+1, high-1);
        else
            return false;
    }

    public static boolean sentencePalindromes(String sentence){
        if(sentence.equals(""))
            return true;
        sentence = sentence.toLowerCase();
        String result = "";
        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i)>='a'&&sentence.charAt(i)<='z')
                result += sentence.charAt(i);
        }
        System.out.println(result);
        return wordPalindromes(result);
    }

    public static void main(String[] args){
//        System.out.println(Chapter1.count_of_one(3));
//        System.out.println(Chapter1.count_of_one(0));
//        System.out.println(Chapter1.count_of_one(1));
//        System.out.println(Chapter1.count_of_one(8));
//
//        Chapter1 test1 = new Chapter1();
//        test1.permute("abcd");
//
//        int[] a = {1,2,3,4};
//        System.out.println(Chapter1.maxNum(a));
//        System.out.println(Chapter1.averageNum(a));
//        System.out.println(Chapter1.wordPalindromes("abcba"));
//        System.out.println(Chapter1.wordPalindromes("abcBA"));
//        System.out.println(Chapter1.wordPalindromes("abcbB"));
//        System.out.println(Chapter1.sentencePalindromes("Madam, I‟m Adam"));
//        System.out.println(Chapter1.wordPalindromes("abcBA"));
      //  Chapter1.combina_r_from_n(5,3);
        Chapter1.HanoiTower(3,'A','B','C');
    }


    //对于n中取r个元素，每一次递归将问题规模缩小成在n-1中取r-1个元素
    public static void combina_r_from_n(int n, int r){
        int[] a = new int[r];
        for(int i=n; i>=r; i--)
          combina_r_from_n(a, i, r);
    }

    private static void combina_r_from_n(int[] a, int n, int r){
        if(r==1){
            a[r-1]=n;//将最后一个元素位置确定在输出数组第一位
            for(int i=a.length-1; i>=0; i--){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }else{
            a[r-1]=n;//输出数组最后一位为n，确定部分结果，并且后续递归中不会出现这个值
            for(int j = n-1; j >= r-1; j--){
                combina_r_from_n(a,j,r-1);//子问题的规模缩小
            }
        }
    }



    /*
    这个问题本来是感觉参数变化太诡异，一直不懂
    下面思路：
    一、对于每一个规模为n的问题，都是要在解决规模为n-1问题的基础上进行的


     */
    public static void HanoiTower(int n, char fromTower, char middleTower, char toTower){
        if(n==1)
            System.out.println("把 块"+n+" 从 塔"+fromTower+" 放到 塔"+toTower+" 上");
        else{
            HanoiTower(n-1, fromTower, toTower, middleTower);
            System.out.println("把 块"+n+" 从 塔"+fromTower+" 放到 塔"+toTower+" 上");
            HanoiTower(n-1, middleTower, fromTower, toTower);
        }


    }


}

class LinklistNode {
    int data;
    LinklistNode next;

    public LinklistNode(){}

    public LinklistNode(int data, LinklistNode next){
        this.data = data;
        this.next = next;
    }
}