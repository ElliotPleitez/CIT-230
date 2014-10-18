package Fourteen.TwentyFour;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
Problem: Create a large data file with 1000 lines. Each line consists of faculty member's first name, last name, rank, and salary. The faculty member's first name and last name for the ith line are FirstNamei and LastNamei. The rank is randomly generated as assistant, associate, and full. The salaray is randomly generated as a number with 2 digits after the decimal point. The salary for an assistant profesor is between 50000 to 80000, for associate profersor 60000 to 110000, and full profesor 75000 to 130000. Save file in Salary.txt 

Solution:
1. Create an String ArrayList to store large data set.
2. Prompt user to populate Arraylist by entering list elements
3. Create output file Salary.txt.
4. Use for loop to get elements of data set and write them individually to output file.
5. Display created output file. 

*/

public class LargeProfessorDataSet {

    public static void main(String[] args) throws Exception {

        // Create String ArrayList
        ArrayList<String> inputFile = new ArrayList<String>();
        String firstName = "";
        String lastName = "";            
        String rank = "";
        String salary = "";

        for (int i = 0; i < inputFile.size(); i++) {
            
            // Prompt user to input professor information
            Scanner input = new Scanner(System.in);
            System.out.println("Enter professor first name, last name, rank, and salary separated by spaces"
                               + "i.e. Luisito Espanola full 129999.99: ");
            firstName = input.next();
            lastName = input.next();            
            rank = input.next();
            salary = input.next();
            inputFile.add(firstName);
            inputFile.add(lastName);
            inputFile.add(rank);
            inputFile.add(salary);
        }
        // Create instance of output file to write to
        File outputFile = new File("Salary.txt");
        // Write elements of inputFile to output file
        PrintWriter output = new PrintWriter(outputFile);
        for (Integer i = 0; i < inputFile.size(); i++) {
            // Get first professor data from the list
            String temp = inputFile.get(i);
            // Test
            System.out.println(temp);
            // Get the firstName from the list element
            firstName = temp.substring(0, temp.indexOf(" "));
            // Get the lastName
            lastName = temp.substring(temp.indexOf(" " + 1), temp.indexOf(" "));
            // Get rank
            rank = temp.substring(temp.indexOf(" " + 1), temp.indexOf(" "));
            // Get salary
            salary = temp.substring(temp.indexOf(" " + 1), temp.indexOf(" "));
            // Write to output
            output.print(firstName + i + " " + lastName + i + " " + rank + " " + salary);            
        }
        // Close the file
        output.close();
    }
}