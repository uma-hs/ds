package ds.binarytree;

/**
 * Created by umamaheshwar on 07/12/2017.
 */
public class BinaryTree {

    private BTNode root;

    public BinaryTree(BTNode root) {
        this.root = root;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode node) {
        if(node==null){
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getValue()+" ");
        inorder(node.getRight());
    }
}
