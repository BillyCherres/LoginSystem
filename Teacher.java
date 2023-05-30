import java.util.Scanner;

public class Teacher extends User{

    public Teacher (String Username, int Password, int ID){
        set_username(Username);
        set_password(Password);
        set_ID(ID);
    }
   
    public static void verify(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Username: ");
        String tempName = scanner.nextLine();
        System.out.println("Please enter Password: ");
        int tempPass = scanner.nextInt();
        System.out.println("Please enter Teacher ID ");
        int tempID = scanner.nextInt();
        
        for (User u: User.admins){
        if (tempName.equals(u.get_username()) && tempPass == u.get_password() && tempID == u.get_ID()){
            System.out.println("Verification Success");
            u.set_verify(true);
            return;
        }
    }
        System.out.println("Your Username, Password, or Teacher ID was inccorrect");
    }

}
