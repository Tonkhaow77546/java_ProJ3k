package TimeValue;

public abstract class DataInput {
    private double presentVal, futureVal;
    private double reward;
    private int time;
    
    public void setPresentVal(double presentVal){
        this.presentVal = presentVal;
    }
    
    public double getPresenVAl(){
        return presentVal;
    }
    
    public void setReward(double reward){
        this.reward = reward;
    }
    
    public double getReward(){
        return reward/100;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public int getTime(){
        return time;
    }
    
    public abstract long calculate();
    
    public void setFutureVal(double futureVal){
        this.futureVal = futureVal;
    }
    
    public double getFutureVal(){
        return futureVal;
    }
}
