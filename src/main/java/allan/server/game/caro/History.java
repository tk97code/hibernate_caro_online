/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allan.server.game.caro;

public class History {

    int row;
    int column;
    String playerEmail;

    public History(int row, int column, String playerEmail) {
        this.row = row;
        this.column = column;
        this.playerEmail = playerEmail;
    }

    @Override
    public String toString() {
        return row + ";" + column + ";" + playerEmail;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerId) {
        this.playerEmail = playerId;
    }
}
