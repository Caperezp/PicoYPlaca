

package picoyplaca.data;

import java.util.Date;

//Class used to save the data entered by the user
public class Input {
    
    private int plaqueNumber;//Corresponds to the plaque number 
    private Date plaqueDate;// Full date and time entered by the user
    
    public Input(){
        
    }

    public int getPlaqueNumber() {
        return plaqueNumber;
    }

    public void setPlaqueNumber(int plaqueNumber) {
        this.plaqueNumber = plaqueNumber;
    }

    public Date getPlaqueDate() {
        return plaqueDate;
    }

    public void setPlaqueDate(Date plaqueDate) {
        this.plaqueDate = plaqueDate;
    }
    
    
}
