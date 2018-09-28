import util.LinkStack;
import util.LinkStackNode;
import util.ListNode;

public class Chapter3P1 {
    /**
     * 设将n(n,1)个整数存放到一维数组R中，
     * 试设计一个在时间和空间两方面尽可能有效的算法，
     * 将R中保有的序列循环左移P（0﹤P﹤n）个位置，
     * 即将R中的数据由（X0 X1 ……Xn-1）变换为（Xp Xp+1 ……Xn-1  X0  X1 …Xp-1)
     * @param arr
     * @param begin
     * @param end
     */
    private void reverse(int[] arr, int begin, int end){
        for(;begin<end;begin++,end--){
            arr[begin]=arr[begin]^arr[end];
            arr[end]=arr[begin]^arr[end];
            arr[begin]=arr[begin]^arr[end];
        }
    }

    public void P_reverse(int[] arr, int p){
        reverse(arr, 0, p-1);
        reverse(arr, p, arr.length-1);
        reverse(arr, 0, arr.length-1);
        for(int a:arr)
            System.out.print(a);
        System.out.println();
    }

    /**
     * Suppose that a singly list is implemented with both a header and tail node.
     Describe contant-time algorithms to
     a. Insert item x before position  p ( given by an iterator ).
     b. Remove the item stored at position  p ( given by an iterator )

     *由于不方便写一个实现了head和tail还有迭代器的链表
     * 主要我自己想法是  这是单链表  同时默认迭代器给的节点是常数时间
     * 这样就省去了遍历用的O（n）时间
     * 只需要插入一个同前的节点   后修改data域的内容就能实现在前面插入
     *
     *
     * 删除同理
     * 但是这个边界情况，即给的节点为head或者tail时，要考虑清楚
     */

    /**
     *   中缀表达式    ----------    后缀表达式    ----------  对后缀表达式求值
     *   合为一趟来做
     *
     *   默认输入为String参数，数字、操作符之间用“ ”隔开
     *   对于题目理解：表述不是很清楚，我默认它让我直接对中缀表达式求值
     *
     *   基本思路：测试用例只有+-*\\/，和一组小括号
     *   默认
     *   1、当操作栈没有元素时，不必使用优先级比较，直接压栈
     *   2、遇到数字元素，直接将数字压到数字栈
     *   3、遇到操作符，先做步骤1，若不符合条件，比较当前操作符与操作栈栈顶操作符的优先级
     *      a、当前操作符与栈顶操作符优先级相同，默认按照四则运算顺序，先使用栈顶操作符，将得到的新数据压入数据栈，然后将当前操作符压入操作栈
     *      b、当前操作符（*）比栈顶操作符优先级高（-+），直接将操作符压入操作栈
     *      c、当前操作符（+-）比栈顶操作符优先级低（*），因此有必要把优先级高的事情做掉，于是取栈顶操作符进行操作，接着数据栈压入新的数据，
     *      最后当前的操作符压入操作栈
     *      d、遇到”(“直接压栈
     *      e、遇到“)”，说明括号已经结束，因此不断取操作符进行运算，直到取出的操作符为"("停止
     *      f、所有表达式元素读取结束后，对所有操作符按顺序出栈进行运算
     */
    public double expression_evaluation(String str){
        String[] expression = str.split(" ");
        LinkStack<String> operatorStack = new LinkStack();
        LinkStack<String> numberStack = new LinkStack();
        try {
            for (String s : expression) {
                if (s.matches("\\s*"))
                    continue;
                if (s.matches("[+\\-*/]")) {
                    if(operatorStack.isEmpty()){
                        operatorStack.push(new LinkStackNode<>(s));
                        continue;
                    }
                    if (!numberStack.isEmpty() && sameOrBigger(operatorStack.peek().getData(), s))//栈顶操作符优先级高于目标操作符
                        compute(operatorStack, numberStack);
                    operatorStack.push(new LinkStackNode<>(s));
                }else if(s.equals("(")){
                    operatorStack.push(new LinkStackNode<>(s));
                }else if(s.equals(")")){
                    while(!operatorStack.peek().getData().equals("("))
                        compute(operatorStack, numberStack);
                    operatorStack.pop();
                }else{
                    numberStack.push(new LinkStackNode<>(s));
                }

            }

            while(!operatorStack.isEmpty()){
                compute(operatorStack, numberStack);
            }
        }catch (Exception e){
            System.out.println("异常中止");
        }
        //return Integer.valueOf(numberStack.peek().getData());
    return Double.valueOf(numberStack.peek().getData());
    }

    private boolean sameOrBigger(String op1, String op2){
        if(op1.matches("[+\\-]")&&op2.matches("[*/]"))
            return false;
        if(op1.equals("("))
            return false;
        return true;
    }

    private void compute(LinkStack<String> operateStack, LinkStack<String> numberStack) throws Exception{
        if(operateStack.getSize()<1||numberStack.getSize()<2)
            throw new Exception("栈中可供使用的操作符或数字数目不正确");
        double x = Double.valueOf(numberStack.pop().getData());
        double y = Double.valueOf(numberStack.pop().getData());
        String s = operateStack.pop().getData();
        switch(s){
            case "+":
                numberStack.push(new LinkStackNode<>(String.valueOf(y+x)));
                break;
            case "-":
                numberStack.push(new LinkStackNode<>(String.valueOf(y-x)));
                break;
            case "*":
                numberStack.push(new LinkStackNode<>(String.valueOf(y*x)));
                break;
            case "/":
                numberStack.push(new LinkStackNode<>(String.valueOf(y/x)));
                break;
                default:
                    throw new Exception("操作符格式不正确");
        }


    }

}
