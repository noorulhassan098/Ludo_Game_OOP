/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo_build;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Layout {

    int x, y;
    int width, height;

    public Layout(int xi, int yi) {
        x = xi;
        y = yi;
        width = 30;
        height = 30;
    }

    public void draw(Graphics2D g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 15 * width, 15 * height);


       
        for (int i = 0; i < 6; i++) {
            
            g.setColor(Color.RED);
            g.fillRect(x + (i * width), y, width, height);
            g.fillRect(x, y + (i * height), width, height);
            g.fillRect(x + (i * width), y + (5 * height), width, height);
            g.fillRect(x + (5 * width), y + (i * height), width, height);

            
            g.setColor(Color.GREEN);
            g.fillRect(x + ((i + 9) * width), y, width, height);
            g.fillRect(x + (9 * width), y + (i * height), width, height);
            g.fillRect(x + ((i + 9) * width), y + (5 * height), width, height);
            g.fillRect(x + (14 * width), y + (i * height), width, height);

            
            g.setColor(Color.YELLOW);
            g.fillRect(x + ((i + 9) * width), y + (9 * height), width, height);
            g.fillRect(x + (9 * width), y + ((i + 9) * height), width, height);
            g.fillRect(x + ((i + 9) * width), y + (14 * height), width, height);
            g.fillRect(x + (14 * width), y + ((i + 9) * height), width, height);

           
            g.setColor(Color.BLUE);
            g.fillRect(x + (i * width), y + (9 * height), width, height);
            g.fillRect(x, y + ((i + 9) * height), width, height);
            g.fillRect(x + (i * width), y + (14 * height), width, height);
            g.fillRect(x + (5 * width), y + ((i + 9) * height), width, height);
        }

        
        g.setColor(Color.RED);
        g.fillRect(x + (1 * width), y + (6 * height), width, height);
        g.setColor(Color.YELLOW);
        g.fillRect(x + ((8 + 5) * width), y + (8 * height), width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x + (8 * width), y + (1 * height), width, height);
        g.setColor(Color.BLUE);
        g.fillRect(x + (6 * width), y + ((8 + 5) * height), width, height);
        g.setColor(Color.lightGray);
         g.fillOval(x  +5+ (2 * width), y +5+(8 * height), width -10, height - 10);
         g.fillOval(x  +5+ (6 * width), y +5+(2 * height), width -10, height - 10);
         g.fillOval(x  +5+ (12 * width), y +5+(6 * height), width -10, height - 10);
         g.fillOval(x  +5+ (8 * width), y +5+(12 * height), width -10, height - 10);
        
        for (int i = 1; i < 6; i++) {
            g.setColor(Color.RED);
            g.fillRect(x + (i * width), y + (7 * height), width, height);

            g.setColor(Color.YELLOW);
            g.fillRect(x + ((8 + i) * width), y + (7 * height), width, height);

            g.setColor(Color.GREEN);
            g.fillRect(x + (7 * width), y + (i * height), width, height);

            g.setColor(Color.BLUE);
            g.fillRect(x + (7 * width), y + ((8 + i) * height), width, height);
        }

        
        drawTriangles(g);

        
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        drawBorders(g);

        
        g.setFont(new Font("serif", Font.BOLD, 40));
        g.drawString("Player 1", 270, 35);
        g.drawString("Player 2", 540, 35);
        g.drawString("Player 4", 270, 540);
        g.drawString("Player 3", 540, 540);
      
       g.setFont(new Font("Arial", Font.PLAIN, 30));
         g.setColor(Color.BLACK);


g.drawString("INSTRUCTIONS:", 710, 150);


g.setFont(new Font("Arial", Font.PLAIN, 20));
g.setColor(Color.RED);
g.drawString("1. Press Enter to roll dice.", 710, 200);
g.drawString("2. Click on Pawn to move.", 710, 230);


    }

    private void drawTriangles(Graphics2D g) {
        int[] xpoints0 = {x + (6 * width), x + (6 * width), x + 15 + (7 * width)};
        int[] ypoints0 = {y + (6 * height), y + (9 * height), y + 15 + (7 * width)};
        g.setColor(Color.RED);
        g.fillPolygon(xpoints0, ypoints0, 3);

        int[] xpoints1 = {x + (9 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] ypoints1 = {y + (6 * height), y + (9 * height), y + 15 + (7 * width)};
        g.setColor(Color.YELLOW);
        g.fillPolygon(xpoints1, ypoints1, 3);

        int[] xpoints2 = {x + (6 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] ypoints2 = {y + (6 * height), y + (6 * height), y + 15 + (7 * width)};
        g.setColor(Color.GREEN);
        g.fillPolygon(xpoints2, ypoints2, 3);

        int[] xpoints3 = {x + (6 * width), x + (9 * width), x + 15 + (7 * width)};
        int[] ypoints3 = {y + (9 * height), y + (9 * height), y + 15 + (7 * width)};
        g.setColor(Color.BLUE);
        g.fillPolygon(xpoints3, ypoints3, 3);
    }

    private void drawBorders(Graphics2D g) {
            g.setStroke(new BasicStroke(4));
            g.setColor(Color.BLACK);
           g.drawRect(250, 50, 450, 450);
           g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
        for (int i = 0; i < 15; i++) {
            
            for (int j = 0; j < 15; j++) {
                if(i<=5 && j<=5 || i<=5&&j>=9&&j<=15 || i>=9&&j<=5 || i>=9&&j>=9 || i>=6&&i<=8&&j>=6&&j<=8 ){
                  continue;
                }
                else{
                   g.drawRect(x + (i * width), y + (j * height), width, height);
                }
                
            }
        }
        
    }
}
