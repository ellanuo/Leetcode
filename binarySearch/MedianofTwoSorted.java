public class Solution{
public static double findMedianSortedArrays(int A[], int B[]) {
	int m = A.length;
	int n = B.length;
 
	if ((m + n) % 2 != 0) // odd
		return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
	else { // even
		return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
			+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
	}
}
 
public static int findKth(int A[], int B[], int k, 
	int aStart, int aEnd, int bStart, int bEnd) {
 
	int aLen = aEnd - aStart + 1;
	int bLen = bEnd - bStart + 1;
 
	// Handle special cases
	if (aLen == 0)
		return B[bStart + k];
	if (bLen == 0)
		return A[aStart + k];
	if (k == 0)
		return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
 
	int aMid = aLen * k / (aLen + bLen); // a's middle count, not the real middle, according to length portion
	int bMid = k - aMid - 1; // b's middle count
 
	// make aMid and bMid to be array index
	aMid = aMid + aStart;
	bMid = bMid + bStart;

  //  int aMid= (aStart+aEnd)/2;
//    int bMid= (bStart+bEnd)/2;
	if (A[aMid] > B[bMid]) {
		k = k - (bMid - bStart + 1);
		aEnd = aMid;
		bStart = bMid + 1;
	} else {
		k = k - (aMid - aStart + 1);
		bEnd = bMid;
		aStart = aMid + 1;
	}
 
	return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
}

}

Base cases:
The smaller array has only one element
Case 1: N = 1, M = 1.
Case 2: N = 1, M is odd
Case 3: N = 1, M is even
The smaller array has only two elements
Case 4: N = 2, M = 2
Case 5: N = 2, M is odd
Case 6: N = 2, M is even

Case 1: There is only one element in both arrays, so output the average of A[0] and B[0].

Case 2: N = 1, M is odd
Let B[5] = {5, 10, 12, 15, 20}
First find the middle element of B[], which is 12 for above array. There are following 4 sub-cases.
…2.1 If A[0] is smaller than 10, the median is average of 10 and 12.
…2.2 If A[0] lies between 10 and 12, the median is average of A[0] and 12.
…2.3 If A[0] lies between 12 and 15, the median is average of 12 and A[0].
…2.4 If A[0] is greater than 15, the median is average of 12 and 15.
In all the sub-cases, we find that 12 is fixed. So, we need to find the median of B[ M / 2 – 1 ], B[ M / 2 + 1], A[ 0 ] and take its average with B[ M / 2 ].

Case 3: N = 1, M is even
Let B[4] = {5, 10, 12, 15}
First find the middle items in B[], which are 10 and 12 in above example. There are following 3 sub-cases.
…3.1 If A[0] is smaller than 10, the median is 10.
…3.2 If A[0] lies between 10 and 12, the median is A[0].
…3.3 If A[0] is greater than 10, the median is 12.
So, in this case, find the median of three elements B[ M / 2 – 1 ], B[ M / 2] and A[ 0 ].

Case 4: N = 2, M = 2
There are four elements in total. So we find the median of 4 elements.

Case 5: N = 2, M is odd
Let B[5] = {5, 10, 12, 15, 20}
The median is given by median of following three elements: B[M/2], max(A[0], B[M/2 – 1]), min(A[1], B[M/2 + 1]).

Case 6: N = 2, M is even
Let B[4] = {5, 10, 12, 15}
The median is given by median of following four elements: B[M/2], B[M/2 – 1], max(A[0], B[M/2 – 2]), min(A[1], B[M/2 + 1])

Remaining Cases:
Once we have handled the above base cases, following is the remaining process.
1) Find the middle item of A[] and middle item of B[].
…..1.1) If the middle item of A[] is greater than middle item of B[], ignore the last half of A[], let length of ignored part is idx. Also, cut down B[] by idx from the start.
…..1.2) else, ignore the first half of A[], let length of ignored part is idx. Also, cut down B[] by idx from the last.

Following is C implementation of the above approach.

// A C program to find median of two sorted arrays of unequal size
#include <stdio.h>
#include <stdlib.h>
 
