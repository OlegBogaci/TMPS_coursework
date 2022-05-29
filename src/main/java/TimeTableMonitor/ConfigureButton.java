package TimeTableMonitor;

import javax.swing.*;


public class ConfigureButton {
    DisplayType displayType;

    public void configure(JButton button, JFrame frame) {
        displayType.configure(button, frame);
    }

    public void setStrategy(DisplayType displayType) {
        this.displayType = displayType;
    }
}
