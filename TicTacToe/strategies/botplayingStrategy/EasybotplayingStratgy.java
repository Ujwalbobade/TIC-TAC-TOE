package TicTacToe.strategies.botplayingStrategy;

import TicTacToe.Modules.Board;
import TicTacToe.Modules.Cell;
import TicTacToe.Modules.Cellstats;
import TicTacToe.Modules.Move;

import java.util.List;

public class EasybotplayingStratgy implements BotPlayingStrategy{
    @Override
    public Move makemove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell:row){
                if(cell.getCellstate().equals(Cellstats.EMPTY)){
                    return new Move(cell,null);
                }
            }
        }
        return null;
    }
}
