import java.util.ArrayList;
import java.util.Scanner;

public class EIUSUBSET_Subset1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        ArrayList<String> sub = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            sub.add(temp);
        }
        for (int i = 0; i < n; i++) {
            int count = list.size();
            String letter = sub.get(n - i - 1);
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    list.add(letter);
                    sb.append(letter + '\n');
                } else {
                    list.add(letter + " " + list.get(j));
                    sb.append(letter + " " + list.get(j) + '\n');
                }
            }
        }
        list.remove(0);
        System.out.println(list.size());
        System.out.println(sb);
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
    }
}
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class SubsetGenerator {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Đọc N
//        int N = sc.nextInt();
//        // Đọc mảng A
//        double[] A = new double[N];
//        for (int i = 0; i < N; i++) {
//            A[i] = sc.nextDouble();
//        }
//
//        // Tính M = 2^N - 1
//        int M = (1 << N) - 1;
//        System.out.println(M);
//
//        // Duyệt từ 1 đến M để tạo các tập con
//        for (int i = 1; i <= M; i++) {
//            ArrayList<Double> subset = new ArrayList<>();
//            // Kiểm tra từng bit
//            for (int j = 0; j < N; j++) {
//                if ((i & (1 << j)) != 0) { // Nếu bit j là 1
//                    subset.add(A[N - 1 - j]); // Thêm phần tử tương ứng
//                }
//            }
//            // In tập con
//            for (int k = 0; k < subset.size(); k++) {
//                System.out.print(subset.get(k));
//                if (k < subset.size() - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//
//        sc.close();
//    }
//}
