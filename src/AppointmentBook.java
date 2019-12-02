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
    }

    public Appointment[] getAppointments() {
        return appointments;
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
            while (scan.hasNextLine()) {
                line = scan.nextLine();
				scanLine = new Scanner(line);
                scanLine.useDelimiter(", ");
                //tokenizing the line variable
                String customerName = scanLine.next();
                String customerPhone = scanLine.next();
                String stylistName = scanLine.next();
                Date date = HairSalon.string2Date(scanLine.next());
                SalonService[] services = new SalonService[0];
                //TODO: populate salon services
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
			pw.write(this.toString());
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
     * Remove appointment by index
     * @param index index of selected row
     */
    public void removeAppointment(int index) {
        for (int i = 0; i < appointments.length; i++) {
            if (i == index) { // appointments[i] == elem
                for (int j = i; j < appointments.length - 1; j++) {
                    appointments[j] = appointments[j+1];
                }
                break;
            }
        }
    }

    /**
     * Returns the index of the appointment
     * @param customerName the name of the customer
     * @return index
     */
    public int search(String customername) {
        // TODO:
        return -1;
    }

    /**
     * Sort appointment by date
     * @return 
     */
    public void sort() {
        // TODO: 
    }

    /**
     * Write appointment receipt to receipt.txt
     * @param appointment the appointment  
     */
    public void writeAppointmentReceiptToFile(String path, Appointment appointment) {
        try {
            FileWriter fw = new FileWriter(new File(path));
			FileOutputStream fis = new FileOutputStream(path);
            PrintWriter pw = new PrintWriter(fis);
            pw.write(appointment.toReceiptFormat());
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
     * Returns 
     * @return sb, 
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