package airport.airplane;

public class Airplane {
    String planeId;
    int maxNoOfPassengers;
    int currentNoOfPassengers;
    boolean isCurrentlyFlying;
    int cruiseSpeed;

    public Airplane() {
    }

    public Airplane(String planeId, int maxNoOfPassengers, int currentNoOfPassengers, boolean isCurrentlyFlying, int cruiseSpeed) {
        this.planeId = planeId;
        this.maxNoOfPassengers = maxNoOfPassengers;
        this.currentNoOfPassengers = currentNoOfPassengers;
        this.isCurrentlyFlying = isCurrentlyFlying;
        this.cruiseSpeed = cruiseSpeed;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public int getMaxNoOfPassengers() {
        return maxNoOfPassengers;
    }

    public void setMaxNoOfPassengers(int maxNoOfPassengers) {
        this.maxNoOfPassengers = maxNoOfPassengers;
    }

    public int getCurrentNoOfPassengers() {
        return currentNoOfPassengers;
    }

    public void setCurrentNoOfPassengers(int currentNoOfPassengers) {
        this.currentNoOfPassengers = currentNoOfPassengers;
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
