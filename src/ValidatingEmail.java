import java.util.Scanner;
public class ValidatingEmail {
	//static String regex = "^[a-zA-Z +]+$";
	static String regex="^\\w{5,29}$";
	static String reg="^\\d{10}$";
	static String uuid="^[A-Za-z]\\w{5,29}$";
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your Email: ");
      String phone = sc.next();
      sc.next();
      System.out.println("Enter your Phone : ");
      String ph = sc.next();
     
      System.out.println("Enter your UId : ");
      String uid = sc.next();
     // String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
      
      //Matching the given phone number with regular expression
       fun(phone);
       funph(ph);
       funuid(uid);
       
   }
     
   
	public static void fun(String phone)
       {
        boolean result = phone.matches(regex);
      if(result) {
         System.out.println("Given username is valid");
      } else {
         System.out.println("Given username is not valid");
      }
         
   }
	
	
	 public static void funph(String ph)
       {
        boolean result = ph.matches(reg);
      if(result) {
         System.out.println("Given phone  is valid");
      } else {
         System.out.println("Given phone is not valid");
      }
         
   }
	
	 public static void funuid(String uid)
     {
      boolean result = uid.matches(uuid);
    if(result) {
       System.out.println("Given uid  is valid");
    } else {
       System.out.println("Given uid is not valid");
    }
       
 }

	 

}