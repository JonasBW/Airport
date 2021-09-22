package airport;

import airport.airplane.Airplane;
import airport.airplane.Airport;
import airport.airplane.Cargoplane;
import airport.airplane.Peopleplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List <Airplane> allAirplanes = new ArrayList();
    public static List <Peopleplane> peoplePlanes = new ArrayList();
    public static List <Cargoplane> cargoPlanes = new ArrayList();

    public static List <Airport> airports = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);
    public static Airport airport = new Airport();
    private Object Assert;

    public static void main(String[] args) {
        allAirplanes.add(new Peopleplane("B767",false,800,500,300));
        allAirplanes.add(new Peopleplane("B768",true,800, 500,400));
        allAirplanes.add(new Peopleplane("B769",true,800,500,500));
        allAirplanes.add(new Cargoplane("C100",true,800,2000,1100));
        allAirplanes.add(new Cargoplane("C101",false,800,4000,1500));

        peoplePlanes.add(new Peopleplane("B767",false,800,500,300));
        peoplePlanes.add(new Peopleplane("B768",true,800, 500,400));
        peoplePlanes.add(new Peopleplane("B769",true,800,500,500));

        cargoPlanes.add(new Cargoplane("C100",true,800,2000,1100));
        cargoPlanes.add(new Cargoplane("C101",false,800,4000,1500));

        airports.add(new Airport("Eindhoven", allAirplanes));

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
//        for(Peopleplane peoplePlane: peoplePlanes) System.out.println("Plane Id: " + peoplePlane.getPlaneId() + " Flying: " + peoplePlane.isCurrentlyFlying() + " Current no of passengers: " + peoplePlane.getCurrentNoOfPassengers());
//        LoadCargo("C100", 2350);
//        UnloadCargo("C101");
//        landedPlanesWithAvailableSpaceInAirport("Eindhoven");
//          planesInAirport("Eindhoven");
        RequestPlaneStatus("C100");
    }


    //Loading with cargo with a weight in tons
    public static void LoadCargo(String planeId, int cargoInTons){
        for(Cargoplane cargoPlane: cargoPlanes){
            if (planeId.equals(cargoPlane.getPlaneId())){
                int availableCargoSpace = cargoPlane.getMaxCargoInTons() - cargoPlane.getCurrentCargoInTons();
                int excessCargo = cargoInTons - availableCargoSpace;
                if(excessCargo > 0){
                    System.out.println("You can not load more than the max " + cargoPlane.getMaxCargoInTons() + " cargo.");
                    System.out.println("There is room for " + availableCargoSpace + ". But " + excessCargo + " do not fit");
                }else{
                    cargoPlane.setCurrentlyFlying(false);
                    System.out.println("Plane " + planeId + " has loaded " + cargoInTons + " new passengers");
                }
            }
        }
    }

    //Discharge of all cargo.
    public static void UnloadCargo(String planeId){
        for(Cargoplane cargoPlane: cargoPlanes){
            if (planeId.equals(cargoPlane.getPlaneId())){
                cargoPlane.setCurrentCargoInTons(0);
                System.out.println("Plane " + planeId + " has discharged all cargo");
            }
        }
    }

    //Passenger planes
    //Load a no of passengers in peoples plane
    public static void LoadPassengers(String planeId, int passengers){
        for(Peopleplane peoplePlane: peoplePlanes){
            if (planeId.equals(peoplePlane.getPlaneId())){
                int availableSeat = peoplePlane.getMaxNoOfPassengers() - peoplePlane.getCurrentNoOfPassengers();
                int excessPassengers = passengers - availableSeat;
                if(excessPassengers > 0){
                    System.out.println("You can not load more than the max " + peoplePlane.getMaxNoOfPassengers() + " passengers");
                    System.out.println("There is room for " + availableSeat + ". But " + excessPassengers + " do not fit");
                }else{
                    peoplePlane.setCurrentlyFlying(false);
                    System.out.println("Plane " + planeId + " has loaded " + passengers + " new passengers");
                }
            }
        }
    }

    //Unload a no of passengers from a people plane
    public static void UnloadPassengers(String planeId, int passengers){
        for(Peopleplane peoplePlane: peoplePlanes){
            if (planeId.equals(peoplePlane.getPlaneId())){
                if(passengers > peoplePlane.getCurrentNoOfPassengers()){
                    System.out.println("You can not unload more than the current " + peoplePlane.getCurrentNoOfPassengers() + " passengers");
                }else{
                    int remainingPassengers = peoplePlane.getCurrentNoOfPassengers() - passengers;
                    peoplePlane.setCurrentNoOfPassengers(remainingPassengers);
                    System.out.println("Plane " + planeId + " has unloaded " + passengers + " passengers");
                }
            }
        }
    }

    public static void TakeOff(String planeId){
        for(Peopleplane peoplePlane: peoplePlanes){
            if (planeId.equals(peoplePlane.getPlaneId())){
                if(peoplePlane.isCurrentlyFlying()){
                    System.out.println("This plane is already flying.");
                }else{
                    peoplePlane.setCurrentlyFlying(true);
                    System.out.println("Plane " + planeId + " has taken off ");
                }
            }
        }
    }

    public static void Land(String planeId){
        for(Peopleplane peoplePlane: peoplePlanes){
            if (planeId.equals(peoplePlane.getPlaneId())){
                if(!peoplePlane.isCurrentlyFlying()){
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
                List <Airplane> peoplePlanesInAirport = airport.getAirplanes();
                System.out.println("People planes from airport: " + airportName);
                for(Airplane peoplePlane: peoplePlanesInAirport) {
                    if(peoplePlane instanceof Peopleplane)
                    System.out.println("Plane Id: " + peoplePlane.getPlaneId() +
                            " Flying: " + peoplePlane.isCurrentlyFlying() +
                            " Current no of passengers: " + ((Peopleplane) peoplePlane).getCurrentNoOfPassengers());
                }
                List <Airplane> cargoPlanesInAirport = airport.getAirplanes();
                System.out.println("Cargo planes from airport: " + airportName);
                for(Airplane cargoPlane: cargoPlanesInAirport) {
                    if(cargoPlane instanceof Cargoplane)
                    System.out.println("Plane Id: " + cargoPlane.getPlaneId() +
                            " Flying: " + cargoPlane.isCurrentlyFlying() +
                            " Current cargo in tons: " + ((Cargoplane) cargoPlane).getCurrentCargoInTons());
                }
            }else{
                System.out.println("Airport not found.");
            }
        }
    }

    public static void landedPlanesWithAvailableSpaceInAirport(String airportName){
        for(Airport airport: airports){
            if (airportName.equals(airport.getAirportName())){
                List <Airplane> planesInAirport = airport.getAirplanes();
                for(Airplane peoplePlane: planesInAirport) {
                    if(peoplePlane instanceof Peopleplane){
                        int availableSeat = ((Peopleplane) peoplePlane).getMaxNoOfPassengers() - ((Peopleplane) peoplePlane).getCurrentNoOfPassengers();

                        if(!peoplePlane.isCurrentlyFlying() && availableSeat > 0){
                            System.out.println("Planes not flying with room for passengers in airport " + airportName);
                            System.out.println("Plane Id: " + peoplePlane.getPlaneId() +
                                    " Available seats: " + availableSeat);
                        }
                    }
                }

                List <Airplane> cargoPlanesInAirport = airport.getAirplanes();
                for(Airplane cargoPlane: cargoPlanesInAirport) {
                    if(cargoPlane instanceof Cargoplane) {
                        int availableCargo = ((Cargoplane) cargoPlane).getMaxCargoInTons() - ((Cargoplane) cargoPlane).getCurrentCargoInTons();
                        if (!cargoPlane.isCurrentlyFlying() && availableCargo > 0) {
                            System.out.println("Cargo planes not flying and with room for cargo in airport " + airportName);
                            System.out.println("Plane Id: " + cargoPlane.getPlaneId() +
                                    " Flying: " + cargoPlane.isCurrentlyFlying() +
                                    " Current cargo in tons: " + ((Cargoplane) cargoPlane).getCurrentCargoInTons());
                            System.out.println("Plane Id: " + cargoPlane.getPlaneId() +
                                    " Available cargo space: " + availableCargo);
                        }
                    }
                }
            }else{
                System.out.println("Airport not found.");
            }
        }
    }

//    Request the status of a single cargoplane that has landed
    public static void RequestPlaneStatus(String planeId){
        for(Peopleplane peoplePlane: peoplePlanes){
            if (planeId.equals(peoplePlane.getPlaneId())){
                int availableSeat = peoplePlane.getMaxNoOfPassengers() - peoplePlane.getCurrentNoOfPassengers();

                System.out.print("Passenger Plane " + planeId + " requested. ");
                if (!peoplePlane.isCurrentlyFlying()) {
                    System.out.print(" Is Not Flying.");
                } else {
                    System.out.print(" Is Flying.");
                }
                System.out.print(" Has room for " + availableSeat + " passengers.");
            }
        }
        for(Cargoplane cargoPlane: cargoPlanes){
            if (planeId.equals(cargoPlane.getPlaneId())){
                int availableCargo = cargoPlane.getMaxCargoInTons() - cargoPlane.getCurrentCargoInTons();

                System.out.print("Cargo Plane " + planeId + " requested. ");
                if (!cargoPlane.isCurrentlyFlying()) {
                    System.out.print(" Is Not Flying.");
                } else {
                    System.out.print(" Is Flying.");
                }
                System.out.print(" Has room for " + availableCargo + " tons in cargo.");
            }
        }
    }
}
