package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SystemDB {
	
	   String 借阅证;
			String 姓名;
			String 学号;
			String 密码;	
			int 图书数量;
		    String  图书名;
		    String 图书编号;
		    String 图书类型;
			Connection con;
			Statement sql;
			ResultSet rs;
			int n ;   //操作图书时增加的图书数量
			String 当前用户 = null;   //当前用户的借阅证
		
			public static final String jdbcName = "org.apache.derby.jdbc.EmbeddedDriver";
			public static Connection conn = null;
			public static final String URL = "jdbc:derby:D://100//lxgc;create=true";
	 		 
	 SystemDB()  {
		 try {
					Class.forName(jdbcName);       //加载驱动程序
					conn = DriverManager.getConnection(URL); //获得数据库连接
				}catch (Exception e ) {
					System.out.print(e);
				}
		 }

	public boolean 用户登录(String a ,String b) {    //  a借阅证，b密码;
		try { String c = null;  //用于获取检索出的密码
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select 密码 from 读者账号数据库 where 借阅证='"+a+"'");
			while (rs.next()) {
				c = rs.getString(1);
			}
			if (b==c) {当前用户=a;
				return true;}
			else return false;
		}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}

	public boolean 管理员登录(String a ,String b) {    //  a借阅证，b密码;
			try { String c = null;  //用于获取检索出的密码
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
			    rs = sql.executeQuery("select 密码 from 管理员账号数据库 where 借阅证='"+a+"'");
			    while (rs.next()) {
			    	c = rs.getString(1);
			    }
			   if (b==c) {当前用户=a;
				   return true;}
			   else return false;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;
			}
		} 
	
	 
	 public String 图书浏览(){
			
			try {
		    String s = null;
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select * from 图书数据库");
			int count = rs.getMetaData().getColumnCount();
         while(rs.next()){
             for(int i=1;i<=count;i++){
             	 s+=rs.getString(i);
                  if(i<count){
                    s+=" ";
                  }
             }
                    s+="/n"; }
         return s;}
         catch (SQLException e) {
				 System.out.print(e);
				 return null ;
			}			
		}
		
	 public String 借书列表浏览() {
			try {
				
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select * from 已借图书列表");
				String s=null;
				int count = rs.getMetaData().getColumnCount();
	            while(rs.next()){
	                for(int i=1;i<=count;i++){
	                     System.out.print(rs.getString(i));
	                      s += rs.getString(i);
	                     if(i<count){
	                    	 s += " ";
	                        
	                     }
	                }
	                s+="/n";}
	            return s;}
	            catch (SQLException e) {
					 System.out.print(e);
					 return null;
				}	
			}
		
	
	
	 public boolean 借书 ( String b) { //b图书编号
			try {
				String a =null,c=null;//啊图书名，c图书类型
				int g=0;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select 图书数量 from 图书数据库 where 图书编号 = '"+b+"' ");
	            while (rs.next()) {
	                g=rs.getInt(1);
	            }
				if ( g> 0)
				rs = sql.executeQuery("select 图书名 from 图书数据库 where 图书编号 ='"+b+"' ");
				while (rs.next()) {
				a = rs.getString(1);				
}
				rs = sql.executeQuery("select 图书类型 from 图书数据库 where 图书名 ='"+b+"' ");
				while(rs.next()) {
				c = rs.getString(1);
}
				g=g-1;
				sql.executeUpdate("update 图书数据库 set 图书数量="+g+"  where 图书名='"+b+"'");
				sql.execute("insert into  已借图书列表 values('"+b+"','"+a+"','"+c+"')");
				    return true;  }
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
			}	
		
	 public boolean 还书(String a) {
			try {
				int g =0;
				//图书编号 = a; 图书名 = b; 图书类型 = c;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select 图书数量 from 图书数据库 where 图书编号 = '"+a+"' "); 
				while(rs.next()) {
					g = rs.getInt(1);
					g=g+1;
					}
				
				sql.executeUpdate("update <图书数据库> set 图书数量= "+g+" where 图书编号='"+a+"'");
				sql.execute("delete from 已借图书列表 where 图书号='"+a+"' ");
				    return true; }
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
		
		public boolean 添加图书 (String a, String b, String c,int n) {
           try {				//图书编号 = a; 图书名 = b; 图书类型 = c;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select 图书数量 from 图书数据库 where 图书编号 = '"+a+"' ");
				
				if (rs.getInt(图书数量)<=0)
				sql.execute("insert into 图书数据库 values('"+a+"','"+b+"','"+c+"',"+n+")");
				else sql.executeUpdate("update 图书数据库 set 图书数量= rs.getInt(图书数量)+1 where 图书名='"+b+"'");
				return true;
           }
           catch (SQLException e) {
        	   System.out.print(e);
        	   return false;
        	   
           }
		}

	public boolean 用户注册(String a,String b,String c,String d) {
		//借阅证 = a; 密码=b;姓名=c; 学号=d;
		try {
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			sql.execute("insert into 读者账号数据库 values('"+a+"','"+b+"','"+c+"','"+d+"')");

			return true;
		}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}
		
		
		public boolean  增加成员(String a,String b,String c,String d) {
			try {//借阅证 = a; 密码=b;姓名=c; 学号=d;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				sql.execute("insert into 读者账号数据库 values('"+a+"','"+b+"','"+c+"','"+d+"')");
				return true;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
		
		public boolean  删减成员(String a) {
			try {//借阅证 = a; 
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				sql.execute("delete from 读者账号数据库 where 借阅证='"+a+"'");
				return true;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
	public boolean 用户修改密码(String a,String b){
		try {
			//a=旧密码，b=新密码
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			sql.executeUpdate("update 读者账号数据库 set 密码 = '"+b+"' where 借阅证='"+ 当前用户+"'");
			return true;}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}

	public String 用户忘记密码 (String a , String b) {
		try {String c =null; //存放密码
			//姓名=a; 学号=b; 密码=c;
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select 学号 from 读者账号数据库 where 姓名 ='"+a+"'");
			while(rs.next()) {
				学号=rs.getString(1);
			}

			if (学号==b) {
				rs = sql.executeQuery("select 密码 from 读者账号数据库 where 姓名 ='"+a+"'");
				while(rs.next()) {
					c = rs.getString(1);
				}
				return c;
			}
			else return null;
		}
		catch (SQLException e) {
			System.out.print(e);
			return null; }
	}
}