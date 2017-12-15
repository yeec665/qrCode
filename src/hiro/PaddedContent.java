package hiro;

public class PaddedContent {

    private static final byte PAD_1 = (byte) Integer.parseInt("11101100", 2);
    private static final byte PAD_2 = (byte) Integer.parseInt("00010001", 2);

    private static final int[][] CIL = {
            {10, 9, 8, 8},
            {12, 11, 16, 10},
            {14, 13, 16, 12}
    };

    private byte[] raw;
    private int p1 = 0, p2 = 0;

    public PaddedContent(QRVersion qrv, Content content) {
        int v = qrv.version();
        int countIndicatorLength = CIL[v < 10 ? 0 : (v < 27 ? 1 : 2)][content.mode()];
        int totalBitLength = 4 + countIndicatorLength + content.getBitLength();
        raw = new byte[ErrorCorrectionTable.byteCapacity(qrv)];
        int lengthIncludingZero = Math.min(totalBitLength + 4, raw.length * 8);
        lengthIncludingZero = (lengthIncludingZero + 7) / 8;
        for (int i = lengthIncludingZero; i < raw.length; i++) {
            if ((i - lengthIncludingZero) % 2 == 0) {
                raw[i] = PAD_1;
            } else {
                raw[i] = PAD_2;
            }
        }
        writeInt(content.modeIndicator(), 4);
        writeInt(content.getCharLength(), countIndicatorLength);
        for (byte b : content.getContentBytes()) {
            writeByte(b);
        }
        //ReedSolomon.printBytesBin(raw);
    }

    private void writeInt(int i, int len) {
        for (int j = len - 1; j >= 0; j--) {
            if ((i & (1 << j)) != 0) {
                raw[p1] |= 0x80 >> p2;
            }
            if (++p2 >= 8) {
                p2 = 0;
                p1++;
            }
        }
    }

    private void writeByte(byte b) {
        if (p2 == 0) {
            raw[p1++] = b;
        } else {
            raw[p1++] |= (0xFF & b) >> p2;
            raw[p1] = (byte) (b << (8 - p2));
        }
    }

    public byte[] getRaw() {
        return raw;
    }
}
