import java.util.*;

public class EIBORE_ThatTinh {
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt(); // Đọc số phần tử của mảng

    // HashMap<Integer, Integer> freq = new HashMap<>();
    // int max_x = 0; // Số lớn nhất trong mảng

    // // Đọc mảng và đếm tần suất xuất hiện của từng số
    // for (int i = 0; i < n; i++) {
    // int num = sc.nextInt();
    // freq.put(num, freq.getOrDefault(num, 0) + 1);
    // max_x = Math.max(max_x, num);
    // }

    // // Nếu dãy toàn số 0 hoặc rỗng thì không có điểm nào
    // if (max_x == 0) {
    // System.out.println(0);
    // return;
    // }

    // // Khởi tạo DP
    // HashMap<Integer, Long> dp = new HashMap<>();
    // dp.put(0, 0L);
    // dp.put(1, (long) freq.getOrDefault(1, 0) * 1);

    // // Áp dụng công thức DP
    // for (int i = 2; i <= max_x; i++) {
    // long take = dp.getOrDefault(i - 2, 0L) + (long) i * freq.getOrDefault(i, 0);
    // long notTake = dp.getOrDefault(i - 1, 0L);
    // dp.put(i, Math.max(take, notTake));
    // }

    // // Kết quả là giá trị tại dp[max_x]
    // System.out.println(dp.get(max_x));
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max_x = 0;
        for (int x : arr) {
            max_x = Math.max(max_x, x);
        }

        int[] freq = new int[max_x + 2];
        for (int x : arr) {
            freq[x]++;
        }
        if (max_x == 0) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[max_x + 1];
        dp[0] = 0;
        dp[1] = (long) freq[1];
        for (int i = 2; i < dp.length; i++) {
            long take = freq[i] * i + dp[i - 2];
            long notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }

        System.out.println(dp[max_x]);
    }

    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // int[] arr = new int[n];
    // int max_x = 0;
    // for (int i = 0; i < n; i++) {
    // arr[i] = sc.nextInt();
    // if (arr[i] > max_x) {
    // max_x = arr[i];
    // }
    // }

    // int[] freq = new int[max_x + 2];
    // for (int x : arr) {
    // freq[x]++;
    // }

    // if (max_x == 0) {
    // System.out.println(0);
    // return;
    // }

    // long[] dp = new long[max_x + 1];
    // dp[0] = 0;
    // dp[1] = (long) 1 * freq[1];
    // for (int i = 2; i <= max_x; i++) {
    // long take = dp[i - 2] + (long) i * freq[i];
    // long notTake = dp[i - 1];
    // dp[i] = Math.max(take, notTake);
    // }

    // System.out.println(dp[max_x]);
    // }
}
