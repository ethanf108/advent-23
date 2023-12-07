package advent;

import java.util.Arrays;

public class Advent_6 {

    public static void main_1(String[] args) {
        final String[] input = in.IO.readFileFully("6").split("\r?\n");
        final int[] times = Arrays.stream(input[0].substring(input[0].indexOf(':') + 1).split(" ")).filter(n -> !n.isBlank()).mapToInt(Integer::parseInt).toArray();
        final int[] records = Arrays.stream(input[1].substring(input[1].indexOf(':') + 1).split(" ")).filter(n -> !n.isBlank()).mapToInt(Integer::parseInt).toArray();
        long bt = 1;
        for (int n = 0; n < times.length; n++) {
            long total = 0;
            final int num = times[n];
            for (int i = 0; i <= num; i++) {
                if (i * (num - i) > records[n]) {
                    total++;
                }
            }
            bt *= total;
        }
        System.out.println(bt);
    }

    public static void main_2(String[] args) {
        final String[] input = in.IO.readFileFully("6").split("\r?\n");
        final long time = Long.parseLong(input[0].chars().filter(Character::isDigit).mapToObj(n -> String.valueOf((char) n)).reduce("", String::concat));
        final long record = Long.parseLong(input[1].chars().filter(Character::isDigit).mapToObj(n -> String.valueOf((char) n)).reduce("", String::concat));
        long total = 0;
        for (long i = 0; i <= time; i++) {
            if (i * (time - i) > record) {
                total++;
            }
        }
        System.out.println(total);
    }
}
