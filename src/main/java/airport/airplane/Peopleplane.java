package airport.airplane;

public class Peopleplane extends Airplane{
    int maxNoOfPassengers;
    int currentNoOfPassengers;

    public Peopleplane(String planeId, boolean isCurrentlyFlying, int cruiseSpeed, int maxNoOfPassengers, int currentNoOfPassengers) {
        super(planeId, isCurrentlyFlying, cruiseSpeed);
        this.maxNoOfPassengers = maxNoOfPassengers;
        this.currentNoOfPassengers = currentNoOfPassengers;
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
}
