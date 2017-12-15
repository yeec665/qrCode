package hiro;

public class DataBlock {

    private int groupIndex;

    private byte[] data;
    private byte[] ecData;

    public DataBlock(int groupIndex, byte[] raw, int from, int len) {
        this.groupIndex = groupIndex;
        data = new byte[len];
        System.arraycopy(raw, from, data, 0, len);
    }

    public void generateEc(int len) {
        ecData = ReedSolomon.divide(data, len);
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    public int length() {
        return data.length + ecData.length;
    }

    public int dataLength() {
        return data.length;
    }

    public int ecDataLength() {
        return ecData.length;
    }

    public byte getData(int index) {
        return data[index];
    }

    public byte getEcData(int index) {
        return ecData[index];
    }
}
