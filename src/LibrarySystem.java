import java.util.Scanner ;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Date_Time{
    public static void date_time(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd:MM:yyyy \n HH:mm:ss");
        String FormattedDateTime = dtf.format(ldt);
        System.out.println(FormattedDateTime +"\n"+ "Welcome to Library");
        //System.out.println(ldt);

    }
}

class Entry{
    public static void entry(){
        System.out.println("choice \n 1. Daily Learner \n 2. Librarian \n 3. Guest ");
        System.out.println("enter choice, who are you ? ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt() ;
        switch(choice){
            case 1 :
                Daily_Learner obj1 = new Daily_Learner();
                obj1.daily_learner();
                break;
            case 2 :
                Librarian obj2 = new Librarian();
                obj2.librarian();
                break ;
            case 3 :
                Guest obj3 = new Guest();
                obj3.guest();
                break ;
            default  :
                System.out.println("check your choice");
        }
    }
}

class Daily_Learner{
    public static void daily_learner(){
        System.out.println("1. sign up 2. log in");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                Sign_Up obj6 = new Sign_Up();
                obj6.sign_up();
                break;
            case 2 :
                Log_In obj7 = new Log_In();
                obj7.log_in();
                break;
            default:
                System.out.println("invalid choice");
        }

    }
//    public static void ascess_permission(){
//
//    }
}

class Librarian{

    public static void librarian(){
        System.out.println("1. sign up \n 2. log in \n 3. add book \n 4. check query");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                Sign_Up obj1 = new Sign_Up();
                obj1.sign_up();
                break;
            case 2 :
                Log_In obj2 = new Log_In();
                obj2.log_in();
                break;
            case 3:
                Add_Book obj3 = new Add_Book();
                obj3.add_book();
                break;
            case 4 :
                Check_Query obj4 = new Check_Query();
                obj4.check_query();
                break;
            default:
                System.out.println("invalid choice");
        }
    }

}

class Guest{
    public static void guest(){
        System.out.println("1. search book \n 2. raise query \n 3. sign up");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                Search_Book obj1 = new Search_Book();
                obj1.search_book();
                break;
            case 2 :
                Raise_Query obj4 = new Raise_Query();
                obj4.raise_query();
                break;
            case 3 :
                Sign_Up obj6 = new Sign_Up();
                obj6.sign_up();
                break;
            default :
                System.out.println("invalid choice");
        }

    }

}

class Sign_Up{
    public static void sign_up(){
        System.out.println("create account ");
        System.out.println("enter email id");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        // regex with all conditions
        String emailRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z0-9@#$!%*?&+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(emailRegex)) {
            System.out.println(" Valid email id ");
            // if email id is valid then, ask for password
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            // Password regex with conditions (min 6 chars just as example)
            String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z\\d@#$!%*?&]{8,}$";

            if (password.matches(passRegex)) {
                System.out.println("Account created successfully!");
                //ask for search book or borrow book or submit book or raise query
                System.out.println(" 1. search bok \n 2. borrow book \n 3. submit book \n 4. raise query \n 5. exit");
                int choice = sc.nextInt();
                switch(choice){
                    case 1 :
                        Search_Book obj1 = new Search_Book();
                        obj1.search_book();
                        break;
                    case 2 :
                        Borrow_Book obj2 = new Borrow_Book();
                        obj2.borrow_book();
                        break;
                    case 3 :
                        Submit_Book obj3 = new Submit_Book();
                        obj3.submit_book();
                        break;
                    case 4 :
                        Raise_Query obj4 = new Raise_Query();
                        obj4.raise_query();
                        break;
                    case 5 :
                        System.out.println("exit");
                        break ;
                    default :
                        System.out.println("invalid choice");

                }

            }
            else {
                System.out.println(" Invalid password. Must contain at least one uppercase, lowercase, digit," +
                        " and special char(@ # $ ! % * ? & + _ . -).");
            }
        }
        else {
            System.out.println(" Invalid email id. Must contain uppercase, lowercase, digit, " +
                    "special char(@ # $ ! % * ? & + _ . -), and be in proper email format.");
        }
    }
}


