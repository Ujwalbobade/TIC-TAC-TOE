package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.NotUniquePlayer;
import TicTacToe.Modules.*;
import TicTacToe.strategies.DiagonalWinningStrategy;
import TicTacToe.strategies.columnwinningStrategy;
import TicTacToe.strategies.rowWiningStrategy;
import TicTacToe.strategies.winningStratgies;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidBotCountException, NotUniquePlayer {
        System.out.println("Game start");

        GameController gameController = new GameController();
        try{
            int dimension=3;
            List<Player> player = new ArrayList<>();
            player.add(new Player(1,"ujwal", PlayerType.HUMAN,new Symbol('X')));
            //player.add(new Player(2,"Neil",PlayerType.HUMAN,new Symbol('O')));
            player.add(new Bot(2,"chatGPT",new Symbol('O'),Botdifflevel.HARD));

            List<winningStratgies> winningStrategies = List.of(
                    new columnwinningStrategy(),
                    new rowWiningStrategy(),
                    new DiagonalWinningStrategy()
            );

            Game game = gameController.startGame(
                    dimension,
                    player,
                    winningStrategies

            );
            
            //1st display game
            gameController.DisplayBoard(game);
            System.out.println(gameController.CheckState(game));

            while(gameController.CheckState(game).equals(GameState.IN_PROCESS)){
                gameController.makeMove(game);
                gameController.DisplayBoard(game);
            }
        }catch (Exception e){
            throw(e);
            //System.out.println("game has stopped working");
        }



    }
}