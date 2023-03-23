

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
        System.out.println(Integer.bitCount(6));

    }
    class Solution {
        List<String> ans;
        public List<String> addOperators(String num, int target) {
            ans=new ArrayList<>();
            char[] array = num.toCharArray();
            char[] opt = {'+','-','*'};
            for(int i=0;i<array.length;i++){
                StringBuilder str = new StringBuilder();
                str.append(array[i]);
                int curr = (int)(array[i] - '0');
                backtrack(array,opt,str,target,curr,i+1,curr);
            }
            return ans;
        }

        public void backtrack(char[] array, char[] opt, StringBuilder str, int target, int sum, int i, int prev) {
            if(i == array.length && sum == target){
                ans.add(str.toString());
                return;
            }
            if(i >= array.length) return;

            for(int j=0;j<3;j++){
                str.append(opt[j]);
                str.append(array[i]);
                int curr = (int)(array[i] - '0');
                if(opt[j] == '*') {
                    sum = sum - prev + prev * curr;
                    prev = prev * curr;
                }
                if(opt[j] == '-'){
                    sum = sum - prev - curr;
                    prev = -curr;
                }
                if(opt[j] == '+'){
                    sum = sum - prev + curr;
                    prev = curr;
                }
                backtrack(array,opt,str,target,sum,i+1,prev);
                str.deleteCharAt(str.length()-1);
                str.deleteCharAt(str.length()-1);
            }
        }
    }

}