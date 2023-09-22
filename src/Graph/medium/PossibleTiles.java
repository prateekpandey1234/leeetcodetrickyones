package Graph.medium;

import java.util.Arrays;

public class PossibleTiles {
    //space and time simpler
    int count;
    public int numTilePossibilities(String tiles) {
        count = 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        dfs(chars, 0, visited);
        return count;
    }

    private void dfs(char[] chars, int length, boolean[] visited){
        if(length == chars.length) return;
        for(int i = 0; i < chars.length; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            //what we are doing here is that we are avoiding those strings which we have encountered earlier
            //it doesn't work like skipping a repetitive character
            count ++;
            visited[i] = true;
            dfs(chars, length + 1, visited);
            visited[i] = false;
        }
    }
    //we can also use simple dfs here using set, but it will 100 times the time-consuming
}
