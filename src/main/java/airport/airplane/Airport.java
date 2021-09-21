package airport.airplane;

import java.util.List;

public class Airport {
    String airportName;
    List peoplePlanes;
    List cargoPlanes;

    public Airport() {
    }

    public Airport(String airportName, List peoplePlanes, List cargoPlanes) {
        this.airportName = airportName;
        this.peoplePlanes = peoplePlanes;
        this.cargoPlanes = cargoPlanes;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List getPeoplePlanes() {
        return peoplePlanes;
    }

    public void setPeoplePlanes(List peoplePlanes) {
        this.peoplePlanes = peoplePlanes;
    }

    public List getCargoPlanes() {
        return cargoPlanes;
    }

    public void setCargoPlanes(List cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }
}
