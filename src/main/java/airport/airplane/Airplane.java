package airport.airplane;

public class Airplane {
    String planeId;
    boolean isCurrentlyFlying;
    int cruiseSpeed;

    public Airplane() {
    }

    public Airplane(String planeId, boolean isCurrentlyFlying, int cruiseSpeed) {
        this.planeId = planeId;
        this.isCurrentlyFlying = isCurrentlyFlying;
        this.cruiseSpeed = cruiseSpeed;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public boolean isCurrentlyFlying() {
        return isCurrentlyFlying;
    }

    public void setCurrentlyFlying(boolean currentlyFlying) {
        isCurrentlyFlying = currentlyFlying;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }
}
