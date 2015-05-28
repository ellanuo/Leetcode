ZigZag Conversion Total Accepted: 40200 Total Submissions: 181964 My Submissions Question Solution 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".



public class Solution {
    public String convert(String s, int numRows) {
        if(s==null)
            return null;
        if(numRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i=i+numRows+numRows-2)
            sb.append(s.charAt(i));
        
        for(int r=1; r<numRows-1; r++)
        {
            int i=r;
            boolean flag=true;
            while(i<s.length())
            {
                sb.append(s.charAt(i));
                if(flag)
                {
                    i+=(numRows-r-1)*2;
                    flag=false;
                }
                else
                {
                    i+=r*2;
                    flag=true;
                }
                
            }
        }
            
       for(int i=numRows-1; i<s.length();i=i+numRows+numRows-2)
            sb.append(s.charAt(i));
            
        return sb.toString();
    }
}
