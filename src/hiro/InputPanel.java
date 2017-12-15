package hiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel implements ActionListener {

    private final QRPanel mContext;
    private final JTextField textField = new JTextField("The quick brown fox jumps over the lazy dog.", 40);

    public InputPanel(QRPanel context) {
        super(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        mContext = context;
        add(textField);
        JButton button = new JButton("OK");
        button.addActionListener(this);
        add(button);
    }

    public String getText() {
        return textField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(mContext::make).start();
    }
}
