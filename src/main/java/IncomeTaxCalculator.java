import java.util.Date;
import java.util.List;

public class IncomeTaxCalculator {

    public double calculateTax(int income, Date dateOfBirth)
    {
        return Math.round(income * getTaxPercentage(income, dateOfBirth) / 100);
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

    private double getTaxPercentage(int income, Date dateOfBirth){
        boolean old = AOW((dateOfBirth));

        if (income == 0){
            return 0.00;
        }
        else if (income <= 20142)
        {
            if(old){
                return 18.65;
            }
            return 36.55;
        }
        else if(income >= 20143 && income <= 34404 && old){
            return 22.95;
        }
        else if(income >= 33405 && income <= 68507 && old){
            return 40.85;
        }
        else if (income >= 20143 && income <= 68507)
        {
            return 40.85;
        }
        else {
            return 51.95;
        }
    }
}
