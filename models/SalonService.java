// SalonService.java - SalonService super class
// Tynan Brown, 19 Nov 2019

/**
 * The SalonService class maintains information about a service provided by the salon.
 * @author Tynan Brown
 */
public abstract class SalonService {

    protected String name;
    protected double price;

    /**
     * Constructs a new SalonService instance.
     * @param name the name of the salon service
     * @param price the cost of the procedure
     */ 
    public SalonService(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of salon service
     * @return the name
     */ 
    public final String getName(){
        return name;
    }

    /**
     * Returns the total cost of salon service
     * @return the cost
     */ 
    public abstract double getCost();
    
 }