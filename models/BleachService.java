// BleachService.java - BleasyService class derrived from SalonService Class
// Tynan Brown, 19 Nov 2019

/**
 * The BleachService class maintains information about the name and price of a Bleach service.
 * @author Tynan Brown
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