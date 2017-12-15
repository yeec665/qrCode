package hiro;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {

    private static final Random RANDOM = new Random();

    public static final String[] EC_STRING = {"Low(7%)", "Medium(15%)", "Quartile(25%)", "High(30%)"};

    private final JComboBox<String> errorCorrectionComboBox = new JComboBox<>(EC_STRING);
    private final JComboBox<String> maskPatternComboBox = new JComboBox<>(new String[]{"Best", "Random", "#0", "#1", "#2", "#3", "#4", "#5", "#6", "#7"});

    public ConfigPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(new JLabel("Error correction level :"));
        add(errorCorrectionComboBox);
        add(new JLabel("Mask pattern :"));
        add(maskPatternComboBox);
    }

    public int getEcLevel() {
        switch (errorCorrectionComboBox.getSelectedIndex()) {
            default:
                return QRVersion.EC_LEVEL_L;
            case 1:
                return QRVersion.EC_LEVEL_M;
            case 2:
                return QRVersion.EC_LEVEL_Q;
            case 3:
                return QRVersion.EC_LEVEL_H;
        }
    }

    public int getMaskPattern() {
        int i = maskPatternComboBox.getSelectedIndex();
        if (i == 0) {
            return -1;
        } else if (i == 1) {
            return RANDOM.nextInt(8);
        } else {
            return i - 2;
        }
    }
}
