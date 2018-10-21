package util;

public class AvlTree  <T extends Comparable<? super T>>{

    private AvlNode<T> root;

    public AvlTree(){root = null;}
    public void makeEmpty(){root = null;}
    public boolean isEmpty(){return root==null;}

    public void insert(T key){
       insert(root, key);
    }
    public AvlNode<T> findMin(){
        if(isEmpty()){
            System.out.println("树为空");
            return null;
        }
        return findMin(root);
    }

    public void remove(T key){
        remove(key, root);
    }

    private AvlNode<T> findMin(AvlNode<T> t){
        if(t==null)
            return t;
        while(t.left!=null){
            t = t.left;
        }
        return t;
    }
    /**
     *
     * @param tree
     * @param key
     * @return 校验完成后的树，所以balance函数反悔的是一个根节点。这个根节点是从局部地子树到整体的树的
     */
    private AvlNode<T> insert(AvlNode<T> tree,T key){
        if(tree==null){
            tree = new AvlNode<>(key, null, null);
        }
        int cmp = key.compareTo(tree.data);
        if(cmp<0){
            tree.left = insert(tree.left, key);
        }else if(cmp<0){
            tree.right = insert(tree.right, key);
        }//如果结点存在，则不替换
        return balance(tree);//return 校验完成后的树，所以balance函数反悔的是一个根节点。这个根节点是从局部地子树到整体的树的
    }

    private static int ALLOW_BLANCE = 1;//
    private AvlNode<T> balance(AvlNode<T> t){
        if(t==null)
            return t;

        if(t.left.height-t.right.height>ALLOW_BLANCE){//左子树太高了,有左左、左右两种情况
            if(t.left.left.height>=t.right.right.height){//左子树的左子树太高了，左左
                t = LeftLeftRotation(t);
            }else{//左子树的右子树太高了，左右
                t = LeftRightRotation(t);
            }
        }else if(t.right.height-t.left.height>ALLOW_BLANCE){//右子树太高了，有右右、右左两种情况
            if(t.right.left.height>=t.right.right.height){//右子树的左子树太高了，右左
                t = RightLeftRotation(t);
            }else{//右子树的右子树太高了，右右
                t = RightRightRotation(t);
            }
        }

        t.height = maxHeight(t.left.height, t.right.height)+1;
        return t;
    }

    private AvlNode<T> remove(T x, AvlNode<T> t){
        if(t==null)
            return t;
        int cmp = x.compareTo(t.data);
        if(cmp<0){
            t.left = remove(x, t.left);
        }else if(cmp>0){
            t.right = remove(x, t.right);
        }else if(t.left!=null&&t.right!=null){
            t.data = findMin(t.right).data;
            t.right = remove(t.data, t.right);
        }else{
            t = (t.left!=null)?t.left:t.right;
        }
        return balance(t);
    }

    private AvlNode<T> RightRightRotation(AvlNode<T> k1){
        AvlNode<T> k2 = k1.right;//调整链接结构
        k1.right = k2.left;
        k2.left = k1;
        k1.height = maxHeight(k1.left.height, k1.right.height)+1;//更新高度，只要是子树的高度加一就行
        k2.height = maxHeight(k1.height, k2.right.height)+1;

        return k2;//返回的是这个局部子树的根节点，保证这个根节点上移
    }

    private AvlNode<T> LeftLeftRotation(AvlNode<T> k1){
        AvlNode<T> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;

        k1.height = maxHeight(k1.left.height, k1.right.height)+1;
        k2.height = maxHeight(k2.left.height, k1.height)+1;

        return k2;
    }

    private AvlNode<T> LeftRightRotation(AvlNode<T> k1){//只需要局部调用左左和右右的情况
        k1.left = RightRightRotation(k1.left);
        return LeftLeftRotation(k1);
    }

    private AvlNode<T> RightLeftRotation(AvlNode<T> k1){
        k1.right = LeftLeftRotation(k1.right);
        return RightRightRotation(k1);
    }

    private int maxHeight(int height1, int height2){
        return height1>height2?height1:height2;
    }
}
