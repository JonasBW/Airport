package airport.airplane;

import java.util.List;

public class Airport {
    String airportName;
    List Airplanes;

    public Airport() {
    }

    public Airport(String airportName, List Airplanes) {
        this.airportName = airportName;
        this.Airplanes = Airplanes;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List getAirplanes() {
        return Airplanes;
    }

    public void setAirplanes(List airplanes) {
        Airplanes = airplanes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportName='" + airportName + '\'' +
                ", Airplanes=" + Airplanes +
                '}';
    }
}
