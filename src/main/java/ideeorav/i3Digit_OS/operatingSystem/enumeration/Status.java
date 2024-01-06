package ideeorav.i3Digit_OS.operatingSystem.enumeration;

public enum Status {

    FILAMENT_AVAILABLE("Available"),
    FILAMENT_UNAVAILABLE("Empty");

    private final String status;

    Status (String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

}
