import java.util.Date;

/**
 * Test
 */
public class AppointmentBookTest {

    public static void main(final String[] args) {

        AppointmentBook appointmentBook = new AppointmentBook();

        Appointment ap1 = new Appointment("Pauline Brown", "9999", "Kelley", new Date());
        
        ap1.addSalonService(new ColorService("Color", 20.0, "Blue", 4));
        
        appointmentBook.addAppointment(ap1);

        appointmentBook.writeAppointmentsToFile("appointments.txt");

        System.out.println(appointmentBook);
    }
}