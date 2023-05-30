import java.util.Scanner;
public class Parent extends User {
    // custom constructor 
    public Parent (String Username, int Password, String Phone){
        set_username(Username);
        set_password(Password);
        set_phone(Phone);
    }

   // verify function that checks attributes specific to parent
    public static void verify(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Username: ");
        String tempName = scanner.nextLine();
        System.out.println("Please enter Password: ");
        int tempPass = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter Phone Number");
        String tempPhone = scanner.nextLine();
 
        for (User u: User.admins){
        if (tempName.equals(u.get_username()) && tempPass == u.get_password() && tempPhone.equals(u.get_phone())){
            System.out.println("Verification Success");
            // sets verify to true
            u.set_verify(true);
            return;
        }
    }
        System.out.println("Your Username, Password, or Phone Number was inccorrect");
    }


    


}
