package TimeTableMonitor;

import javax.swing.*;
import java.awt.*;

public class DisplayTypeNight implements DisplayType {
    @Override
    public void configure(JButton button, JFrame frame) {
        button.setFont(new Font("StarPro Bold", Font.PLAIN, 30));
        button.setBackground(new Color(38, 38, 38));
        button.setForeground(Color.WHITE);
        frame.getContentPane().setBackground(Color.BLACK);
    }
}
