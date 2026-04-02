//Time Complexity
//Build : O(n)
//Query : O(log n)
//Update :  O(log n)

// Space Complexity:
//Tree Array = O(n)
//Recursion = O(log n)
//Total = O(n)

public class Max_Min_Segment_Tree {
    public static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildTree(int arr[], int i, int start, int end) { //O(n)
        if (start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = (start + end) / 2; // start+ (end-start)/2
        buildTree(arr, 2 * i + 1, start, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getMaxUtil(int i, int s1, int s2, int q1, int q2) {  //O(logn)
        if (s1 > q2 || s2 < q1) { //no overlap
            return Integer.MIN_VALUE;
        }
        if (s1 >= q1 && s2 <= q2) { //complete overlap
            return tree[i];
        } else { //partial overlap

            int mid = (s1 + s2) / 2;
            int left = getMaxUtil(2 * i + 1, s1, mid, q1, q2);
            int right = getMaxUtil(2 * i + 2, mid + 1, s2, q1, q2);
            return Math.max(left, right);

        }
    }

    public static int getMax(int arr[], int q1, int q2) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, q1, q2);
    }

    public static void updateUtil(int i, int idx, int s1, int s2, int newVal) { //O(logn)
        if (s1 == s2) {
            tree[i] = newVal;
            return;
        }

        int mid = (s1 + s2) / 2;
        if (idx <= mid) {
            updateUtil(2 * i + 1, idx, s1, mid, newVal);
        } else {
            updateUtil(2 * i + 2, idx, mid + 1, s2, newVal);
        }
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);

    }

    public static void update(int arr[], int idx, int newVal) {

        int n = arr.length;

        arr[idx] = newVal;
        updateUtil(0, idx, 0, n - 1, newVal);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n - 1);
        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }
        System.out.println(getMax(arr, 0, n - 1));
        update(arr, 2, 2);
        System.out.println(getMax(arr, 0, n - 1));
    }
}

