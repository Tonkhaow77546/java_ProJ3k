public class CalculateTax extends Tax{
    protected double TAX;

    public void no_Tax(double money, double bonuns, Object Status){
      if (Status.equals("Spouse has income(filing separately)") || Status.equals("Spouse has no income")) {
            if (money <= 18333 && bonuns <= 10000){
                TAX = 0.0;
            }else{
                TAX = ladder_Tax(money, bonuns);
            }
        }else{
            if(money <= 10000 && bonuns <= 5000){
                TAX = 0.0;
            }
            else{
                TAX = ladder_Tax(money, bonuns);
            }
        }
    }

    public double ladder_Tax(double money, double bonuns){
        money *= 12 + bonuns;
        if(money >= 1500001 && money <= 300000){
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
