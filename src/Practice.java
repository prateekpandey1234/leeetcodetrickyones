

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;
import HashTables.HashTable;
import LinkedList.easy.ListNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Practice {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,31)>Integer.MAX_VALUE);

    }
    public int maxProduct(String[] words) {
        int max=0,min=1;
        if(words[0].length()< words[1].length()){
            max=1;min=0;
        }
        for(int i=2;i<words.length;i++){
            if(words[i].length()>words[max].length() && ) {
                int tm = max;
                max=i;
                min=tm;
            }
            else if(words[i].length()>words[min].length())
        }

    }


}