package hiro;

public class QRVersion {

    public static final int MIN_VER = 1;
    public static final int MAX_VER = 40;

    public static final int MIN_MODE = 0;
    public static final int MAX_MODE = 3;

    public static final int EC_LEVEL_L = 1;
    public static final int EC_LEVEL_M = 0;
    public static final int EC_LEVEL_Q = 3;
    public static final int EC_LEVEL_H = 2;

    public static final int MIN_EC_LEVEL = 0;
    public static final int MAX_EC_LEVEL = 3;

    public static int confineEcLevel(int level) {
        if (level < MIN_EC_LEVEL) {
            return MIN_EC_LEVEL;
        }
        if (level > MAX_EC_LEVEL) {
            return MAX_EC_LEVEL;
        }
        return level;
    }

    private int version;
    private int mode;
    private int ecLevel;
    private int maskPattern;

    public QRVersion(int version, int mode, int ecLevel, int maskPattern) {
        if (version < MIN_VER || version > MAX_VER) {
            throw new IllegalArgumentException();
        }
        if (mode < MIN_MODE || mode > MAX_MODE) {
            throw new IllegalArgumentException();
        }
        if (ecLevel < MIN_EC_LEVEL || ecLevel > MAX_EC_LEVEL) {
            throw new IllegalArgumentException();
        }
        this.version = version;
        this.mode = mode;
        this.ecLevel = ecLevel;
        this.maskPattern = maskPattern;
    }

    public QRVersion(int version, int mode, int ecLevel) {
        this(version, mode, ecLevel, 0);
    }

    public int version() {
        return version;
    }

    public int mode() {
        return mode;
    }

    public int ecLevel() {
        return ecLevel;
    }

    public int rankOfEcLevel() {
        switch (ecLevel) {
            case EC_LEVEL_L:
                return 0;
            case EC_LEVEL_M:
                return 1;
            case EC_LEVEL_Q:
                return 2;
            case EC_LEVEL_H:
                return 3;
            default:
                return 0;
        }
    }

    public void setMaskPattern(int maskPattern) {
        this.maskPattern = maskPattern;
    }

    public int maskPattern() {
        return maskPattern;
    }

    public int sideLength() {
        return (version - 1) * 4 + 21;
    }

    @Override
    public String toString() {
        String s = version + "m" + mode + "k" + maskPattern + "-";
        switch (ecLevel) {
            case EC_LEVEL_L:
                return s + "L";
            case EC_LEVEL_M:
                return s + "M";
            case EC_LEVEL_Q:
                return s + "Q";
            case EC_LEVEL_H:
                return s + "H";
            default:
                return s + "?";
        }
    }
}
