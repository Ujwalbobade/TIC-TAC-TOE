package TicTacToe.Modules;

import java.util.Scanner;

public class Player {
    private int id;

    private String Name;

    private  PlayerType playerType;

    private Symbol symbol;

    private Scanner scanner;

    public Player(int id, String name, PlayerType playerType, Symbol symbol){
        this.id=id;
        this.playerType=playerType;
        this.symbol=symbol;
        this.Name=name;
        this.scanner=new Scanner(System.in);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }


    public Move makeMove(Board board) {
        System.out.println("please mention  the row in which you want to move");
        int row= scanner.nextInt();
        System.out.println("please mention  the col in which you want to move");
        int col=scanner.nextInt();
        return new Move(new Cell(row,col),this);

    }
}
