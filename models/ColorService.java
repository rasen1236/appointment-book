// ColorService.java - SalonService class derrived from SalonService Class
Tynan Brown, Seungchol Lee, Rasendra Bhattarai
// Team 4
// 19 Nov 2019

/**
 *The ColorService class maintains information about the name and price of a Bleach service. It includes the two parameters named color and color price
 // type and has a specific constructor that takes is used by the implementation class to make the ColorService class. This class is the 
 // extension of the abstract class SalonService which has the abstract method called: getCost(). This class is responsoble for adding the service 
 // to the appointment. Without this class the salon service for the Color service class cant be able to made.
 * 
 */
public class ColorService extends SalonService {

    private String color;
    private int coloringPrice;

    /**
     * Constructs a new SalonService instance.
     * @param color the color of dye
     * @param coloringPrice the price of the dye
     */
    public ColorService(String name, double price, String color, int coloringPrice) {
        super(name, price);
        this.color = color;
        this.coloringPrice = coloringPrice;
    }

    /**
     * Returns the price of the color service
     * @return price the price of the color service
     */ 
    public double getCost() {
        double cost = (price + coloringPrice);
        return cost;
    }

    /**
     * Returns a string describing the color service
     * @return description of the color service
     */
    @Override
    public String toString() {
        String line = super.name + color + HairSalon.cents2dollarsAndCents((int)getCost() + coloringPrice);
        return line;
    }
}
