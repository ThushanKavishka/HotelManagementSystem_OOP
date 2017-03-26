
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rooms {

    Scanner sc = new Scanner(System.in);

    public void displayAllRooms(String[] displayRooms) {

        try {
            String displayRoom;
            String getConfirm;
            fileHandling handler = new fileHandling();

            System.out.println(" L - Load Data Into The Array");
            System.out.print("Press 'L' To get Confirm: ");
            getConfirm = sc.next();
            if (getConfirm.equalsIgnoreCase("L")) {
                //read the each file and get values
                for (int i = 1; i <= 10; i++) {
                    displayRoom = handler.read((Integer.toString(i)));
                    displayRooms = displayRoom.split("/");
                    System.out.println("");
                    System.out.println("ROOM NO " + i + ":" + " CUS_ID:" + displayRooms[0] + "  F_NAME:" + displayRooms[1] + "  L_NAME:" + displayRooms[2]
                            + "  AVAILABILITY:" + displayRooms[3]);

                }
            } else {
                return;
            }
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("ERROR OCCURED!!");
        }
    }

    public void addCustomer(String[] displayRooms) {
        try {
            String fName;
            String lName;
            String getConfirm;
            int cusID;
            int roomNo;

            System.out.print("Enter the Room No : ");
            roomNo = sc.nextInt();
            System.out.print("Enter the customer ID : ");
            cusID = sc.nextInt();
            System.out.print("Enter the customer First Name: ");
            fName = sc.next();
            System.out.print("Enter the customer Last Name : ");
            lName = sc.next();

            System.out.println("");
            System.out.println("");

            fileHandling handler = new fileHandling();

            String roomDetail = "";
            //String[] fields = new String[4];

            System.out.println(" S - Store Data In Text File");
            System.out.print("Press 'S' To get Confirm: ");
            getConfirm = sc.next();
            if (getConfirm.equalsIgnoreCase("S")) {
                //get user inputs and write it into a correct file
                for (int i = 1; i <= 10; i++) {
                    roomDetail = handler.read((Integer.toString(i)));
                    displayRooms = roomDetail.split("/");
                    if (displayRooms[3].equalsIgnoreCase("0") && roomNo == i) {
                        handler.write(Integer.toString(i), cusID + "/" + fName + "/" + lName + "/" + "1");
                        
                    }/*else(roomNo!= i && displayRooms[3].equalsIgnoreCase("1")){
                        System.out.println("");
                        System.out.println("Invalid User Input");
                        break;
                    }*/

                }
            }
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("INVALID USER INPUT!!");
        }
    }

    public void findRoomsFromCus_Name(String[] displayRooms) {
        try {
            String cusFName;
            String cusLName;
            String getConfirm;

            System.out.print("Enter Customer First Name: ");
            cusFName = sc.next();
            System.out.print("Enter Customer Last Name : ");
            cusLName = sc.next();
            System.out.println("");
            fileHandling handler = new fileHandling();
            String roomDetail = "";
            // String[] fields = new String[4];

            System.out.println(" L - Load Data Into The Array");
            System.out.print("Press 'L' To get Confirm: ");
            getConfirm = sc.next();
            System.out.println("");
            if (getConfirm.equalsIgnoreCase("L")) {

                //read the each file and get values
                for (int i = 1; i <= 10; i++) {
                    roomDetail = handler.read((Integer.toString(i)));
                    displayRooms = roomDetail.split("/");
                    if (displayRooms[1].equalsIgnoreCase(cusFName) && displayRooms[2].equalsIgnoreCase(cusLName)) {
                        System.out.println("ROOM NO " + i + " :" + " CUS_ID:" + displayRooms[0] + "  F_NAME:" + displayRooms[1]
                                + "  L_NAME:" + displayRooms[2] + "  AVAILABILITY:" + displayRooms[3]);

                        break;
                    } else {
                        System.out.println("");
                        System.out.println("Invalid User Input");
                        break;
                    }
                }
            } else {
                return;
            }
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("ERROR OCCURED!!!");
        }
    }

    public void displayEmptyRooms(String[] displayRooms) {
        try {
            fileHandling handler = new fileHandling();

            String roomDetail = "";
            //String[] fields = new String[4];
            String getConfirm;

            System.out.println(" L - Load Data Into The Array");
            System.out.print("Press 'L' To get Confirm: ");
            getConfirm = sc.next();
            if (getConfirm.equalsIgnoreCase("L")) {

                //read the each file and get values
                for (int i = 1; i <= 10; i++) {
                    roomDetail = handler.read((Integer.toString(i)));
                    displayRooms = roomDetail.split("/");
                    if (displayRooms[3].equalsIgnoreCase("0")) {
                        System.out.println("");
                        System.out.println("ROOM NO " + i + " :" + " CUS_ID:" + displayRooms[0] + "  F_NAME:" + displayRooms[1]
                                + "  L_NAME:" + displayRooms[2] + "  AVAILABILITY:" + displayRooms[3]);
                    }
                }
            } else {
                return;
            }
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("ERROR OCCURED!!");
        }
    }

    public void removeCustomer(String[] displayRooms) {
        try {
            int cusID;
            String cus_FNAME;
            String cus_LNAME;
            String getPermission;

            System.out.print("Enter Customer ID : ");
            cusID = sc.nextInt();
            System.out.print("Enter Customer First Name: ");
            cus_FNAME = sc.next();
            System.out.print("Enter Customer Last Name:  ");
            cus_LNAME = sc.next();
            System.out.print("Are you sure that you want to Permanently Remove this Customer? (Y/N):  ");
            getPermission = sc.next();

            fileHandling handler = new fileHandling();

            String roomDetail = "";

            //read the each file and get values
            for (int i = 1; i <= 10; i++) {
                roomDetail = handler.read((Integer.toString(i)));
                displayRooms = roomDetail.split("/");
                if (displayRooms[0].equals(cusID) && displayRooms[1].equalsIgnoreCase(cus_FNAME) && displayRooms[2].equalsIgnoreCase(cus_LNAME)
                        && getPermission.equalsIgnoreCase("Y")) {
                    handler.write(Integer.toString(i), "0/0/0/0");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("INVALID USER INPUT!!");
        }
    }

    public void orderedRoomsByName(String[] displayRooms, String[] stu) {

        String roomDetail = "";
        fileHandling handler = new fileHandling();
        //read the each file and get values
        for (int i = 1; i <= 10; i++) {
            roomDetail = handler.read((Integer.toString(i)));
            // System.out.println(roomDetail);
            displayRooms = roomDetail.split("/");
            // System.out.println(Arrays.toString(displayRooms));

            //fName = displayRooms[1]; 
            // System.out.println(fName);
            stu[i - 1] = displayRooms[1];

        }

        System.out.println(Arrays.toString(stu));

        //}
        int firstWord;
        int secondWord;
        int count = 1;
        //create a different array to load customer names from stu array
        ArrayList<String> arrList = new ArrayList<String>();
        int k = 0;
        //initialize the new array from stu array
        for (int x = 0; x < stu.length; x++) {

            if (!(stu[x].equals("0"))) {

                arrList.add(k, stu[x]);
                k++;
            }

        }
        //sort using bubble sort algorithm
        for (int i = 0; i < arrList.size() - 1; i++) {
            for (int j = 0; j < arrList.size() - 1; j++) {
                //convert 1st character of the customer name into integer
                firstWord = arrList.get(j).toLowerCase().charAt(0);
                secondWord = arrList.get(j + 1).toLowerCase().charAt(0);

                if (firstWord > secondWord) {
                    //swap the words
                    String tempWord = arrList.get(j);
                    arrList.set(j, arrList.get(j + 1));
                    arrList.set(j + 1, tempWord);

                }

            }

        }
        //print sorted customer names using for each loop
        System.out.println("CUSTOMERS IN ALPHABETICALLY ORDER: ");
        for (String sortedCustomer : arrList) {

            System.out.println(count + ". " + sortedCustomer);
            count++;
        }
    }
}
