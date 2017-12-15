package hiro;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class QRPanel extends JComponent {

    private static final Font FT_DL = new Font(Font.SERIF, Font.PLAIN, 26);
    private static final FontRenderContext FRC = new FontRenderContext(new AffineTransform(), true, false);
    private static final String STR_A = "Made by YC in CSE";
    private static final String STR_B = "2017.12.15";

    public static void main(String[] args) {
        //ReedSolomon.test();
        //BCH.test();
        showPanel();
    }

    public static void showPanel() {
        JFrame jFrame = new JFrame("QR Code");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());
        QRPanel qrPanel = new QRPanel();
        jFrame.add(qrPanel.configPanel, BorderLayout.NORTH);
        jFrame.add(qrPanel, BorderLayout.CENTER);
        jFrame.add(qrPanel.inputPanel, BorderLayout.SOUTH);
        jFrame.setVisible(true);
    }

    private final ConfigPanel configPanel = new ConfigPanel();
    private final InputPanel inputPanel = new InputPanel(this);
    private final WrappedBitmap wrappedBitmap = new WrappedBitmap();

    public QRPanel() {

    }

    public void make() {
        FinalMixer finalMixer = new FinalMixer(inputPanel.getText());
        finalMixer.build(configPanel.getEcLevel(), configPanel.getMaskPattern());
        synchronized (wrappedBitmap) {
            finalMixer.write(wrappedBitmap);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        paint2((Graphics2D) g);
    }

    private void paint2(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fill(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));
        synchronized (wrappedBitmap) {
            BufferedImage image = wrappedBitmap.getImage();
            if (image != null) {
                g.drawImage(image, getAffine(image.getWidth()), this);
            } else {
                g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
                paintText(g);
            }
        }
    }

    private void paintText(Graphics2D g) {
        Rectangle2D rectA = FT_DL.getStringBounds(STR_A, FRC);
        Rectangle2D rectB = FT_DL.getStringBounds(STR_B, FRC);
        g.setFont(FT_DL);
        g.setColor(Color.ORANGE);
        g.drawString(STR_A, 0.5f * (float) (getWidth() - rectA.getWidth()), 0.5f * (float) (getHeight() - rectA.getHeight() - rectB.getHeight()));
        g.drawString(STR_B, 0.5f * (float) (getWidth() - rectB.getWidth()), 0.5f * (float) (getHeight() + rectA.getHeight() + rectB.getHeight()));
    }

    private AffineTransform getAffine(int n) {
        double w = 0.85 * Math.min(getWidth(), getHeight());
        return new AffineTransform(w / n, 0, 0, w / n,
                0.5 * (getWidth() - w), 0.5 * (getHeight() - w));
    }
}
