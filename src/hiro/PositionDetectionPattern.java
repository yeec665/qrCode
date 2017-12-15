package hiro;

import java.awt.*;
import java.util.ArrayList;

public class PositionDetectionPattern implements MatrixInterface {

    private final int n;

    private final ArrayList<Point> alignmentPattern = new ArrayList<>();

    public PositionDetectionPattern(QRVersion qrv) {
        n = qrv.sideLength();
        buildAlignmentPatterns(qrv.version());
    }

    private void buildAlignmentPatterns(int ver) {
        if (ver < 2) {
            return;
        }
        if (ver < 7) {
            int p1 = n - 7;
            alignmentPattern.add(new Point(p1, p1));
        } else {
            int p1 = n / 2;
            int p2 = n - 7;
            alignmentPattern.add(new Point(6, p1));
            alignmentPattern.add(new Point(p1, 6));
            alignmentPattern.add(new Point(p1, p1));
            alignmentPattern.add(new Point(p1, p2));
            alignmentPattern.add(new Point(p2, p1));
            alignmentPattern.add(new Point(p2, p2));
        }
    }

    @Override
    public boolean read(int x, int y) {
        for (Point p : alignmentPattern) {
            int dx = Math.abs(x - p.x);
            int dy = Math.abs(y - p.y);
            if (dx < 3 && dy < 3) {
                return dx == 2 || dy == 2 || dx == 0 && dy == 0;
            }
        }
        if (x < 7 && y < 7) {
            return readInSquare(x, y);
        } else if (x >= n - 7 && y < 7) {
            return readInSquare(x + 7 - n, y);
        } else if (x < 7 && y >= n - 7) {
            return readInSquare(x, y + 7 - n);
        } else if (x == 6) {
            return (y & 1) == 0;
        } else if (y == 6) {
            return (x & 1) == 0;
        }
        return false;
    }

    private boolean readInSquare(int x, int y) {
        return x == 0 || y == 0 || x == 6 || y == 6 ||
                x >= 2 && x <= 4 && y >= 2 && y <= 4;
    }

    @Override
    public boolean valid(int x, int y) {
        for (Point p : alignmentPattern) {
            if (Math.abs(x - p.x) < 3 && Math.abs(y - p.y) < 3) {
                return true;
            }
        }
        if (x < 8) {
            return x == 6 || y < 8 || y >= n - 8;
        } else if (y < 8) {
            return y == 6 || x >= n - 8;
        }
        return false;
    }
}
