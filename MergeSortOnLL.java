import java.util.LinkedList;

public class MergeSortOnLL {
    public static void merge(LinkedList<Integer> ll, int mid, int start, int last) {
        LinkedList<Integer> ll1 = new LinkedList<>();
        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= last) {
            if (ll.get(i) < ll.get(j)) {
                ll1.add(ll.get(i));
                i++;
              
            } else {
                ll1.add(ll.get(j));
                j++;
            }
        }
        while (i <= mid) {
            ll1.add(ll.get(i));
            i++;
        }
        while (j <= last) {
            ll1.add(ll.get(j));
            j++;
        }
        for (int t = 0; t < ll1.size(); t++) {
            ll.set(start+t, ll1.get(t));
        }

    }

    public static void sort(LinkedList<Integer> ll, int start, int last) {
        if (start != last) {
            int mid = (start + last) / 2;
            sort(ll, start, mid);
            sort(ll, mid + 1, last);
            merge(ll, mid, start, last);
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(2);
        ll.add(9);
        ll.add(3);
        ll.add(1);
        ll.add(7);
        sort(ll, 0, ll.size() - 1);
        System.out.println(ll);
    }
}
