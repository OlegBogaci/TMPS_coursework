package TimeTableMonitor;

import javax.swing.*;
import java.awt.*;

public class RunApp {
    private static DisplayType displayType;
    private static JFrame frame;
    private static JButton departure;
    private static JButton arrival;
    private static JButton clearCache;
    private static JButton back;
    private static TimeTableProxySnapshot snapshot = null;
    private static PlaneTimeTableProxy app = null;
    private static final GridBagConstraints c = new GridBagConstraints();
    private static final ConfigureButton configureButton = new ConfigureButton();

    public RunApp(AppBuilder appBuilder) {
        frame = appBuilder.frame;
        arrival = appBuilder.arrival;
        clearCache = appBuilder.clearCache;
        back = appBuilder.back;
        departure = appBuilder.departure;
        displayType = appBuilder.displayType;
    }

    public static class AppBuilder {
        private final DisplayType displayType;
        private final JFrame frame;
        private JButton departure = new JButton();
        private JButton arrival = new JButton();
        private JButton clearCache = new JButton();
        private JButton back = new JButton();

        public AppBuilder(String frameName, DisplayType displayType) {
            frame = new JFrame(frameName);
            this.displayType = displayType;
        }

        public AppBuilder departure(String departure) {
            this.departure = new JButton(departure);
            return this;
        }

        public AppBuilder arrival(String arrival) {
            this.arrival = new JButton(arrival);
            return this;
        }

        public AppBuilder clearCache(String clearCache) {
            this.clearCache = new JButton(clearCache);
            return this;
        }

        public AppBuilder back(String back) {
            this.back = new JButton(back);
            return this;
        }

        public RunApp build() {
            return new RunApp(this);
        }

    }

    public void startApp() {
        frame.setLayout(new GridBagLayout());
        configureButton.setStrategy(displayType);
        configureButton.configure(arrival, frame);
        configureButton.configure(departure, frame);
        configureButton.configure(clearCache, frame);
        configureButton.configure(back, frame);

        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 2;
        frame.add(departure, c);
        c.gridx = 2;
        c.gridy = 2;
        frame.add(arrival, c);
        c.fill = 0;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        frame.add(clearCache, c);
        c.gridx = 1;
        c.gridy = 3;
        frame.add(back, c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 200);
        frame.setVisible(true);

        back.addActionListener(e -> {
            if (snapshot != null && app == null) {
                snapshot.restore();
            }
        });

        departure.addActionListener(e -> {
            if (app == null) {
                UIFactory departureWindow = new OutFactory();
                app = new PlaneTimeTableProxy(departureWindow);
                app.createUI();
                app.createSnapshot();
                snapshot = app.createSnapshot();
            }
        });

        arrival.addActionListener(e -> {
            if (app == null) {
                UIFactory arrivalWindow = new InFactory();
                app = new PlaneTimeTableProxy(arrivalWindow);
                app.createUI();
                app.createSnapshot();
                snapshot = app.createSnapshot();
            }
        });

        clearCache.addActionListener(e -> PlaneTimeTableProxy.clearCache());
    }

    public static void windowClosed() {
        app = null;
    }

    //AbstractFactory, Builder, Proxy, Facade, Snapshot, Strategy
    public static void main(String[] args) {
        RunApp runApp = new AppBuilder("AIR UTM", new DisplayTypeDay()).departure("DEPARTURE").arrival("ARRIVAL").back("BACK").clearCache("REFRESH").build();
        runApp.startApp();
    }
}
