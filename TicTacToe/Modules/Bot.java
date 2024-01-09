package TicTacToe.Modules;

import TicTacToe.strategies.botplayingStrategy.BotPlayingStrategy;
import TicTacToe.strategies.botplayingStrategy.BotPlayingStratgyFactory;

public class Bot extends Player {
    Botdifflevel botdifflevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id,String name,Symbol symbol,Botdifflevel botdifflevel)
    {
        super(id,name,PlayerType.BOT,symbol);
        this.botdifflevel=botdifflevel;
        this.botPlayingStrategy= BotPlayingStratgyFactory.getBotPlayingStratgyByLevel(botdifflevel);

    }

    public Botdifflevel getBotdifflevel() {
        return botdifflevel;
    }

    public void setBotdifflevel(Botdifflevel botdifflevel) {
        this.botdifflevel = botdifflevel;
    }

    public Move makeMove(Board board){
        Move move=botPlayingStrategy.makemove(board);
        move.setPlayer(this);
        return move;
    }


}
