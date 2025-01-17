import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class EIPAIR_BuyGifts {
    static InputReader reader;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        reader = new InputReader(System.in);
        int T = reader.nextInt();
        for (int t = 0; t < T; t++) {
            int n = reader.nextInt();
            HashMap<Integer, Integer> priceCount = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                int price = reader.nextInt();
                priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
            }
            
            long totalWays = 0;
            for (int count : priceCount.values()) {
                if (count > 1) {
                    totalWays += (long) count * (count - 1) / 2;
                }
            }
            
            sb.append(totalWays).append("\n");
        }
        System.out.print(sb);
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
    }
}
