package advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Advent_9 {

    public static void main(String[] args) {
        final String input = in.IO.readFileFully("9");
        long total = 0;
        long total2 = 0;
        for (String line : input.split("\r?\n")) {
            List<int[]> nums = new ArrayList<>();
            nums.add(Arrays.stream(line.split(" +")).mapToInt(Integer::parseInt).toArray());
            while (nums.stream().noneMatch(n -> Arrays.stream(n).allMatch(m -> m == 0))) {
                int[] last = nums.getLast();
                int[] next = new int[last.length - 1];
                for (int i = 0; i < next.length; i++) {
                    next[i] = last[i + 1] - last[i];
                }
                nums.add(next);
            }
            int[] end = nums.stream().mapToInt(n -> n[n.length - 1]).toArray();
            for (int i = end.length - 1; i > 0; i--) {
                end[i - 1] = end[i - 1] + end[i];
            }
            total += end[0];

            //part 2
            end = nums.stream().mapToInt(n -> n[0]).toArray();
            for (int i = end.length - 1; i > 0; i--) {
                end[i - 1] = end[i - 1] - end[i];
            }
            total2 += end[0];

        }
        System.out.println("Part 1: " + total);
        System.out.println("Part 2: " + total2);
    }
}
