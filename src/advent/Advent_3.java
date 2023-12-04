package advent;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Advent_3 {

    record Num(Integer num, Rectangle2D.Double rect) {

    }

    public static void main(String[] args) {
        final String input = in.IO.readFileFully("3");
        final List<Num> nums = new ArrayList<>();
        final List<Rectangle2D> symbols = new ArrayList<>();
        final List<Rectangle2D> gears = new ArrayList<>();
        int y = 0;
        for (String line : input.replaceAll("\r?\n", ".\n").split("\n")) {
            String num = "";
            for (int x = 0; x < line.length(); x++) {
                if (Character.isDigit(line.charAt(x))) {
                    num += line.charAt(x);
                } else {
                    if (!num.isBlank()) {
                        nums.add(new Num(Integer.parseInt(num), new Rectangle2D.Double(x - num.length() + 0.01, y + 0.01, num.length() - 0.02, 0.98)));
                        num = "";
                    }
                    if (line.charAt(x) != '.') {
                        symbols.add(new Rectangle2D.Double(x - 0.1, y - 0.1, 1.2, 1.2));
                        if (line.charAt(x) == '*') {
                            gears.add(new Rectangle2D.Double(x - 0.1, y - 0.1, 1.2, 1.2));
                        }
                    }
                }
            }
            y++;
        }

        final Set<Num> add = new HashSet<>();
        for (var s : symbols) {
            for (var num : nums) {
                if (num.rect.intersects(s)) {
                    add.add(num);
                }
            }
        }
        System.out.println("1: " + add.stream().mapToInt(n -> n.num).sum());


        int total = 0;
        for (var g : gears) {
            List<Integer> n = new ArrayList<>();
            for (var num : nums) {
                if (num.rect.intersects(g)) {
                    n.add(num.num);
                }
            }
            if (n.size() == 2) {
                total += n.get(0) * n.get(1);
            }
        }
        System.out.println("2: " + total);
    }
}
