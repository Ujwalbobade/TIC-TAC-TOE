package TicTacToe.Controller;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.NotUniquePlayer;
import TicTacToe.Modules.Board;
import TicTacToe.Modules.Game;
import TicTacToe.Modules.GameState;
import TicTacToe.Modules.Player;
import TicTacToe.strategies.winningStratgies;


// Client -> GameController -> Services/Models
// 1. start the Game
// 2. While the game state is IN_PROGRESS
// 2.1. Display the board
// 2.2. Make the move

// 3. Based on the game state you will return the result
// DRAW : Mention the draw result
// Winner : Get the winner and return


// 4. Undo

// No of players :

import java.util.List;

public class GameController {


    public Game startGame(int deimension, List<Player>players, List<winningStratgies> winningStratgies) throws InvalidBotCountException, NotUniquePlayer {

        return Game.getbuilder().setDimension(deimension).setPlayers(players).setWinningStratgies(winningStratgies).Build();
        //Used builder pattern to initialze game object in one go

    }

    public void DisplayBoard(Game game){
        //borad printing method
        game.printBoard();

    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState CheckState(Game game){
        return game.getGameState();
    }

//    public Player GetWinner(){
//        return new Player();
//    }

    public void Undo(){

    }
}


