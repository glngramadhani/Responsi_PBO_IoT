public class SmartCamera extends IoTDevice implements Connectable {
    private String resolution;
    private boolean recording;
    private boolean wifiConnected;

    public SmartCamera(String deviceId, String name, String resolution) {
        super(deviceId, name, 12.0);
        this.resolution = resolution;
        this.recording = false;
        this.wifiConnected = false;
    }

    @Override
    public void processData(double motionSensorValue) {
        System.out.println("\n[Camera Processing] Nilai Sensor Gerak: " + motionSensorValue);
        if (motionSensorValue > 0.5) {
            this.recording = true;
            this.setActiveStatus(true);
            System.out.println("-> Gerakan terdeteksi! Perekaman video dimulai (" + resolution + ").");
        } else {
            this.recording = false;
            this.setActiveStatus(false);
            System.out.println("-> Tidak ada gerakan. Perekaman dihentikan.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Resolusi Kamera   : " + this.resolution);
        System.out.println("Status Perekaman  : " + (this.recording ? "Merekam..." : "Standby"));
        System.out.println("Status WiFi       : " + (this.wifiConnected ? "Tersambung" : "Terputus"));
    }

    @Override
    public void connectToWiFi(String networkName) {
        this.wifiConnected = true;
        System.out.println(getName() + " terhubung ke sistem CCTV via: " + networkName);
    }

    @Override
    public boolean isConnected() { return this.wifiConnected; }
    public boolean isRecording() { return this.recording; }
}