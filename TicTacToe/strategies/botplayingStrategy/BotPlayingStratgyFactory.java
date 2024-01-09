package TicTacToe.strategies.botplayingStrategy;

import TicTacToe.Modules.Botdifflevel;

public class BotPlayingStratgyFactory {
    public static BotPlayingStrategy getBotPlayingStratgyByLevel (Botdifflevel botdifflevel){
        switch (botdifflevel){
            case EASY -> {
                return new EasybotplayingStratgy();
            }
            case MEDIUM -> {
                return new MediumBotPlayingStrategy();
            }
            case HARD -> {
                return new HardBotPlayingStratgy();
            }
            default -> {
                return new EasybotplayingStratgy();
            }
        }

    }
}
