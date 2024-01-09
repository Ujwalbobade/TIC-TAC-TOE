package TicTacToe.strategies.botplayingStrategy;

import TicTacToe.Modules.Board;
import TicTacToe.Modules.Cell;
import TicTacToe.Modules.Cellstats;
import TicTacToe.Modules.Move;

import java.util.*;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    Map<Integer,Cell> rest = new HashMap<>();
    Move move=null;
    /*@Override
    public Move makemove(Board board) {
        int g = 3;
        int c = 0;
        Iterator<List<Cell>> rowIterator = board.getBoard().iterator();
        int j=0;
        while (rowIterator.hasNext() && j>=8 ) {
            List<Cell> row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if (cell.getCellstate().equals(Cellstats.EMPTY) && (cell.getCol() + cell.getRow()) % 2 == 0) {
                    g--;
                    j++;
                    return new Move(cell, null);
                } else if (g <= 0) {
                    Iterator<Map.Entry<Integer, Cell>> iterator = rest.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Cell> entry = iterator.next();
                        if (entry.getValue().getCellstate().equals(Cellstats.EMPTY)) {
                            Move move = new Move(entry.getValue(), cell.getPlayer());
                            iterator.remove(); // Remove safely using the iterator
                            j++;
                            return move;
                        }
                    }
                } else {
                    rest.put(c, cell);
                    c++;
                }

                System.out.println(g);
                rest.forEach(((k, v) -> System.out.println(k + " " + v.getCellstate() + " value col:-" + v.getCol() + " row:-" + v.getRow())));
            }

            row.forEach(i -> System.out.print(" " + i));
            System.out.println();
        }

        return null;
    }*/

    @Override
    public Move makemove(Board board) {
        int g = 3;
        int c=0;
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellstate().equals(Cellstats.EMPTY) && (cell.getCol() + cell.getRow()) % 2 == 0) {
                    g--;
                    return new Move(cell, null);
                }else if(g<=0){
                    Iterator<Map.Entry<Integer, Cell>> iterator = rest.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Cell> entry = iterator.next();
                        if (entry.getValue().getCellstate().equals(Cellstats.EMPTY)) {
                            move = new Move(entry.getValue(), cell.getPlayer());
                            iterator.remove(); // Remove safely using the iterator
                            return move;
                        }}
                }else{
                    rest.put(c,cell);
                    c++;
                }
                //System.out.println(g);
               // rest.forEach(((k,v)-> System.out.println(k+" "+v.getCellstate()+"value col:-"+v.getCol()+" row:-"+v.getRow())));
            }
            //row.forEach(i -> System.out.print(" " + i));
            //System.out.println();
        }
        // Process the remaining cells in the 'rest' map
        Iterator<Map.Entry<Integer, Cell>> iterator = rest.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Cell> entry = iterator.next();
            if (entry.getValue().getCellstate().equals(Cellstats.EMPTY)) {
                Move move = new Move(entry.getValue(),entry.getValue().getPlayer());
                iterator.remove(); // Remove safely using the iterator
                return move;
            }
        }
        return null;
    }
}
