import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES_PageNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        Arrays.sort(pages);

        StringBuilder sb = new StringBuilder();
        int pageMin = pages[0];
        int pageMax = pages[0];
        int countContinous = 1;

        for (int i = 1; i < n; i++) {
            if (pages[i] == pageMax + 1) {
                pageMax = pages[i];
                countContinous++;
            } else {
                if (countContinous >= 3) {
                    sb.append(pageMin).append("-").append(pageMax).append(" ");
                } else {
                    for (int j = 0; j < countContinous; j++) {
                        sb.append(pageMin + j).append(" ");
                    }
                }
                pageMin = pages[i];
                pageMax = pages[i];
                countContinous = 1;
            }
        }

        if (countContinous >= 3) {
            sb.append(pageMin).append("-").append(pageMax).append(" ");
        } else {
            for (int j = 0; j < countContinous; j++) {
                sb.append(pageMin + j).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}
