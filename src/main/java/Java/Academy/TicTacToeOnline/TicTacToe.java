package Java.Academy.TicTacToeOnline;

import java.util.Scanner;

public class TicTacToe {

    private int field[][];
    private boolean player;
    private Boolean gameEnded;
    private int turns;

    public TicTacToe(){
        field = new int[3][3];
        player = true;
        gameEnded = false;
        turns=0;
    }

    public void turn(int i, int j) {
        if(i>3 || j>3)
            return;
        if (isPlayer() &&field[i-1][j-1] == 0){
            field[i-1][j-1] = 1;
            player = false;
        }
        else if (field[i-1][j-1] == 0){
            field[i-1][j-1] = -1;
            player = true;
        }
        turns = getTurns() + 1;
    }


    public int[][] getField() {
        return field;
    }

    public void startGame(){
        Scanner in = new Scanner(System.in);
        while (!isGameEnded()){
            if(isPlayer())
                System.out.println("Enter your coordinates,player one: ");
            else System.out.println("Enter your coordinates,player two: ");
            turn(in.nextInt(),in.nextInt());
            print();
        }
        System.out.println(this.winner());
    }

    public boolean isGameEnded() {
        for(int i = 0;i<3;++i)
        {
            if(field[i][0]!=0 && field[i][0]== field[i][1] && field[i][1] == field[i][2]
            || field[0][i]!=0 && field[0][i]== field[1][i] && field[1][i] == field[2][i])
                gameEnded = true;
        }
        if(field[0][0]!=0 && field[0][0] == field[1][1] && field[2][2] == field[1][1])
            gameEnded = true;
        if(field[0][2]!=0 && field[0][2] == field[1][1] && field[2][0] == field[1][1])
            gameEnded = true;
        if (getTurns() ==10)
            gameEnded = true;
        return gameEnded;
    }

    @Override
    public String toString(){
        String message = new String();
        for(int i = 0;i<3;++i){
            for(int j = 0;j<3;++j){
                switch (field[i][j]){
                    case 0:
                        message = message + "_";
                        break;
                    case 1:
                        message = message + "X";
                        break;
                    case -1:
                        message = message + "O";
                        break;
                }
                message = message + " ";
            }
            message = message + "\n";
        }
        return message;
    }

    public void print(){
        System.out.println(this.toString());
    }


    public int getTurns() {
        return turns;
    }

    public boolean isPlayer() {
        return player;
    }

    public String winner(){
        if(getTurns() == 9&&!isGameEnded())
            return "It`s a draw\n";
        if(isGameEnded()){
            if(isPlayer())
                return "Second player won\n";
            else return "First player won\n";
        }
        return null;
    }

    public void startNewGame(){
        for (int i = 0;i<field.length;++i){
            for (int j = 0;i<field[i].length;++j){
                field[i][j]=0;
            }
        }
        turns=0;
    }
}
