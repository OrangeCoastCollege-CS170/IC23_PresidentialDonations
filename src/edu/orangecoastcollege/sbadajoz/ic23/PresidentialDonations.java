package edu.orangecoastcollege.sbadajoz.ic23;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

/*
Badajoz, Seve
CS A170
November 23, 2016

IC23
*/
public class PresidentialDonations {
    public static void analyzeData(String fileName) {
        double min = Double.MAX_VALUE, max = Double.MIN_NORMAL, average = 0.0, sum = 0.0;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        try
        {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNextDouble()) {
                double donation = file.nextDouble();
                average++;
                sum += donation;
                if(min > donation) min = donation;
                if(max < donation) max = donation;
            }
            file.close();
            average = sum / average;
            System.out.println("\nAfter analzying the data found for " + Character.toUpperCase(fileName.charAt(0)) +fileName.substring(1, fileName.indexOf("2")) + " the following data was produced:"
                    + "\nLargest Donation: " + currency.format(max)
                    + "\nSmallest Donation: " + currency.format(min)
                    + "\nAverage Donation: " + currency.format(average));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File does not exist");
        }
    }
    public static void main(String[] args) {
        analyzeData("clinton2016donations.txt");
        analyzeData("trump2016donations.txt");
    }
}
