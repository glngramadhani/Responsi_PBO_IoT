public interface PowerManageable {
    void setPowerSaveMode(boolean enable);
    double getBatteryLevel();
}