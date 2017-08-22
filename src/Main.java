import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(tryBottomUp(13, new int[]{2, 3}));
        System.out.println(changePossibilitiesBottomUp(13, new int[]{2, 3}));
    }

    public static int numberOfWays(int amount, int[] denominations, Map<Integer, Integer> m) {
        if (m.containsKey(amount)) {
            return m.get(amount);
        }
        int numWays = 0;

        for (int i = 0; i < denominations.length && amount >= denominations[i]; i++) {
            int r = amount % denominations[i];
            int q = amount / denominations[i];

            if (r == 0) {
                if (q > 1) {
                    numWays += (numberOfWays(denominations[i], denominations, m) - 1) * (q - 1) + 1;
                } else {
                    numWays += 1;
                }
            } else {
                int remainderRemainingDays = numberOfWays(r, denominations, m);
                int dRemainingDays = 1;
                if (q > 1) {
                    dRemainingDays = (numberOfWays(denominations[i], denominations, m)) * (q - 1);
                }
                numWays += (remainderRemainingDays * dRemainingDays);
            }
        }
        m.put(amount, numWays);
        return numWays;
    }

    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount+1]; // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount < amount + 1; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }

    public static int tryBottomUp(int amount, int[] denominations) {
        int[] x = new int[amount + 1];
        x[0] = 1;

        for (int coin : denominations) {
            for (int a = coin; a < x.length; a++) {
                int r = a - coin;
                x[a] += x[r];
            }
        }
        return x[amount];
    }
}
