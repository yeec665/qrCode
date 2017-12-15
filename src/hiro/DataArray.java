package hiro;

public class DataArray {

    private byte[] finalMsg;
    private int p1 = 0, p2 = 0, remain = 0;

    public DataArray(DataBlock[] dataBlocks) {
        int sumD = 0, sumEc = 0;
        for (DataBlock dataBlock : dataBlocks) {
            sumD += dataBlock.dataLength();
            sumEc += dataBlock.ecDataLength();
        }
        finalMsg = new byte[sumD + sumEc];
        for (int i = 0, j = 0, k = 0; i < sumD; ) {
            if (k < dataBlocks[j].dataLength()) {
                finalMsg[i++] = dataBlocks[j].getData(k);
            }
            if (++j >= dataBlocks.length) {
                j = 0;
                k++;
            }
        }
        for (int i = sumD, j = 0, k = 0; i < finalMsg.length; ) {
            if (k < dataBlocks[j].ecDataLength()) {
                finalMsg[i++] = dataBlocks[j].getEcData(k);
            }
            if (++j >= dataBlocks.length) {
                j = 0;
                k++;
            }
        }
    }

    public void rewind() {
        p1 = 0;
        p2 = 0;
        remain = 0;
    }

    public boolean next() {
        if (p2 >= 8) {
            p2 = 0;
            p1++;
        }
        if (p1 < finalMsg.length) {
            return (finalMsg[p1] & (0x80 >> p2++)) != 0;
        }
        remain++;
        return false;
    }

    @Override
    public String toString() {
        if (remain > 0) {
            return "DataArray : remain=" + remain;
        } else {
            return "DataArray : overflow=" + ((finalMsg.length - p1) * 8 - p2);
        }
    }
}
