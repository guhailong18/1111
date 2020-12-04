package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addbook extends JFrame{
    JTextField text1, text2, text3,text4;//图书名，图书编号，作者，图书数量
    JLabel jl1,jl2,jl3,jl4;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JButton jb1,jb2;  //创建按钮
    JComboBox comBox;   //下拉列表
    PoliceListen listen=new PoliceListen();//添加监视器
    public Addbook(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init() {
        text1.addActionListener(listen);
        text2.addActionListener(listen);
        text3.addActionListener(listen);
        text4.addActionListener(listen);
        jb1.addActionListener(listen);
        jb2.addActionListener(listen);
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        text1 = new JTextField(12);  //创建文本框组件
        text2 = new JTextField(12);
        text3 = new JTextField(12);
        text4 = new JTextField(12);
        jl1 = new JLabel("图书名");
        jl2 = new JLabel("图书编号");
        jl3 = new JLabel("作者");
        jl4 = new JLabel("图书数量");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        //设置布局
        setLayout(new FlowLayout());
        jp1.add(jl1);
        jp1.add(text1);
        jp2.add(jl2);
        jp2.add(text2);
        jp3.add(jl3);
        jp3.add(text3);
        jp4.add(jl4);
        jp4.add(text4);
        jp5.add(jb1);
        jp5.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(jp5);
        setSize(320,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("添加图书");
        setLocation(x,y);
        //下拉选框
        add(new JLabel("图书类型"));
        comBox = new JComboBox();
        comBox.addItem("请选择图书类型");
        comBox.addItem("科技");
        comBox.addItem("人文");
        comBox.addItem("艺术");
        comBox.addItem("其他");
        add(comBox);
        //添加图标
        ImageIcon imageIcon=new ImageIcon("image/1.png");
        setIconImage(imageIcon.getImage());
        //确认按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str1=text1.getText();
                String str2 = text2.getText();
                String str3 = text3.getText();
                String str4 = text4.getText();
                int a = Integer.parseInt(str4);
                boolean b = listen.添加图书(str1,str2,str3,a);
                if(b&&str1 != null && str1.length() != 0&&str2 != null && str2.length() != 0&&str3 != null && str3.length() != 0&& str4.length() != 0&&str4 != null ){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"添加成功");
                    dispose();
                 //   new Admin(); //进入到管理员窗口
                }else {
                    JOptionPane.showMessageDialog(null,"添加失败，请检查是否有漏填！");
                }
            }
        });
        //返回按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
             //   new Reader();
            }
        });
    }
}
