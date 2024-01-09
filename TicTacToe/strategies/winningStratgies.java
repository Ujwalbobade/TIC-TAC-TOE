package TicTacToe.strategies;

import TicTacToe.Modules.Board;
import TicTacToe.Modules.Move;
import TicTacToe.Modules.Player;

public interface winningStratgies {

    public boolean checkWinner(Move move, Board board);


}
