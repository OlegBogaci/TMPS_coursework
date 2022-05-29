package TimeTableMonitor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaneTimeTable implements TimeTable {
    public final UIFactory factory;
    public Window win;
    public Text text;

    public PlaneTimeTable(UIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        win = factory.createWindow();
        win.addText(getTimeTable());
        win.showWindow();
    }

    @Override
    public ArrayList<String> getTimeTable() {
        text = factory.createText();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src/main/java/timetable"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (factory instanceof InFactory && (line.contains("ARRIVED") || line.contains("EXPECTED")))
                list.add(line);
            else if (factory instanceof OutFactory && (line.contains("BOARDING") || line.contains("DEPARTED")))
                list.add(line);
        }

        return list;
    }
}
