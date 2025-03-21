import java.io.*;
import java.util.*;

public class EIUGIFTS_WomanDay {
    private static InputReader reader;

    public static void main(String[] args) throws IOException {
        doTask();
    }

    private static void doTask() throws IOException {
        reader = new InputReader(System.in);
        int numOfGifts = reader.nextInt();
        long budget = reader.nextLong();
        int[] prices = new int[numOfGifts];

        for (int i = 0; i < numOfGifts; i++) {
            prices[i] = reader.nextInt();
        }

        Arrays.sort(prices);

        int left = 0, right = numOfGifts - 1;
        int bestSum = -1;
        int bestDiff = Integer.MAX_VALUE;

        while (left < right) {
            int sum = prices[left] + prices[right];
            int diff = Math.abs(prices[left] - prices[right]);

            if (sum <= budget) {
                if (sum > bestSum || (sum == bestSum && diff < bestDiff)) {
                    bestSum = sum;
                    bestDiff = diff;
                }
                left++;
            } else {
                right--;
            }
        }

        if (bestSum == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(bestSum + " " + bestDiff);
        }
    }

    static class InputReader {
        private byte[] inbuf = new byte[1 << 16];
        private int lenbuf = 0, ptrbuf = 0;
        private InputStream is;

        public InputReader(InputStream stream) throws IOException {
            is = stream;
            lenbuf = is.read(inbuf);
        }

        private int readByte() {
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() throws IOException {
            int c = readByte();
            while (isSpaceChar(c)) {
                c = readByte();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = readByte();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() throws IOException {
            int c = readByte();
            while (isSpaceChar(c)) {
                c = readByte();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = readByte();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}