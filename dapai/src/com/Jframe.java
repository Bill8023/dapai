package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jframe extends Frame implements ActionListener {
    private JButton button1, button2, button3;
    private Image iBuffer;
    private Graphics gBuffer;

    cancvs cancvs = new cancvs();
    int Screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int Screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int width = 900;
    int height = 560;

    Jframe() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("退出");
                System.exit(0);
            }
        });
        setLayout(null);
        button1 = new JButton("玩家要牌");
        button2 = new JButton("电脑要牌");
        button3 = new JButton("重新开始");
        button1.setBounds(280, 510, 100, 30);
        button2.setBounds(400, 510, 100, 30);
        button3.setBounds(520, 510, 100, 30);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        add(button1);
        add(button2);
        add(button3);
        setTitle("21点扑克牌游戏");
        setBounds((Screen_width - width) / 2, (Screen_height - height) / 2, width, height);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        cancvs.paint(g, this);
    }

    public void update(Graphics scr) {
        if (iBuffer == null) {
            iBuffer = createImage(this.getSize().width, this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
        paint(gBuffer);
        scr.drawImage(iBuffer, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            cancvs.wanjia_add();
            repaint();
            if (cancvs.score_wanjia > 21 || cancvs.score_diannao > 21) {
                button1.removeActionListener(this);
                button2.removeActionListener(this);
            }
        } else if (e.getSource() == button2) {
            cancvs.diannao_add();
            repaint();
            if (cancvs.score_wanjia > 21 || cancvs.score_diannao > 21) {
                button1.removeActionListener(this);
                button2.removeActionListener(this);
            }
        } else if (e.getSource() == button3) {
            cancvs = new cancvs();
            repaint();
            button1.addActionListener(this);
            button2.addActionListener(this);
        }
    }
}
