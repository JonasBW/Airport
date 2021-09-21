package airport;

import airport.airplane.Airport;
import airport.airplane.Cargoplane;
import airport.airplane.Peopleplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List <Peopleplane> peopleplanes = new ArrayList();
    public static List <Cargoplane> cargoplanes = new ArrayList();
    public static List <Airport> airports = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);
    public static Airport airport = new Airport();

    public static void main(String[] args) {
        peopleplanes.add(new Peopleplane("B767",false,800,500,300));
        peopleplanes.add(new Peopleplane("B768",true,800, 500,400));
        peopleplanes.add(new Peopleplane("B769",true,800,500,500));

        cargoplanes.add(new Cargoplane("C100",true,800,2000,1100));
        cargoplanes.add(new Cargoplane("C101",false,800,4000,1500));

        airports.add(new Airport("Eindhoven", peopleplanes, cargoplanes));

//        System.out.print("Please Enter plane identification: ");
//        String planeId = scanner.nextLine();
//        System.out.print("Enter number of new passengers: ");
//        int newLoadPassengers = scanner.nextInt();
//        System.out.print("Enter number of unloaded passengers: ");
//        int unloadPassengers = scanner.nextInt();

//        LoadPassengers(planeId, newLoadPassengers);
//        TakeOff(planeId);
//        UnloadPassengers(planeId, unloadPassengers);
//        Land(planeId);
//        for(Peopleplane peopleplane: peopleplanes) System.out.println("Plane Id: " + peopleplane.getPlaneId() + " Flying: " + peopleplane.isCurrentlyFlying() + " Current no of passengers: " + peopleplane.getCurrentNoOfPassengers());
//          planesInAirport("Eindhoven");
        landedPlanesWithSeatsInAirport("Eindhoven");
    }

    public static void LoadPassengers(String planeId, int passengers){
        for(Peopleplane peopleplane: peopleplanes){
            if (planeId.equals(peopleplane.getPlaneId())){
                int availableSeat = peopleplane.getMaxNoOfPassengers() - peopleplane.getCurrentNoOfPassengers();
                int excessPassengers = passengers - availableSeat;
                if(excessPassengers > 0){
                    System.out.println("You can not load more than the max " + peopleplane.getMaxNoOfPassengers() + " passengers");
                    System.out.println("There is room for " + availableSeat + ". But " + excessPassengers + " do not fit");
                }else{
                    peopleplane.setCurrentlyFlying(false);
                    System.out.println("Plane " + planeId + " has loaded " + passengers + " new passengers");
                }
            }
        }
    }

    public static void TakeOff(String planeId){
        for(Peopleplane peopleplane: peopleplanes){
            if (planeId.equals(peopleplane.getPlaneId())){
                if(peopleplane.isCurrentlyFlying()){
                    System.out.println("This plane is already flying.");
                }else{
                    peopleplane.setCurrentlyFlying(true);
                    System.out.println("Plane " + planeId + " has taken off ");
                }
            }
        }
    }

    public static void UnloadPassengers(String planeId, int passengers){
        for(Peopleplane peopleplane: peopleplanes){
            if (planeId.equals(peopleplane.getPlaneId())){
                if(passengers > peopleplane.getCurrentNoOfPassengers()){
                    System.out.println("You can not unload more than the current " + peopleplane.getCurrentNoOfPassengers() + " passengers");
                }else{
                    int remainingPassengers = peopleplane.getCurrentNoOfPassengers() - passengers;
                    peopleplane.setCurrentNoOfPassengers(remainingPassengers);
                    System.out.println("Plane " + planeId + " has unloaded " + passengers + " passengers");
                }
            }
        }
    }

    public static void Land(String planeId){
        for(Peopleplane peopleplane: peopleplanes){
            if (planeId.equals(peopleplane.getPlaneId())){
                if(!peopleplane.isCurrentlyFlying()){
                    System.out.println("This plane has already landed.");
                }else{
                    System.out.println("Plane " + planeId + " has landed.");
                }
            }
        }
    }

    public static void planesInAirport(String airportName){
        for(Airport airport: airports){
            if (airportName.equals(airport.getAirportName())){
                List <Peopleplane> peoplePlanesInAirport = airport.getPeoplePlanes();
                System.out.println("People planes from airport: " + airportName);
                for(Peopleplane peopleplane: peoplePlanesInAirport) {
                    System.out.println("Plane Id: " + peopleplane.getPlaneId() +
                            " Flying: " + peopleplane.isCurrentlyFlying() +
                            " Current no of passengers: " + peopleplane.getCurrentNoOfPassengers());
                }
                List <Cargoplane> cargoPlanesInAirport = airport.getCargoPlanes();
                System.out.println("Cargo planes from airport: " + airportName);
                for(Cargoplane cargoplane: cargoPlanesInAirport) {
                    System.out.println("Plane Id: " + cargoplane.getPlaneId() +
                            " Flying: " + cargoplane.isCurrentlyFlying() +
                            " Current cargo in tons: " + cargoplane.getCurrentCargoInTons());
                }
            }else{
                System.out.println("Airport not found.");
            }
        }
    }

    public static void landedPlanesWithSeatsInAirport(String airportName){
        for(Airport airport: airports){
            if (airportName.equals(airport.getAirportName())){
                List <Peopleplane> peopleplanesInAirport = airport.getPeoplePlanes();
                for(Peopleplane peopleplane: peopleplanesInAirport) {
                    int availableSeat = peopleplane.getMaxNoOfPassengers() - peopleplane.getCurrentNoOfPassengers();

                    if(!peopleplane.isCurrentlyFlying() && availableSeat > 0){
                        System.out.println("Planes not flying with room for passengers: ");
                        System.out.println("Plane Id: " + peopleplane.getPlaneId() +
                                " Available seats: " + availableSeat);
                    }
                }

                List <Cargoplane> cargoPlanesInAirport = airport.getCargoPlanes();
                for(Cargoplane cargoplane: cargoPlanesInAirport) {
                    int availableCargo = cargoplane.getMaxCargoInTons() - cargoplane.getCurrentCargoInTons();
                    if(!cargoplane.isCurrentlyFlying() && availableCargo > 0) {
                        System.out.println("Cargo planes not flying and with room for cargo: " + airportName);
                        System.out.println("Plane Id: " + cargoplane.getPlaneId() +
                                " Flying: " + cargoplane.isCurrentlyFlying() +
                                " Current cargo in tons: " + cargoplane.getCurrentCargoInTons());
                        System.out.println("Plane Id: " + cargoplane.getPlaneId() +
                                " Available cargo space: " + availableCargo);
                    }
                }
            }else{
                System.out.println("Airport not found.");
            }
        }
    }

}
