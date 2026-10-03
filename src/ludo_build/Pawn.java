package ludo_build;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Pawn {
    int x, y;       
    int current;    
    int height, width;

    public Pawn(int h, int w) {
        current = -1; 
        x = -1;
        y = -1;
        height = h;
        width = w;
    }

    public void draw(Graphics2D g, int homeX, int homeY, int player) {
        int startX = 250; 
        int startY = 50;   

       
        Color color = switch (player) {
            case 0 -> Color.RED;
            case 1 -> Color.GREEN;
            case 2 -> Color.YELLOW;
            case 3 -> Color.BLUE;
            default -> Color.BLACK;
        };

        g.setColor(color);

        if (current == -1) {
            
            x = homeX;
            y = homeY;
            g.fillOval(startX + 5 + (x * width), startY + 5 + (y * height), width - 10, height - 10);
        } else {
            
            x = Path.ax[player][current];
            y = Path.ay[player][current];
            g.fillOval(startX + 5 + (x * width), startY + 5 + (y * height), width - 10, height - 10);
        }

       
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        if (current == -1) {
            g.drawOval(startX + 5 + (x * width), startY + 5 + (y * height), width - 10, height - 10);
        } else {
            g.drawOval(startX + 5 + (x * width), startY + 5 + (y * height), width - 10, height - 10);
        }
    }
}
