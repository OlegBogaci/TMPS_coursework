package TimeTableMonitor;

import javax.swing.*;

public class OutText implements Text {
    JTable b = new JTable();

    @Override
    public JTable getTable() {
        b.setBounds(130, 100, 100, 40);
        return b;
    }
}
