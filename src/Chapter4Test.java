import util.BinaryNode;
import util.BinarySearchTree;

public class Chapter4Test {

    BinarySearchTree tree = new BinarySearchTree();

    public Chapter4Test(){
        initTree();
    }

    public void makeBinaryTree_Post_Test(){
        BinaryNode<String> node;
        node = Chapter4.makeBinaryTree_Post("a,b,c,/,-");
        node.showTree();
        System.out.println();
    }

    public void preOrderTraverseTest(){
        Chapter4.preOrderTraverse(tree.getRoot());
        System.out.println();
    }

    public void inOrderTraverseTest(){
        Chapter4.inOrderTraverse(tree.getRoot());
        System.out.println();
    }

    public void postOrderTraverseTest(){
        Chapter4.postOrderTraverse(tree.getRoot());
        System.out.println();
    }

    private void initTree(){
        tree.insert("a");
        tree.insert("b");
        tree.insert("d");
        tree.insert("e");
        tree.insert("c");

    }
    public static void main(String[] args){
        Chapter4Test t = new Chapter4Test();
        t.makeBinaryTree_Post_Test();
        t.preOrderTraverseTest();
        t.inOrderTraverseTest();
        t.postOrderTraverseTest();
    }
}
