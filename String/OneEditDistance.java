/* Given two strings S and T, determine if they are both one edit distance apart.


Hint:
1. If | n – m | is greater than 1, we know immediately both are not one-edit distance apart.
2. It might help if you consider these cases separately, m == n and m ≠ n.
3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
If m > n, we could just simply swap S and T.
4. If m == n, it becomes finding if there is exactly one modified operation. 
If m ≠ n, you do not have to consider the delete operation. Just consider the insert operation in T. */

public boolean isOneEditDistance(String s, String t) {
   int m = s.length(), n = t.length();
   if (m > n) return isOneEditDistance(t, s);
   if (n - m > 1) return false;
   int i = 0, shift = n - m;
   while (i < m && s.charAt(i) == t.charAt(i)) i++;
   if (i == m) return shift > 0;      //append
   if (shift == 0) i++;               //modify
   while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;   //insert or modify
   return i == m;
}

bool edit(string s1, string s2) {
    if(s2.size() < s1.size()) {
        return edit(s2, s1);
    }        
    if(s1.size() + 1 < s2.size()) {
        return false;
    }

    int i = 0;
    while(i < s1.size()) {
        if(s1[i] != s2[i]) {
            if(s1.size() == s2.size()) {
                return s1.substr(i+1) == s2.substr(i+1);
            }else {
                return s1.substr(i) == s2.substr(i+1);
            }
        }
        i ++;
    }
    # this is for the last char
    return s1.size() != s2.size();
}
