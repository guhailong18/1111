package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class Change extends JFrame{
    JPasswordField jPF1,jPF2;
    JLabel jl1,jl2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;  //创建按钮
    PoliceListen listen=new PoliceListen();//添加监视器
    public Change(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width-300)/2;
        int y = (height - 200)/2;
        jPF1 = new JPasswordField(13);
        jPF2 = new JPasswordField(13);  //创建密码框组件
        jl1 = new JLabel("请输入旧密码:");
        jl2 = new JLabel("请输入新密码:");
        jb1 = new JButton("确认");
        jb2 = new JButton("返回首页");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        //设置布局
        this.setLayout(new GridLayout(3,1));
        jp1.add(jl1);
        jp1.add(jPF1);
        jp2.add(jl2);
        jp2.add(jPF2);
        jp3.add(jb1);
        jp3.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("修改密码");
        setLocation(x,y);
        //对确定按钮添加监视事件
        jb1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean a = listen.用户修改密码(jPF1.getText(),jPF2.getText());
                if(a&&new String(jPF2.getPassword()).length() > 6){  //修改成数据库返回的信息
                    JOptionPane.showMessageDialog(null,"修改成功");
                    dispose();
                    new Reader(); //进入到读者窗口
                }else {
                    JOptionPane.showMessageDialog(null,"修改失败");
                }
            }
        });
        //对返回首页按钮添加监视事件
        jb2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new Reader();
            }
        });
    }
}
