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


        segmentTree.update(0, -1);
        segmentTree.update(1, -2);

        System.out.println(segmentTree.min(1,1));

       // System.out.println(segmentTree.toString());

    }
}
