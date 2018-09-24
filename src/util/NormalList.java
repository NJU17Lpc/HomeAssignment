package util;

public class NormalList<T> {
    private ListNode firstNode;
    private ListNode lastNode;
    private int size;

    public NormalList(){}

    public NormalList(ListNode<T> node){
        this.firstNode = node;
        this.lastNode = node;
        this.size = 1;
    }

    public NormalList(ListNode<T>[] nodes){
        for(ListNode node:nodes){
            this.add(node);
        }
    }

    public NormalList(T ele){
        this.firstNode=new ListNode(ele);
        this.lastNode=this.firstNode;
        this.size=1;
    }

    public static NormalList<Integer> makeConvenientList(int[] datas){
        ListNode<Integer> item;
        NormalList<Integer> targetList=new NormalList<>();
        for(int i=0; i<datas.length; i++){
            item = new ListNode<>(datas[i]);
            targetList.add(item);
        }
        return targetList;
    }

    public ListNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(ListNode firstNode){
        this.firstNode = firstNode;
    }

    public ListNode getLastNode() {
        return lastNode;
    }

    public void setLastNode(ListNode lastNode) {
        this.lastNode = lastNode;
    }

    public void add(ListNode newNode){//设置一个尾节点方便多了，快多了
        if(firstNode==null) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return;
        }
        lastNode.next = newNode;
        lastNode = newNode;
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

    public boolean insertNode(int index, ListNode newNode){//这个insert有点问题，需要改一下，同时把尾节点换做add方法
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
