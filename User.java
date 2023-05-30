import java.util.LinkedList;
import java.util.Scanner;

public abstract class User{
    private String _Username;
    private int _Password;
    private boolean _Verify = false;
    private int Id;
    private String Phone;

    public static LinkedList<User> admins;

    public User (){
        set_username("Empty");
        set_password(0);
    }

    public User(String username, int password){
        set_username(username);
        set_password(password);
    }

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


    
}
