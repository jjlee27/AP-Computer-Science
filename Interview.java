/**
* AP Computer Science Lab 1
* Program to interview anyone using this program,
* store the responses, and then summarize the answers.
* author: Jason Lee
* date: 10/5/24
*/

// import the Scanner class
import java.util.Scanner;

public class Interview{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //initialize birthyear at start: value not important because it will be redefined
        int birthYear = 0;
        
        //clears screen for start of interview
        clearScreen();

        //information about first & last name
        System.out.print("What is your first name?:");
        String firstName = scan.nextLine();
        System.out.println();
        System.out.print("What is your last name?:");
        String lastName = scan.nextLine();
        System.out.println();

        // asks if they have a preffered name or not
        System.out.print("Do you have a preferred nickname? (type yes or no):");
        String nicknameTF = scan.nextLine();
        // defines nickname and contains statement that will print if not inputted yes or no
        String nickname = "you didn't follow the instructions. You should've typed yes or no when asked about your nickname";

        System.out.println();

        //if they do, ask for nickname
        if(nicknameTF.equals("yes")|| nicknameTF.equals("Yes")){
            System.out.print("What is your nickname?:");
            nickname = scan.nextLine();
            System.out.println();
       }
       //if replied no to previous prompt, does not redefine nickname


        //information on age
        System.out.print("How old are you?:");
        int age = scan.nextInt();
        System.out.println();


        //clear the hanging newline
        scan.nextLine();
        //information on birthday

        //asks for day of birth
        System.out.print("What day were you born on?:");
        String birthDay = scan.nextLine();
        System.out.println();

        //asks for day of month
        System.out.print("What month were you born on?:");
        String birthMonth = scan.nextLine();
        System.out.println();

        //asks for year (yes or no question)
        System.out.print("Have you had your birthday this year? (type yes or no):");
        String hadBirthday = scan.nextLine();
        // if yes, subtract age from year
        if(hadBirthday.equals("yes")|| hadBirthday.equals("Yes")){
            birthYear = 2024 - age;
            System.out.println();
        }
        //if not, subtract one more
        else{
            birthYear = 2024 - age - 1;
            System.out.println();
        }
    

        //information on birthplace

        //town/city
        System.out.print("What town/city were you born in?:");
        String birthCity = scan.nextLine();
        System.out.println();

        //country
        System.out.print("What country were you born in?:");
        String birthCountry = scan.nextLine();
        System.out.println();


        //current residence
        //town or city
        System.out.print("What town or city do you live in?:");
        String currentTown = scan.nextLine();
        System.out.println();
        //state
        System.out.print("What state do you live in?:");
        String currentState = scan.nextLine();
        System.out.println();

        //favorite hobby
        System.out.println("What is your favorite hobby?");
        System.out.print("(Ex. biking, reading, sleeping):");
        String hobby = scan.nextLine();
        System.out.println();

        //clears screen
        clearScreen();

        //checks if they have a nickname or not)
        //if responded yes to preferred nickname, print out nickname
        if(nicknameTF.equals("yes")|| nicknameTF.equals("Yes")){
            System.out.println("Hello " + nickname + "!");
        }
        //else, print their first and last name
        else{
            System.out.println("Hello " + firstName + " " + lastName + "!");
        }
        //prints out the stored information in sentence form
        System.out.println("You are " + age + " years old");
        System.out.println("You were born on " + birthMonth + " " + birthDay + ", " + birthYear);
        System.out.println("You were born in " + birthCity + ", " + birthCountry);
        System.out.println("You currently live in " + currentTown + ", " + currentState);
        System.out.println("You enjoy " + hobby);

        //Thank you!
        System.out.println("Thank you for this Interview!");
        scan.close();
    }


// the method below clears the command line
// and can be called from the main method
// simply by adding the line of code
// clearScreen();
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}