package Fourteen.TwentyFour;

import java.util.Random;
// Create a Professor class to be used to display professor information
public class Professor {
    String firstName, lastName;
    Rank rank;
    double salary;
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
        // Generate a random Salary amount based on rank with random cents also
        int dollarRandom;
        double centRandom;
        switch(rank){
        case Assistant:
            dollarRandom = new Random().nextInt((80000 - 50000) + 1) + 50000;
            centRandom = new Random().nextInt(100);
            this.salary = dollarRandom + (centRandom / 100);
            break;
        case Associate:
            dollarRandom = new Random().nextInt((110000 - 60000) + 1) + 110000;
            centRandom = new Random().nextInt(100);
            this.salary = dollarRandom + (centRandom / 100);
            break;
        case Full:
            dollarRandom = new Random().nextInt((130000 - 75000) + 1) + 75000;
            centRandom = new Random().nextInt(100);
            this.salary = dollarRandom + (centRandom / 100);
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
