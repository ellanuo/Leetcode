public class Solution {
    public double pow(double x, int n) {
        if(n==0)
            return 1.0;
        if(n==1)
            return x;
        if(n==2)
            return x*x;
        if(n<0)
            return 1.0/(x*pow(x, -n-1));   //if n=Integer.MIN_VALUE; -n will be larger than Integer.MAX_VALUE
        
        if(n%2==0)
            return pow(pow(x, n/2),2);
        else
            return x*pow(x,n-1);
        
        
    }
}
