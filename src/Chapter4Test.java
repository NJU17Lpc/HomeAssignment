import util.BinaryNode;
import util.BinarySearchTree;

public class Chapter4Test<T> {

    BinarySearchTree tree = new BinarySearchTree();

    public Chapter4Test(){
        initTree();
    }

    private void makeBinaryTree_Post_Test(){
        BinaryNode<String> node;
        node = Chapter4.makeBinaryTree_Post("a,b,c,/,-");
        node.showTree();
        System.out.println();
    }

    private void preOrderTraverseTest(){
      //  Chapter4.preOrderTraverse(tree.getRoot());
        Chapter4.preOrderTraverse(makeHeapTree("ABCDE*F**GH"));
      //  Chapter4.preOrderTraverse(makeHeapTree("ABCDEF"));
        System.out.println();
    }

    private void inOrderTraverseTest(){
       // Chapter4.inOrderTraverse(tree.getRoot());
        Chapter4.inOrderTraverse(makeHeapTree("ABCDE*F**GH"));
        System.out.println();
    }

    private void postOrderTraverseTest(){
      //  Chapter4.postOrderTraverse(tree.getRoot());
        Chapter4.postOrderTraverse(makeHeapTree("ABCDE*F**GH"));
        System.out.println();
    }

    private void initTree(){
        tree.insert("a");
        tree.insert("b");
        tree.insert("d");
        tree.insert("e");
        tree.insert("c");

    }

    private BinaryNode<Character> makeHeapTree(String str){
        char[] clist = str.toCharArray();
        BinaryNode<Character>[] targetList = new BinaryNode[clist.length+1];
        for(int i=0; i<clist.length; i++){
            targetList[i+1]=new BinaryNode<>(clist[i]);
        }
        int length=targetList.length-1;
        for(int i=1; i<=length; i++){
            targetList[i].left = (2*i>length||targetList[2*i].data=='*')?null:targetList[2*i];
            targetList[i].right = (2*i+1>length||targetList[2*i+1].data=='*')?null:targetList[2*i+1];
        }
        return targetList[1];
    }

    public static void main(String[] args){
        Chapter4Test t = new Chapter4Test();
       // t.makeBinaryTree_Post_Test();
        t.preOrderTraverseTest();
        t.inOrderTraverseTest();
        t.postOrderTraverseTest();
    }
}
