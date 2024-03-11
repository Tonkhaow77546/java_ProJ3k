//Formula calculated by https://www.set.or.th/th/education-research/education/happymoney/glossary/time-value-of-money?lang=th

package TimeValue.FutureValueHead;

import TimeValue.DataInput;

public class FutureValue extends DataInput{
    @Override
    public long calculate(){
        return (long) (getPresenVAl()*(Math.pow((1+getReward()), getTime())));
    }
}
