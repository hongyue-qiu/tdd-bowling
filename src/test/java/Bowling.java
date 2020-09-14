public class Bowling {
    int pin = 11;
    int throwOppotunityNormal = 3;



    private int getSoreOfOneTurn(int[] strickBallOneTurn) {
        int soreOfOneTurn = 0;
        if (strickBallOneTurn[0] == 10){
            for (int i = 0; i < strickBallOneTurn.length; i++) {
                if (strickBallOneTurn[i] < pin && throwOppotunityNormal >0){
                    soreOfOneTurn = soreOfOneTurn + strickBallOneTurn[i];
                    throwOppotunityNormal = throwOppotunityNormal - 1;
                }
                throwOppotunityNormal = throwOppotunityNormal + 10;
            }

        }

        if (strickBallOneTurn[0] + strickBallOneTurn[1] < 10){
            for (int i = 0; i < 2; i++) {
                if (strickBallOneTurn[i] < pin && throwOppotunityNormal >0){
                    soreOfOneTurn = soreOfOneTurn + strickBallOneTurn[i];
                    pin = pin - strickBallOneTurn[i];
                    throwOppotunityNormal = throwOppotunityNormal - 1;
                }

            }
        }
        return soreOfOneTurn;
    }

    public int inOneTurnScoreInTenthRound(int[] strickBallOneTurn) {
        int soreOfOneTurn = 0;
        if (strickBallOneTurn[0] == 10){
            soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn);

            throwOppotunityNormal = throwOppotunityNormal + 10;
        }
        if (strickBallOneTurn[0] + strickBallOneTurn[1] == 10){
            soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn);
        }
        if (strickBallOneTurn[0] + strickBallOneTurn[1] < 10){
            soreOfOneTurn = strickBallOneTurn[0] + strickBallOneTurn[1];
        }

        return soreOfOneTurn;
    }
    public int inOneTurnScore(int[] strickBallOneTurn) {
        int soreOfOneTurn = getSoreOfOneTurn(strickBallOneTurn);


        return soreOfOneTurn;
    }

}
