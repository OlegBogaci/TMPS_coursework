package TimeTableMonitor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class WindowFacade {
    public static void createWindow(JPanel panel, JFrame frame) {
        panel.setSize(700, 500);
        panel.setLayout(new GridLayout());
        panel.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                RunApp.windowClosed();
            }
        });
    }

    public static JTable createTable(ArrayList<String> table) {
        Object[][] strings = new String[table.size()][];
        int i = 0;

        for (String s : table) {
            String[] arr = s.split("\\s+");
            strings[i] = arr;
            i++;

        }

        String[] cn = {"FLIGHT №", "DESTINATION", "DATE", "FLIGHT STATUS"};
        JTable table1 = new JTable(strings, cn) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setRowHeight(22);
        table1.setShowVerticalLines(false);
        Color lineColor = new Color(122, 138, 153);
        table1.setBorder(BorderFactory.createLineBorder(lineColor));
        table1.getTableHeader().setFont(new Font("StarPro Bold", Font.ITALIC, 20));
        table1.getTableHeader().setOpaque(false);
        table1.getTableHeader().setBackground(new Color(145, 226, 220));
        table1.getTableHeader().setForeground(new Color(38, 38, 38));
        table1.setFont(new Font("Consolas", Font.BOLD, 18));
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();
        render1.setHorizontalAlignment(JLabel.CENTER);
        render1.setBackground(new Color(38, 38, 38));
        render1.setForeground(Color.WHITE);
        render1.setFont(new Font("Consolas", Font.BOLD, 18));
        render2.setBackground(Color.WHITE);
        table1.getColumnModel().getColumn(0).setCellRenderer(render1);
        table1.getColumnModel().getColumn(2).setCellRenderer(render1);
        table1.getColumnModel().getColumn(0).setMinWidth(115);
        table1.getColumnModel().getColumn(0).setMaxWidth(115);
        table1.getColumnModel().getColumn(2).setMinWidth(100);
        table1.getColumnModel().getColumn(2).setMaxWidth(100);
        table1.getColumnModel().getColumn(1).setCellRenderer(render2);
        table1.getColumnModel().getColumn(3).setCellRenderer(render2);
        return table1;
    }
}
