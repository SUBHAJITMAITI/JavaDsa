public class SpiralMatrix {
    public static void printSpiral(int[][] arr) {
        int startROW = 0;
        int startCOLUM = 0;
        int endROW = arr.length - 1;
        int endCOLUM = arr[0].length - 1;
        while (startROW <= endROW && startCOLUM <= endCOLUM) {
            // top

            for (int j = startCOLUM; j <= endCOLUM; j++) {
                System.out.print(arr[startROW][j] + " ");
            }

            // right

            for (int i = startROW + 1; i <= endROW; i++) {
                System.out.print(arr[i][endCOLUM] + " ");
            }

            // bottom

            for (int j = endCOLUM - 1; j >= startCOLUM; j--) {
                if (startROW == endROW) {
                    break;
                }

                System.out.print(arr[endROW][j] + " ");
            }

            // left

            for (int i = endROW - 1; i >= startROW + 1; i--) {
                if (startCOLUM == endCOLUM) {
                    break;
                }
                System.out.print(arr[i][startCOLUM] + " ");
            }

            startROW++;
            startCOLUM++;
            endROW--;
            endCOLUM--;
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };

        printSpiral(arr);

    }
}
