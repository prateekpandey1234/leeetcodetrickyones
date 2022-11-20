import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodechefModule {
    //codechef module
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        for(int x=0;x<t;x++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String singleLine = br.readLine();
            int num = Integer.parseInt(singleLine.split(" ")[0]);
        }}
}
