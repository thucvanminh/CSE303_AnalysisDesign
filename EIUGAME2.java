import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class EIUGAME2 {
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        int doc = sc.nextInt();
        int ngang = sc.nextInt();
        int[][] count = new int[doc][ngang];
        int[][] matrix = new int[doc][ngang];
        long[][] dp = new long[doc][ngang];
        count[0][0] = 1;
        for (int i = 0; i < doc; i++) {
            for (int j = 0; j < ngang; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < doc; i++) {
            for (int j = 0; j < ngang; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                    count[i][j] = 1;

                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    count[i][j] = count[i - 1][j] % 10000000;

                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                    count[i][j] = count[i][j - 1] % 10000000;

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];

                    if (dp[i - 1][j] == dp[i][j - 1]) {
                        count[i][j] = (count[i - 1][j] + count[i][j - 1]) % 10000000;
                    } else {
                        if (dp[i - 1][j] > dp[i][j - 1]) {
                            count[i][j] = count[i - 1][j] % 10000000;
                        } else count[i][j] = count[i][j - 1] % 10000000;
                    }

                }
            }
        }
        long result = count[doc - 1][ngang - 1] % 10000000;
        StringBuilder sb = new StringBuilder();
        sb.append(dp[doc - 1][ngang - 1]);
        System.out.println(sb);


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
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
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
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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
