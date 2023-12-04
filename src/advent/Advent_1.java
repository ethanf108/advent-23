package advent;

import in.IO;

public class Advent_1 {

    public static void main(String[] args) {
        final String input = IO.readFileFully("1");
        int total = 0;
        for(String line : input.toLowerCase().split("\r?\n")){
            int num = 0;
            for(int i = 0; i < line.length(); i++){
                if(Character.isDigit(line.charAt(i))){
                    num+=10*Integer.parseInt(line.charAt(i)+"");
                    break;
                } else if (line.substring(i).startsWith("one")){
                    num+=10;
                    break;
                } else if (line.substring(i).startsWith("two")){
                    num+=20;
                    break;
                } else if (line.substring(i).startsWith("three")){
                    num+=30;
                    break;
                } else if (line.substring(i).startsWith("four")){
                    num+=40;
                    break;
                } else if (line.substring(i).startsWith("five")){
                    num+=50;
                    break;
                } else if (line.substring(i).startsWith("six")){
                    num+=60;
                    break;
                } else if (line.substring(i).startsWith("seven")){
                    num+=70;
                    break;
                } else if (line.substring(i).startsWith("eight")){
                    num+=80;
                    break;
                } else if (line.substring(i).startsWith("nine")) {
                    num += 90;
                    break;
                }
            }
            System.out.println(num);
            for(int i = line.length()-1; i >= 0; i--){
                if(Character.isDigit(line.charAt(i))){
                    num+=Integer.parseInt(line.charAt(i)+"");
                    break;
                } else if (line.substring(i).startsWith("one")){
                    num+=1;
                    break;
                } else if (line.substring(i).startsWith("two")){
                    num+=2;
                    break;
                } else if (line.substring(i).startsWith("three")){
                    num+=3;
                    break;
                } else if (line.substring(i).startsWith("four")){
                    num+=4;
                    break;
                } else if (line.substring(i).startsWith("five")){
                    num+=5;
                    break;
                } else if (line.substring(i).startsWith("six")){
                    num+=6;
                    break;
                } else if (line.substring(i).startsWith("seven")){
                    num+=7;
                    break;
                } else if (line.substring(i).startsWith("eight")){
                    num+=8;
                    break;
                } else if (line.substring(i).startsWith("nine")){
                    num+=9;
                    break;
                } else if (line.substring(i).startsWith("10")){
                    num+=10;
                    break;
                }
            }
            System.out.println(num);
            System.out.println();
            total+=num;
        }
        System.out.println(total);
    }
}
