import java.util.LinkedList;

/**
 * 该章节主要为递归解题
 */
public class Chapter1 {
    /**
     * Write a recursive method that returns the number of 1’s in the binary
     representation of N. Use the fact that is equal to the number of 1’s in the
     representation of N/2, plus 1, if N is odd
     * @param num
     * @return
     */
    public static int count_of_one (int num){
        if(num==0)
            return 0;
        else
            return count_of_one(num/2)+num%2;
    }

    /**
     * Write the routines wise the following declarations:
     public void permute( String str );
     private void permute( char [ ] str, int low, int high )
     The first routine is a driver that calls the second and prints all the
     permutations of the characters in String str.
     If str is “abc”, then the strings that are output are abc, acb, bac, bca, cab,and cba.
     Use recursion for the second routine.
     * @param str
     */
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

    /**
     * 已知a[n]为整型数组，试写出实现下列运算的递归算法。
     1）求数组a中的最大整数。
     2）求n个整数的平均值。
     * @param a
     * @return
     */
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

    /**
     * Write a recursive method that calculates and returns the length of a linked list.
     * @param listNode
     * @return
     */
    public static int length_of_list(LinklistNode listNode){
        if(listNode==null)
            return 0;
        else
            return length_of_list(listNode.next)+1;
    }

    /**
     * Check recursively if the following objects are palindromes:
     a.  A word
     b. a sentence ( ignoring blanks, lower- and uppercase differences, and punctuation marks
     so that “Madam, I’m Adam” is accepted as a palindrome)
     * @param word
     * @return
     */
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

    /**
     * 找出从自然数 1, 2, …, n 中任取r个数的所有组合, 编一个递归算法.
     例子:  n = 5     1  2  3  4  5
     r = 3               5  4  3
                         5  4  2
                         5  4  1
                         5  3  2
                         5  3  1
                         5  2  1
                         4  3  2
                         4  3  1
                         4  2  1
                         3  2  1

     理解 ： 默认高位在前，因为取r个，所以第一位最小为r
     初始状态  n个里选r个   减而治之   n-1个里选r-1个
             最小为1个里选1个

     n个里选r个  需要输出r位，传输r位数组  最高位可以有r到n几个选择，外部使用迭代
     n-1个里选r-1个  需要输出r-1位，传输r-1位数组  最高位可以有r-1到n-1几个选择，外部使用迭代

     1个里选1个  需要输出1位，传输1位数组  最高位为1个选择。程序到最小规模，输出

     其中每个下一步问题的规模依赖于上一步迭代的次数

     输入：5，3
     输出：
     5 4 3
     5 4 2
     5 4 1
     5 3 2
     5 3 1
     5 2 1
     4 3 2
     4 3 1
     4 2 1
     3 2 1
     * @param n
     * @param r
     */
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


    /**
     * 实现Hanoi塔
     *
     * 输入：4
     * 输出：把 块1 从 塔A 放到 塔B 上
     把 块2 从 塔A 放到 塔C 上
     把 块1 从 塔B 放到 塔C 上
     把 块3 从 塔A 放到 塔B 上
     把 块1 从 塔C 放到 塔A 上
     把 块2 从 塔C 放到 塔B 上
     把 块1 从 塔A 放到 塔B 上
     把 块4 从 塔A 放到 塔C 上
     把 块1 从 塔B 放到 塔C 上
     把 块2 从 塔B 放到 塔A 上
     把 块1 从 塔C 放到 塔A 上
     把 块3 从 塔B 放到 塔C 上
     把 块1 从 塔A 放到 塔B 上
     把 块2 从 塔A 放到 塔C 上
     把 块1 从 塔B 放到 塔C 上
     * @param n
     * @param fromTower
     * @param middleTower
     * @param toTower
     */
    /*
    这个问题本来是感觉参数变化太诡异，一直不懂
    下面思路： A   B   C   n在A上，要移动到C上
     一、对于每一个规模为n的问题，都是要在解决规模为n-1问题的基础上进行的
        当移动n时，我们把n-1视为已经移动完成了，换句话说，对n-1的移动的子问题已经被解决
        1、把最大的一块保留在A上，移动n-1块到B上
        2、把A上的一块移到C上
        3、把B上n-1块移到C上
     二、下面是遇到的麻烦
        除了中间一步，剩余的两步都需要建立在已经解决子问题的基础上才能解决
        因此1、3的过程也是递归调用的过程
        为了理解调用过程的合理性，我们用n=3为例子来看：
        1、把n-1=2块放到B上
           a、把(n-1)-1=1块放在C上
           b、把A上1块放在B上
           c、把C上1块放在B上
        2、把A上1块放在C上
        3、把B上2块放在C上
           a、把1块放在A上
           b、把2块放在C上
           c、把1块放在C上
        我们发现，每次调用的三个柱子分为： 源头 辅助 目的
        在函数设立时我们需要确定这三者在参数列表中相对位置，而这个位置对应的柱子不是绝对的
        我们要根据需要不断地将同样的柱子赋予不同的身份

        基本的思路都是：1、找辅助，拆分 2、单个问题从源头到目的，归位 3、辅助位到目的，归位
        因此函数形式不会改变

      三、
        n=1时，对于问题来说，将圆盘从A到C，因此此时圆盘一定是在A上
        另一个角度，反过来看，已经移动完毕的圆盘可以当做空气
        于是对任何的n的问题，当规模缩小到n=1时，都等价于移动一个圆盘的问题
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