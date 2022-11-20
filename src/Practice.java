

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Practice {
   Stack<Character> stk;
    public int calculate(String s) {
        stk = new Stack();
        int ans =0;
        char[] arr = s.toCharArray();
        for(char ch:arr)stk.add(ch);
        int prevnum=0;
        while(!stk.isEmpty()){
            char curr = stk.peek();
            if(curr==')')ans+=bracketsum();
            else if(Character.isDigit(curr))prevnum=Integer.parseInt(String.valueOf(curr));
            else if(curr=='+')ans+=prevnum;
            else ans-=prevnum;
            stk.pop();
        }
        return ans;
    }
    public int bracketsum(){
        int ansb =0;
        int prevnum=0;
        while(stk.peek()!='('){
            char currb = stk.peek();
            if(Character.isDigit(currb)){
                prevnum=Integer.parseInt(String.valueOf(currb));
            }else if(currb=='+'){
                ansb+=prevnum;
            }else{
                ansb-=prevnum;
            }
            stk.pop();
        }
        return ansb;
    }
}


