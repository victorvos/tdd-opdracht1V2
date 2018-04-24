import java.util.Date;
import java.util.List;

public class IncomeTaxCalculator {

    public double calculateTax(int inc, Date dateOfBirth)
    {
        return Math.round(inc * getTaxPercentage(inc, dateOfBirth) / 100);
    }

    private boolean AOW(Date dateOfBirth)
    {
        if (dateOfBirth.before(new Date("01/01/53")))
        {
            return true;
        }
        else{
            return false;
        }
    }

    private double getTaxPercentage(int inc, Date dateOfBirth){
        boolean old = AOW((dateOfBirth));

        if (inc == 0){
            return 0.00;
        }
        else if (inc <= 20142)
        {
            if(old){
                return 18.65;
            }
            return 36.55;
        }
        else if(inc >= 20143 && inc <= 34404 && old){
            return 22.95;
        }
        else if(inc >= 33405 && inc <= 68507 && old){
            return 40.85;
        }
        else if (inc >= 20143 && inc <= 68507)
        {
            return 40.85;
        }
        else {
            return 51.95;
        }
    }
}
