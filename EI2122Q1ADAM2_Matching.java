import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2_Matching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int X = Integer.parseInt(tokenizer.nextToken());
        
        int[] menHeights = new int[N];
        int[] womenHeights = new int[M];
        
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            menHeights[i] = Integer.parseInt(tokenizer.nextToken());
        }
        
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            womenHeights[i] = Integer.parseInt(tokenizer.nextToken());
        }
        
        Arrays.sort(menHeights);
        Arrays.sort(womenHeights);
        
        int left = 0, right = Math.max(menHeights[N-1], womenHeights[M-1]) - Math.min(menHeights[0], womenHeights[0]);
        int result = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canFormPairs(menHeights, womenHeights, X, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
    
    private static boolean canFormPairs(int[] men, int[] women, int X, int maxDiff) {
        int i = 0, j = 0, pairs = 0;
        while (i < men.length && j < women.length && pairs < X) {
            if (Math.abs(men[i] - women[j]) <= maxDiff) {
                pairs++;
                i++;
                j++;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }
        }
        return pairs >= X;
    }
}