package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {
    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size(){
        List<Poker> player1 = Arrays.asList(new Poker("C","3"), new Poker("D","4"), new Poker("H","K"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","A"), new Poker("D","5"), new Poker("H","3"), new Poker("H","4"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player2 win",result);
    }
    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_max_card_number_equal(){
        List<Poker> player1 = Arrays.asList(new Poker("C","3"), new Poker("D","A"), new Poker("H","K"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","A"), new Poker("D","5"), new Poker("H","3"), new Poker("H","4"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player1 win",result);
    }
    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_max_and_second_max_card_number_equal(){
        List<Poker> player1 = Arrays.asList(new Poker("C","3"), new Poker("D","A"), new Poker("H","K"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","A"), new Poker("D","5"), new Poker("C","K"), new Poker("H","Q"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player2 win",result);
    }

    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_one_pokers_is_PAIR_and_another_pokers_is_HIGH_CARD(){
        List<Poker> player1 = Arrays.asList(new Poker("C","5"), new Poker("D","A"), new Poker("H","K"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","A"), new Poker("D","5"), new Poker("C","K"), new Poker("H","Q"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player1 win",result);
    }

    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_one_pokers_is_pair_and_another_pokers_is_TWO_PAIR(){
        List<Poker> player1 = Arrays.asList(new Poker("C","5"), new Poker("D","A"), new Poker("H","K"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","2"), new Poker("D","2"), new Poker("S","4"), new Poker("C","4"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player2 win",result);
    }

    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_one_pokers_is_THREE_OF_A_KIND_and_another_pokers_is_TWO_PAIR(){
        List<Poker> player1 = Arrays.asList(new Poker("C","5"), new Poker("D","A"), new Poker("H","5"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","2"), new Poker("D","2"), new Poker("S","4"), new Poker("C","4"), new Poker("H","9"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player1 win",result);
    }

    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_one_pokers_is_THREE_OF_A_KIND_and_another_pokers_is_STRAIGHT(){
        List<Poker> player1 = Arrays.asList(new Poker("C","5"), new Poker("D","A"), new Poker("H","5"), new Poker("H","8"), new Poker("S","5"));
        List<Poker> player2 = Arrays.asList(new Poker("C","2"), new Poker("D","3"), new Poker("S","4"), new Poker("D","5"), new Poker("H","6"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player2 win",result);
    }

    @Test
    public void testPoker_given_two_pokers_then_compare_one_card_size_when_one_pokers_is_FLUSH_and_another_pokers_is_STRAIGHT(){
        List<Poker> player1 = Arrays.asList(new Poker("C","5"), new Poker("C","J"), new Poker("C","8"), new Poker("C","7"), new Poker("C","T"));
        List<Poker> player2 = Arrays.asList(new Poker("C","2"), new Poker("D","3"), new Poker("S","4"), new Poker("D","5"), new Poker("H","6"));


        String result= Poker.compareCards(player1,player2);

        Assert.assertEquals("player1 win",result);
    }
}
