// SalonService.java - SalonService super class
Tynan Brown, Seungchol Lee, Rasendra Bhattarai
// Team 4
// 19 Nov 2019

/**
 // This is a abstract class and it cannnot be used to make a salon service object in the implementation. It has two instance variable namely name and 
 // the price of the service. It has a specific constructor and has two parameters passed to it. It consists of abstract method named: getCost().
 // This class is extending four classes namely: Bleach service, color service, blowout and style service.
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
