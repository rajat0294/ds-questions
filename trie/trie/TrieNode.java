package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean isEnd;

    Map<Character,TrieNode> children;

    public TrieNode(){
        this.children=new HashMap<>();
    }

    public void insert(String word, TrieNode node, int index) {
        if (word.length() - 1 == index) {
            TrieNode temp = node.children.get(word.charAt(index));
            if (temp == null) {
                TrieNode newNode = new TrieNode();
                newNode.isEnd = true;
                node.children.put(word.charAt(index), newNode);
            } else {
                temp.isEnd = true;
            }
        } else {
            TrieNode temp = node.children.get(word.charAt(index));
            if(temp!=null) {
                insert(word, temp, index + 1);
            }else{
                TrieNode newNode=new TrieNode();
                node.children.put(word.charAt(index),newNode);
                insert(word,newNode,index+1);
            }
        }
    }

    public boolean search(String searchString, TrieNode node, int index) {
        if (searchString.length() - 1 == index) {
            TrieNode temp = node.children.get(searchString.charAt(index));
            if (temp != null && temp.isEnd) {
                return true;
            } else {
                return false;
            }
        } else {
            TrieNode temp = node.children.get(searchString.charAt(index));
            if (temp == null) {
                return false;
            } else {
                return search(searchString, temp, index + 1);
            }
        }
    }

    public TrieNode delete(String word,TrieNode node,int index){
        if(index==word.length()){
            if(node.children.size()==0){
                return null;
            }else{
                node.isEnd=false;
                return node;
            }
        }
        else{
            TrieNode nodeReturned=delete(word,node.children.get(word.charAt(index)),index+1);
            if(nodeReturned==null){
                node.children.remove((word.charAt(index)));
            }
            if(node.children.size()==0 && nodeReturned!=null)
            {
                return null;
            }else{
                return node;

            }
        }
    }

    public static void main(String[] args) {
        TrieNode root=new TrieNode();
        root.insert("bad",root,0);
        root.insert("bat",root,0);
        root.insert("geet",root,0);
        root.insert("geets",root,0);
        root.insert("zoo",root,0);
        root.delete("bat",root,0);
        root.delete("zoo",root,0);

        System.out.println(root.search("bat",root,0));
        System.out.println(root.search("zoo",root,0));

    }
}
