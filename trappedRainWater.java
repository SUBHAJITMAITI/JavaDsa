public class trappedRainWater {
    public static int trapWater(int height[]) {
        if(height.length<3){
            return 0;
        }
        int n = height.length;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int TrapW = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            TrapW += waterLevel - height[i];
        }
        return TrapW;
    }

    public static void main(String[] args) {
        int height[] = { 2, 4,6,8,10 };
        System.out.println(trapWater(height));
    }
}
