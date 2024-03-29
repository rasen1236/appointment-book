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

    private String appointmentsPath = "appointments.txt";
    private String receiptPath = "Receipt.txt";

    private Appointment[] appointments;
    private SalonService[] salonServices;

    /**
     * Constructs a new AppointmentBook instance.
     */
    public AppointmentBook() {
        this.appointments = new Appointment[0];
        this.salonServices = new SalonService[0];
    }

    /**
     * Write Appointments to file
     * @param path location of file
     * @param appointments array of all appointments
     */
    public void loadAppointmentsFromFile() {
        try {
            String line = null; 
			Scanner scan = new Scanner(new FileInputStream(new File(appointmentsPath)));  
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
                Appointment appointment = new Appointment(customerName, customerPhone, stylistName, date);
                appointment.addSalonService(new ColorService("Color", 20, "green", 5));
                //TODO: populate salon services
                
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

    public void loadSalonServices() {
        SalonService service1 = new ColorService("Match Color", 20.0, "Red", 5);
        SalonService service2 = new StyleService("Russion Bob", 22.0, "Wicked", 5);
        SalonService[] tempArr = new SalonService[] {service1, service2 };
        salonServices = tempArr;
    }

    /**
     * Write Appointments to file
     * @param path location of file
     * @param appointments array of all appointments
     */
    public void writeAppointmentsToFile() {
        try {
            FileWriter fw = new FileWriter(new File(appointmentsPath));
			FileOutputStream fis = new FileOutputStream(appointmentsPath);
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
    public void removeAppointment(int rowIndex) {
        for (int i = 0; i < appointments.length; i++) {
            if (i == rowIndex) { 
                Appointment[] newArr = new Appointment[appointments.length - 1]; 
                for(int index = 0; index < i; index++){
                    newArr[index] = appointments[index];
                }
                for(int j = i; j < appointments.length - 1; j++){
                    newArr[j] = appointments[j+1];
                }
                appointments = newArr;
                break;
            }
        }
    }

    /**
     * Write and return appointment receipt to receipt.txt
     * @param appointment the appointment  
     * @return appointment receipt
     */
    public String writeAppointmentReceiptToFile(int rowIndex) {
        try {
            FileWriter fw = new FileWriter(new File(receiptPath));
			FileOutputStream fis = new FileOutputStream(receiptPath);
            PrintWriter pw = new PrintWriter(fis);
            pw.write(appointments[rowIndex].toReceiptFormat());
            pw.close();
        } 
        catch(FileNotFoundException e) {
			e.printStackTrace(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return appointments[rowIndex].toReceiptFormat();
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public SalonService[] getSalonServices() {
        return salonServices;
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