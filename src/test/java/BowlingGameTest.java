import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    void should_return_score_when_level_is_not_ten_score_pin(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {4,5};
        //when
        int result = bowling.inOneTurnScore(strickBallOneTurn);
        //Then
        assertEquals(9,result);
    }

    @Test
    void should_return_score_when_level_is_not_ten_score_strike(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,5,4};
        //when
        int result = bowling.inOneTurnScore(strickBallOneTurn);
        //Then
        assertEquals(19,result);
    }

    @Test
    void should_return_score_when_level_is_ten_sore_pin(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {8,2,5};
        //when
        int result = bowling.inOneTurnScoreInTentheRound(strickBallOneTurn);
        //Then
        assertEquals(15,result);
    }
    @Test
    void should_return_score_when_level_is_ten_sore(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,8,5};
        //when
        int result = bowling.inOneTurnScoreInTentheRound(strickBallOneTurn);
        //Then
        assertEquals(23,result);
    }

    @Test
    void should_return_false_when_sore_more_than_10(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //whens
        //Then
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bowling.inAllTurnScore(strickBallOneTurn);
        });
    }
    @Test
    void should_return_false_when_turn_more_than_11(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //whens
        //Then
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bowling.inAllTurnScore(strickBallOneTurn);
        });
    }
    @Test
    void should_return_false_when_turn_more_than_10_and_10th_strike_not_10(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //whens
        //Then
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bowling.inAllTurnScore(strickBallOneTurn);
        });
    }
    @Test
    void should_return_false_when_one_turn_more_than_strike_10_ball(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //whens
        //Then
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            bowling.inAllTurnScore(strickBallOneTurn);
        });
    }
    @Test
    void should_return_score_when_all_striked(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10,10};
        //when
        int result = bowling.inAllTurnScore(strickBallOneTurn);
        //Then
        assertEquals(300,result);
    }
    @Test
    void should_return_score_when_not_all_striked(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,0,10,0,10,0,3,5,10,0,10,0,10,0,10,0,10,0,10,10,10};
        //when
        int result = bowling.inAllTurnScore(strickBallOneTurn);
        //Then
        assertEquals(271,result);
    }

}
