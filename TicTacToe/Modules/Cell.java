package TicTacToe.Modules;

public class Cell {
    int row;
    int col;

    private Player player;

    private  Cellstats Cellstate;

    Cell(int x,int y){
        this.row=x;
        this.col=y;
        this.player=null;
        this.Cellstate=Cellstats.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cellstats getCellstate() {
        return Cellstate;
    }

    public void setCellstate(Cellstats cellstate) {
        Cellstate = cellstate;
    }



    public void display() {
        //cell is printing itself
        if(player == null){
            System.out.print("| - |");
        }else{
            System.out.print("| "+player.getSymbol().getSymbol()+" |");
        }
    }
}
