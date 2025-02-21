// import java.io.*;
// import java.util.*;

// public class EI2122Q1ADAM2_Matching {
//     public static void main(String[] args) throws IOException {
//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

//         int N = Integer.parseInt(tokenizer.nextToken());
//         int M = Integer.parseInt(tokenizer.nextToken());
//         int X = Integer.parseInt(tokenizer.nextToken());

//         int[] menHeights = new int[N];
//         int[] womenHeights = new int[M];

//         tokenizer = new StringTokenizer(reader.readLine());
//         for (int i = 0; i < N; i++) {
//             menHeights[i] = Integer.parseInt(tokenizer.nextToken());
//         }

//         tokenizer = new StringTokenizer(reader.readLine());
//         for (int i = 0; i < M; i++) {
//             womenHeights[i] = Integer.parseInt(tokenizer.nextToken());
//         }

//         Arrays.sort(menHeights);
//         Arrays.sort(womenHeights);

//         int left = 0, right = Math.max(menHeights[N-1], womenHeights[M-1]) - Math.min(menHeights[0], womenHeights[0]);
//         int result = right;

//         while (left <= right) {
//             int mid = (left + right) / 2;
//             if (canFormPairs(menHeights, womenHeights, X, mid)) {
//                 result = mid;
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }

//         System.out.println(result);
//     }

//     private static boolean canFormPairs(int[] men, int[] women, int X, int maxDiff) {
//         int i = 0, j = 0, pairs = 0;
//         while (i < men.length && j < women.length && pairs < X) {
//             if (Math.abs(men[i] - women[j]) <= maxDiff) {
//                 pairs++;
//                 i++;
//                 j++;
//             } else if (men[i] < women[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }
//         return pairs >= X;
//     }
// }

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Matching {

    public static void main(String[] args) throws IOException {
        // Example Usage
        InputReader rd = new InputReader(System.in);
        int nMen = rd.nextInt();
        int nWomen = rd.nextInt();
        int pairs = rd.nextInt();

        int[] men1 = new int[nMen];
        int[] women1 = new int[nWomen];
        for (int i = 0; i < nMen; i++) {
            men1[i] = rd.nextInt();
        }
        for (int i = 0; i < nWomen; i++) {
            women1[i] = rd.nextInt();
        }

        int result1 = minMaxHeightDifference(men1, women1, pairs);
        System.out.println(result1); 

    }

    static int minMaxHeightDifference(int[] men, int[] women, int x) {
        Arrays.sort(men);
        Arrays.sort(women);

        int low = 0;
        int high = Math.max(men[men.length - 1] - women[0], women[women.length - 1] - men[0]);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (isPossible(men, women, x, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] men, int[] women, int x, int maxDiff) {
        int menIdx = 0;
        int womenIdx = 0;
        int pairsFormed = 0;

        while (menIdx < men.length && womenIdx < women.length && pairsFormed < x) {
            if (Math.abs(men[menIdx] - women[womenIdx]) <= maxDiff) {
                pairsFormed++;
                menIdx++;
                womenIdx++;
            } else if (men[menIdx] < women[womenIdx]) {
                menIdx++;
            } else {
                womenIdx++;
            }
        }

        return pairsFormed == x;
    }

    static class InputReader {
        private byte[] inbuf = new byte[2 << 23];
        public int lenbuf = 0, ptrbuf = 0;
        public InputStream is;

        public InputReader(InputStream stream) throws IOException {

            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = System.in;
            lenbuf = is.read(inbuf);
        }

        public InputReader(FileInputStream stream) throws IOException {
            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = stream;
            lenbuf = is.read(inbuf);
        }

        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                ptrbuf--;
                return true;
            }
            return false;
        }

        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b
                                        // != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        public Character nextChar() {
            return skip() >= 0 ? (char) skip() : null;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}