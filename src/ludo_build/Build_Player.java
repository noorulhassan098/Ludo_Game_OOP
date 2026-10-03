package ludo_build;

import java.awt.Graphics2D;

public class Build_Player {
    private static final int PLAYER_COUNT = 4;
    private static final int TOKEN_COUNT = 4;

    Player[] pl;
    private final int[][] initialX = {
        {1, 1, 3, 3},
        {10, 10, 12, 12},
        {10, 10, 12, 12},
        {1, 1, 3, 3}
    };
    private final int[][] initialY = {
        {1, 3, 1, 3},
        {1, 3, 1, 3},
        {10, 12, 10, 12},
        {10, 12, 10, 12}
    };

    public Build_Player(int height, int width) {
        pl = new Player[PLAYER_COUNT];
        for (int i = 0; i < PLAYER_COUNT; i++) {
            pl[i] = new Player(height, width, i); 
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            for (int j = 0; j < TOKEN_COUNT; j++) {
                pl[i].pa[j].draw(g, initialX[i][j], initialY[i][j], i);
            }
        }
    }
}
