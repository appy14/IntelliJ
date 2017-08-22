import java.util.Arrays;

/**
 * Created by apaswami on 3/23/17.
 */
public class ICake14 {

    public static void main(String[] args) {
        int flightLength = 300;

        int[] movieLengths = new int[]{100, 250, 500, 300};

        System.out.println(areTwoMoviesAvailable(flightLength, movieLengths));
    }

    public static boolean areTwoMoviesAvailable(int flightLength, int[] movieLengths) {
        Arrays.sort(movieLengths);

        if (movieLengths[0] + movieLengths[movieLengths.length - 1] < flightLength) {
            return false;
        }

        int halfFlightLength = flightLength / 2;

        int i = 0;
        int j = movieLengths.length - 1;

        while (i < j) {
            int total = movieLengths[i] + movieLengths[j];
            if (total == flightLength) {
                return true;
            }
            if (total > flightLength) {
                j--;
            } else if (total < flightLength) {
                i++;
            }
        }
        return false;
    }


}
