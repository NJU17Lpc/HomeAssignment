import util.BinaryNode;
import util.LinkStack;
import util.LinkStackNode;

public class Chapter4 {

    /**
     * 编写一个Java函数， 输入后缀表达式， 构造其二叉树
     表示。设每个操作符有一个或两个操作数。
     * @param exp 元素之间用逗号隔开
     */
   public static BinaryNode<String> makeBinaryTree_Post(String exp){
       LinkStack<BinaryNode<String>> stack = new LinkStack<>();
       String[] expList = exp.split(",");
       LinkStackNode<BinaryNode<String>> node1;
       LinkStackNode<BinaryNode<String>> node2;

       for(String s:expList){
           if(s.matches("[+\\-*\\/]")){
                node1 = stack.pop();
                node2 = stack.pop();
               stack.push(new LinkStackNode<>(new BinaryNode<>(s,node2.getData(),node1.getData())));
           }
           else if(s.equals("~")){
                node1 = stack.pop();
               stack.push(new LinkStackNode<>(new BinaryNode<>(s,null,node1.getData())));
           }else{
               stack.push(new LinkStackNode<>(new BinaryNode<String>(s,null,null)));
           }
       }
        return stack.pop().getData();
   }

    /**
     * 建立一棵二叉树，并输出前序、中序、后序遍历结果
     * @param root
     */

   public static void preOrderTraverse(BinaryNode root){//输出二叉树的前序遍历
       if(root==null)
           return ;
       System.out.print(root.data);
       preOrderTraverse(root.left);
       preOrderTraverse(root.right);
   }
   public static void inOrderTraverse(BinaryNode root){//输出二叉树的后序遍历
       if(root==null)
           return ;
       inOrderTraverse(root.left);
       System.out.print(root.data);
       inOrderTraverse(root.right);
   }
    public static void postOrderTraverse(BinaryNode root){//输出二叉树的后序遍历
        if(root==null)
            return ;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data);
    }

   public static void main(String[] args){
       BinaryNode<String> node;
       node = Chapter4.makeBinaryTree_Post("a,b,c,/,-,~");
       node.showTree();
   }

}
