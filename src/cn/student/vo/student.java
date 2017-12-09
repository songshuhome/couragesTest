package cn.student.vo;

import java.util.Date;

public class student  {
    private String sid;
    private String password;
    private String name;
    private String grade;
    private String phone;
    private int statu;
    private int flag;
    private Date lastdate;
    private int  number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getSid() {
        return sid;
    }
    public String getGrade() {
        return grade;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setGrade(String clas) {
        this.grade = clas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}
