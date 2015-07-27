
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true




class TrieNode
{
    boolean isLeaf;
    TrieNode [] next;
    public TrieNode()
    {
        isLeaf=false;
        next=new TrieNode[26];
    }
}



public class WordDictionary {
     private TrieNode root;
     
     public WordDictionary()
     {
         root=new TrieNode();
     }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0; i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(index<0 || index>=26)
                return;
            
            if(p.next[index]==null)
            {
                p.next[index]=new TrieNode();
            }
            p=p.next[index];
        }
        p.isLeaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        //TrieNode p=root;
        
        return searchTrie(root, word, 0);
        
    }
    
    private boolean searchTrie(TrieNode root, String word, int pos)
    {
        
        if(pos==word.length() )
            return root.isLeaf;
        
        char c=word.charAt(pos);
        for(int i=0;i<26;i++)
        {
            if(c-'a'==i && root.next[i]==null)
                return false;
            else if((c=='.' || c-'a'==i) && root.next[i]!=null)
            {
                if(searchTrie(root.next[i], word, pos+1))
                    return true;
            }
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");


class TrieNode
{
    boolean isLeaf;
    TrieNode [] next;
    public TrieNode()
    {
        isLeaf=false;
        next=new TrieNode[26];
    }
}



public class WordDictionary {
     private TrieNode root;
     
     public WordDictionary()
     {
         root=new TrieNode();
     }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0; i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(index<0 || index>=26)
                return;
            
            if(p.next[index]==null)
            {
                p.next[index]=new TrieNode();
            }
            p=p.next[index];
        }
        p.isLeaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        //TrieNode p=root;
        
        return searchTrie(root, word, 0);
        
    }
    
    private boolean searchTrie(TrieNode root, String word, int pos)
    {
        
      /*  if(pos==word.length() )
            return root.isLeaf;
        
        char c=word.charAt(pos);
        for(int i=0;i<26;i++)
        {
            if(c-'a'==i && root.next[i]==null)
                return false;
                
            else if((c=='.' || c-'a'==i) && root.next[i]!=null)
            {
                if(searchTrie(root.next[i], word, pos+1))
                    return true;
            }
        }
        
        return false; */
        TrieNode p=root;
        for(int i=pos;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(c!='.' && p.next[c-'a']!=null)
                p=p.next[c-'a'];
            else if(c!='.' && p.next[c-'a']==null)
                return false;
            
            else
            {
                for(int j=0; j<26;j++)
                {
                    if(p.next[j]!=null)
                    {
                        if(searchTrie(p.next[j],word, i+1))
                            return true;
                    }
                }
                return false;
            }
        }
        
        return  p.isLeaf;
        
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
