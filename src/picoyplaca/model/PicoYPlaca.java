
package picoyplaca.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import picoyplaca.data.Input;


public class PicoYPlaca {

    public static void main(String[] args) {
        int number;//Saves the plaque number
        Date inputDate;//Saves the date and time 
        
        //Getting the corresponding input data
        try (Scanner consoleInput = new Scanner(System.in)) {
            System.out.println("Enter your plaque number without the last number: ");
            number = consoleInput.nextInt();//Saving the plaque number
            if (!verifyNumber(number))//Verifing the correct format of the plaque number
                throw new NumberFormatException("Incorrect plaque number");
            System.out.println("Enter a date and time in the following format (dd/MM/yyyy): ");
            String date = consoleInput.next();//Saveing the date into a String
            System.out.println("Enter a time in the following format (HH:mm): ");
            String time = consoleInput.next();//Saveing the time into a String
            consoleInput.close();//close input
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");//Setting the format for date and time
            
            //Parsing the String into the Date variable
            inputDate = dateFormat.parse(date+"-"+time);
            //Saving all the input data from console into the Input class
            Input input = new Input();
            input.setPlaqueNumber(number);
            input.setPlaqueDate(inputDate);

            //Setting all parameter into the Search class and beggining the prediction process
            Search search = new Search();
            String result = search.getResults(input);
            System.out.println(result);//Prints out the final result
        }
            
            catch (ParseException e) {
                System.out.println("Incorrect date and time");
            }
            catch (InputMismatchException | NumberFormatException e){
                System.out.println("Incorrect plaque number");
            }
        }
        //Method used to verify the correct length of a plaque number
        public static boolean verifyNumber(int number){
        if(Integer.toString(number).length() < 2 || Integer.toString(number).length() > 3)
            return false;
        return true;
    }
        
    }
