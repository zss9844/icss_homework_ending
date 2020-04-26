package com.icss.meeting.dao;

import com.icss.meeting.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MeetingParticipantsDao {
    public void insert(int meetingid, String[] empids) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtils.getConn();
            ps = con.prepareStatement("insert into meetingparticipants (meetingid,employeeid) values (?,?);");
            for (String empid : empids) {
                ps.setInt(1, meetingid);
                ps.setInt(2, Integer.parseInt(empid));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps);
            JDBCUtils.close(con);
        }
    }
}
