

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;
import HashTables.HashTable;
import LinkedList.easy.ListNode;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Practice {

    public static void main(String[] args) {
        System.out.println(grayCode(2));

    }


    public int tallestBillboard(int[] rods) {
        int sum=0;
        int ans=0;
        for(int i:rods)sum+=i;
        for(int i=1;i<sum/2;i++){
            int rem = sum-(2*i);
            if(check(rods,rem,0))ans=Math.max(ans,i);
        }
        return ans;
    }
    public boolean check(int[] arr,int rem,int i){
        if(i==arr.length && rem!=0)return false;
        if(rem==0)return true;
        return (rem>=arr[i])?check(arr,rem-arr[i],i+1):check(arr,rem,i+1);
    }



}