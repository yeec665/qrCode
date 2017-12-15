package hiro;

import java.util.Arrays;

public class GaloisField256 {

    /**
     * https://www.thonky.com/qr-code-tutorial/log-antilog-table
     */
    public static final int[] BASE_2 = new int[256];
    public static final int[] LOG_2 = new int[256];

    static {
        for (int x = 1, i = 0; i < 256; i++) {
            BASE_2[i] = x;
            LOG_2[x] = i;
            x <<= 1;
            if (x >= 256) {
                x ^= 285;
            }
        }
        LOG_2[1] = 0;
        //System.out.println(Arrays.toString(BASE_2));
        //System.out.println(Arrays.toString(LOG_2));
    }

    public static int baseConvert(int i) {
        return BASE_2[0xFF & i];
    }

    public static int logConvert(int i) {
        return LOG_2[0xFF & i];
    }

    public static void baseConvert(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) BASE_2[0xFF & b[i]];
        }
    }

    public static void logConvert(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) LOG_2[0xFF & b[i]];
        }
    }
}
