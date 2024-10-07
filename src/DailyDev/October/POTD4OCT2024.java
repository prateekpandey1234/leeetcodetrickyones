package DailyDev.October;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class POTD4OCT2024 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;
    }
    public long dividePlayers2(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        // Calculate total skill and build frequency map
        for (int s : skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Iterate through unique skill values
        for (int currSkill : skillMap.keySet()) {
            int currFreq = skillMap.get(currSkill);
            int partnerSkill = targetSkill - currSkill;

            // Check if valid partner skill exists with matching frequency
            if (
                    !skillMap.containsKey(partnerSkill) ||
                            currFreq != skillMap.get(partnerSkill)
            ) {
                return -1;
            }

            // Calculate chemistry for all pairs with this skill
            totalChemistry +=
                    (long) currSkill * (long) partnerSkill * (long) currFreq;
        }

        // Return half of total chemistry (as each pair is counted twice)
        return totalChemistry / 2;
    }

    // simple first way using sorting i used this
    public long dividePlayers1(int[] arr) {
        long sum=0;
        Arrays.sort(arr);

        int d=arr[0]+arr[arr.length-1];
        for(int i=0;i<arr.length/2;i++){
            if(d!=arr[i]+arr[arr.length-i-1]){
                return -1;
            }
            sum+=(long)((long) arr[i] *arr[arr.length-i-1]);
        }
        return sum;
    }

}
