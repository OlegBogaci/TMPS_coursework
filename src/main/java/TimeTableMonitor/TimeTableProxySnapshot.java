package TimeTableMonitor;


public class TimeTableProxySnapshot implements TimeTableSnapshot {
    private PlaneTimeTableProxy editor;
    private final PlaneTimeTable planeTimeTable;


    public TimeTableProxySnapshot(PlaneTimeTableProxy editor, PlaneTimeTable planeTimeTable) {
        this.planeTimeTable = planeTimeTable;
        this.editor = editor;

    }

    public void restore() {
        editor.setPlaneTimeTable(this.planeTimeTable);
        editor.createUI();
    }
}
