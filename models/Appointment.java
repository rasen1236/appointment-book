import java.util.Date;

// Appointment.java - Appointment super class
// Tynan Brown, Seungchol Lee, Rasendra Bhattarai
// Team 4
// 19 Nov 2019

/**
 * The Appointment class maintains information about an appointment. This class is the data definition class and consists of all the information 
 * related to the appointment class. This class consists of customer Name, customer phone and stylistName and the salon service array.
 * This class is used ny the implementation class to produce the required output. This appointment class helps the users which are customers and 
 * stylist to create, delete and modify an appointment. The appointment's list can be seen by the stylist and it is sorted out in the ascending order.
 * This programs also calculates the total amount a customer has to pay once he uses this system along with the information about the services he choses to
 * to receive from us.
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

    // Getters
    public String getCustomerName() { return customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public String getStylistName() { return stylistName; }
    public String getDate() { return HairSalon.date2String(date); }

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

    public String toReceiptFormat() {
        StringBuilder sb = new StringBuilder();
        String line = (customerName + ", " + customerPhone + ", " + stylistName + ", " + HairSalon.date2String(date) + "\n\n");
        sb.append(line);

        for (SalonService salonService : salonServices) {
            sb.append(salonService.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Returns a string representing a recipt of the salon services
     * @return sb formatted list of all items
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = (customerName + ", " + customerPhone + ", " + stylistName + ", " + HairSalon.date2String(date) +  "\n");

        // for (SalonService salonService : salonServices) {
        //     line = line + salonService.toString();
        // }
        System.out.println(line);
        sb.append(line);
        return sb.toString();
    }
 }
