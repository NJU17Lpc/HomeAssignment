package util;

public class BinarySearchTree <T extends Comparable<? super T>>{

    private BinaryNode<T> root;

    public BinarySearchTree(){root = null;}
    public void makeEmpty(){root = null;}
    public boolean isEmpty(){return root==null;}

    public BinaryNode<T> getRoot() {
        return root;
    }

    public boolean contains(T x){
        return contains(x, root);
    }

    public BinaryNode<T> findMin(){
        if(isEmpty()){
            System.out.println("树为空");
            return null;
        }
        return findMin(root);
    }

    public BinaryNode<T> findMax(){
        if(isEmpty()){
            System.out.println("树为空");
            return null;
        }
        return findMax(root);
    }

    public void insert(T x){
        root = insert(x, root); //private方法中最后刚好返回根节点
    }

    public BinaryNode<T> remove(T x){
        return remove(x, root);
    }

    public void printTree() {//按照从小到大的顺序递归打印
        if (isEmpty())
            System.out.println("空树");
        else
            printTree(root);
    }
    private void printTree(BinaryNode<T> t){
        if(t==null)
            return;
        printTree(t.left);
        System.out.println(t.data);
        printTree(t.right);
    }

    private boolean contains(T x, BinaryNode<T> t){//建立在搜索树是有序条件下，T实现了Comparable接口
        if(t==null)
            return false;
        int compareResult = x.compareTo(t.data);
        if(compareResult<0)
            return contains(x, t.left);
        else if(compareResult>0)
            return contains(x, t.right);
        else
            return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t){//循环实现
        if(t==null)
            return null;
        while(t.left!=null)
            t = t.left;
        return t;
    }

    private BinaryNode<T> findMax(BinaryNode<T> t){//递归实现
        if(t==null)
            return null;
        else if(t.right==null)
            return t;
        return findMax(t.right);
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t){//递归实现，也可以改成迭代实现，使用pre和cur循环找到空节点和上一个非空节点，再插入
        if(t==null)
            return new BinaryNode<>(x,null,null);

        int compareResult = x.compareTo(t.data);
        if(compareResult<0)
            t.left = insert(x, t.left);
        else if(compareResult>0)
            t.right = insert(x, t.right);
        return t;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t){
        if(t==null)
            return null;
        int compareResult = x.compareTo(t.data);
        if(compareResult<0)
            t.left = remove(x, t.left);
        else if(compareResult>0)
            t.right = remove(x, t.right);
        else if(t.left!=null && t.right!=null){//找到了待删除的元素，同时该元素有2个子节点
            //找到该节点右子树的最小节点a，将a的数据赋给此时的t，然后删除之前的a节点。最后的结果是t保存了新的数据，同时保证了二叉搜索树的结构
            t.data = findMin(t.right).data;
            t.right = remove(t.data, t.right);//利用当前t的数据删除之前的a节点
        }
        else
            t = (t.left!=null)?t.left:t.right;
        return t;
    }
}

//class UnderflowException extends Exception {
//    public UnderflowException(){
//        this("容器下溢异常");
//    }
//    public UnderflowException(String msg){
//        super(msg);
//    }
//}
