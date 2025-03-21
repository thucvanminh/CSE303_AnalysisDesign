import java.util.*;

public class EIJUMP_JumpJump {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] colors = new int[n];
        // for (int i = 0; i < n; i++) {
        // colors[i] = sc.nextInt();
        // }

        // int[] nextSame = new int[n];
        // Arrays.fill(nextSame, -1);
        // Map<Integer, Integer> lastOccurrence = new HashMap<>();
        // for (int i = n - 1; i >= 0; i--) {
        // int c = colors[i];
        // if (lastOccurrence.containsKey(c)) {
        // nextSame[i] = lastOccurrence.get(c);
        // }
        // lastOccurrence.put(c, i);
        // }

        // int[] dist = new int[n];
        // Arrays.fill(dist, Integer.MAX_VALUE);
        // dist[0] = 0;
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(0);

        // while (!queue.isEmpty()) {
        // int u = queue.poll();
        // // Jump to u + 1
        // if (u + 1 < n && dist[u + 1] > dist[u] + 1) {
        // dist[u + 1] = dist[u] + 1;
        // queue.add(u + 1);
        // }
        // // Jump to nextSame[u]
        // int v = nextSame[u];
        // if (v != -1 && dist[v] > dist[u] + 1) {
        // dist[v] = dist[u] + 1;
        // queue.add(v);
        // }
        // }

        // System.out.println(dist[n - 1]);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Map<Integer, Integer> lastOccurrence = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, lastOccurrence.getOrDefault(arr[i], Integer.MAX_VALUE-1)+1);
            lastOccurrence.put(arr[i], dp[i]);
        }

        System.out.println(dp[n]-1);
    }
}
