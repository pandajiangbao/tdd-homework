package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {
    private String type;
    private Integer number;
    public Poker(String type, String number) {
        this.type = type;
        switch (number) {
            case "T":
                this.number = 10;
                break;
            case "J":
                this.number = 11;
                break;
            case "Q":
                this.number = 12;
                break;
            case "K":
                this.number = 13;
                break;
            case "A":
                this.number = 14;
                break;
            default:
                this.number = Integer.parseInt(number);
                break;
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "type='" + type + '\'' +
                ", number=" + number +
                '}';
    }

    public static final int HIGH_CARD = 1;
    public static final int PAIR = 2;
    public static final int TWO_PAIR = 3;
    public static final int THREE_OF_A_KIND = 4;
    public static final int STRAIGHT = 5;
    public static final int FLUSH = 6;
    public static final int FULL_HOUSE = 7;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int STRAIGHT_FLUSH = 9;

    public static String compareCards(List<Poker> player1, List<Poker> player2) {

        player1 = player1.stream().sorted(Comparator.comparing(Poker::getNumber).reversed()).collect(Collectors.toList());
        player2 = player2.stream().sorted(Comparator.comparing(Poker::getNumber).reversed()).collect(Collectors.toList());
        Integer style1 = judgeStyle(player1);
        Integer style2 = judgeStyle(player2);
        player2.forEach(System.out::println);
        System.out.println("style1 = " + style1);
        System.out.println("style2 = " + style2);
        if (style1 > style2) return "player1 win";
        if (style1 < style2) return "player2 win";


        return compareCardsNumber(player1, player2,style1);
    }

    public static String compareCardsNumber(List<Poker> player1, List<Poker> player2,Integer style) {
        Integer max1 = player1.get(0).getNumber();
        Integer max2 = player2.get(0).getNumber();

        if (max1 > max2) {
            return "player1 win";
        } else if (max1.equals(max2)) {
            if (player1.size() == 1 && player2.size() == 1) return "nobody win";
            player1.remove(0);
            player2.remove(0);
            return compareCardsNumber(player1, player2,HIGH_CARD);
        }
        return "player2 win";
    }

    public static Integer judgeStyle(List<Poker> player) {
        int count = 0;
        for (int i = 0; i < player.size() - 1; i++) {
            if (player.get(i).getNumber() == player.get(i + 1).getNumber())
                count++;
        }
        // 11112  12222
        // 11122  11222
        if (count == 3) {
            if (player.get(1).getNumber() == player.get(3).getNumber())
                return FOUR_OF_A_KIND;
            else
                return FULL_HOUSE;
        }
        // 11123 12223 12333
        // 11223 12233 11233
        if (count == 2) {
            if ((player.get(0).getNumber() == player.get(2).getNumber()) ||
                    (player.get(1).getNumber() == player.get(3).getNumber()) ||
                    (player.get(2).getNumber() == player.get(4).getNumber()))
                return THREE_OF_A_KIND;
            else
                return TWO_PAIR;
        }
        // 11234
        if (count == 1)
            return PAIR;

        if (isStraight(player, count) && (player.stream().map(Poker::getType).distinct().count() == 1))
            return STRAIGHT_FLUSH;
        else if (isStraight(player, count))
            return STRAIGHT;
        else if (player.stream().map(Poker::getType).distinct().count() == 1)
            return FLUSH;
        return HIGH_CARD;
    }

    private static boolean isStraight(List<Poker> player, int count) {
        return count == 0 &&
                (player.get(1).getNumber() == player.get(0).getNumber() - 1) &&
                (player.get(2).getNumber() == player.get(1).getNumber() - 1) &&
                (player.get(3).getNumber() == player.get(2).getNumber() - 1) &&
                (player.get(4).getNumber() == player.get(3).getNumber() - 1);
    }
}
