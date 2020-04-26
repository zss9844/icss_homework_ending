package com.icss.meeting.dao;

import com.icss.meeting.pojo.Employee;
import com.icss.meeting.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getEmpByUserPass(String username,String password){
        /**
         * DriverManager
         * Connection
         * statement
         * ResultSet
         */

        List<Employee> emps = new ArrayList<>();
        try {
            Connection conn = JDBCUtils.getConn();
            Statement stmt = conn.createStatement();
            String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getInt(1));
                emp.setEmployeeName(rs.getString(2));
                emp.setUserName(rs.getString(3));
                emp.setPhone(rs.getString(4));
                emp.setEmail(rs.getString(5));
                emp.setStatus(rs.getString(6));
                emp.setDepartmentId(rs.getInt(7));
                emp.setPassWord(rs.getString(8));
                emp.setRole(rs.getString(9));
                emps.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }
    public List<Employee> getEmpByMeetingId(int mid) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement("SELECT * FROM employee WHERE employeeid IN(SELECT employeeid FROM meetingparticipants WHERE meetingid=?)");
            ps.setInt(1,mid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getString("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getString("role")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
            JDBCUtils.close(con);
        }
        return list;
    }
    public static int updateEmpStatusById(int id, int status) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement("UPDATE employee set status=? WHERE employeeid=?");
            ps.setInt(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps);
            JDBCUtils.close(con);
        }
        return -1;
    }
    public static List<Employee> searchEmp(String employeename, String username, int status, int page, int count) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT * FROM employee WHERE status=? AND role =2");
        if (employeename != null && !"".equals(employeename)) {
            sb.append(" and employeename=?");
        }
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        sb.append(" limit ?,?");
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, status);
            int index = 2;
            if (employeename != null && !"".equals(employeename)) {
                ps.setString(index++, employeename);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
            }
            ps.setInt(index++, (page - 1) * count);
            ps.setInt(index++, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getString("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getString("role")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
            JDBCUtils.close(con);
        }
        return list;
    }
    public static int getCount(String employeename, String username, int status) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT count(*) FROM employee WHERE status=? AND role =2");
        if (employeename != null && !"".equals(employeename)) {
            sb.append(" and employeename=?");
        }
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, status);
            int index = 2;
            if (employeename != null && !"".equals(employeename)) {
                ps.setString(index++, employeename);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
            JDBCUtils.close(con);
        }
        return -1;
    }
    public static Employee login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement("SELECT * FROM employee WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getString("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
