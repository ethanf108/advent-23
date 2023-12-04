package advent;

import java.util.*;
import java.util.stream.IntStream;

public class Advent_4 {

    public static void main(String[] args) {
        final String input = in.IO.readFileFully("4");
        final int[] cards = new int[input.split("\r?\n").length];
        int i = 0;
        for (var line : input.split("\r?\n")) {
            final var card = line.substring(line.indexOf(':') + 2).split(" \\| ");
            final List<Integer> winning = new ArrayList<>(Arrays
                    .stream(card[0].strip().split(" +"))
                    .map(Integer::parseInt)
                    .toList());
            final List<Integer> got = Arrays
                    .stream(card[1].strip().split(" +"))
                    .map(Integer::parseInt)
                    .toList();

            winning.retainAll(got);
            cards[i] = winning.size();
            i++;
        }

        System.out.println("1: " + Arrays.stream(cards).map(n -> 1 << (n - 1)).sum());

        final Queue<Integer> q = new ArrayDeque<>(IntStream.range(0, cards.length).boxed().toList());
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            final int card = q.poll();
            int num = cards[card];
            for (i = card; i < card + num; i++) {
                q.offer(i + 1);
            }
        }

        System.out.println("2: " + count);
    }
}
