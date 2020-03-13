import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        lines.add("size\tNlongN\tN");
        // i is the size of the test data
        for (int i = 10000; i < 1000000; i += 10000) {
            StringBuilder builder = new StringBuilder();
            builder.append(i).append('\t');
            MaxHeap heap = new MaxHeap(i);
            Integer[] randomArray = getRandomArray(i);

            long startTime = System.nanoTime();
            heap.MaxHeapNLogN(randomArray);
            long endTime = System.nanoTime();

            builder.append(endTime - startTime).append('\t');

            startTime = System.nanoTime();
            heap.MaxHeapN(randomArray);
            endTime = System.nanoTime();

            builder.append(endTime - startTime);
            lines.add(builder.toString());
        }

        Files.write(Paths.get("Test-out.txt"), lines);
    }

    private static Integer[] getRandomArray(int size){
        Integer[] randomInts = new Integer[size];

        for (int i = 0; i < randomInts.length; i++)
            randomInts[i] = i;

        return randomInts;
    }
}
