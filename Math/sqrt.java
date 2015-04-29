//binary search
//pay attention to integer overflow. check only mid<x/mid;
//not mid*mid<x;


public class Solution {
    public int mySqrt(int x) {
        if(x<0)
            return -1;
        if(x==0)
            return 0;
        if(x==1)
            return 1;
        int lo=1; int hi=x;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(mid==x/mid)
                return mid;
            else if(mid<x/mid)
                lo=mid+1;
            else
                hi=mid-1;
        }
        
        return hi;
        
    }
}


public class Solution {
    public int mySqrt(int x) {
        if(x<0)
            return -1;
        if(x==0)
            return 0;
        if(x==1)
            return 1;
        int lo=1; int hi=x;
        while(lo+1<hi)
        {
            int mid=(lo+hi)/2;
            if(mid<x/mid)
                lo=mid;
            else
                hi=mid;
        }
        //if(lo<x/lo && hi>x/hi)
        if(hi==x/hi)
            return hi;
        else
            return lo;
        
    }
}
