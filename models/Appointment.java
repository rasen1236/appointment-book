import java.util.Date;

// Appointment.java - Appointment super class
// Tynan Brown, 19 Nov 2019

/**
 * The Appointment class maintains information about an appointment
 * @author Tynan Brown
 */
public class Appointment {

    private String customerName;
    private String customerPhone;
    private String stylistName;
    private Date date;
    private SalonService[] salonServices;

    /**
     * Constructs a new Appointment instance.
     * @param customerName the name of the customer who has booked the appointment
     * @param customerPhone the contact number of the customer
     * @param stylistName the name of the hair salon stylist
     * @param date the date and time of the appointment
     * @param salonService the list of services to be performed
     */ 
    public Appointment(String customerName, String customerPhone, String stylistName, Date date) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.stylistName = stylistName;
        this.date = date;
        this.salonServices = new SalonService[0];
    }

    /**
     * Add a salon service to an appointment
     * @param salonService the salon service
     */
    public void addSalonService(SalonService salonService) {
        int currentSize = salonServices.length;
        int newSize = currentSize + 1;
        SalonService[] tempArray = new SalonService[newSize];
        for (int i=0; i < currentSize; i++)
        {
            tempArray[i] = salonServices [i];
        }
        tempArray[newSize - 1] = salonService;
        salonServices = tempArray;
    }

    /**
     * Returns the total cost of all salon services
     * @return total cost of salon services
     */
    public int totalCost() {
        double total = 0;
        for (SalonService salonService : salonServices) {
            total = total + salonService.getCost();
        }
        return (int)total;
    }

    /**
     * Returns the total cost of tax for all salon services
     * @return total tax of salon services
     */
    public int totalTax() {
        double taxRate = HairSalon.TAX_RATE / 100;
        double total = 0;
        for (SalonService salonService  : salonServices) {
            total = total + salonService.getCost();
        }
        return (int)Math.round(total * taxRate);
    }

    /**
     * Returns a string representing a recipt of the salon services
     * @return sb formatted list of all items
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = (customerName + ", " + customerPhone + ", " + stylistName + ", " + HairSalon.date2String(date));
        sb.append(line);

        // for (SalonService salonService : salonServices) {
        //     sb.append(salonService.toString());
        // }
        return sb.toString();
    }
 }