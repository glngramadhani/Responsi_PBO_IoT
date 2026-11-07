public class SmartThermostat extends IoTDevice implements Connectable, PowerManageable {
    private double targetTemperature;
    private boolean wifiConnected;
    private boolean powerSaveMode;
    private double batteryLevel;

    public SmartThermostat(String deviceId, String name) {
        super(deviceId, name);
        this.targetTemperature = 24.0;
        this.wifiConnected = false;
        this.powerSaveMode = false;
        this.batteryLevel = 100.0;
    }

    public SmartThermostat(String deviceId, String name, double powerConsumption, double targetTemperature) {
        super(deviceId, name, powerConsumption);
        this.targetTemperature = targetTemperature;
        this.wifiConnected = false;
        this.powerSaveMode = false;
        this.batteryLevel = 100.0;
    }

    @Override
    public void processData(double currentRoomTemp) {
        System.out.println("\n[Thermostat Processing] Suhu Ruangan Terbaca: " + currentRoomTemp + "°C");
        if (currentRoomTemp > this.targetTemperature) {
            this.setActiveStatus(true);
            this.setPowerConsumption(45.5);
            System.out.println("-> Suhu terlalu tinggi! Pendingin ruangan dihidupkan.");
        } else {
            this.setActiveStatus(false);
            this.setPowerConsumption(5.0);
            System.out.println("-> Suhu ideal. Pendingin ruangan dimatikan (Standby).");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Target Temperatur : " + this.targetTemperature + "°C");
        System.out.println("Status WiFi       : " + (this.wifiConnected ? "Tersambung" : "Terputus"));
        System.out.println("Mode Hemat Daya   : " + (this.powerSaveMode ? "Aktif" : "Non-Aktif"));
        System.out.println("Level Baterai     : " + this.batteryLevel + "%");
    }

    @Override
    public void connectToWiFi(String networkName) {
        this.wifiConnected = true;
        System.out.println(getName() + " berhasil terhubung ke jaringan: " + networkName);
    }

    @Override
    public boolean isConnected() { return this.wifiConnected; }

    @Override
    public void setPowerSaveMode(boolean enable) {
        this.powerSaveMode = enable;
        if (enable) {
            this.batteryLevel -= 1.0;
            System.out.println(getName() + ": Mode hemat daya diaktifkan.");
        } else {
            System.out.println(getName() + ": Mode hemat daya dinonaktifkan.");
        }
    }

    @Override
    public double getBatteryLevel() { return this.batteryLevel; }
    public double getTargetTemperature() { return this.targetTemperature; }
    public void setTargetTemperature(double targetTemperature) { this.targetTemperature = targetTemperature; }
}