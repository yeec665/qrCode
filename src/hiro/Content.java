package hiro;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class Content {

    public static final Charset BYTE_MODE_CHARSET;

    static {
        Charset charset = Charset.defaultCharset();
        try {
            charset = Charset.forName("ISO-8859-1");
        } catch (UnsupportedCharsetException e) {
            e.printStackTrace();
        }
        BYTE_MODE_CHARSET = charset;
    }

    public static boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static int bitLengthInNumeric(int x) {
        int y = 10 * (x / 3);
        x %= 3;
        if (x == 1) {
            y += 4;
        } else if (x == 2) {
            y += 7;
        }
        return y;
    }

    public static void fillInNumeric(byte[] bc, String s) {
        int p1 = 0, p2 = 0, limit = s.length() / 3 * 3;
        for (int i = 0; i < limit; i += 3) {
            int x = (s.charAt(i) - '0') * 100 + (s.charAt(i + 1) - '0') * 10 + (s.charAt(i + 2) - '0');
            for (int j = 0; j < 10; j++) {
                x <<= 1;
                if ((x & 0x400) != 0) {
                    bc[p1] |= 0x80 >> p2;
                }
                if (++p2 >= 8) {
                    p1++;
                    p2 = 0;
                }
            }
        }
        if (s.length() % 3 == 1) {
            int x = s.charAt(limit) - '0';
            for (int j = 0; j < 4; j++) {
                x <<= 1;
                if ((x & 0x10) != 0) {
                    bc[p1] |= 0x80 >> p2;
                }
                if (++p2 >= 8) {
                    p1++;
                    p2 = 0;
                }
            }
        } else if (s.length() % 3 == 2) {
            int x = (s.charAt(limit) - '0') * 10 + (s.charAt(limit + 1) - '0');
            for (int j = 0; j < 7; j++) {
                x <<= 1;
                if ((x & 0x80) != 0) {
                    bc[p1] |= 0x80 >> p2;
                }
                if (++p2 >= 8) {
                    p1++;
                    p2 = 0;
                }
            }
        }
    }

    public static boolean isAlphanumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' ||
                    c == ' ' || c == '$' || c == '%' || c == '*' ||
                    c == '+' || c == '-' || c == '.' || c == '/' ||
                    c == ':')) {
                return false;
            }
        }
        return true;
    }

    public static int bitLengthInAlphanumeric(int x) {
        int y = 11 * (x / 2);
        x %= 2;
        if (x == 1) {
            y += 6;
        }
        return y;
    }

    public static int alphaNumericCode(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        switch (c) {
            default:
            case ' ':
                return 36;
            case '$':
                return 37;
            case '%':
                return 38;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '.':
                return 42;
            case '/':
                return 43;
            case ':':
                return 44;
        }
    }

    public static void fillInAlphanumeric(byte[] bc, String s) {
        int p1 = 0, p2 = 0, limit = s.length() & 0xFFFFFFFE;
        for (int i = 0; i < limit; i += 2) {
            int x = alphaNumericCode(s.charAt(i)) * 45 + alphaNumericCode(s.charAt(i + 1));
            for (int j = 0; j < 11; j++) {
                x <<= 1;
                if ((x & 0x800) != 0) {
                    bc[p1] |= 0x80 >> p2;
                }
                if (++p2 >= 8) {
                    p1++;
                    p2 = 0;
                }
            }
        }
        if (s.length() % 2 == 1) {
            int x = alphaNumericCode(s.charAt(limit));
            for (int j = 0; j < 6; j++) {
                x <<= 1;
                if ((x & 0x40) != 0) {
                    bc[p1] |= 0x80 >> p2;
                }
                if (++p2 >= 8) {
                    p1++;
                    p2 = 0;
                }
            }
        }
    }

    private int mode;
    private int charLength;
    private int bitLength;
    private byte[] contentBytes;

    public Content(String s) {
        charLength = s.length();
        if (isNumeric(s)) {
            mode = 0;
            bitLength = bitLengthInNumeric(s.length());
            contentBytes = new byte[(bitLength + 7) / 8];
            fillInNumeric(contentBytes, s);
        } else if (isAlphanumeric(s)) {
            mode = 1;
            bitLength = bitLengthInAlphanumeric(s.length());
            contentBytes = new byte[(bitLength + 7) / 8];
            fillInAlphanumeric(contentBytes, s);
        } else {
            mode = 2;
            contentBytes = s.getBytes(BYTE_MODE_CHARSET);
            bitLength = 8 * contentBytes.length;
        }
    }

    public int mode() {
        return mode;
    }

    public int modeIndicator() {
        return 1 << mode;
    }

    public int getCharLength() {
        return charLength;
    }

    public int getBitLength() {
        return bitLength;
    }

    public byte[] getContentBytes() {
        return contentBytes;
    }

    public QRVersion getVersion(int ecLevel, int maskPattern) {
        ecLevel = QRVersion.confineEcLevel(ecLevel);
        int version = CharacterCapacity.decideVersionFromList(charLength, mode, ecLevel);
        return new QRVersion(version, mode, ecLevel, maskPattern);
    }

    public QRVersion getVersion(int ecLevel) {
        ecLevel = QRVersion.confineEcLevel(ecLevel);
        int version = CharacterCapacity.decideVersionFromList(charLength, mode, ecLevel);
        return new QRVersion(version, mode, ecLevel);
    }
}
