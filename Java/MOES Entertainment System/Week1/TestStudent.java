public class TestStudent {
    public static void main(String[] args){
        //FIRST TEST
                try{
                    Account account = new Account();
                    Student student = new Student("Dak Prescott", 4, "dak@mavs.uta.edu", account);
                    Account account2 = new Account();
                    Student staff = new Student("Mike McCarthy", 350, "coachmike@uta.edu", account2);

                    String expectedStudent = "Dak Prescott (4, dak@mavs.uta.edu, " + account.getAccountNumber() + ")";
                    String expectedStaff = "Mike McCarthy (350, coachmike@uta.edu, " + account2.getAccountNumber() + ")";
                    String actualStudent = student.toString();
                    String actualStaff = staff.toString();

                    if(expectedStaff.equals(actualStaff)){
                    }
                    else {
                        System.out.println("Staff is not correct");
                        System.out.println("Expected: " + expectedStaff);
                        System.out.println("Actual: " + actualStaff);
                    }

                    if(expectedStudent.equals(actualStudent)){
                    }
                    else {
                        System.out.println("Student is not correct");
                        System.out.println("Expected: " + expectedStudent);
                        System.out.println("Actual: " + actualStudent);
                        
                    } 
                }catch (Exception x) {
                        System.out.println("FAIL");

        //SECOND TEST
        Account account3 = new Account();
            try{
                new Student("Donovan Wilson", 6, "donovanwilson@offensiveplayer.com", account3);
                System.out.println("Fail"); //no exception
                System.out.println("Exception not thrown");
                } catch(IllegalArgumentException ex){
                if(!ex.getMessage().startsWith("Non-UTA email: ")){
                    System.out.println("UNEXPECTED ILLEGAL ARGUMENT!");
                }
                }  catch(Exception b){
                    System.out.printf("OTHER EXCEPTION DETECTED");
                }
            }
            //THIRD TEST
    }
    }
