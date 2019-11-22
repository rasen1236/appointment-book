import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

// AppointmentBook.java - AppointmentBook class
// Tynan Brown, 19 Nov 2019

/**
 * The AppointmentBook maintains the store of appointments
 * @author Tynan Brown
 */
public class AppointmentBook {

    private Appointment[] appointments;
    private SalonService[] salonServices;

    /**
     * Constructs a new AppointmentBook instance.
     */
    public AppointmentBook() {
        this.appointments = new Appointment[0];
        this.salonServices = new SalonService[0];
        loadAppointmentsFromFile("appointments.txt");
    }

    /**
     * Write Appointments to file
     * @param path location of file
     * @param appointments array of all appointments
     */
    public void loadAppointmentsFromFile(String path) {
        try {
            String line = null; 
			Scanner scan = new Scanner(new FileInputStream(new File(path)));  
			Scanner scanLine = null; 
            //int counter = 0; 

            while (scan.hasNextLine()) {
                line = scan.nextLine();
				scanLine = new Scanner(line);
                scanLine.useDelimiter(", ");
                //tokenizing the line variable
                String customerName = scanLine.next();
                String customerPhone = scanLine.next();
                String stylistName = scanLine.next();
                
                Date date = new Date();//HairSalon.string2Date(scanLine.next());
                SalonService[] services = new SalonService[0];
                Appointment appointment = new Appointment(customerName, customerPhone, stylistName, date);
                addAppointment(appointment);
            }
            scan.close();
        } 
        catch(FileNotFoundException e) {
			e.printStackTrace(); 
		}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Write Appointments to file
     * @param path location of file
     * @param appointments array of all appointments
     */
    public void writeAppointmentsToFile(String path) {
        try {
            FileWriter fw = new FileWriter(new File(path));
			FileOutputStream fis = new FileOutputStream(path);
			PrintWriter pw = new PrintWriter(fis);
			for(int i=0; i < appointments.length; i++){
				if(appointments[i]!=null) pw.write(appointments[i].toString() +"\n");
			}
			pw.close();
        } 
        catch(FileNotFoundException e) {
			e.printStackTrace(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new appointment to the application
     * @param appointment 
     */
    public void addAppointment(Appointment appointment) {
        int currentSize = appointments.length;
        int newSize = currentSize + 1;
        Appointment[] tempArray = new Appointment[newSize];
        for (int i=0; i < currentSize; i++)
        {
            tempArray[i] = appointments [i];
        }
        tempArray[newSize - 1] = appointment;
        appointments = tempArray;
    }

    /**
     * Returns the index of the 
     * @return tot
     */
    public int binarySearch() {
        // TODO: appointments binary search 
        return -1;
    }

    public void sort() {
        // TODO: insertion sort etc
    }

    /**
     * Returns the receipt 
     * @return tot
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Appointment appointment : appointments) {
            sb.append(appointment.toString());
        }
        return sb.toString();
    }
    
}