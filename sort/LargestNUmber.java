Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
       // boolean flag=false;  
        List<String> number = new ArrayList<String>();
        for(int i=0; i<nums.length;i++)
        {
         //   if(nums[i]!=0)
           //     flag=true;
            number.add(Integer.toString(nums[i]));
        }
        
      //  if(!flag)
        //    return "0";
        
        Collections.sort(number, new Comparator<String>(){
            public int compare(String a, String b)
            {
                String aa=a+b;
                String bb=b+a;
                for(int i=0; i<aa.length();i++)
                {
                    if(aa.charAt(i)>bb.charAt(i))
                        return -1;
                    if(aa.charAt(i)<bb.charAt(i))
                        return 1;
                }
                return 0;
            }
        }
        );
        
        StringBuilder sb = new StringBuilder();
        for(String s:number)
            sb.append(s);
            
        if(sb.charAt(0)=='0')
            return "0";
            
        return sb.toString();
        
    }
}
