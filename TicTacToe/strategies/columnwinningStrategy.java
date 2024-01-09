package TicTacToe.strategies;

import TicTacToe.Modules.Board;
import TicTacToe.Modules.Move;
import TicTacToe.Modules.Player;
import TicTacToe.Modules.Symbol;

import java.util.HashMap;
import java.util.Map;

public class columnwinningStrategy implements winningStratgies{
    private final Map<Integer, HashMap<Symbol,Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)){
            counts.put(col,new HashMap<>());
        }
        HashMap<Symbol,Integer>colMap = counts.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        colMap.put(symbol,colMap.get(symbol)+1);

        return colMap.get(symbol)==board.getSize();
    }
}
