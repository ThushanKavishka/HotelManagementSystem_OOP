 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileHandling {
    //Create 10 Files

    public void createRooms() {
        for (int i = 1; i <= 10; i++) {
            try {
                FileWriter f = new FileWriter((Integer.toString(i)));
                f.write("0/0/0/0");

                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //   System.out.println("10 Files(Rooms)Created!");   
    }

    //write to the file..
    public void write(String roomNo, String data) {
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(roomNo, false));
            // System.out.println(data);
            out.write(data);
            out.close();
            //System.out.println("Data Write to the Files Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // read from file..
    public String read(String roomNo) {
        String str = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(roomNo));
            str = in.readLine();
            // System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
