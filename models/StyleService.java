// StyleService.java - StyleService class derrived from SalonService Class
// Tynan Brown, 19 Nov 2019

/**
 * The StyleService class maintains information about the name and price of a style service.
 * @author Tynan Brown
 */
public class StyleService extends SalonService {

    private String style;
    private int stylingPrice;

    /**
     * Constructs a new SalonService instance.
     * @param style the style of hair cut
     * @param stylingPrice the price of the hair cut
     */
    public StyleService(String name, double price, String style, int stylingPrice) {
        super(name, price);
        this.style = style;
        this.stylingPrice = stylingPrice;
    }

    /**
     * Returns the price of the style service
     * @return price the price of the style service
     */ 
    public double getCost() {
        double cost = (price + stylingPrice);
        return cost;
    }

    /**
     * Returns a string describing the style service
     * @return description of the style service
     */
    @Override
    public String toString() {
        String line = super.name + HairSalon.cents2dollarsAndCents((int)getCost());
        return line;
    }
}