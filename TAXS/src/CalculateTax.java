public class CalculateTax extends Tax implements Tax_Percentage{
    protected double TAX;

    public void no_Tax(double money, double bonuns, Object Status, double Net_income){
    if (Status.equals("Spouse has income(filing separately)") || Status.equals("Spouse has no income")) {
        if (money <= 18333 && bonuns <= 10000){
            TAX = 0.0;
        }else{
            TAX = ladder_Tax(Net_income);
        }
    }else{
        if(money <= 10000 && bonuns <= 5000){
            TAX = 0.0;
        }
        else{
            TAX = ladder_Tax(Net_income);
        }
        }
    }
    
    @Override
    public double ladder_Tax(double money){
        if(money <= 150000){
            return 0;
        }
        else if(money >= 1500001 && money <= 300000){
            return 5;
        }else if(money >= 300001 && money <= 500000){
            return 10;
        }else if(money >= 500001 && money <= 750000){
            return 15;
        }else if(money >= 750001 && money <= 1000000){
            return 20;
        }
        else if(money >= 1000001 && money <= 2000000){
            return 25;
        }else if(money >= 2000001 && money <= 5000000){
            return 30;
        }else{
            return 35;
        }
    }
}