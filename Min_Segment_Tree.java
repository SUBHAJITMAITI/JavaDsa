//Time Complexity
//Build : O(n)
//Query : O(log n)
//Update :  O(log n)

// Space Complexity:
//Tree Array = O(n)
//Recursion = O(log n)
//Total = O(n)

public class Min_Segment_Tree {
    public static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildTree(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, 2 * i + 1, start, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);
        tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getMinUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {
            return Integer.MAX_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getMinUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMinUtil(2 * i + 2, mid + 1, sj, qi, qj);

            return Math.min(left, right);

        }

    }

    public static int getMin(int arr[], int qi, int q2) {
        int n = arr.length;
        return getMinUtil(0, 0, n - 1, qi, q2);
    }

    public static void updateUtil(int i, int idx, int newval, int si, int sj) {
        // if (idx < si || idx > sj) {
        //     return;
        // }
        if (si == sj) {
            tree[i] = newval;
            return;
        }

        int mid = (si + sj) / 2;
        if (idx <= mid) {
            updateUtil(2 * i + 1, idx, newval, si, mid);
        } else {
            updateUtil(2 * i + 2, idx, newval, mid + 1, sj);
        }
        tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);

    }

    public static void update(int arr[], int idx, int newval) {
        int n = arr.length;
        arr[idx] = newval;
        updateUtil(0, idx, newval, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n - 1);
        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }
        System.out.println(getMin(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMin(arr, 2, 5));
    }
}
