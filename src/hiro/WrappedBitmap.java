package hiro;

import java.awt.image.BufferedImage;

public class WrappedBitmap implements QRHolder {

    private BufferedImage bufferedImage;

    public WrappedBitmap() {

    }

    @Override
    public void setSize(int n) {
        bufferedImage = new BufferedImage(n, n, BufferedImage.TYPE_INT_RGB);
    }

    public int getSize() {
        return bufferedImage.getWidth();
    }

    @Override
    public void putData(int x, int y, boolean isBlack) {
        bufferedImage.setRGB(x, y, isBlack ? 0x000000 : 0xFFFFFF);
    }

    public BufferedImage getImage() {
        return bufferedImage;
    }
}
