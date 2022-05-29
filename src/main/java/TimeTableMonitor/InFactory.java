package TimeTableMonitor;

public class InFactory implements UIFactory {
    @Override
    public Window createWindow() {
        return new InWindow();
    }

    @Override
    public Text createText() {
        return new InText();
    }
}