class Log_In{
    public static void log_in(){

        // ask for password, if password also got matched from the database
        // ask for choice
        System.out.println("enter valid email id");
        //ask for email id, and find it from the database
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        // regex with all conditions
        String emailRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z0-9@#$!%*?&+_.-]+@[A-Za-z0-9.-]+$";
        if (email.matches(emailRegex)) {
            //search the given email in the database, if got matched then ask for password
            System.out.println(" email id found");

            // ask for password
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            // Password regex with conditions (min 6 chars just as example)
            String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z\\d@#$!%*?&]{8,}$";

            if (password.matches(passRegex)) {//search the password in the database to login
                System.out.println("log in successful !");
                //if password got matched then, ask for choices
                System.out.println("1. search bok \n 2. borrow book \n 3. submit book \n 4. raise query \n 5. exit");
                int choice = sc.nextInt();
                switch(choice){
                    case 1 :
                        Search_Book obj1 = new Search_Book();
                        obj1.search_book();
                        break;
                    case 2 :
                        Borrow_Book obj2 = new Borrow_Book();
                        obj2.borrow_book();
                        break;
                    case 3 :
                        Submit_Book obj3 = new Submit_Book();
                        obj3.submit_book();
                        break;
                    case 4 :
                        Raise_Query obj4 = new Raise_Query();
                        obj4.raise_query();
                        break;
                    case 5 :
                        System.out.println("exit");
                        break ;
                    default :
                        System.out.println("invalid choice");

                }

            }
            else {
                System.out.println(" Invalid password. Must contain at least one uppercase, lowercase, digit," +
                        " and special char(@ # $ ! % * ? & + _ . -).");
            }
        }
        else {
            System.out.println(" Invalid email id. Must contain uppercase, lowercase, digit, " +
                    "special char(@ # $ ! % * ? & + _ . -), and be in proper email format.");
        }
    }

}

class Search_Book{
    public static boolean search_book(){
        System.out.println("enter book name");
        Scanner sc = new Scanner(System.in);
        String book = sc.nextLine();
        String[] Books = {"Whispers of the Wind",
                            "The Last Horizon",
                            "Echoes of Eternity",
                            "Shadows Beneath the Moon",
                            "Crimson Skies",
                            "The Forgotten Kingdom",
                            "Silent Footsteps",
                            "A Thousand Suns",
                            "The Glass Tower",
                            "Storms of Destiny"};
        boolean found = false;
        for(int i=0 ; i<Books.length ; i++){
            if(Books[i].equals(book)){
                found = true;
                //search the book in the database, if got matched return true
                break;
            }
        }
        if(found){
            System.out.println(STR."\{book} found");
            return true;
        }
        else{
            System.out.println(STR."\{book} not found");
            return false;
        }

        //return false;
    }
}

class Borrow_Book{
    public static void borrow_book(){
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter book name");
//        String book = sc.nextLine();
        Search_Book obj = new Search_Book();
        boolean foundBook =  obj.search_book();
        if(foundBook){
            System.out.println("enter date to return");
            String return_date = sc.nextLine();
            String bookId = sc.nextLine();
            //this bookId and the return_date will be added to that emilId
        }
        else{
            System.out.println("Sorry! can't lend ");
        }

    }
}

class Submit_Book{
    public static void submit_book(){
        Scanner sc = new Scanner(System.in);
        System.out.println("book id");
        String bookId = sc.nextLine();
        System.out.println("book name");
        String book = sc.nextLine();
        System.out.println("author name");
        String author = sc.nextLine();

    }
}

class Raise_Query{
    public static void raise_query(){
        Scanner sc = new Scanner(System.in);
        System.out.println("how can I help you");
        String query = sc.nextLine();
    }
}

class Add_Book{
    public static void add_book(){
        System.out.println("enter valid email id to log in");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        // regex with all conditions
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z0-9@#$!%*?&+_.-]+@[A-Za-z0-9.-]+$";
        if (email.matches(regex)) {//search the given email in the database, if got matched then ask for password
            System.out.println(" email id found");

            // ask for password
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            // Password regex with conditions (min 6 chars just as example)
            String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%*?&])[A-Za-z\\d@#$!%*?&]{8,}$";

            if (password.matches(passRegex)) {//search the password in the database, if got matched from the database,
                //then ask for further choices
                System.out.println("log in successful !");
                System.out.println("enter book name");
                String bookName = sc.nextLine();
                System.out.println("enter author name");
                String authorName = sc.nextLine();
                System.out.println("enter book id");
                String bookId = sc.nextLine();
            }
            else {
                System.out.println(" Invalid password. Must contain at least one uppercase, lowercase, digit," +
                        " and special char(@ # $ ! % * ? & + _ . -).");
            }
        }
        else {
            System.out.println(" Invalid email id. Must contain uppercase, lowercase, digit, " +
                    "special char(@ # $ ! % * ? & + _ . -), and be in proper email format.");
        }
    }
}

class Check_Query{
    public static void check_query(){
        Raise_Query obj = new Raise_Query();
        obj.raise_query();
    }
}

public class LibrarySystem{
    public static void main(String[] args) {

        Date_Time obj1 = new Date_Time();
        obj1.date_time();

        Entry obj2 = new Entry();
        obj2.entry();

    }
}