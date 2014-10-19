package Fourteen.TwentyThree;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import Fourteen.Thirteen.Count;

//Author: Elliot J Pleitez
//Date: 2014-10-18
//Description: This application searches online for a set of scores. It averages them and displays the total. File has scores separated by the space character

public class WebScore {
    int count, totalScore;

    //main stub (entry)
    public static void main(String[] args) {
        //create an instance of self
        WebScore webScore = new WebScore();
        webScore.runMyself();
    }
    
    public void runMyself(){
        try{
            //open url stream and begin reading from file
            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());
            //note: could have used the delimeter but this was easier...
            while(input.hasNextInt()){
                //while there are integers, add to totalScore and count.
                this.totalScore += input.nextInt();
                this.count++;
            }
        }
        catch(IOException e){
            //return type of error thrown during URL/Scanner class
            System.out.println(e.getMessage());
        }
        if(this.count == 0){
            //file could either not be found or values were not integers
            System.out.println("No scores to evaluate, could not find file or integer values.");
        }
        else{
            //echo results to user
            System.out.println("Total score:   " + this.totalScore);
            System.out.println("Average score: " + (this.totalScore / this.count));
        }
    }
}

/**

Comments by Luisito Espanola
Date: 2014-10-18

proper execution of the program as if you are testing it.
   The program executed properly.
proper understanding of the code as if you have to modify it.
   Code easy to understand. 
any suggestion to improve the code, in your opinion - please be respectful in this step. 
   Code needs no improvements. I like the solution. I learned a new way of using OOP.
     
*/
