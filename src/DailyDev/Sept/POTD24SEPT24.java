package DailyDev.Sept;

public class POTD24SEPT24 {
    // needed bit of hint , but did good implementation
    class TrieNode{
        TrieNode[] childs;
        TrieNode(){
            this.childs=new TrieNode[10];
        }
    }
    class Trie{
        TrieNode root ;
        Trie(){
            this.root= new TrieNode();
        }
        public void insert(String str){
            TrieNode temp = root;
            for(char c:str.toCharArray()){
                if(temp.childs[c-'0']==null){
                    temp.childs[c-'0']=new TrieNode();
                }
                temp=temp.childs[c-'0'];
            }
        }
    }
    // another approach is using hashset but it seems brute force
}
