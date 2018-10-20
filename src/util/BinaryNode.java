package util;

public class BinaryNode<T> {

    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data){this(data, null, null);}

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void showTree(){
        printTree(left);
        System.out.print(data);
        printTree(right);
    }

    private void printTree(BinaryNode<T> t){
        if(t==null)
            return;
        printTree(t.left);
        System.out.print(t.data);
        printTree(t.right);
    }
}
