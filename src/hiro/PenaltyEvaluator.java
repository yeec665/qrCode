package hiro;

public class PenaltyEvaluator implements QRHolder {

    private int n;
    private boolean[][] m;

    @Override
    public void setSize(int n) {
        this.n = n;
        m = new boolean[n][n];
    }

    @Override
    public void putData(int x, int y, boolean isBlack) {
        m[x][y] = isBlack;
    }

    public int penalty1() {
        int sum = 0;
        for (int x = 0; x < n; x++) {
            boolean b = false;
            int c = 0;
            for (int y = 0; y < n; y++) {
                if (m[x][y] == b) {
                    c++;
                } else {
                    b = !b;
                    if (c >= 5) {
                        sum += c - 2;
                    }
                    c = 1;
                }
            }
            if (c >= 5) {
                sum += c - 2;
            }
        }
        for (int y = 0; y < n; y++) {
            boolean b = false;
            int c = 0;
            for (int x = 0; x < n; x++) {
                if (m[x][y] == b) {
                    c++;
                } else {
                    b = !b;
                    if (c >= 5) {
                        sum += c - 2;
                    }
                    c = 1;
                }
            }
            if (c >= 5) {
                sum += c - 2;
            }
        }
        return sum;
    }

    public int penalty2() {
        int sum = 0;
        for (int x = n - 2; x >= 0; x--) {
            for (int y = n - 2; y >= 0; y--) {
                boolean b = m[x][y];
                if (b == m[x + 1][y] && b == m[x][y + 1] && b == m[x + 1][y + 1]) {
                    sum += 3;
                }
            }
        }
        return sum;
    }

    public int penalty3() {
        int sum = 0;
        for (int x = n - 10; x >= 0; x--) {
            for (int y = n - 10; y >= 0; y--) {
                if (m[x][y]) {
                    if (!m[x + 1][y] && m[x + 2][y] && m[x + 3][y] && m[x + 4][y]
                            && !m[x + 5][y] && m[x + 6][y] && !m[x + 7][y] &&
                            !m[x + 8][y] && !m[x + 9][y] && !m[x + 10][y]) {
                        sum += 40;
                    }
                    if (!m[x][y + 1] && m[x][y + 2] && m[x][y + 3] && m[x][y + 4]
                            && !m[x][y + 5] && m[x][y + 6] && !m[x][y + 7] &&
                            !m[x][y + 8] && !m[x][y + 9] && !m[x][y + 10]) {
                        sum += 40;
                    }
                } else {
                    if (!m[x + 1][y] && !m[x + 2][y] && !m[x + 3][y] && m[x + 4][y]
                            && !m[x + 5][y] && m[x + 6][y] && m[x + 7][y] &&
                            m[x + 8][y] && !m[x + 9][y] && m[x + 10][y]) {
                        sum += 40;
                    }
                    if (!m[x][y + 1] && !m[x][y + 2] && !m[x][y + 3] && m[x][y + 4]
                            && !m[x][y + 5] && m[x][y + 6] && m[x][y + 7] &&
                            m[x][y + 8] && !m[x][y + 9] && m[x][y + 10]) {
                        sum += 40;
                    }
                }
            }
        }
        return sum;
    }

    public int penalty4() {
        int blackSum = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (m[x][y]) {
                    blackSum++;
                }
            }
        }
        return (int) (100.0 * blackSum / (n * n) - 50) / 5 * 10;
    }

    public int penaltyScore() {
        int p1 = penalty1();
        int p2 = penalty2();
        int p3 = penalty3();
        int p4 = penalty4();
        int sum = p1 + p2 + p3 + p4;
        //System.out.printf("penalty[%d + %d + %d + %d = %d]\n", p1, p2, p3, p4, sum);
        return sum;
    }
}
