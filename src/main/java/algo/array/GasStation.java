package algo.array;


/**
 * Created by orca on 2020/5/24.
 * 问题分类：
 * 1、环路下标如何计算：(length+i)%length
 * 2、走了一圈的终止条件：!(j>i&&(length+i)%length==i) //顺时针  !(j<i&&(length+i)%length==i) //逆时针
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int roads;
        int gas_left;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                roads = 0;
                gas_left = 0;
                for (int j = i; !(j > i && (cost.length + j) % cost.length == i); j++) {
                    gas_left += gas[(cost.length + j) % cost.length];
                    gas_left -= cost[(cost.length + j) % cost.length];
                    if (gas_left < 0) {
                        break;
                    }
                    roads++;
                }
                if (roads == cost.length) {
                    return i;
                }
            }

            if (gas[i] >= cost[(cost.length + i - 1) % cost.length]) {
                roads = 0;
                gas_left = 0;
                for (int j = i; !(j < i && (cost.length + j) % cost.length != i); j--) {
                    gas_left += gas[(cost.length + j) % cost.length];
                    gas_left -= cost[(cost.length + j) % cost.length];
                    if (gas_left < 0) {
                        break;
                    }
                    roads++;
                }
                if (roads == cost.length) {
                    return i;
                }
            }
        }
        return -1;
    }
}
