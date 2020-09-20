import java.util.ArrayList;
import java.util.List;

public class Bowling {
    int pin = 11;
    int throwOppotunityNormal = 3;


    private int getSoreOfOneTurn(int[] strickBallOneTurn, int index) {
        int soreOfOneTurn = 0;
        if (strickBallOneTurn[0] == 10) {
            for (int i = index; i < strickBallOneTurn.length; i++) {
                if (strickBallOneTurn[i] < pin && throwOppotunityNormal > 0) {
                    soreOfOneTurn = soreOfOneTurn + strickBallOneTurn[i];
                    throwOppotunityNormal = throwOppotunityNormal - 1;
                }
                throwOppotunityNormal = throwOppotunityNormal + 10;
            }

        }

        if (strickBallOneTurn[index] + strickBallOneTurn[index + 1] < 10) {
            for (int i = index; i < index + 2; i++) {
                if (strickBallOneTurn[i] < pin && throwOppotunityNormal > 0) {
                    soreOfOneTurn = soreOfOneTurn + strickBallOneTurn[i];
                    pin = pin - strickBallOneTurn[i];
                    throwOppotunityNormal = throwOppotunityNormal - 1;
                }

            }
        }
        return soreOfOneTurn;
    }

    public int inOneTurnScoreInTentheRound(int[] strickBallOneTurn) {
        int soreOfOneTurn = 0;
        if (strickBallOneTurn[0] == 10) {
            soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn, 0);

            throwOppotunityNormal = throwOppotunityNormal + 10;
        }

        if (strickBallOneTurn[0] + strickBallOneTurn[1] <= 10) {
            soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn, 1);
            soreOfOneTurn = strickBallOneTurn[0] + soreOfOneTurn;
        }

        return soreOfOneTurn;
    }

    public int inOneTurnScore(int[] strickBallOneTurn) {
        int soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn, 0);
        return soreOfOneTurn;
    }

    public int inAllTurnScore(int[] strickBallOneTurn) {
        int score = 0;
        int record = 0;
        if (strickBallOneTurn.length > 21) throw new IllegalArgumentException();
        if (strickBallOneTurn[18] < 10 && strickBallOneTurn[19] + strickBallOneTurn[18] < 10
                && strickBallOneTurn.length > 20) throw new IllegalArgumentException();
        for (int i = 0; i < 18; i += 2) {
            if (strickBallOneTurn[i] > 10) throw new IllegalArgumentException();
            if (i % 2 == 0 && strickBallOneTurn[i] + strickBallOneTurn[i + 1] > 10)
                throw new IllegalArgumentException();
//            if (i%2 == 0 &&
//                    (strickBallOneTurn[i] == 10 || strickBallOneTurn[i] + strickBallOneTurn[i+1] == 10)){
//                if (strickBallOneTurn[i+2] == 10) onTurnScore = 20 + strickBallOneTurn[i+3]+onTurnScore;
//                onTurnScore = 10 + strickBallOneTurn[i+2]+ strickBallOneTurn[i+3]+onTurnScore;
//            }else {
//                onTurnScore =strickBallOneTurn[i] + strickBallOneTurn[i+1]+onTurnScore;
//                i++;
//            }
//            onTurnScore =strickBallOneTurn[i] + strickBallOneTurn[i+1]+onTurnScore;
//            i++;
            if (strickBallOneTurn[i] == 10) {
                score = score + 10 + strickBallOneTurn[i + 2];
            }
            if (strickBallOneTurn[i] < 10 && strickBallOneTurn[i] + strickBallOneTurn[i + 1] == 10) score = score + 10;
            score = score + strickBallOneTurn[i] + strickBallOneTurn[i + 1];
        }
        if (strickBallOneTurn[18] == 10) {
            score = score + strickBallOneTurn[18] + strickBallOneTurn[19] + strickBallOneTurn[20];
        } else {
            score = score + strickBallOneTurn[18] + strickBallOneTurn[19];
        }
        return score;
    }

}
