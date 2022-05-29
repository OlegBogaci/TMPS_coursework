package TimeTableMonitor;

public class OutFactory implements UIFactory {
    @Override
    public Window createWindow() {
        return new OutWindow();
    }

    @Override
    public Text createText() {
        return new OutText();
    }
}
