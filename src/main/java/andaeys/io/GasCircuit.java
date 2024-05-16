package andaeys.io;

import java.util.HashMap;
import java.util.Map;

class GasCircuit {
    static int canCompleteCircuit2(int[] gas, int[] cost) {
        // condition cannot move to the next station:
        // tank at station i < cost[i]
        int idx = -1;
        int n = gas.length;
        for (int i = 0; i <n ; i++) {
            int dif = gas[i]-cost[i];
            int tank = gas[i];
            if (dif>=0) {
                //start travel from i
                int next = 0;
                if(i<n-1) next = i + 1;
                while (next!=i && tank>=0) {
                    tank = tank - cost[next];
                    if(tank>=0) {
                        tank += gas[next];
                        if (next==n-1){
                            next = 0;
                        } else {
                            next = next+1;
                        }
                    }
                }
                if (tank>=0) idx = i;
            }
        }

        return idx;
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startIdx = 0;
        int currentTank = 0;
        int totalGas = 0;
        int totalCost = 0;

        Map<Integer, Integer> xMap = new HashMap<>();
        for(int key: xMap.keySet()){
            int val = xMap.get(key);

        }

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i]- cost[i];

            //check if can reach next station
            if (currentTank<0) {
                currentTank = 0;
                startIdx = i+1;
            }
        }
        if (totalGas<totalCost) return -1;
        return startIdx;
    }

    public static void main(String[] args) {
        int[] gas;
        int[] cost;
        int expResult;
        int result;
        gas = new int[]{1,2,3,4,5};
        cost = new int[]{3,4,5,1,2};
        expResult = 3;
        result = canCompleteCircuit(gas, cost);
        //assert
        System.out.println("result: "+result+" | correct: "+(expResult==result));

        //case 2
        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        expResult = -1;
        result = canCompleteCircuit(gas, cost);
        //assert
        System.out.println("result: "+result+" | correct: "+(expResult==result));

    }
}