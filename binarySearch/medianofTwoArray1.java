http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
    
     
/* This function returns median of ar1[] and ar2[].
   Assumptions in this function:
   Both ar1[] and ar2[] are sorted arrays
   Both have n elements */
int getMedian(int ar1[], int ar2[], int n)
{
    int m1; /* For median of ar1 */
    int m2; /* For median of ar2 */
 
    /* return -1  for invalid input */
    if (n <= 0)
        return -1;
 
    if (n == 1)
        return (ar1[0] + ar2[0])/2;
 
    if (n == 2)
        return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
 
    m1 = median(ar1, n); /* get the median of the first array */
    m2 = median(ar2, n); /* get the median of the second array */
 
    /* If medians are equal then return either m1 or m2 */
    if (m1 == m2)
        return m1;
 
     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
    if (m1 < m2)
    {
        if (n % 2 == 0)
            return getMedian(ar1 + n/2 - 1, ar2, n - n/2 +1);
        else
            return getMedian(ar1 + n/2, ar2, n - n/2);
    }
 
    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
    else
    {
        if (n % 2 == 0)
            return getMedian(ar2 + n/2 - 1, ar1, n - n/2 + 1);
        else
            return getMedian(ar2 + n/2, ar1, n - n/2);
    }
}
 
/* Function to get median of a sorted array */
int median(int arr[], int n)
{
    if (n%2 == 0)
        return (arr[n/2] + arr[n/2-1])/2;
    else
        return arr[n/2];
}
 
/* Driver program to test above function */
int main()
{
    int ar1[] = {1, 2, 3, 6};
    int ar2[] = {4, 6, 8, 10};
    int n1 = sizeof(ar1)/sizeof(ar1[0]);
    int n2 = sizeof(ar2)/sizeof(ar2[0]);
    if (n1 == n2)
      printf("Median is %d", getMedian(ar1, ar2, n1));
    else
     printf("Doesn't work for arrays of unequal size");
 
    getchar();
    return 0;
}
 
/* Utility functions */
int max(int x, int y)
{
    return x > y? x : y;
}


 
int min(int x, int y)
{
    return x > y? y : x;
}

//test
 1 3 7 8
 2 4 5 6
 
 
 import java.lang.Math;

public class findMedian
{
	private static double getMedian(int [] a, int start, int n)
	{
		return (n%2!=0)? (double)a[start+n/2]:(double)(a[start+n/2-1]+a[start+n/2])/2;
	}

	private static double findMedianHelper(int [] A, int [] B, int startA, int startB, int n)
	{
		if(n==1)
			return (double)(A[startA]+B[startB])/2;
		if(n==2)
			return (double)(Math.max(A[startA],B[startB])+Math.min(A[startA+1],B[startB+1]))/2;

		//else
		//{
			double midA=getMedian(A, startA, n);
			double midB=getMedian(B, startB, n);
			System.out.println(midA+" "+midB);
			if(midA==midB)
				return midA;
			if(midA<midB)  //get right part of A, left part of B
			{
				if(n%2==1)
					return findMedianHelper(A, B, startA+n/2, startB, n-n/2); // the subarray will include medA, [midA-endA], [startB-midB]
				else
					return findMedianHelper(A, B, startA+n/2-1, startB, n-n/2+1); //the subarray will include medA2 (midA1<=midA<=midA2) [midA2-endA], [startB-midB]
			}
			else
			{
				if(n%2==1)
					return findMedianHelper(A, B, startA, startB+n/2, n-n/2);
				else
					return findMedianHelper(A, B, startA, startB+n/2-1, n-n/2+1);
			}

		//}
	}


	public static  double findMedianinArray(int [] A, int [] B, int n)
	{
		return findMedianHelper(A, B, 0, 0, n);
	}

	public static void main(String[] argv )
	{
		int [] A = new int []{1,3,7,8};
		int [] B = new int []{2,4,5,6};

		double mid = findMedianinArray(A, B, 4);
		System.out.println(mid);


	}
}
 
 
 
 
