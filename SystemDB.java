package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SystemDB {
	
	   String ����֤;
			String ����;
			String ѧ��;
			String ����;	
			int ͼ������;
		    String  ͼ����;
		    String ͼ����;
		    String ͼ������;
			Connection con;
			Statement sql;
			ResultSet rs;
			int n ;   //����ͼ��ʱ���ӵ�ͼ������
			String ��ǰ�û� = null;   //��ǰ�û��Ľ���֤
		
			public static final String jdbcName = "org.apache.derby.jdbc.EmbeddedDriver";
			public static Connection conn = null;
			public static final String URL = "jdbc:derby:D://100//lxgc;create=true";
	 		 
	 SystemDB()  {
		 try {
					Class.forName(jdbcName);       //������������
					conn = DriverManager.getConnection(URL); //������ݿ�����
				}catch (Exception e ) {
					System.out.print(e);
				}
		 }

	public boolean �û���¼(String a ,String b) {    //  a����֤��b����;
		try { String c = null;  //���ڻ�ȡ������������
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select ���� from �����˺����ݿ� where ����֤='"+a+"'");
			while (rs.next()) {
				c = rs.getString(1);
			}
			if (b==c) {��ǰ�û�=a;
				return true;}
			else return false;
		}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}

	public boolean ����Ա��¼(String a ,String b) {    //  a����֤��b����;
			try { String c = null;  //���ڻ�ȡ������������
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
			    rs = sql.executeQuery("select ���� from ����Ա�˺����ݿ� where ����֤='"+a+"'");
			    while (rs.next()) {
			    	c = rs.getString(1);
			    }
			   if (b==c) {��ǰ�û�=a;
				   return true;}
			   else return false;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;
			}
		} 
	
	 
	 public String ͼ�����(){
			
			try {
		    String s = null;
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select * from ͼ�����ݿ�");
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
		
	 public String �����б����() {
			try {
				
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select * from �ѽ�ͼ���б�");
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
		
	
	
	 public boolean ���� ( String b) { //bͼ����
			try {
				String a =null,c=null;//��ͼ������cͼ������
				int g=0;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select ͼ������ from ͼ�����ݿ� where ͼ���� = '"+b+"' ");
	            while (rs.next()) {
	                g=rs.getInt(1);
	            }
				if ( g> 0)
				rs = sql.executeQuery("select ͼ���� from ͼ�����ݿ� where ͼ���� ='"+b+"' ");
				while (rs.next()) {
				a = rs.getString(1);				
}
				rs = sql.executeQuery("select ͼ������ from ͼ�����ݿ� where ͼ���� ='"+b+"' ");
				while(rs.next()) {
				c = rs.getString(1);
}
				g=g-1;
				sql.executeUpdate("update ͼ�����ݿ� set ͼ������="+g+"  where ͼ����='"+b+"'");
				sql.execute("insert into  �ѽ�ͼ���б� values('"+b+"','"+a+"','"+c+"')");
				    return true;  }
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
			}	
		
	 public boolean ����(String a) {
			try {
				int g =0;
				//ͼ���� = a; ͼ���� = b; ͼ������ = c;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select ͼ������ from ͼ�����ݿ� where ͼ���� = '"+a+"' "); 
				while(rs.next()) {
					g = rs.getInt(1);
					g=g+1;
					}
				
				sql.executeUpdate("update <ͼ�����ݿ�> set ͼ������= "+g+" where ͼ����='"+a+"'");
				sql.execute("delete from �ѽ�ͼ���б� where ͼ���='"+a+"' ");
				    return true; }
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
		
		public boolean ���ͼ�� (String a, String b, String c,int n) {
           try {				//ͼ���� = a; ͼ���� = b; ͼ������ = c;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				rs = sql.executeQuery("select ͼ������ from ͼ�����ݿ� where ͼ���� = '"+a+"' ");
				
				if (rs.getInt(ͼ������)<=0)
				sql.execute("insert into ͼ�����ݿ� values('"+a+"','"+b+"','"+c+"',"+n+")");
				else sql.executeUpdate("update ͼ�����ݿ� set ͼ������= rs.getInt(ͼ������)+1 where ͼ����='"+b+"'");
				return true;
           }
           catch (SQLException e) {
        	   System.out.print(e);
        	   return false;
        	   
           }
		}

	public boolean �û�ע��(String a,String b,String c,String d) {
		//����֤ = a; ����=b;����=c; ѧ��=d;
		try {
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			sql.execute("insert into �����˺����ݿ� values('"+a+"','"+b+"','"+c+"','"+d+"')");

			return true;
		}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}
		
		
		public boolean  ���ӳ�Ա(String a,String b,String c,String d) {
			try {//����֤ = a; ����=b;����=c; ѧ��=d;
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				sql.execute("insert into �����˺����ݿ� values('"+a+"','"+b+"','"+c+"','"+d+"')");
				return true;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
		
		public boolean  ɾ����Ա(String a) {
			try {//����֤ = a; 
				con = DriverManager.getConnection(URL);
				sql= con.createStatement();
				sql.execute("delete from �����˺����ݿ� where ����֤='"+a+"'");
				return true;
			}
			catch (SQLException e) {
				 System.out.print(e);
				 return false;}
		}
	public boolean �û��޸�����(String a,String b){
		try {
			//a=�����룬b=������
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			sql.executeUpdate("update �����˺����ݿ� set ���� = '"+b+"' where ����֤='"+ ��ǰ�û�+"'");
			return true;}
		catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}

	public String �û��������� (String a , String b) {
		try {String c =null; //�������
			//����=a; ѧ��=b; ����=c;
			con = DriverManager.getConnection(URL);
			sql= con.createStatement();
			rs = sql.executeQuery("select ѧ�� from �����˺����ݿ� where ���� ='"+a+"'");
			while(rs.next()) {
				ѧ��=rs.getString(1);
			}

			if (ѧ��==b) {
				rs = sql.executeQuery("select ���� from �����˺����ݿ� where ���� ='"+a+"'");
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