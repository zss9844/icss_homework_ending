package com.icss.meeting.service;

import com.icss.meeting.dao.EmployeeDao;
import com.icss.meeting.pojo.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDao ed = new EmployeeDao();
    private Employee loginUser;
    public List<Employee> searchEmp(String employeename, String username, int status, int page, int count) {
        return EmployeeDao.searchEmp(employeename, username, status, page, count);
    }
    public boolean login(String username,String password){
        if(ed.getEmpByUserPass(username,password).size() > 0){
            return true;
        }
        return false;
    }
    public int getCount(String employeename, String username, int status) {
        return EmployeeDao.getCount(employeename, username, status);
    }
    public int updateEmpStatusById(int id, int status) {
        return EmployeeDao.updateEmpStatusById(id, status);
    }
    public static int checklogin(String username, String password) {
        int result = 3;//表示登录失败
        Employee loginEmp = EmployeeDao.login(username, password);
        if (loginEmp == null) {
            return result;
        }else{
            this.loginUser = loginEmp;
            return loginEmp.getStatus();
        }
    }
    public static Employee getLoginUser() {
        return loginUser;
    }
}
