package util;

/**
 * 这种链栈一般是元素数量不能准确预测时使用
 * 如果元素变化数量在可控范围内，还是最好要用顺序栈
 *
 */
public class LinkStack<T> {

    private LinkStackNode<T> firstNode;
    private int size;

    public LinkStack(LinkStackNode<T> firstNode){
        this.firstNode = firstNode;
        this.size = 1;
    }

    public LinkStack(){}

    public boolean isEmpty(){
        return size<=0;
    }

    public int getSize(){
        return size;
    }

    public void push(LinkStackNode<T> newNode){
        if(firstNode==null){
            firstNode = newNode;
        }
        newNode.next = firstNode;
        firstNode = newNode;
        size++;
    }

    public LinkStackNode<T> pop(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("栈中已没有元素");
        }
        LinkStackNode res = firstNode;
        firstNode = firstNode.next;
        size--;
        return res;
    }

    public LinkStackNode<T> peek(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("栈中已没有元素");
        }
        LinkStackNode res = firstNode;
        return res;
    }

}
