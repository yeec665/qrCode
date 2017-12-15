package hiro;

public class BCH {

    private static final int GENERATOR_POLYNOMIAL_5 = Integer.parseInt("10100110111", 2);
    private static final int MASK_CODE_5 = Integer.parseInt("101010000010010", 2);

    public static int encode5(int x) {
        x &= 0x1F;
        x <<= 10;
        int r = x;
        for (int i = 4; i >= 0; i--) {
            if ((r & (1 << (10 + i))) != 0) {
                r ^= GENERATOR_POLYNOMIAL_5 << i;
            }
        }
        return (x | r) ^ MASK_CODE_5;
    }

    private static final int GENERATOR_POLYNOMIAL_6 = Integer.parseInt("1111100100101", 2);

    public static int encode6(int x) {
        x &= 0x3F;
        x <<= 12;
        int r = x;
        for (int i = 5; i >= 0; i--) {
            if ((r & (1 << (12 + i))) != 0) {
                r ^= GENERATOR_POLYNOMIAL_6 << i;
            }
        }
        return (x | r);
    }

    public static void test() {
        for (int x = 0; x < 32; x++) {
            int y = encode5(x);
            y |= 1 << 15;
            System.out.println(x + " :");
            System.out.println(Integer.toBinaryString(y).substring(1));
        }
        for (int x = 7; x <= 40; x++) {
            int y = encode6(x);
            y |= 1 << 18;
            System.out.println(x + " :");
            System.out.println(Integer.toBinaryString(y).substring(1));
        }
    }
}
