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
