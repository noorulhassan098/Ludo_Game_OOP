package ludo_build;

import java.awt.Graphics2D;

public class Player {
    int height, width;
    int coin;      
    Pawn[] pa;
    int playerIndex; 

    public Player(int height, int width, int playerIndex) {
        this.height = height;
        this.width = width;
        this.playerIndex = playerIndex;
        coin = 0;
        pa = new Pawn[4];
        for (int i = 0; i < 4; i++) {
            pa[i] = new Pawn(height, width);
        }
    }

    public void draw(Graphics2D g) {
      
        for (int i = 0; i < pa.length; i++) {
            if (pa[i] != null) {
                pa[i].draw(g, -1, -1, playerIndex);
            }
        }
    }
}
