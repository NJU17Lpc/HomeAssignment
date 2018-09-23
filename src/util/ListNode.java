package util;

public class ListNode<T> {
    private T data;
    public ListNode next;
    public ListNode pre;
    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public ListNode(){}

    public ListNode(T data){
        this.data = data;
    }
}
