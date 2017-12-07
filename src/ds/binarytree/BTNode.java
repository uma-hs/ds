package ds.binarytree;

/**
 * Created by umamaheshwar on 07/12/2017.
 */
public class BTNode {

    private int value;
    private BTNode left;
    private BTNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
