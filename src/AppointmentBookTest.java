import java.util.Date;

/**
 * Test
 */
public class AppointmentBookTest {

    public static void main(final String[] args) {

        AppointmentBook appointmentBook = new AppointmentBook();

        appointmentBook.loadAppointmentsFromFile();

        Appointment ap1 = new Appointment("Pauline Brown", "+1571234583", "Kelley", new Date());
        Appointment ap2 = new Appointment("Kelly Warwick", "+1461824893", "Julie Kao", new Date());
        
        ap1.addSalonService(new ColorService("Color", 20.0, "Blue", 4));
        ap2.addSalonService(new ColorService("Color", 20.0, "Purple", 4));

        appointmentBook.addAppointment(ap1);
        appointmentBook.addAppointment(ap2);

        appointmentBook.writeAppointmentReceiptToFile(1);

        appointmentBook.removeAppointment(2);

        appointmentBook.writeAppointmentsToFile();

        System.out.println(appointmentBook);
    }
}