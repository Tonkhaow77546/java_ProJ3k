//Formula calculated by https://www.set.or.th/th/education-research/education/happymoney/glossary/time-value-of-money?lang=th
package TimeValue.PresentValueHead;

import TimeValue.DataInput;

public class PresentValue extends DataInput{
    @Override
    public long calculate(){
        return (long) (getFutureVal()/(Math.pow((1+getReward()), getTime())));
    }
}
