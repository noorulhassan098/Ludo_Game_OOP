/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo_build;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameMoves extends JPanel implements KeyListener, MouseListener {

    Layout la;
    Build_Player p;
    
    int current_player = 0;
    int dice = 0;
    int flag = 0, kill = 0;

    public GameMoves() {
        setFocusable(true);
        requestFocusInWindow();

        la = new Layout(250, 50);
        p = new Build_Player(la.height, la.width);

        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        la.draw((Graphics2D) g);
        p.draw((Graphics2D) g);

        //  dice and winner display
        if (p.pl[current_player].coin == 4) {
            drawWinner(g, current_player);
        } else if (dice != 0) {
            drawDice(g, current_player, dice);
        }

        
        if (flag == 0 && dice != 0 && dice != 6 && kill == 0) {
            current_player = (current_player + 1) % 4;
        }
        kill = 0;
    }

    private void drawWinner(Graphics g, int player) {
        g.setColor(Color.WHITE);
        g.fillRect(590, 100, 380, 130);
        g.setColor(getPlayerColor(player));
        g.setFont(new Font("serif", Font.BOLD, 40));
        g.drawString("Player " + (player + 1) + " wins.", 600, 150);
        g.drawString("Congratulations.", 600, 200);

        
        current_player = 0;
        la = new Layout(80, 50);
        p = new Build_Player(la.height, la.width);
        dice = 0;
        flag = 0;
        kill = 0;
    }

  private void drawDice(Graphics g, int player, int diceValue) {
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.WHITE);
    g2.fillRoundRect(10, 100, 220, 200, 20, 20);

    g2.setColor(Color.DARK_GRAY);
    g2.setStroke(new BasicStroke(3));
    g2.drawRoundRect(10, 100, 220, 200, 20, 20);

    g2.setColor(getPlayerColor(player));
    g2.setFont(new Font("Arial", Font.BOLD, 32));
    g2.drawString("PLAYER " + (player + 1), 20, 145);


    g2.setColor(Color.BLACK);
    g2.setFont(new Font("Arial", Font.PLAIN, 28));
    g2.drawString("Dice Roll:", 20, 185);

   
    Image diceImage = null;

    try {
        diceImage = new ImageIcon(getClass().getResource(diceValue + ".png")).getImage();
    } catch (Exception e) {
        System.out.println("Dice image not found: " + diceValue);
    }

        g2.drawImage(diceImage, 70, 190, 120, 100, null);
    
}




    private Color getPlayerColor(int player) {
        return switch (player) {
            case 0 -> Color.RED;
            case 1 -> Color.GREEN;
            case 2 -> Color.YELLOW;
            case 3 -> Color.BLUE;
            default -> Color.BLACK;
        };
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && flag == 0) {
            dice = 1 + (int) (Math.random() * 6);
            flag = canMovePawn() ? 1 : 0;
            repaint();
        }
    }

    private boolean canMovePawn() {
        for (int i = 0; i < 4; i++) {
            int cur = p.pl[current_player].pa[i].current;
            if ((cur != -1 && cur + dice <= 56) || (dice == 6 && cur == -1)) {
                return true;
            }
        }
        return false;
    }

 @Override
public void mouseClicked(MouseEvent e) {
    if (flag == 1) { 
        
        int x = (e.getX() - 250) / 30;
        int y = (e.getY() - 50) / 30;

        for (int i = 0; i < 4; i++) {
            Pawn pawn = p.pl[current_player].pa[i];

            if (pawn.x == x && pawn.y == y) {
                if (pawn.current == -1) {
                    if (dice == 6) { 
                        pawn.current = 0; 
                        handleKill(pawn); 
                        flag = 0;   
                        repaint();
                        break;
                    }
                } else { 
                    if (pawn.current + dice <= 56) {
                        pawn.current += dice;  
                        if (pawn.current == 56) 
                            p.pl[current_player].coin++;
                        handleKill(pawn);         
                        flag = 0;    
                        repaint();
                        break;
                    }
                }
            }
        }
    }
}


    private void handleKill(Pawn movedPawn) {
        int cur = movedPawn.current;
        if ((cur % 13 != 0 && cur % 13 != 8) && cur < 51) {
            for (int i = 0; i < 4; i++) {
                if (i == current_player) continue;
                for (int j = 0; j < 4; j++) {
                    Pawn opponent = p.pl[i].pa[j];
                    if (opponent.x == Path.ax[current_player][cur] && opponent.y == Path.ay[current_player][cur]) {
                        opponent.current = -1;
                        kill = 1;
                        return;
                    }
                }
            }
        }
    }
    
    private void drawboarderdice(Graphics2D g){
     g.setStroke(new BasicStroke(3));   
         g.setColor(Color.BLACK);     
     g.drawRect(10, 100, 210, 300);

    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
