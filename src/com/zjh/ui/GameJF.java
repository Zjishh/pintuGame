package com.zjh.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
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
    int[] imgnum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16};
    int[][] imgnum2 = new int[4][4];
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
            imgnum2[i / 4][i % 4] = imgnum[i];
        }
    }

    private void initImage() {
        JLabel backimg = new JLabel(new ImageIcon("image\\background.png"));

        backimg.setBounds(40,40,508,560);


        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int num = imgnum2[j][i];
                JLabel label = new JLabel(new ImageIcon("image\\girl\\girl1\\" + num + ".jpg"));
                //指定位置
                label.setBounds(105 * i+83, 105 * j+134, 105, 105);
                //添加边框
                label.setBorder(new BevelBorder(1));
                this.getContentPane().add(label);
            }
        }
        this.getContentPane().add(backimg);

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
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

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
    }
}
