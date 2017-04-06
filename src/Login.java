
import java.util.Scanner;

public class Login {

    public static void main(String args[]) {
        //initialize the displayRooms array and arr array
        String[] displayRooms = new String[4];
        String[] arr = new String[10];

        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                             |");
        System.out.println("                        *******WELCOME TO HOTEL MANAGEMENT SYSTEM*******              ");
        System.out.println("|                                                                                             |");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("      ##  LOGIN #####    ");
        System.out.println("");
        System.out.print("   USERNAME:   ");
        String username = sc.next();
        System.out.println("");
        System.out.print("   PASSWORD:   ");
        String password = sc.next();
        System.out.println("");
        if ((username.equalsIgnoreCase("1")) && ((password.equalsIgnoreCase("1")))) {
            System.out.println("Login Successfully!!!");

            //Creating 10 rooms..
            fileHandling handl = new fileHandling();
            handl.createRooms();

            while (true) {
                System.out.println("");
                System.out.println("");
                System.out.println("***************************************");
                System.out.println("---------------HOME PAGE---------------");
                System.out.println("***************************************");
                System.out.println("");

                String var = "";

                //Create Main Menu...
                System.out.println(" V - Display Rooms");
                System.out.println(" A - Add Customers");
                System.out.println(" F - Find Rooms");
                System.out.println(" E - Display Empty Rooms");
                System.out.println(" D - Remove Customer");
                System.out.println(" O - View Rooms Ordered By Name");
                System.out.println(" S - Store Data In Text File");
                System.out.println(" L - Load Data Into The Array");
                System.out.println("");
                System.out.print("");
                System.out.print("Select Your Route:  ");
                System.out.print("");
                System.out.print("");

                var = sc.next();

                Rooms obj1 = new Rooms();
                if (var.equalsIgnoreCase("V")) {
                    System.out.println("");
                    System.out.println("----------ALL ROOMS----------");
                    System.out.println("");

                    obj1.displayAllRooms(displayRooms);

                } else if (var.equalsIgnoreCase("A")) {
                    System.out.println("");
                    System.out.println("----------ADDING CUSTOMER----------");
                    System.out.println("");

                    obj1.addCustomer(displayRooms);

                } else if (var.equalsIgnoreCase("F")) {
                    System.out.println("");
                    System.out.println("----------FIND ROOMS----------");
                    System.out.println("");

                    obj1.findRoomsFromCus_Name(displayRooms);

                } else if (var.equalsIgnoreCase("E")) {
                    System.out.println("");
                    System.out.println("----------EMPTY ROOMS----------");
                    System.out.println("");

                    obj1.displayEmptyRooms(displayRooms);

                } else if (var.equalsIgnoreCase("D")) {
                    System.out.println("");
                    System.out.println("----------REMOVE CUSTOMER----------");
                    System.out.println("");

                    obj1.removeCustomer(displayRooms);

                } else if (var.equalsIgnoreCase("O")) {
                    System.out.println("");
                    System.out.println("----------SORT CUSTOMERS' NAMES----------");
                    System.out.println("");

                    obj1.orderedRoomsByName(displayRooms, arr);

                } else {

                    System.out.println("");
                    System.out.println("INVALID SELECTION");

                }
            }
        } else {
            System.out.println("Username or Password Incorrect!!!");
        }
    }

}
