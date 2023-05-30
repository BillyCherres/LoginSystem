import java.util.Scanner;
public class Student extends User{

    public Student (String Username, int Password){
        set_username(Username);
        set_password(Password);
    }

   /// verify function that checks attributes of Student
    public static void verify(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Username: ");
        String tempName = scanner.nextLine();
        System.out.println("Please enter Password: ");
        int tempPass = scanner.nextInt();
        
        for (User u: User.admins){
        if (tempName.equals(u.get_username()) && tempPass == u.get_password()){
            System.out.println("Verification Success");
            // sets verify to true
            u.set_verify(true);
            return;
        }
    }
        System.out.println("Your Username or Password was inccorrect");
    }




}
