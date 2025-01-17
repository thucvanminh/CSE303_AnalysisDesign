import java.io.*;
import java.util.*;

public class EIULOVE {
    private static InputReader reader;

    public static void main(String[] args) throws IOException {
        doTask();
    }

    private static void doTask() throws IOException {
        reader = new InputReader(System.in);
        int numOfGifts = reader.nextInt();
        long budget = reader.nextLong();
        long highestNum = 0;
        for (int i = 0; i < numOfGifts; i++) {
            long temp = reader.nextLong();
            if (temp >= highestNum && temp <= budget) {
                highestNum = temp;
            }
        }
        if (highestNum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(highestNum);
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
                if (lenbuf <= 0)
                    return -1;
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