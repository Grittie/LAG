import java.util.Arrays;
import java.util.Random;

public class ParallelSortingResearch {
    public static void main(String[] args) {
        int N = 60000000;

        // Create a randomIntegers array and create a copy to avoid interference
        int[] randomIntegers = generateRandomIntegers(N);
        int[] parallelIntArray = randomIntegers.clone();

        // Serial sorting
        long serialStartTime = System.currentTimeMillis();
        Arrays.sort(randomIntegers);
        long serialEndTime = System.currentTimeMillis();
        long serialElapsedTime = serialEndTime - serialStartTime;

        // Parallel sorting
        long parallelStartTime = System.currentTimeMillis();
        Arrays.parallelSort(parallelIntArray);
        long parallelEndTime = System.currentTimeMillis();
        long parallelElapsedTime = parallelEndTime - parallelStartTime;

        // Display results
        System.out.println("Number of elements: " + N);
        System.out.println("Serial Sort Elapsed Time: " + serialElapsedTime + " milliseconds");
        System.out.println("Parallel Sort Elapsed Time: " + parallelElapsedTime + " milliseconds");
    }

    private static int[] generateRandomIntegers(int N) {
        Random random = new Random();
        int[] randomIntegers = new int[N];
        for (int i = 0; i < N; i++) {
            randomIntegers[i] = random.nextInt();
        }
        return randomIntegers;
    }
}


