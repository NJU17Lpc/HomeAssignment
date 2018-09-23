package util;

public class NormalList<T> {
    private ListNode firstNode;
    private int size;

    public NormalList(){}

    public NormalList(ListNode<T> node){
        this.firstNode = node;
        this.size = 1;
    }

    public NormalList(ListNode<T>[] nodes){
        for(ListNode node:nodes){
            this.add(node);
        }
    }

    public NormalList(T ele){
        this.firstNode=new ListNode(ele);
    }

    public ListNode getFirstNode() {
        return firstNode;
    }

    public void add(ListNode newNode){
        ListNode tempNode = firstNode;
        ListNode tempPreNode = tempNode;
        while(tempNode!=null){
            tempPreNode = tempNode;
            tempNode = tempNode.next;
        }
        tempPreNode.next = newNode;
        size++;
    }

    public ListNode find(int index){   //从0开始
        if(index<0 || index>=size){
            return null;
        }
        int j=0;
        ListNode tempNode = firstNode;
        while(j<index&&tempNode!=null){
            tempNode = tempNode.next;
            j++;
        }
        return tempNode;
    }

    public ListNode deleteNode(int index){
        if(index<0 || index>=size){
            return null;
        }
        int j=0;
        ListNode tempNode = firstNode;
        ListNode tempPreNode = firstNode;
        while(j<index&&tempNode!=null){
            tempPreNode = tempNode;
            tempNode = tempNode.next;
            j++;
        }
        tempPreNode.next = tempNode.next;
        return tempNode;
    }

    public boolean insertNode(int index, ListNode newNode){
        if(index<0 || index>size){
            return false;
        }
        int j=0;
        ListNode tempNode = firstNode;
        ListNode tempPreNode = firstNode;
        while(j<index&&tempNode!=null){
            tempPreNode = tempNode;
            tempNode = tempNode.next;
            j++;
        }
        newNode.next = tempPreNode.next;
        tempPreNode.next = newNode;
        size++;
        return true;
    }

    public void displayList(){
        System.out.print("List中各元素为：");
        ListNode node = firstNode;
        while(node!=null){
            System.out.print(node.getData()+" ");
            node = node.next;
        }
        System.out.println();
    }

}
