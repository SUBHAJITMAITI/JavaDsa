public class BitManupulation {
    // first question
    public static void evenorodd(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0) {
            // Even number
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newbit) {
        // if (newbit == 0) {
        // return clearIthBit(n, i);

        // } else {
        // return setIthBit(n, i);
        // }
        n = clearIthBit(n, i);
        int bitmask = newbit << i;
        return n | bitmask;
    }

    public static int clearLastIthBit(int n, int i) {
        int bitmask = ~0 << i;
        return n & bitmask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ~0 << j + 1;
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    // question 2
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;

    }

    // question 3
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int FastExponentiation(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                ans = ans * a;

            }
            n = n >> 1;
            a = a * a;
        }
        return ans;
    }

    public static void main(String[] args) {
        // evenorodd(3);
        // evenorodd(10);
        // System.out.println(getIthBit(10, 2));
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIthBit(15, 2));
        // System.out.println(clearRangeOfBits(10, 2, 4));
        // System.out.println(isPowerOfTwo(7));
        // System.out.println(countSetBits(10));
        System.out.println(FastExponentiation(3, 5));
        System.out.println(FastExponentiation(5, 3));
    }
}

