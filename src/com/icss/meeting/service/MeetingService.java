package com.icss.meeting.service;


import com.icss.meeting.pojo.Employee;
import com.icss.meeting.pojo.Meeting;
import com.icss.meeting.dao.EmployeeDao;
import com.icss.meeting.dao.MeetingDao;
import com.icss.meeting.dao.MeetingParticipantsDao;

import java.util.List;

public class MeetingService {
    private MeetingDao meetingDao = new MeetingDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    private MeetingParticipantsDao meetingParticipantsDao = new MeetingParticipantsDao();

    public void insert(Meeting meeting, String[] empids) {
        int insert = meetingDao.insert(meeting);
        meetingParticipantsDao.insert(insert, empids);
    }

    public List<Meeting> searchMeeting(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate, int page, int count) {
        return meetingDao.searchMeeting(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate, page, count);
    }

    public int getCount(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate) {
        return meetingDao.getCount(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate);
    }

    public Meeting getMeetingDetailsByMeetingId(int mid) {
        Meeting meeting = meetingDao.getMeetingById(mid);
        this.emps = employeeDao.getEmpByMeetingId(meeting.getMeetingid());
        return meeting;
    }
    public static List<Meeting> getCanceledMeeting(int empid) {
        return meetingDao.getCanceledMeeting(empid);
    }
    public static List<Meeting> getMeeting7Days(int empid) {
        return meetingDao.getMeeting7Days(empid);
    }
    public List<Meeting> getMyBookingMeeting(int empid) {
        return meetingDao.getMyBookingMeeting(empid);
    }
    public int cancelMeeting(int mid, String reason) {
        return meetingDao.cancelMeeting(mid, reason);
    }
    public List<Meeting> getMyMeeting(int empid) {
        return meetingDao.getMyMeeting(empid);
    }
}

