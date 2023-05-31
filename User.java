// Parent Class
import java.util.LinkedList;
import java.util.Scanner;

public abstract class User{// abstract so an object cant be made for this class
    private String _Username;
    private int _Password;
    private boolean _Verify = false;
    private int Id;// this is specific to the teacher only
    private String Phone;// this is specific to the parent only

    // list that holds all of the accounts
    public static LinkedList<User> admins;

    // constructor
    public User (){

    }

    // getters and setters
    public void set_username(String username){
        _Username = username;
    }

    public void set_password(int password){
        _Password = password;
    }

    public String get_username(){
        return _Username;
    }

    public int get_password(){
        return _Password;
    }

    public void set_verify(boolean verify){
        _Verify = verify;
    }

    public boolean get_verify(){
        return _Verify;
    }

    public void set_ID(int ID){
        Id = ID;
    }

    public int get_ID(){
        return Id;
    }

    public void set_phone(String phone){
        Phone = phone;
    }

    public String get_phone(){
        return Phone;
    }


    // Parent sign up func
    public static void ParentSignUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Username");
        String Pusername = scanner.nextLine();
        System.out.println("Enter your Password");       
        int Ppassword = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your Phone Number");
        String Phone = scanner.nextLine();
        Parent parent = new Parent(Pusername, Ppassword, Phone);
        User.admins.add(parent);

    
    }
    // Student Sign up Func
    public static void StudentSignUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Username");
        String Susername = scanner.nextLine();
        System.out.println("Enter your Password");       
        int Spassword = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(Susername, Spassword);
        User.admins.add(student);
    }

    // Teacher Sign Up func
    public static void TeacherSignUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Username");
        String Tusername = scanner.nextLine();
        System.out.println("Enter your Password");       
        int Tpassword = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your Teacher ID");       
        int TID = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = new Teacher(Tusername, Tpassword, TID);
        User.admins.add(teacher);
    }

    // Termination Function
    public static void Terminate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String Temp = scanner.nextLine();
        for(User u: User.admins){
            if (Temp.equals(u.get_username()) && u.get_verify()){
                User.admins.remove(u);
                System.out.println(u.get_username() + "'s account is successfully terminated");
                return;
            }
        }
        System.out.println("Error: Either your Username is incorrect or your not logged into the account");
}
// Change Username Function
public static void ChangeName(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your username");
    String Temp = scanner.nextLine();
    for(User u: User.admins){
        if (Temp.equals(u.get_username()) && u.get_verify()){
            System.out.println("Please enter your new Username");
            String newName = scanner.nextLine();
            System.out.println("Please re-enter your new Username");
            String TempnewName = scanner.nextLine();
            
            if(newName.equals(TempnewName)){
                u.set_username(newName);
                u.set_verify(false);
                System.out.println("New Username is set. Please re-login to your account");
                return;
            }else{
                System.out.println("New Username does not match. Please re do your step 8");
                return;
            }

        }
        System.out.println("Error: Either your Username is incorrect or your not logged into the account");

    }

}
// Change Password Function
    public static void ChangePassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String Temp = scanner.nextLine();
        for(User u: User.admins){
            if (Temp.equals(u.get_username()) && u.get_verify()){
                System.out.println("Please enter your new password");
                int newPass = scanner.nextInt();
                System.out.println("Please re-enter your new password");
                int TempnewPass = scanner.nextInt();
                if(newPass != TempnewPass){
                    System.out.println("New Password does not match. Please re do your step 9");
                    return;
                }else{
                    u.set_password(newPass);
                    u.set_verify(false);
                    System.out.println("New Password is set. Please re-login to your account");
                    return;
                }

            }
            System.out.println("Error: Either your Username is incorrect or your not logged into the account");

        }

    }


    
}
