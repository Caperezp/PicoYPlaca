
package picoyplaca.model;

import java.util.Calendar;
import java.util.Random;
import picoyplaca.data.Input;

//Class in charge of porcesing the data and give a result
public class Search {
    
    //Recieve the input data and return the final result
    public String getResults(Input inputData){
        String result;//Variable used for delivering the final result
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputData.getPlaqueDate());//Transforming the Date variable into Calendar for a better use of time operations
        if (!verifyWeekend(cal))//Veirfy if the current date corresponds to a weekend day
            return "Your vehicle can circulate";
        if (!verifyHour(cal))//Verify if the current time entered corresponds to a free time pico y placa
            return "Your vehicle can circulate";
        result = checkAviability(getLastNumber(),cal.get(Calendar.DAY_OF_WEEK));//Confirms if the vehicle can circulate given the last number and day of the week
        return result;//Returns the final result
    }
    
    //Generates and return a random number
    public int getLastNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10);
    }
    //Metohd used to check if the given date corresponds to a weekend day
    public boolean verifyWeekend(Calendar calendar){
        if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1)
           return false;
        return true;
    }
    //Metohd used to check if the given time corresponds to a free time pico y placa
    public boolean verifyHour(Calendar calendar){
        //Setting the limit of hours for the pico y placa free time
        Calendar begin = Calendar.getInstance();
        begin.set(Calendar.HOUR_OF_DAY, 9);
        begin.set(Calendar.MINUTE, 30);
        Calendar end = Calendar.getInstance();
        end.set(Calendar.HOUR_OF_DAY, 16);
        end.set(Calendar.MINUTE, 0);
        Calendar lastHour = Calendar.getInstance();
        lastHour.set(Calendar.HOUR_OF_DAY, 19);
        lastHour.set(Calendar.MINUTE, 30);
        //checks if the corresponding hour matches a free time pico y placa
        if (calendar.get(Calendar.HOUR_OF_DAY) < 7 || (calendar.compareTo(begin) >= 0 && calendar.compareTo(end) <= 0) || calendar.compareTo(lastHour) > 0)
                return false;
        return true;
    }
    
    //Given a numver and day of the week, it checks if the vehicle can circulate or not
    public String checkAviability(int lastNumber, int dayOfWeek){
        String result = "Your vehicule may circulate"; //Default result
        //Compares the day of the week with the two numbers that aren't allowed to circulate
        switch (dayOfWeek){
            case 2 :
                if(lastNumber == 1 || lastNumber ==2)
                    result = "Your vehicule may not circulate";
                break;
            case 3 :
                if(lastNumber == 3 || lastNumber ==4)
                     result = "Your vehicule may not circulate";
                break;
            case 4 :
                if(lastNumber == 5 || lastNumber ==6)
                     result = "Your vehicule may not circulate";
                break;
            case 5 :
                if(lastNumber == 7 || lastNumber ==8)
                     result = "Your vehicule may not circulate";
                break;     
            case 6 :
                if(lastNumber == 9 || lastNumber ==0)
                     result = "Your vehicule may not circulate";
                break;      
        }
        return result;
    }
    
}
