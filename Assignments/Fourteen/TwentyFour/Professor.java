package Fourteen.TwentyFour;

import java.util.Random;
// Create a Professor class to be used to display professor information
public class Professor {
    String firstName, lastName;
    Rank rank;
    long salary;
    // Randomly generate rank between 3 choices
    public enum Rank {
        Assistant,
        Associate,
        Full;
    }
    // Construct an instance of professor with given fields
    public Professor(String firstName, String lastName, int i){
        this.firstName = firstName + i;
        this.lastName = lastName + i;
        this.rank = Rank.values()[new Random().nextInt(Rank.values().length)];
        
        double random;
        switch(rank){
        case Assistant:
            random = new Random().nextDouble();
            double unroundedSalary = 50000 + (random * (80000 - 50000));
            this.salary = Math.round(unroundedSalary * 100) / 100;
            break;
        case Associate:
            random = new Random().nextDouble();
            double unroundedSalary1 = 60000 + (random * (110000 - 60000));
            this.salary = Math.round(unroundedSalary1 * 100) / 100;
            break;
        case Full:
            random = new Random().nextDouble();
            double unroundedSalary2 = 75000 + (random * (130000 - 75000));
            this.salary = Math.round(unroundedSalary2 * 100) / 100;
            break;
        }        
    }
    // Return professor first name
    public String getFirstName() {
        return this.firstName;    
    }
    // Return last name
    public String getLastName() {
        return this.lastName;    
    }
    // Return rank
    public Rank getRank() {
        return this.rank;    
    }
    // Return salary
    public double getSalary() {
        return this.salary;    
    }
    // Override toString to display professor fields separated by spaces
    public String toString() {
    	return (this.getFirstName() + " " + this.getLastName() + " " + this.getRank() + " " + this.getSalary());  	
    }
}
