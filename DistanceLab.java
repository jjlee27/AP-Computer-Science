/**
* APCS Lab2: Simple Distance and Fuel Usage Lab.
* author: Jason Lee
* date: 10/28/24
*/

//import the scanner class
import java.util.Scanner;

public class DistanceLab {
    // main method goes here
    public static void main(String[] args) {

        // declare the scanner
        Scanner scan = new Scanner(System.in);

        // declare variable speed
        double speedMPH;
        // use a do while loop to check if the input is negative
        do {
            System.out.print("Enter the speed of the vehicle in mph: ");
            speedMPH = scan.nextDouble();
            // if speed is negative or equal to 0, ask to input again
            if (speedMPH <= 0) {
                System.out.println("speed must be greater than zero");
            }
        } while (speedMPH <= 0);

        // declare variable hours
        int hours;
        // use a do while loop to check if the number is negative
        do {
            System.out.print("Enter the number of hours traveled: ");
            hours = scan.nextInt();
            // if hours is negative or equal to 0, ask to input again
            if (hours <= 0) {
                System.out.println("time must be greater than zero");
            }
        } while (hours <= 0);

        // declare variable mpg
        double mpg;
        // use a do while loop to check if the input is negative
        do {
            System.out.print("Enter the miles-per-gallon: ");
            mpg = scan.nextDouble();
            // if mpg is negative or equal to 0, ask to input again
            if (mpg <= 0) {
                System.out.println("mpg must be greater than zero");
            }
        } while (mpg <= 0);

        // Close the scanner
        scan.close();

        // run the showTravelStats method
        showTravelStats(hours, speedMPH, mpg);
    }

    // write a comment describing the method below
    /**
     * The method below will take three inputs
     * input of hours, speed in mph, and miles per gallon
     * the method will then calculate the distance traveled by the vehicle and the
     * fuel consumed
     * this method uses a for loop to print the distance and fuel consumed every
     * hour
     * this is done by multiplying the hour and the speed in mph
     * afterwards, it will calculate the fuel consumed
     * this is done by dividing the distance by the mpg of the vehicle
     * Last but not least, it uses a formatted print output
     * it shows how many decimal digits each value should have and spaces it out
     * properly
     */
    public static void showTravelStats(int hours, double speedMPH, double mpg) {

        // print out to format the chart
        System.out.println("-------------------------------------------");
        System.out.printf("%-9s%-21s%-13s%n", "Hours", "Distance-Traveled", "Fuel-Consumed");
        System.out.printf("%-9s%-21s%-13s%n", "", "(miles)", "(gallons)");
        System.out.println("-------------------------------------------");

        // uses for loop to print the information for every hour
        for (int hour = 1; hour <= hours; hour++) {
            // calculate distance hour and speed
            double distance = hour * speedMPH;
            // calculate fuelConsumed
            double fuelConsumed = distance / mpg;

            // return (hour,distance,fuelConsumed) using formatted print output
            System.out.printf("%-9d%-21.1f%.2f%n", hour, distance, fuelConsumed);
        }

    }
}