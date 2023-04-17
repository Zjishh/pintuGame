package com.zjh.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

/****************************
 * @project pintu
 * @package com.zjh.ui
 * @className GameJF
 * @author Zjiah
 * @date 2023/4/12 20:19
 * @Description:   *
 ****************************/
public class GameJF extends JFrame {
    int[] imgnum = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int[][] imgnum2 = new int[4][4];
    int x0 = 0, y0 = 0;
    int win[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    String path = "image\\girl\\girl1\\";//**
    int step = 0;

    public GameJF() {
        init();

        initMunebar();

        initData();


        initImage();


        this.setVisible(true);
    }

    private void initData() {


        for (int i = 0; i < imgnum.length; i++) {
            Random random = new Random();
            int i1 = random.nextInt(imgnum.length);
            int temp = imgnum[i];
            imgnum[i] = imgnum[i1];
            imgnum[i1] = temp;
        }

        for (int i = 0; i < imgnum.length; i++) {
            if (imgnum[i] == 0) {

                x0 = i / 4;
                y0 = i % 4;
                System.out.println("0索引的下标是" + x0 + "," + y0);
            }
                imgnum2[i / 4][i % 4] = imgnum[i];


        }
    }

    private void initImage() {
        //清空原本的图片
        this.getContentPane().removeAll();

        if (Victory()) {
            JLabel winimg = new JLabel(new ImageIcon("A:\\JetBrains\\ideaProjects\\pintu\\image\\win.png"));
            winimg.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winimg);
        }

        JLabel label1 = new JLabel("步数："+step);
        label1.setBounds(50,30,100,20);
        this.getContentPane().add(label1);

        JLabel backimg = new JLabel(new ImageIcon("image\\background.png"));

        backimg.setBounds(40, 40, 508, 560);


        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int num = imgnum2[j][i];
                JLabel label = new JLabel(new ImageIcon(path + num + ".jpg"));
                //指定位置
                label.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                //添加边框
                label.setBorder(new BevelBorder(1));
                this.getContentPane().add(label);
            }
        }
        this.getContentPane().add(backimg);


        //刷新界面
        this.getContentPane().repaint();
    }


    private void initMunebar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象 （功能  关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        replayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step = 0;
                //d打乱数据
                initData();

                initImage();

            }
        });
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        reLoginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameJF.this.setVisible(false);
                new LoginJF();
            }
        });
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem accountItem = new JMenuItem("公众号");
        accountItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                JDialog jDialog = new JDialog();
                JLabel label = new JLabel(new ImageIcon("image\\about.png"));
                label.setBounds(0,0,258,258);
                jDialog.getContentPane().add(label);
                jDialog.setSize(344,344);
                //置顶
                jDialog.setAlwaysOnTop(true);
                //弹窗居中
                jDialog.setLocationRelativeTo(null);
                //不关闭无法惊醒接下来的操作
                jDialog.setModal(true);
                jDialog.setVisible(true);
            }
        });

        // //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void init() {
        this.setSize(603, 680);
        this.setTitle("游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);//jizhong
        //取消默认居中放置
        this.setLayout(null);
        this.setDefaultCloseOperation(3);//关闭模式
        //给整个界面添加监听
        //为什么不能用匿名内部类
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            //按下不送
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == 65) {
                    //清空原本的图片
                    GameJF.this.getContentPane().removeAll();
                    JLabel backALL = new JLabel(new ImageIcon(path + "all.jpg"));

                    backALL.setBounds(83, 134, 420, 420);
                    GameJF.this.getContentPane().add(backALL);

                    JLabel backimg = new JLabel(new ImageIcon("image\\background.png"));

                    backimg.setBounds(40, 40, 508, 560);
                    GameJF.this.getContentPane().add(backimg);


                    GameJF.this.getContentPane().repaint();
                }


            }

            @Override
            //松开按键的时候
            public void keyReleased(KeyEvent e) {
                //对上下左右判断
                //左上右下37，38，39，40
                int keyCode = e.getKeyCode();
                if (keyCode == 65) {
                    initImage();
                } else if (keyCode == 87) {
                    imgnum2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                    x0 = 3;
                    y0 = 3;
                    initImage();
                }
//                else if(Victory()){
//                    return;
//                }
                switch (keyCode) {
                    case 37:
                        step++;
                        if (y0 == 3) {
                            break;
                        }
                        imgnum2[x0][y0] = imgnum2[x0][y0 + 1];
                        imgnum2[x0][y0 + 1] = 0;
                        y0++;
                        initImage();
                        break;
                    case 38:
                        step++;
                        if (x0 == 3) {
                            break;
                        }
                        imgnum2[x0][y0] = imgnum2[x0 + 1][y0];
                        imgnum2[x0 + 1][y0] = 0;
                        x0++;
                        initImage();
                        break;
                    case 39:
                        step++;
                        if (y0 == 0) {
                            break;
                        }
                        imgnum2[x0][y0] = imgnum2[x0][y0 - 1];
                        imgnum2[x0][y0 - 1] = 0;
                        y0--;
                        initImage();
                        break;
                    case 40:
                        step++;
                        if (x0 == 0) {
                            break;
                        }
                        imgnum2[x0][y0] = imgnum2[x0 - 1][y0];
                        imgnum2[x0 - 1][y0] = 0;
                        x0--;
                        initImage();
                        break;


                }

            }
        });

    }

    //判断数组是否相等 是否胜利
    public boolean Victory() {
        for (int i = 0; i < imgnum2.length; i++) {
            for (int j = 0; j < imgnum2[i].length; j++) {

                if (imgnum2[i][j] != win[i][j]) {
                    return false;
                }
            }

        }
        return true;
    }
}
