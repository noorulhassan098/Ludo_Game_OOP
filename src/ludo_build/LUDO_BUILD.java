/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ludo_build;


import javax.swing.JFrame;

public class LUDO_BUILD{
    public static void main(String[] args) {
        JFrame frame = new JFrame("NOOR-UL-HASSAN LUDO");
        frame.setBounds(10, 10, 1000, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        GameMoves gm = new GameMoves();
        frame.add(gm);

        frame.setVisible(true);
    }
}


