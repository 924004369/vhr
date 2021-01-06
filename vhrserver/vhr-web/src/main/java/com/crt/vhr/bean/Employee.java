package com.crt.vhr.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private Integer id;

    private String name;

    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date birthday;

    private String idCard;

    private String wedlock;

    private Integer nationid;

    private String nativeplace;

    private Integer politicid;

    private String email;

    private String phone;

    private String address;

    private Integer departmentid;

    private Integer joblevelid;

    private Integer posid;

    private String engageform;

    private String tiptopdegree;

    private String specialty;

    private String school;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date begindate;

    private String workstate;

    private String workid;

    private Double contractterm;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date conversiontime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date notworkdate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date begincontract;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date endcontract;

    private Integer workage;

    private Department department;
    private JobLevel jobLevel;
    private politicsStatus politicsStatus;
    private Position position;
    private Nation nation;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public com.crt.vhr.bean.politicsStatus getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(com.crt.vhr.bean.politicsStatus politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock == null ? null : wedlock.trim();
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public Integer getPoliticid() {
        return politicid;
    }

    public void setPoliticid(Integer politicid) {
        this.politicid = politicid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getJoblevelid() {
        return joblevelid;
    }

    public void setJoblevelid(Integer joblevelid) {
        this.joblevelid = joblevelid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getEngageform() {
        return engageform;
    }

    public void setEngageform(String engageform) {
        this.engageform = engageform == null ? null : engageform.trim();
    }

    public String getTiptopdegree() {
        return tiptopdegree;
    }

    public void setTiptopdegree(String tiptopdegree) {
        this.tiptopdegree = tiptopdegree == null ? null : tiptopdegree.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate == null ? null : workstate.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public Double getContractterm() {
        return contractterm;
    }

    public void setContractterm(Double contractterm) {
        this.contractterm = contractterm;
    }

    public Date getConversiontime() {
        return conversiontime;
    }

    public void setConversiontime(Date conversiontime) {
        this.conversiontime = conversiontime;
    }

    public Date getNotworkdate() {
        return notworkdate;
    }

    public void setNotworkdate(Date notworkdate) {
        this.notworkdate = notworkdate;
    }

    public Date getBegincontract() {
        return begincontract;
    }

    public void setBegincontract(Date begincontract) {
        this.begincontract = begincontract;
    }

    public Date getEndcontract() {
        return endcontract;
    }

    public void setEndcontract(Date endcontract) {
        this.endcontract = endcontract;
    }

    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationid=" + nationid +
                ", nativeplace='" + nativeplace + '\'' +
                ", politicid=" + politicid +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentid=" + departmentid +
                ", joblevelid=" + joblevelid +
                ", posid=" + posid +
                ", engageform='" + engageform + '\'' +
                ", tiptopdegree='" + tiptopdegree + '\'' +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", begindate=" + begindate +
                ", workstate='" + workstate + '\'' +
                ", workid='" + workid + '\'' +
                ", contractterm=" + contractterm +
                ", conversiontime=" + conversiontime +
                ", notworkdate=" + notworkdate +
                ", begincontract=" + begincontract +
                ", endcontract=" + endcontract +
                ", workage=" + workage +
                ", department=" + department +
                ", jobLevel=" + jobLevel +
                ", politicsStatus=" + politicsStatus +
                ", position=" + position +
                ", nation=" + nation +
                '}';
    }
}