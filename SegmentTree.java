//Time Complexity
//Build : O(n)
//Query : O(log n)
//Update : O(log n)

//Space :  O(n)

public class SegmentTree {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int[] arr, int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, i * 2 + 1, start, mid); // left subtree- i * 2 + 1
        buildST(arr, i * 2 + 2, mid + 1, end); // right subtree- i * 2 + 2
        return tree[i] = tree[i * 2 + 1] + tree[i * 2 + 2];

    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { // non overlapping
            return 0;
        } else if (qi <= si && qj >= sj) { // complete overlapping
            return tree[i];

        } else { // partial overlap
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }

    }

    public static int getSum(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) { // O(logn)
        if (si > idx || sj < idx) {
            return;
        }
        tree[i] += diff;
        if (si != sj) { //non-leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff); //left
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff); //right

        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, n - 1, idx, diff); //segment tree updation
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n - 1);
        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }
        System.out.println(getSum(arr, 1, 2));
        update(arr, 2, 2);
        System.out.println(getSum(arr, 1, 2));
    }
}
