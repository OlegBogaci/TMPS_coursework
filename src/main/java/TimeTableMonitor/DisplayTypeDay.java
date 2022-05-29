package TimeTableMonitor;

import javax.swing.*;
import java.awt.*;

public class DisplayTypeDay implements DisplayType {
    @Override
    public void configure(JButton button, JFrame frame) {
        button.setFont(new Font("StarPro Bold", Font.PLAIN, 30));
        frame.getContentPane().setBackground(null);
    }
}
