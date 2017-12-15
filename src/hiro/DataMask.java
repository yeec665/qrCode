package hiro;

public class DataMask implements MatrixInterface {

    private int maskPattern;

    public DataMask(QRVersion qrv) {
        maskPattern = qrv.maskPattern();
    }

    public boolean bitInPattern(int i) {
        return ((maskPattern >> i) & 1) != 0;
    }

    /**
     * https://www.cnblogs.com/magicsoar/p/4483032.html
     *
     * @param x coord
     * @param y coord
     * @return dot in pattern
     */
    @Override
    public boolean read(int x, int y) {
        switch (maskPattern) {
            default:
                return false;
            case 0:
                return (x + y) % 2 == 0;
            case 1:
                return y % 2 == 0;
            case 2:
                return x % 3 == 0;
            case 3:
                return (x + y) % 3 == 0;
            case 4:
                return ((x / 2 + y / 3) & 1) == 0;
            case 5:
                return x * y % 2 + x * y % 3 == 0;
            case 6:
                return (x * y % 2 + x * y % 3) % 2 == 0;
            case 7:
                return (x * y % 3 + (x + y) % 2) % 2 == 0;
        }
    }
}
