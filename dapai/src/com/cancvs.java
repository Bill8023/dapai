package com;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class cancvs {
    private Image[] pic;
    private int random;
    int score_wanjia = 0;
    int score_diannao = 0;
    LinkedList wanjia = new LinkedList<Integer>();
    LinkedList diannao = new LinkedList<Integer>();


    public void wanjia_add() {
        score_wanjia = 0;
        while (true) {
            random = (int) (Math.random() * 52);
            wanjia.add(random);
            if (wanjia.equals(wanjia.stream().distinct().collect(Collectors.toList()))) {
                for (int i = 0; i < wanjia.size(); i++) {
                    if (((int) wanjia.get(i) + 1) % 13 == 0||((int) wanjia.get(i) + 1) % 13 == 11||((int) wanjia.get(i) + 1) % 13 == 12) {
                        score_wanjia = score_wanjia + 10;
                    } else {
                        score_wanjia = ((int) wanjia.get(i) + 1) % 13 + score_wanjia;
                    }
                }
                System.out.println("1" + wanjia);
                break;
            } else {
                wanjia.pollLast();
            }
        }
    }

    public void diannao_add() {
        score_diannao = 0;
        while (true) {
            random = (int) (Math.random() * 52);
            diannao.add(random);
            if (diannao.equals(diannao.stream().distinct().collect(Collectors.toList()))) {
                for (int i = 0; i < diannao.size(); i++) {
                    if (((int) diannao.get(i) + 1) % 13 == 0||((int) diannao.get(i) + 1) % 13 == 11||((int) diannao.get(i) + 1) % 13 == 12) {
                        score_diannao = score_diannao + 10;
                    } else {
                        score_diannao = ((int) diannao.get(i) + 1) % 13 + score_diannao;
                    }
                }
                System.out.println("2:" + diannao);
                break;
            } else {
                diannao.pollLast();
            }
        }
    }

    cancvs() {
        pic = new Image[56];
        pic[52] = Toolkit.getDefaultToolkit().getImage("./dapai/src/images/53.jpg");
        pic[53] = Toolkit.getDefaultToolkit().getImage("./dapai/src/images/54.jpg");
        pic[54] = Toolkit.getDefaultToolkit().getImage("./dapai/src/images/pukepaibeijing.png");
        pic[55] = Toolkit.getDefaultToolkit().getImage("./dapai/src/images/beijing.jpg");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                pic[i * 13 + j] = Toolkit.getDefaultToolkit().getImage("./dapai/src/images/" + (i * 13 + j + 1) + ".jpg");
            }
        }
    }

    public void paint(Graphics graphics, Frame frame) {
        graphics.drawImage(pic[55], 0, 0, 900, 500, frame);
        graphics.drawImage(pic[54], 403, 40, 88, 125, frame);
        graphics.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        graphics.drawString("玩家牌数值：" + score_wanjia + "分", 10, 190);
        graphics.drawString("电脑牌数值：" + score_diannao + "分", 10, 350);
        for (int i = 0; i < wanjia.size(); i++) {
            graphics.drawImage(pic[(int) (wanjia.get(i))], 7 + 58 * i, 200, 88, 125, frame);
        }
        for (int j = 0; j < diannao.size(); j++) {
            graphics.drawImage(pic[(int) (diannao.get(j))], 7 + 58 * j, 360, 88, 125, frame);
        }
    }
}
