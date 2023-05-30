// this program gives the user an option to sign up as a parent student or teacher
// To terminate any accounts (removing objects from an array list)
// and to show who is regsitered by printing the list


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        int n = 1;

        User.admins = new LinkedList<User>();

        while (n != 0){
            // menu
        System.out.println("-------------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Parent Sign up");
        System.out.println("2 - Student Sign up");
        System.out.println("3 - Teacher Sign up");
        System.out.println("4 - Show who is registered");
        System.out.println("5 - Login Teacher Account");
        System.out.println("6 - Login Student Account");
        System.out.println("7 - Login Parent Account");
        System.out.println("8 - Terminate Account");
        System.out.println("0 - Quit");
        // prompts user to choose from menu
        n = scanner.nextInt();
        // switch case which calls upon functions based off choice
        switch(n){
            //Parent Sign in/Sign up
            case 1:
            scanner.nextLine();
            Parent.ParentSignUp();
            break;

        //Student Sign in/ Sign up
            case 2:
            scanner.nextLine();
            Student.StudentSignUp();

            break;

            //Teacher Sign ip/ Sign up
            case 3:
            scanner.nextLine();
            Teacher.TeacherSignUp();
            break;

            //Show who is registered
            case 4:
            System.out.println("-------------------------\n");
            System.out.println("List of people registered");
            System.out.println("-------------------------\n");
            for(User u : User.admins){
                System.out.println(u.get_username());   
            }
            break;
            // Login Teacher Account
            case 5: 
            scanner.nextLine();
            Teacher.verify();
            break;
            // Login Student Account
            case 6:
            scanner.nextLine();
            Student.verify();
            break;
            //Login Parent account
            case 7:
            scanner.nextLine();
            Parent.verify();
            break;
            //Terminate Account
            case 8:
            scanner.nextLine();
            User.Terminate();
            break;

            default: 
            System.out.println("Please choose a number between 0 and 4 inclusive ");
        }

    }
       
    scanner.close();
    }
}  