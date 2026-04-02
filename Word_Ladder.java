public class Word_Ladder {

    public static boolean oneCharDiff(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;

    }

    public static boolean findpath(String[] arr, String start, String target, boolean visit[]) {
        if (start.equals(target)) {
            System.out.print(start + " ");
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visit[i] && oneCharDiff(start, arr[i])) {
                visit[i] = true;
                System.out.print(start + "->");
                if (findpath(arr, arr[i], target, visit)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = { "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN" };
        String start = "TOON";
        String target = "PLEA";
        boolean[] visit = new boolean[arr.length];
        findpath(arr, start, target, visit);
    }
}
