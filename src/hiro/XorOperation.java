package hiro;

public class XorOperation implements MatrixInterface {

    private MatrixInterface m1, m2;

    public XorOperation(MatrixInterface m1, MatrixInterface m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    @Override
    public boolean read(int x, int y) {
        return m1.read(x, y) ^ m2.read(x, y);
    }
}
