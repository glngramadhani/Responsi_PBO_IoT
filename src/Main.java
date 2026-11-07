public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    SISTEM MANAJEMEN PERANGKAT IOT (NIM ...144)   ");
        System.out.println("==================================================");

        SmartThermostat thermostat = new SmartThermostat("IOT-TH-01", "Thermostat Ruang Utama", 10.0, 25.0);
        SmartCamera camera = new SmartCamera("IOT-CAM-01", "Kamera Teras Depan", "1080p Full HD");

        System.out.println("\n--- [1] STATUS AWAL PERANGKAT ---");
        thermostat.displayInfo();
        System.out.println("--------------------------------------------------");
        camera.displayInfo();

        System.out.println("\n--- [2] INTERFACE & POLIMORFISME INTERFACE ---");
        Connectable wifiDevice1 = thermostat;
        Connectable wifiDevice2 = camera;

        wifiDevice1.connectToWiFi("IoT_Home_Network");
        wifiDevice2.connectToWiFi("IoT_Home_Network");

        PowerManageable powerDevice = thermostat;
        powerDevice.setPowerSaveMode(true);
        System.out.println("Sisa Baterai Thermostat: " + powerDevice.getBatteryLevel() + "%");

        System.out.println("\n--- [3] PENGUJIAN ABSTRACT METHOD & LOGIKA STATE PERCABANGAN ---");
        thermostat.processData(28.5);
        camera.processData(0.85);

        System.out.println("\n--- [4] STATUS AKHIR PERANGKAT ---");
        thermostat.displayInfo();
        System.out.println("--------------------------------------------------");
        camera.displayInfo();

        System.out.println("\n==================================================");
        System.out.println("         PENGUJIAN SISTEM IOT SELESAI             ");
        System.out.println("==================================================");
    }
}