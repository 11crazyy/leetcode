package test;

public class AddGas {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, curTank = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {//到不了 重新开始
                curTank = 0;
                index = i + 1;
            }
        }
        return totalTank >= 0 ? index : -1;
    }
}
