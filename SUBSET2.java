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

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
        }
        int totalSubsets = 1 << n;

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            int total = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                    total += arr[j];
                }
            }
            if (total == target) {
                count++;
            }
        }
        System.out.println(count);
    }
}
