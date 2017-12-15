package hiro;

public class ErrorCorrectionTableRow {

    private int[] fields;

    public ErrorCorrectionTableRow(int... ii) {
        if (ii.length == 7) {
            fields = ii;
        } else if (ii.length == 5) {
            fields = new int[7];
            System.arraycopy(ii, 0, fields, 0, 4);
            fields[6] = ii[4];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfDataCodewords() {
        return fields[0];
    }

    public int ecCodewordsPerBlock() {
        return fields[1];
    }

    public int numberOfBlocksInGroup1() {
        return fields[2];
    }

    public int numberOfCodewordsInBlock1() {
        return fields[3];
    }

    public int numberOfBlocksInGroup2() {
        return fields[4];
    }

    public int numberOfCodewordsInBlock2() {
        return fields[5];
    }

    public int byteCapacity() {
        return fields[6];
    }
}
