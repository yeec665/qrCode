package hiro;

public class CoordinateIterator {

    private boolean leftSide = false;
    private boolean downWard = false;
    private int x, y, n;

    public CoordinateIterator(int n) {
        x = n - 1;
        y = n - 1;
        this.n = n;
    }

    public boolean next() {
        if (x == 6) {
            if (++y >= n) {
                x = 5;
                y = 0;
            }
            return true;
        }
        if (leftSide) {
            leftSide = false;
            x++;
            if (downWard) {
                if (++y >= n) {
                    downWard = false;
                    x -= 2;
                    y--;
                }
            } else {
                if (--y < 0) {
                    downWard = true;
                    x -= 2;
                    y++;
                }
            }
        } else {
            leftSide = true;
            x--;
        }
        return x >= 0 && y < n;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
