public abstract class IoTDevice {
    public static final String FIRMWARE_VERSION = "v2.5.0";
    private final String deviceId;
    private String name;
    private boolean activeStatus;
    private double powerConsumption;

    public IoTDevice(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
        this.activeStatus = false;
        this.powerConsumption = 0.0;
    }

    public IoTDevice(String deviceId, String name, double powerConsumption) {
        this.deviceId = deviceId;
        this.name = name;
        this.activeStatus = false;
        this.powerConsumption = powerConsumption;
    }

    public abstract void processData(double inputVal);

    public void displayInfo() {
        System.out.println("ID Perangkat      : " + this.deviceId);
        System.out.println("Nama Perangkat    : " + this.name);
        System.out.println("Status Aktif      : " + (this.activeStatus ? "ON" : "OFF"));
        System.out.println("Konsumsi Daya     : " + this.powerConsumption + " W");
        System.out.println("Versi Firmware    : " + FIRMWARE_VERSION);
    }

    public String getDeviceId() { return this.deviceId; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public boolean isActiveStatus() { return this.activeStatus; }
    public void setActiveStatus(boolean activeStatus) { this.activeStatus = activeStatus; }
    public double getPowerConsumption() { return this.powerConsumption; }
    public void setPowerConsumption(double powerConsumption) { this.powerConsumption = powerConsumption; }
}