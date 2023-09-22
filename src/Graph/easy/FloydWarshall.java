package Graph.easy;

public class FloydWarshall {
    //is also used for multisource shortest path
    public void shortest_distance(int[][] matrix)
    {
        //modifying our adjacency list
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)matrix[i][j]=(int)(1e9);// i,j are not connected directly
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
        //if there was to be a negative cycle then it will appear as we check for
        // matrix[i][i] <0 , where ith node is part of negative cycle, but we know that
        // matrix[i][i] =0 always
    }
}
