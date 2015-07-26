Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

class TrieNode {
    // Initialize your data structure here.
    boolean isLeaf;
    TrieNode[] children;
    public TrieNode() {
        isLeaf=false;
        children=new TrieNode[26];
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p=root;
        for(int i=0; i<word.length();i++)
        {
            if(p.children[word.charAt(i)-'a']==null)
            {
                p.children[word.charAt(i)-'a']=new TrieNode();
            }
            
            p=p.children[word.charAt(i)-'a'];
        }
        p.isLeaf=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(p.children[index]==null)
                return false;
            
            p=p.children[index];
            
        }
        
        return p.isLeaf;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p= root;
        for(int i=0;i<prefix.length();i++)
        {
            int index=prefix.charAt(i)-'a';
            if(p.children[index]==null)
                return false;
            p=p.children[index];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
