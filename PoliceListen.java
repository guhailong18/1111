package gui;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.* ;

public class PoliceListen implements ActionListener{
    JTextArea textShow;
    JTextField jF1,jF2,jF3,jF4;
    JPasswordField jPasswordField;
    SystemDB db=new SystemDB();
    public void setJTextField(JTextField text){
        jF1 = text;
    }
    public void setJTextArea(JTextArea area){
        textShow = area;
    }
    public void setjPasswordField(JPasswordField jPF){
        jPasswordField=jPF;
    }
    public boolean matched(){
        if(jF1.getText().trim().equals("admin")&&new String(jPasswordField.getPassword()).equals("abcdef")){  //从数据库匹配姓名和学号
            return true;
        }else {
            return false;
        }
    }
    public void actionPerformed(ActionEvent e) {
        String str="123456";   //从数据库换取密码
        textShow.append(str);
    }

    public boolean 用户登录(String a ,String b) {    //  a借阅证，b密码;
        boolean f= db.用户登录(a,b);
        return f;
    }

    public boolean 管理员登录(String a ,String b) {    //  a借阅证，b密码;
        boolean f= db.管理员登录(a,b);
        return f;
    }


    public String 图书浏览(){
        String f= db.图书浏览();
        return f;
    }

    public String 借书列表浏览() {
        String f = db.借书列表浏览();
        return f;
    }



    public boolean 借书 ( String b) { //b图书编号
        boolean f= db.借书(b);
        return f;
    }

    public boolean 还书(String a) {
        boolean f= db.还书(a);
        return f;
    }

    public boolean 添加图书 (String a, String b, String c,int n) {
        boolean f= db.添加图书(a,b,c,n);
        return f;
    }

    public boolean 用户注册(String a,String b,String c,String d) {
        boolean f= db.用户注册(a,b,c,d);
        return f;
    }


    public boolean  增加成员(String a,String b,String c,String d) {
        boolean f= db.增加成员(a,b,c,d);
        return f;
    }

    public boolean  删减成员(String a) {
        boolean f= db.删减成员(a);
        return f;
    }
    public boolean 用户修改密码(String a,String b){
        boolean f= db.用户修改密码(a,b);
        return f;
    }

    public String 用户忘记密码 (String a , String b) {
        String f= db.用户忘记密码(a,b);
        return f;
    }
}
