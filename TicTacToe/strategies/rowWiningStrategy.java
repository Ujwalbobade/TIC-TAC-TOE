package TicTacToe.strategies;

import TicTacToe.Modules.Board;
import TicTacToe.Modules.Move;

import TicTacToe.Modules.Symbol;


import java.util.HashMap;
import java.util.Map;

public class rowWiningStrategy implements winningStratgies{
    private final Map<Integer,HashMap<Symbol,Integer>> counts = new HashMap<>();


    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(row)){
            counts.put(row,new HashMap<>());
        }

        HashMap<Symbol,Integer>rowMap = counts.get(row);
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol,0);
        }
        rowMap.put(symbol,rowMap.get(symbol)+1);

        //checking thw winning condition
        return rowMap.get(symbol)==board.getSize();
    }
}
