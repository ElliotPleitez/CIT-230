package Fourteen.TwentyFour;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

import javax.swing.JFileChooser;

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
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File file = fileChooser.getSelectedFile();
        fileChooser.showOpenDialog(null);
        
//           File file = fileChooser.getSelectedFile();
//           Integer opt = j.showSaveDialog(this);
            
            
        // Create instance of output file to write to
        File salaryFile = new File("Salary.txt");
        // Write elements of inputFile to output file
        PrintWriter output = new PrintWriter(salaryFile);
        for (int i = 0; i < 1000; i++) {
            output.println(professorList.get(i).toString());
        }
        // Close the file
        output.close();
    }
}

//Comments by: Elliot J Pleitez
//Date: 2014-10-18
//Program runs as expected and does exactly what is necessary.
//Program is documented and well written for future modifications.
//One improvement i'd do is provide a directory to save file.