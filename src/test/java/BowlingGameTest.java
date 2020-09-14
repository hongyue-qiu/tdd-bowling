import org.junit.jupiter.api.Test;

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
    void should_return_score_when_level_is_ten_sore(){
        //given
        Bowling bowling = new Bowling();
        int[] strickBallOneTurn = {10,8,5};
        //when
        int result = bowling.inOneTurnScoreInTenthRound(strickBallOneTurn);
        //Then
        assertEquals(23,result);
    }
}
