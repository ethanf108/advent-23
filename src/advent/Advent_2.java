package advent;

import in.IO;

public class Advent_2 {

    public static void main(String[] args) {
        final String input = IO.readFileFully("2");
        int sum = 0;
        BIG:
        for (String line : input.split("\r?\n")) {
            int red = 0, green = 0, blue = 0;
            for (String game : line.substring(line.indexOf(":") + 2).split("; ")) {
                for (String tok : game.split(", ")) {
                    switch (tok.split(" ")[1]) {
                        case "red" -> red = Math.max(red, Integer.parseInt(tok.split(" ")[0]));
                        case "blue" -> blue = Math.max(blue, Integer.parseInt(tok.split(" ")[0]));
                        case "green" -> green = Math.max(green, Integer.parseInt(tok.split(" ")[0]));
                    }
                }
            }
            sum += red * green * blue;
        }
        System.out.println(sum);
    }
}
