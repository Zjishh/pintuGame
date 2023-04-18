package com.zjh.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Year;
import java.util.Random;

/****************************
 * @project pintu
 * @package com.zjh.ui
 * @className LoginJF
 * @author Zjiah
 * @date 2023/4/12 20:20
 * @Description:   *
 ****************************/
public class LoginJF extends JFrame {
    StringBuffer yanzhengma = new StringBuffer();

    public LoginJF() {

        init();
        initYanzhengma();
        initImg();

        this.setVisible(true);
    }

    private void initYanzhengma() {
        yanzhengma.delete(0,yanzhengma.length());

        Random random = new Random();
        for (int j = 0; j < 4; j++) {

            int i = random.nextInt(123);
            char cha = 0;
            while (i < 48 || (i > 57 && i < 65) || (i > 90 && i < 97) || i > 122) {
                i = random.nextInt(123);
            }
            cha = (char) i;
            yanzhengma.append(cha);
        }


    }

    private void initImg() {


        JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);
        //2.添加用户名输入框
        JTextField username = new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        JTextField password = new JTextField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);
        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        JTextField code = new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(yanzhengma.toString());
        //位置和宽高
        rightCode.setBounds(320, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);
        rightCode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                initYanzhengma();
                rightCode.setText(yanzhengma.toString());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //5.添加登录按钮
        JButton login = new JButton();
        login.setBounds(123, 310, 125, 47);
        login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);

        //.点击登录
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                login.setIcon(new ImageIcon("image\\login\\登录按下.png"));


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));


                if (username.getText().equals("1")&&password.getText().equals("1")) {
                    if (code.getText().toUpperCase().equals(rightCode.getText().toUpperCase())){
                        LoginJF.this.setVisible(false);
                        new GameJF();
                    }else {
                        tanchuang("验证码错误");
                    }
                }
                else {
                    tanchuang("账号或者密码错误");
                }


            }

            private void tanchuang(String s) {
                JDialog jDialog = new JDialog();
                JLabel label = new JLabel(s);
                jDialog.getContentPane().add(label);
                jDialog.setSize(200,100);
                //置顶
                jDialog.setAlwaysOnTop(true);
                //弹窗居中
                jDialog.setLocationRelativeTo(null);
                //不关闭无法惊醒接下来的操作
                jDialog.setModal(true);
                jDialog.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //6.添加注册按钮
        JButton register = new JButton();
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                register.setIcon(new ImageIcon("image\\login\\注册按下.png"));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    private void init() {
        this.setSize(488, 430);
        this.setTitle("拼图1.0  -- 登录");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);//关闭模式
        this.setLayout(null);


    }


}
