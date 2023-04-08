

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

    public int minimizeArrayValue(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]!=0 && nums[i+1]>nums[i]){
                int avg =nums[i+1]+nums[i];
                max=Math.max(nums[i+1],(avg%2==0)?avg/2:avg/2+1);
            }
        }
        return max;
    }

}