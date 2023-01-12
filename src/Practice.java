

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;
import HashTables.HashTable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Practice {
    public static void main(String[] args){
        System.out.println((float) 4/333);

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int k =-1;
        List<int[]> ans = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            if(k==-1){
                if(newInterval[0]>=intervals[i][0] && newInterval[0]<=intervals[i][0]){
                    if(newInterval[1]<=intervals[i][0]){
                        return intervals;
                    }
                    else{
                        k=i;
                    }
                }else{
                    ans.add(intervals[i]);
                }
            }else{
                if(newInterval[1]>=intervals[i][0] && newInterval[1]<=intervals[i][0]){
                    int[] nep = new int[2];
                    nep[0]=intervals[k][0];
                    nep[1]=Math.max(intervals[i][1],newInterval[1]);
                    ans.add(nep);
                    k=-1;
                }
            }
        }
        int[][] nep = new int[ans.size()][2];
        for(int i =0;i< ans.size();i++){
            nep[i]=ans.get(i);
        }
        return nep;
    }
}


