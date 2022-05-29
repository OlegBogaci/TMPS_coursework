package TimeTableMonitor;

import java.util.ArrayList;

public class PlaneTimeTableProxy implements TimeTable {

    private PlaneTimeTable planeTimeTable;
    private static ArrayList<String> timetableCacheArrival = null;
    private static ArrayList<String> timetableCacheDeparture = null;

    public PlaneTimeTableProxy(UIFactory factory) {
        planeTimeTable = new PlaneTimeTable(factory);
    }

    public ArrayList<String> getTimeTableDeparture() {
        if (timetableCacheDeparture == null) {
            timetableCacheDeparture = planeTimeTable.getTimeTable();
        }
        return timetableCacheDeparture;
    }

    public ArrayList<String> getTimeTableArrival() {
        if (timetableCacheArrival == null) {
            timetableCacheArrival = planeTimeTable.getTimeTable();
        }
        return timetableCacheArrival;

    }

    @Override
    public void createUI() {
        planeTimeTable.win = planeTimeTable.factory.createWindow();

        if (planeTimeTable.factory instanceof InFactory)
            planeTimeTable.win.addText(getTimeTableArrival());
        else planeTimeTable.win.addText(getTimeTableDeparture());

        planeTimeTable.win.showWindow();
    }

    @Override
    public ArrayList<String> getTimeTable() {
        return null;
    }

    public TimeTableProxySnapshot createSnapshot() {
        return new TimeTableProxySnapshot(this, planeTimeTable);
    }

    public void setPlaneTimeTable(PlaneTimeTable planeTimeTable) {
        this.planeTimeTable = planeTimeTable;
    }

    public static void clearCache() {
        timetableCacheDeparture = null;
        timetableCacheArrival = null;
    }
}
