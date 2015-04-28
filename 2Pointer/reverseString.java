/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space. */



public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return s;
            
        
        StringBuilder sb = new StringBuilder(s.trim());
        int low=0;
        int high=sb.length()-1;
        
        while(low<high)
        {
            char c = sb.charAt(low);
            sb.setCharAt(low, sb.charAt(high));
            sb.setCharAt(high,c);
            low++;
            high--;
        }
        
        
        for(int i=0; i<sb.length();)
        {
            if(sb.charAt(i)==' ')
            {
                sb.deleteCharAt(i);
                continue;
            }
            int j=i;
            while(j<sb.length() && sb.charAt(j)!=' ')
                j++;
            
            int next=j;    
            j--;
            
            while(i<j)
            {
                char c=sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            }
            i=next+1;
            
        }
        
        return sb.toString();
    }
}


// reverses the part of an array and returns the input array for convenience
public char[] reverse(char[] arr, int i, int j) {
    while (i < j) {
        char tmp = arr[i];
        arr[i++] = arr[j];
        arr[j--] = tmp;
    }
    return arr;
}

public String reverseWords(String s) {
    // reverse the whole string and convert to char array
    char[] str = reverse(s.toCharArray(), 0, s.length()-1);
    int start = 0, end = 0; // start and end positions of a current word
    for (int i = 0; i < str.length; i++) {
        if (str[i] != ' ') { // if the current char is letter 
            str[end++] = str[i]; // just move this letter to the next free pos
        } else if (i > 0 && str[i-1] != ' ') { // if the first space after word
            reverse(str, start, end-1); // reverse the word
            str[end++] = ' '; // and put the space after it
            start = end; // move start position further for the next word
        }
    }
    reverse(str, start, end-1); // reverse the tail word if it's there
    // here's an ugly return just because we need to return Java's String
    // also as there could be spaces at the end of original string 
    // we need to consider redundant space we have put there before
    return new String(str, 0, end > 0 && str[end-1] == ' ' ? end-1 : end);
}


