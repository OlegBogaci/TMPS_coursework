package TimeTableMonitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OutWindow implements Window {
    JFrame frame = new JFrame("Departure");
    JPanel panel = new JPanel();
    JTable table;

    @Override
    public void showWindow() {
        WindowFacade.createWindow(panel, frame);
        JScrollPane pane = new JScrollPane(table);
        pane.getViewport().setBackground(new Color(38, 38, 38));
        panel.add(pane);
    }

    @Override
    public void addText(ArrayList<String> table) {
        this.table = WindowFacade.createTable(table);
    }
}
