import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {

    public static void  DB(){

        Connection connection = null;
        Statement statement = null;

        try{
            //String url = "jdbc:mysql://ip:port/db_name";
            String url = "jdbc:postgresql://16.155.194.46:5432/db_test";
            String user = "dbuser";
            String password = "123456";

            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("是否成功链接数据库"+connection);
            String sql = "select * from student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                //取出列值
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sex = resultSet.getString(4);

                System.out.println("学号:"+id+", 姓名:"+name+", 年龄:"+age+", 性别:"+sex);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        DB();
    }

}
