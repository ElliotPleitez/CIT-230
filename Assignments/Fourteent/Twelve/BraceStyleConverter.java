package Fourteent.Twelve;

import java.util.Scanner;
import javax.swing.JFileChooser; 
import java.io.*;
import java.util.ArrayList;

/**
//Author: Luisito Espanola
//Date: 2014-10-16
Problem 14.12 Write a program that converts the Java source code from the next-line brace style to the end-of-line brace style.

Solution:
1. Use FileChooser to Prompt user to input file needed to be converted.
2. Read the each line of the file needed to be converted.
3. Trim each line to clear all the front spaces.
4. Save each line as elements in an ArrayList.
5. Use the Print statement to Write each line in a new converted file if it does not contain the open curly brackets. 
6. If it contains the open curly brackets. Append a couple of spaces and the opening curly brackets to current line and do a carriage return and tab to move cursor to desired location. 
7. save new file.   

*/

public class BraceStyleConverter {

    public static void main(String[] args) throws Exception {

        // Prompt user to pick file from a list
        System.out.println("Please select to open the file you want to convert");
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Get the selected file use the BMI.java file in the same directory
            File file = fileChooser.getSelectedFile();

           // Create a Scanner for the file
           Scanner input = new Scanner(file);

          // Read text from the file
          while (input.hasNext()) {
              String inputString = input.nextLine();
              // Trim leading spaces from inputString
              inputString.trim();
              // Create an ArrayList to save/add inputString to
              ArrayList<String> inputList = new ArrayList<String>();
              inputList.add(inputString);
              // Display the contents in the list
              System.out.println(inputList.toString());
              // Create a new outputFile to write to
              File convertedFile = new File("BraceStyleConverted.java");
              PrintWriter outputFile = new PrintWriter(convertedFile); 
              // Write contents of inputList into new outputFile
              for(int i = 0; i < inputList.size(); i++) {
                  // If element does not contain curly open brace then print contents into outputFile
                  if (inputList.get(i).charAt(0) != '{') {
                      outputFile.print(inputList.get(i));
                  }
                  else {
                      outputFile.print("  " + inputList.get(i));
                      outputFile.println();               
                  }
               System.out.println("Does it exist? " + file.exists());
              }
          // Close the files
          outputFile.close();
          input.close();
        } 
        System.out.println("No file selected"); 
    }
  }
} 

////Comments by: Elliot J Pleitez
//Date: 2014-10-18
//Program runs as expected and does exactly what is necessary.
//Program is documented and well written for future modifications.
//One improvement i'd do add a few more handlers so it work's with any possible error.