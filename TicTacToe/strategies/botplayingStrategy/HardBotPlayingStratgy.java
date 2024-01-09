package TicTacToe.strategies.botplayingStrategy;

import TicTacToe.Modules.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardBotPlayingStratgy implements BotPlayingStrategy{
    Map<Integer,Cell> Playercell=new HashMap<>();
    int p=0;

    Map<Integer,Cell> BotPlayerCell=new HashMap<>();
    int b=0;
    @Override
    public Move makemove(Board board) {
        for(List<Cell> row:board.getBoard()){
            for(Cell cell:row){
                if(cell.getCellstate().equals(Cellstats.FILLED)){
                    if(cell.getPlayer().getPlayerType().equals(PlayerType.HUMAN)){
                        Playercell.put(p,cell);p++;
                    }else{
                        BotPlayerCell.put(b,cell);b++;
                    }
                }
                else if(cell.getCellstate().equals(Cellstats.EMPTY)){
                    return new Move(cell,null);
                }
            }
            Playercell.forEach((k,v)-> System.out.println(k+" "+v.getPlayer().getName()));
            BotPlayerCell.forEach((k,v)-> System.out.println(k+" "+v));
        }
        return null;
    }
}
