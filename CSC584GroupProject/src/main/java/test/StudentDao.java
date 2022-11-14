package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class StudentDao {

    public ArrayList<StudentBean> getStudent() {
        ArrayList<StudentBean> list_student = new ArrayList<>();
        final String url = "jdbc:mysql:/csc584";
	      final String user = "root";
	      final String password = "p@ssw0rd1234";
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
        	con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM service");
            while(resultSet.next()){
            	String id = resultSet.getString("serviceID");
                String name = resultSet.getString("serviceName");
                StudentBean studentBean = new StudentBean(name, id);

                list_student.add(studentBean);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list_student;
    }
}