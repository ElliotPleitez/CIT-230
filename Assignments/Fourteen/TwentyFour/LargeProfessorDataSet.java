package Fourteen.TwentyFour;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
//Author: Luisito Espanola
//Date: 2014-10-16
Problem: Create a large data file with 1000 lines. Each line consists of faculty member's first name, last name, rank, and salary.
The faculty member's first name and last name for the ith line are FirstNamei and LastNamei.
The rank is randomly generated as assistant, associate, and full. The salary is randomly generated as a number with 2 digits after the decimal point.
The salary for an assistant professor is between 50000 to 80000, for associate professor 60000 to 110000, and full profesor 75000 to 130000.
Save file in Salary.txt 

Solution:
1. Create an String ArrayList to store large data set.
2. Prompt user to populate Array list by entering list elements
3. Create output file Salary.txt.
4. Use for loop to get elements of data set and write them individually to output file.
5. Display created output file. 

*/

public class LargeProfessorDataSet {

    public static void main(String[] args) throws Exception {
        String firstName, lastName;
        
        // Create String ArrayList
        ArrayList<Professor> professorList = new ArrayList<Professor>();

        // Prompt user to input professor information
        Scanner input = new Scanner(System.in);
        System.out.println("Enter professor first name, last name separated by spaces i.e. Luisito Espanola: ");
        firstName = input.next();
        lastName = input.next();
        
        for (int i = 1; i <= 1000; i++) {
            Professor professor = new Professor(firstName, lastName, i);
            professorList.add(professor);
        }        
        System.out.println(professorList.size());
        // Create instance of output file to write to
        File salaryFile = new File("Salary.txt");
        // Write elements of inputFile to output file
        PrintWriter output = new PrintWriter(salaryFile);
        for (int i = 0; i <= 1000; i++) {
            output.print(professorList.toString());            
        }
        // Close the file
        output.close();
    }
}