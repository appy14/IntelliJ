import java.util.*;

public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int numLib = n;
            long minCost = (long) numLib * x;
            int numRoads = 0;

            int[] r = new int[n + 1];
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();

                if (!isConnected(r, city_1, city_2)) {
                    if (r[city_1] == 0) {
                        if (r[city_2] == 0) {
                            r[city_1] = city_1;
                            r[city_2] = city_1;
                        } else {
                            r[city_1] = r[city_2];
                        }
                    } else {
                        if (r[city_2] == 0) {
                            r[city_2] = r[city_1];
                        } else {
                            replace(r, r[city_2], r[city_1]);
                        }
                    }
                    if (numRoads == 27568) {
                        System.out.println("city_1: " + city_1 + " city_2: " + city_2 + " " + r[city_1] + " " + r[city_2]);
                    }
                    numRoads++;
                    if (numLib > 1)
                        numLib--;
                }
                long cost = (long) numLib * x + (long) numRoads * y;
                if (cost == 8049633228L) {
                    System.out.println("numRoads: " + numRoads + " numLib: " + numLib + " minCost: " + minCost);
                }
                if (cost == 8049578964L) {
                    System.out.println("1, numRoads: " + numRoads + " numLib: " + numLib + " minCost: " + minCost);
                }

                if (cost < minCost) {
                    minCost = cost;
                }
            }
            System.out.println(minCost);
        }
    }

    static boolean isConnected(int[] r, int city_1, int city_2) {
        return r[city_1] != 0 && r[city_1] == r[city_2];
    }

    static void replace(int[] r, int oldParentCity, int newParentCity) {
        for (int i = 0; i < r.length; i++) {
            if (r[i] == oldParentCity) {
                r[i] = newParentCity;
            }
        }
    }
}
