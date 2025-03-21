import java.util.Scanner;

 class Logging2 {
    public static long maxMoney(int n, long[] values) {
        // Khởi tạo mảng dp với 2 trạng thái cho mỗi cây:
        // dp[i][0]: Tối đa khi không cắt cây i
        // dp[i][1]: Tối đa khi cắt cây i

        long[][] dp = new long[n + 2][2];
        dp [0][0] =0;
        dp [0][1] =0;
        dp [1][0] =0;
        dp [1][1] =0;

        for (int i = 2; i < n+2; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            dp[i][1] = dp[i-2][0] + values[i-2];
        }

        return Math.max(dp[n+1][0], dp[n+1][1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextLong();
        }

        long result = maxMoney(n, values);
        System.out.println(result);

        scanner.close();
    }
}