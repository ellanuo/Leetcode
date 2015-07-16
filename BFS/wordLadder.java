Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

//If we try to change each letter in the word from ('a'-'z'), to see if the new word exists in dictionary. 
//In that case, we don't need to compare this  word with every word in dictionary, this will save a lot of time!

time complexity O(n*len*26) ; n is the size of dictionary

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord.equals(endWord))
            return 1;
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        
        int level=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int l=0; l<size; l++){
                String mid=queue.remove();
                
            
                for(int i=0; i<mid.length(); i++)
                {
                    char[] str= mid.toCharArray();  
                    //must create an new array in each iteratoin, otherwise the previous bit may get changed
                    for(char c= 'a'; c<='z'; c++)
                    {
                        str[i]=c;
                        String newWord = new String(str);
                        if(newWord.equals(endWord))
                             return level+1;
                 
                         if(wordDict.contains(newWord) && !visited.contains(newWord))
                        {
                            
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                        
                    }
                }
                
            }
            level++;
        }
        return 0;
    }
}

