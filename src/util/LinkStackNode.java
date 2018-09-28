package util;

public class LinkStackNode <T> {
    T data;
    LinkStackNode next;

    public LinkStackNode(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
}
