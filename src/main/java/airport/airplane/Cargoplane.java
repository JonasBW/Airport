package airport.airplane;

public class Cargoplane extends Airplane{
    int maxCargoInTons;
    int currentCargoInTons;

    public Cargoplane(String planeId, boolean isCurrentlyFlying, int cruiseSpeed, int maxCargoInTons, int currentCargoInTons) {
        super(planeId, isCurrentlyFlying, cruiseSpeed);
        this.maxCargoInTons = maxCargoInTons;
        this.currentCargoInTons = currentCargoInTons;
    }

    public int getMaxCargoInTons() {
        return maxCargoInTons;
    }

    public void setMaxCargoInTons(int maxCargoInTons) {
        this.maxCargoInTons = maxCargoInTons;
    }

    public int getCurrentCargoInTons() {
        return currentCargoInTons;
    }

    public void setCurrentCargoInTons(int currentCargoInTons) {
        this.currentCargoInTons = currentCargoInTons;
    }
}
