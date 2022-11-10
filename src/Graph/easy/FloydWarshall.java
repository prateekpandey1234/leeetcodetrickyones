package Graph.easy;

import java.util.Scanner;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix)
    {
        //modifying our adjacency list
        Scanner sc = new Scanner(System.in);

        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)matrix[i][j]=(int)(1e9);
                if(i==j)matrix[i][j]=0;
            }
        }
        //it is kind of dp problem where we use previous data from matrix to solve next matrix
        //we will go from node i via node k to node j
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
    }
}
