package ds.segmenttree;

/**
 * Created by uhs on 11/12/17.
 */
public class SegmentTreeTest {

    public static void main(String[] args) {
        int in[] = new int[] {2, 5, 1, 4, 9, 3};
        SegmentTree segmentTree = new SegmentTree(in);
        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.min(4,6));
    }
}
