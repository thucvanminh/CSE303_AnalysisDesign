import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SUBSET2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        doTask();
    }

    static void doTask() {
        int n = sc.nextInt();
        int target = sc.nextInt();
        int count = 0;
        int[] arr = new int[n];
        HashSet<ArrayList> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
        }
        int totalSubsets = 1 << n;

        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                    total += arr[i];
                }
            }
            if (total == target) {
                count++;
            }
            // System.out.println(subset);
        }
        System.out.println(count);
    }
}
