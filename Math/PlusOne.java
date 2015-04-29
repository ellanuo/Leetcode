/* Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list
*/



public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0)
            return digits;
            
        int carry=1;
        int len=digits.length;
        for(int i=len-1; i>=0; i--)
        {
            int tmp=(digits[i]+carry);
            carry=tmp>=10 ? 1:0;
            digits[i]=tmp%10;
        }
        if(carry==0)
            return digits;
        else
        {
            int [] newDigits= new int [len+1];
            newDigits[0]=1;
            for(int i=1; i<=len;i++)
                newDigits[i]=digits[i-1];
            return newDigits;
        }
        
    }
}
