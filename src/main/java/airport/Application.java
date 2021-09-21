package airport;

import airport.airplane.Airplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List <Airplane> airplanes = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        airplanes.add(new Airplane("B767",500,300,false,800));
        airplanes.add(new Airplane("B500",500,300,true,800));

        System.out.print("Please Enter plane identification: ");
        String planeId = scanner.nextLine();
        System.out.print("Enter number of new passengers: ");
        int newLoadPassengers = scanner.nextInt();
        System.out.print("Enter number of unloaded passengers: ");
        int unloadPassengers = scanner.nextInt();

        LoadPassengers(planeId, newLoadPassengers);
        TakeOff(planeId);
        UnloadPassengers(planeId, unloadPassengers);
        Land(planeId);
        for(Airplane airplane: airplanes) System.out.println(airplane.getPlaneId());
    }

    public static void LoadPassengers(String planeId, int passengers){
        for(Airplane airplane: airplanes){
            if (planeId.equals(airplane.getPlaneId())){
                int availableSeat = airplane.getMaxNoOfPassengers() - airplane.getCurrentNoOfPassengers();
                int excessPassengers = passengers - availableSeat;
                if(excessPassengers > 0){
                    System.out.println("You can not load more than the max " + airplane.getMaxNoOfPassengers() + " passengers");
                    System.out.println("There is room for " + availableSeat + ". But " + excessPassengers + " do not fit");
                }else{
                    System.out.println("Plane " + planeId + " has loaded " + passengers + " new passengers");
                }
            }
        }
    }

    public static void TakeOff(String planeId){
        for(Airplane airplane: airplanes){
            if (planeId.equals(airplane.getPlaneId())){
                if(airplane.isCurrentlyFlying()){
                    System.out.println("This plane is already flying.");
                }else{
                    System.out.println("Plane " + planeId + " has taken off ");
                }
            }
        }
    }

    public static void UnloadPassengers(String planeId, int passengers){
        for(Airplane airplane: airplanes){
            if (planeId.equals(airplane.getPlaneId())){
                if(passengers > airplane.getCurrentNoOfPassengers()){
                    System.out.println("You can not unload more than the current " + airplane.getCurrentNoOfPassengers() + " passengers");
                }else{
                    System.out.println("Plane " + planeId + " has unloaded " + passengers + " passengers");
                }
            }
        }
    }

    public static void Land(String planeId){
        for(Airplane airplane: airplanes){
            if (planeId.equals(airplane.getPlaneId())){
                if(!airplane.isCurrentlyFlying()){
                    System.out.println("This plane has already landed.");
                }else{
                    System.out.println("Plane " + planeId + " has landed.");
                }
            }
        }
    }
}
