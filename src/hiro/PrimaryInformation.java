package hiro;

public class PrimaryInformation implements MatrixInterface {

    private final int n;
    private final int formatInformation;
    private final boolean hasVersionInformation;
    private int versionInformation;

    public PrimaryInformation(QRVersion qrv) {
        n = qrv.sideLength();
        formatInformation = BCH.encode5(((0x3 & qrv.ecLevel()) << 3) | (0x7 & qrv.maskPattern()));
        hasVersionInformation = qrv.version() > 6;
        if (hasVersionInformation) {
            versionInformation = BCH.encode6(qrv.version());
        }
    }

    @Override
    public boolean read(int x, int y) {
        if (x == 8) {
            if (y < 9) {
                if (y > 5) y--;
                return (formatInformation & (1 << y)) != 0;
            } else if (y >= n - 8) {
                return y == n - 8 || (formatInformation & (1 << (y + 15 - n))) != 0;
            }
        } else if (y == 8) {
            if (x < 6) {
                return (formatInformation & (1 << (14 - x))) != 0;
            } else if (x == 7) {
                return (formatInformation & (1 << 8)) != 0;
            } else if (x >= n - 8) {
                return (formatInformation & (1 << (n - 1 - x))) != 0;
            }
        }
        if (hasVersionInformation) {
            if (x < 6 && y >= n - 11 && y < n - 8) {
                return (versionInformation & (1 << (3 * x + y + 11 - n))) != 0;
            }
            if (y < 6 && x >= n - 11 && x < n - 8) {
                return (versionInformation & (1 << (3 * y + x + 11 - n))) != 0;
            }
        }
        return false;
    }

    @Override
    public boolean valid(int x, int y) {
        if (x == 8) {
            return y < 9 || y >= n - 8;
        } else if (y == 8) {
            return x < 9 || x >= n - 8;
        }
        return hasVersionInformation &&
                (x < 6 && y >= n - 11 && y < n - 8 ||
                        y < 6 && x >= n - 11 && x < n - 8);
    }
}
