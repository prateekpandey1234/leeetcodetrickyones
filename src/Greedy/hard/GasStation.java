package Greedy.hard;
//the main intuition is explained as below=>
//1.suppose we ran out of gas at station j when we started from i ... then we know that we were  losing gas gradually
//  station to station
//2.there we don't need to start form those points between [i,j] because they will still cause loss
//3.hence we increment our start to i+1 to search for better ways...
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0; // it will give us a difference b/w gas & cost
        int surplus = 0; // our tank ... surplus recorded for particular index
        int start = 0; // and the index of gas station

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){ // if the tank goes -ve
                surplus = 0; // reset our tank
                start = i + 1; // and update the stating gas station
            }
        }
        return (total_surplus < 0) ? -1 : start;//total surplus
    }
}
