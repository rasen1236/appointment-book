// BleachService.java - BleasyService class derrived from SalonService Class
// Tynan Brown, Seungchol Lee, Rasendra Bhattarai
// Team 4
// 19 Nov 2019

/**
 *The BleachService class maintains information about the name and price of a Bleach service. It includes the single parameters named peroxide
 // type and has a specific constructor that takes is used by the implementation class to make the BleachService class. This class is the 
 // extension of the abstract class SalonService which has the abstract method called: getCost(). This class is responsoble for adding the service 
 // to the appointment. Without this class the salon service for the bleach service class cant be able to made.
 * 
 */
public class BleachService extends SalonService {

    private String peroxideType;

    /**
     * Constructs a new BleachService instance.
     * @param peroxideType the color of dye
     */
    public BleachService(String name, double price, String peroxideType) {
        super(name, price);
        this.peroxideType = peroxideType;
    }

    /**
     * Returns the price of the Bleach service
     * @return price the price of the Bleach service
     */ 
    public double getCost() {
        return price;
    }

    /**
     * Returns a string describing the Bleach service
     * @return description of the Bleach service
     */
    @Override
    public String toString() {
        String line = super.name + HairSalon.cents2dollarsAndCents((int)getCost());
        return line;
    }
}
