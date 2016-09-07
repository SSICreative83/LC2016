class TrieNode {
    // Initialize your data structure here.
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];   
    
    public TrieNode() {

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(ws.children[cur - 'a'] == null) {
                ws.children[cur - 'a'] = new TrieNode();
            }
            ws = ws.children[cur - 'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(ws.children[cur - 'a'] == null) {
                return false;
            }
            ws = ws.children[cur - 'a'];
        }
        return ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if(ws.children[cur - 'a'] == null) {
                return false;
            }
            ws = ws.children[cur - 'a'];
        }        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
