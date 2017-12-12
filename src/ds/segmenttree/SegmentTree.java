package ds.segmenttree;

/**
 * Created by uhs on 11/12/17.
 * https://www.youtube.com/watch?v=Oq2E2yGadnU
 */
public class SegmentTree {

    private int arr[];

    public SegmentTree(int input[]) {
        constructTree(input);
    }

    private void constructTree(int input[]) {
        int n = input.length;
        arr = new int[2*n];
        int j = 0;
        for(int i=n; i<arr.length; i++) {
            arr[i] = input[j];
            j++;
        }
        for(int i= n-1; i>-1; i--) {
            int leftIndex = 2*i;
            int rightIndex=leftIndex+1;
            arr[i]=Math.min(arr[leftIndex],arr[rightIndex]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length/2; i++) {
            sb.append(arr[i]+" ");
        }

        sb.append("\n");
        for(int i=arr.length/2; i<arr.length; i++) {
            sb.append(arr[i]+" ");
        }
        return sb.toString();
    }

    /**
     * Minimum in range including both left & right index.[1-N]
     * @param left (index 1 for 0)
     * @param right(index n for n-1)
     * @return
     */
    public int min(int left, int right) {
        int n = arr.length/2;
        left = n+left-1;
        right = n+right-1;
        int min = Integer.MAX_VALUE;
        while (left<=right){
            //left%2!=0
            if((left&1)!=0) {
                //left should be even
                min = Math.min(min, arr[left]);
                left++;
            }
            //right%2==0
            if((right&1)==0){
                //right should be odd
                min = Math.min(min,arr[right]);
                right--;
            }
            // left = left/2
            left=left>>1;
            right=right>>1;
        }

        return min;
    }

    /**
     * Index [0,N-1]
     * @param index
     * @param value
     */

    public void update(int index, int value) {
        int n = arr.length/2;
        index = n+index;
        while (index>=1){
            arr[index] = value;
            index=index>>1;
            arr[index] = Math.min(arr[index*2], arr[(index*2)+1]);
        }
    }
}
