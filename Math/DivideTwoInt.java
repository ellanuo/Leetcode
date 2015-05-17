//Divide two integers without using multiplication, division and mod operator.

//If it is overflow, return MAX_INT.


public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;
        if(divisor==0)
            return Integer.MAX_VALUE;
            
        long result=divideLong(dividend, divisor);
        return result>Integer.MAX_VALUE? Integer.MAX_VALUE:(int)result;
    }
    private long divideLong(long dividend,  long divisor)
    {
        boolean negative = dividend<0 != divisor<0; 
        long p=Math.abs(dividend);
        long q=Math.abs(divisor);
        if(p<q)
            return 0;
        long div=1;
        long sum=q;
        
        while(p>=(sum+sum))
        {
            sum+=sum; 
            div+=div;
        }
        
        return negative? -(div+divideLong(p-sum,q)):(div+divideLong(p-sum, q));
    }
}


public int divide(int dividend, int divisor) {
    long result = divideLong(dividend, divisor);
    return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
}

// It's easy to handle edge cases when
// operate with long numbers rather than int
public long divideLong(long dividend, long divisor) {

    // Remember the sign
    boolean negative = dividend < 0 != divisor < 0;

    // Make dividend and divisor unsign
    if (dividend < 0) dividend = -dividend;
    if (divisor < 0) divisor = -divisor;

    // Return if nothing to divide
    if (dividend < divisor) return 0;

    // Sum divisor 2, 4, 8, 16, 32 .... times
    long sum = divisor;
    long divide = 1;
    while ((sum+sum) <= dividend) {
        sum += sum;
        divide += divide;
    }

    // Make a recursive call for (devided-sum) and add it to the result
    return negative ? -(divide + divideLong((dividend-sum), divisor)) :
        (divide + divideLong((dividend-sum), divisor));
}


//int的绝对值，int里面有一个特殊的数字：-2147483648，
//它的绝对值或者相反数 2147483648是超出int的范围的，对于这一情况需要特殊处理。
//所以不能直接调用 divide(-dividend, divisor)或者divide(dividend, – divisor)。也不能写 int dv = abs(dividend)。
//处理方式是使用long long来保存其绝对值


http://wp.javayu.me/2014/02/divide-two-integers/


