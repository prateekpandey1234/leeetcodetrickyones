package BitManipulation.medium;

public class MinimumFlipsForOR {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        //So the approach here is to compare each bit of both a and b with c bit
        //to do so , in built functions to generate binary string is  not useful
        // what we will do here is first we will check whether LSB of c is 0 or 1
        // using c & 1 command to get LSB . this will be later used to check whether  we need to
        // switch any one of the bit(c&1==1) or both the bits (c&1==0)
        while (a != 0 | b != 0 | c != 0) {
            if ((c & 1) == 1) {
                //if both are zero then we will flip or invert one of them   bit
                if ((a & 1) == 0 && (b & 1) == 0) {
                    answer++;
                }
            } else {
                // it c&1==0 then we would need both bits to be zero... here this will give us whether we need to flip one of them
                //o rboth of them
                answer += (a & 1) + (b & 1);
            }
            //now to move forward we will shift our bits using bit shifting operator
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return answer;
    }
}
