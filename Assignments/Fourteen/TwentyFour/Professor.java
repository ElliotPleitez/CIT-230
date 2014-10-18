package Fourteen.TwentyFour;

import java.util.Random;

public class Professor {
    String firstName, lastName;
    Rank rank;
    Double salary;
    
    public enum Rank {
        Assistant,
        Associate,
        Full;
    }
    
    public Professor(String firstName, String lastName, int i){
        this.firstName = firstName + i;
        this.lastName = lastName + i;
        this.rank = Rank.values()[new Random().nextInt(Rank.values().length)];
        
        double random;
        switch(rank){
        case Assistant:
            random = new Random().nextDouble();
            this.salary = 50000 + (random * (80000 - 50000));
            break;
        case Associate:
            random = new Random().nextDouble();
            this.salary = 110000 + (random * (110000 - 60000));
        case Full:
            random = new Random().nextDouble();
            this.salary = 130000 + (random * (130000 - 75000));
        }
    }
}
