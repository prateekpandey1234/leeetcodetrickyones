package DyanamicProgramming.hard;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length; // Number of rows in the matrix
        int n = matrix[0].length; // Number of columns in the matrix
        int[] height = new int[n]; // Initialize an array to store heights of the histogram
        int maxA = 0; // Initialize the maximum area variable

        // Loop through each row in the matrix
        for(int i = 0 ; i < m ; i++){
            // Calculate the heights of the histogram for the current row we are just here making sure of
            // continuous number of 1
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '1')   height[j] = height[j] + 1; // If '1' is encountered, increase the height
                else    height[j] = 0; // If '0' is encountered, reset the height to 0
            }

            // Calculate the maximum area using the histogram heights
            maxA = Math.max(maxA , maxAreaHisto(height , n));
        }
        return maxA; // Return the maximum area
    }

    public int maxAreaHisto(int[] height , int n){
        // a stack is chosen because it simplifies the process of tracking heights, efficiently finding widths,
        // and calculating areas while maintaining the correct order
        Stack<Integer> st = new Stack<>(); // Initialize a stack to store indices of histogram heights
        int maxA = 0; // Initialize the maximum area variable

        // Loop through the histogram heights
        for(int i = 0 ; i <= n ; i++){
            while(!st.isEmpty() && (i == n || height[st.peek()] >= height[i])){
                // While the stack is not empty and the current height is less than or equal to the previous height,
                // calculate the area of the rectangle formed by the previous height
                int ht = height[st.peek()]; // Get the height from the top of the stack
                st.pop(); // Remove the index from the stack

                int width;
                if(st.isEmpty())    width = i; // If the stack is empty, the width is 'i' (from the beginning to the current index)
                    //width = i serves 2 purposes as it also tells about rows with equal or greater than current number of 1's
                else    width = i - st.peek() - 1; // Otherwise, the width is the difference between 'i' and the previous index on the stack

                maxA = Math.max(maxA , ht * width); // Calculate the area and update the maximum area if necessary
            }
            st.push(i); // Push the current index onto the stack
        }
        return maxA; // Return the maximum area
    }
}
