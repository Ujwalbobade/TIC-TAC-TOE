package TicTacToe.Modules;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.NotUniquePlayer;
import TicTacToe.strategies.winningStratgies;
import introtoinheritance.B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// Code Models from our class diagram
// code controllers
// set up the main in the client
// gameController stateless and Game stateful
// startGame
// builder design pattern
// multi-valued attributes : addPlayer()
// validate() method

// To-do :
// complete validate()
// try to attempt different methods in gameController

public class Game {

    private Board board;

    private List<Move> moves;

    private List<Player> players;

    private int nextplayerIndex;

    private GameState gameState;

    private List<winningStratgies> winngStratgies;

    private int nextPlayerMoveIndex;

    private Player winner;

    private Game(int dimension,List<Player>players,List<winningStratgies>winngStratgies){
        this.board=new Board(dimension);
        this.gameState=GameState.IN_PROCESS;
        this.nextplayerIndex=0;
        this.winngStratgies=winngStratgies;
        this.winner=null;
        this.moves=new ArrayList<>();
        this.players=players;

    }
    public  static  Builder getbuilder(){return new Builder();}

    public boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >= board.getSize()){
            return false;
        }
        if(col>= board.getSize()){
            return false;
        }
        return  board.getBoard().get(row).get(col).getCellstate().equals(Cellstats.EMPTY);

    }
    public void makeMove() {

      Player currentMoveplayer = players.get(nextplayerIndex);
      System.out.println(" It is "+ currentMoveplayer.getName()+"'s turn please make the move");
      Move move=currentMoveplayer.makeMove(board);
      if(!validateMove(move)){
          System.out.println("invalid move please try again");;
          return;
      }
      int row = move.getCell().getRow();
      int col=move.getCell().getCol();

      Cell celltoupdated =board.getBoard().get(row).get(col);
      celltoupdated.setCellstate(Cellstats.FILLED);
      celltoupdated.setPlayer(currentMoveplayer);

      Move finalobj=new Move(celltoupdated,currentMoveplayer);
      moves.add(finalobj);


      nextplayerIndex++;
      nextplayerIndex%=players.size();


      if(checkWinner(board,finalobj)){
          gameState = GameState.SUCCESS;
          winner = currentMoveplayer;
          System.out.println("########________Player "+winner.getName()+" wins_____#######");

      }else if(moves.size()== board.getSize()* board.getSize()){
          gameState =GameState.DRAW;
          System.out.println(" #######______ DRAW_____#########  ");
      }




        }

        public  boolean checkWinner(Board board,Move move){
            for(winningStratgies winningStratgies : winngStratgies){
                if(winningStratgies.checkWinner(move,board)){
                return true;
                }}

            return false;
        }

    public static class Builder{

        private int dimension;
        private List<Player>players;
        private List<winningStratgies> winningStratgies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStratgies(List<TicTacToe.strategies.winningStratgies> winningStratgies) {
            this.winningStratgies = winningStratgies;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }
        public void validate() throws InvalidBotCountException {
            // validate Bot count
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }
            }
            if (botCount > 1) {
                throw new InvalidBotCountException();
            }
            // validate players count
            if (players.size() != dimension - 1) {
                throw new RuntimeException();
            }
        }
            public void validate2() throws  NotUniquePlayer {
            // validate unique symbol for every player
            Map<Character,Integer> SysmbolCount = new HashMap<>();
            for(Player P :  players){
                if(!SysmbolCount.containsKey(P.getSymbol().getSymbol())){
                    SysmbolCount.put(P.getSymbol().getSymbol(),0);

                }else{
                    SysmbolCount.put(P.getSymbol().getSymbol(),SysmbolCount.get(P.getSymbol()));
                }
            }
        }

        public Game Build() throws InvalidBotCountException, NotUniquePlayer {
             //validation
             validate();
             validate2();
             return new Game(this.dimension,this.players,this.winningStratgies);
         }

    }

    public  Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextplayerIndex() {
        return nextplayerIndex;
    }

    public void setNextplayerIndex(int nextplayerIndex) {
        this.nextplayerIndex = nextplayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<winningStratgies> getWinngStratgies() {
        return winngStratgies;
    }

    public void setWinngStratgies(List<winningStratgies> winngStratgies) {
        this.winngStratgies = winngStratgies;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void printBoard(){
        //actual print logic
        board.printboard();
    }
}
