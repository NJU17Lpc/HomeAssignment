package util;

public class AvlNode<T> {
    public AvlNode(T data){
        this(data, null, null);
    }
    public AvlNode(T data, AvlNode<T> left, AvlNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
    public int height(AvlNode<T> t){
        return t==null?-1:t.height;
    }
    public T data;
    public AvlNode<T> left;
    public AvlNode<T> right;
    public int height;
}
