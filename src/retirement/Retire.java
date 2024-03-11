//Formula calculated by https://www.finnomena.com/planet46/beat-inflation-in-retirement/
package retirement;

public class Retire {
    private int age = 0;
    private int retireAge = 0;
    private double expen = 0;
    private int dieAge = 0;
    private double inflation = 0;
    private double begin = 0;
    
   
    public Retire(){
        this(0, 0, 0, 0, 0, 0);
    }
    
    public Retire(int age, int retireAge, double expen, int dieAge, double inflation, double begin){
        setAge(age);
        setRetireAge(retireAge);
        setExpen(expen);
        setDieAge(dieAge);
        setInflation(inflation);
        setBegin(begin);
    }
    
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setRetireAge(int retireAge){
        this.retireAge = retireAge;
    }
    
    public int getRetireAge(){
        return retireAge;
    }
    
    public void setExpen(double expen){
        this.expen = expen;
    }
    
    public double getExpen(){
        return expen;
    }
    
    public void setDieAge(int dieAge){
        this.dieAge = dieAge;
    }
    
    public int getDieAge(){
        return dieAge;
    }
    
    public void setInflation(double inflation){
        this.inflation = inflation;
    }
    
    public double getInflation(){
        return (double)(inflation/100);
    }
    
    public void setBegin(double begin){
        this.begin = begin;
    }
    
    public double getBegin(){
        return begin;
    }
    
    public double  calculateAll(){
       double adjustMoney = (((getDieAge()-getRetireAge())*12)*getExpen())*(Math.pow((1+getInflation()), getRetireAge()-getAge()));
        return  adjustMoney;
    }
    
    public double calculatePerMonth(){
        return (calculateAll()-getBegin())/((getRetireAge()-getAge())*12);
    }
    
}