// A utility function to find maximum of two integers
int max( int a, int b )
{ return a > b ? a : b; }
 
// A utility function to find minimum of two integers
int min( int a, int b )
{ return a < b ? a : b; }
 
// A utility function to find median of two integers
float MO2( int a, int b )
{ return ( a + b ) / 2.0; }
 
// A utility function to find median of three integers
float MO3( int a, int b, int c )
{
    return a + b + c - max( a, max( b, c ) )
                     - min( a, min( b, c ) );
}
 
// A utility function to find median of four integers
float MO4( int a, int b, int c, int d )
{
    int Max = max( a, max( b, max( c, d ) ) );
    int Min = min( a, min( b, min( c, d ) ) );
    return ( a + b + c + d - Max - Min ) / 2.0;
}
 
// This function assumes that N is smaller than or equal to M
float findMedianUtil( int A[], int N, int B[], int M )
{
    // If the smaller array has only one element
    if( N == 1 )
    {
        // Case 1: If the larger array also has one element, simply call MO2()
        if( M == 1 )
            return MO2( A[0], B[0] );
 
        // Case 2: If the larger array has odd number of elements, then consider
        // the middle 3 elements of larger array and the only element of
        // smaller array. Take few examples like following
        // A = {9}, B[] = {5, 8, 10, 20, 30} and
        // A[] = {1}, B[] = {5, 8, 10, 20, 30}
        if( M & 1 )
            return MO2( B[M/2], MO3(A[0], B[M/2 - 1], B[M/2 + 1]) );
 
        // Case 3: If the larger array has even number of element, then median
        // will be one of the following 3 elements
        // ... The middle two elements of larger array
        // ... The only element of smaller array
        return MO3( B[M/2], B[M/2 - 1], A[0] );
    }
 
    // If the smaller array has two elements
    else if( N == 2 )
    {
        // Case 4: If the larger array also has two elements, simply call MO4()
        if( M == 2 )
            return MO4( A[0], A[1], B[0], B[1] );
 
        // Case 5: If the larger array has odd number of elements, then median
        // will be one of the following 3 elements
        // 1. Middle element of larger array
        // 2. Max of first element of smaller array and element just
        //    before the middle in bigger array
        // 3. Min of second element of smaller array and element just
        //    after the middle in bigger array
        if( M & 1 )
            return MO3 ( B[M/2],
                         max( A[0], B[M/2 - 1] ),
                         min( A[1], B[M/2 + 1] )
                       );
 
        // Case 6: If the larger array has even number of elements, then
        // median will be one of the following 4 elements
        // 1) & 2) The middle two elements of larger array
        // 3) Max of first element of smaller array and element
        //    just before the first middle element in bigger array
        // 4. Min of second element of smaller array and element
        //    just after the second middle in bigger array
        return MO4 ( B[M/2],
                     B[M/2 - 1],
                     max( A[0], B[M/2 - 2] ),
                     min( A[1], B[M/2 + 1] )
                   );
    }
 
    int idxA = ( N - 1 ) / 2;
    int idxB = ( M - 1 ) / 2;
 
     /* if A[idxA] <= B[idxB], then median must exist in
        A[idxA....] and B[....idxB] */
    if( A[idxA] <= B[idxB] )
        return findMedianUtil( A + idxA, N / 2 + 1, B, M - idxA );
 
    /* if A[idxA] > B[idxB], then median must exist in
       A[...idxA] and B[idxB....] */
    return findMedianUtil( A, N / 2 + 1, B + idxA, M - idxA );
}
 
// A wrapper function around findMedianUtil(). This function makes
// sure that smaller array is passed as first argument to findMedianUtil
float findMedian( int A[], int N, int B[], int M )
{
    if ( N > M )
       return findMedianUtil( B, M, A, N );
 
    return findMedianUtil( A, N, B, M );
}
 
// Driver program to test above functions
int main()
{
    int A[] = {900};
    int B[] = {5, 8, 10, 20};
 
    int N = sizeof(A) / sizeof(A[0]);
    int M = sizeof(B) / sizeof(B[0]);
 
    printf( "%f", findMedian( A, N, B, M ) );
    return 0;
}

http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/












