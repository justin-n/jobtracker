package com.jobtracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name="job_time")
public class JobTime {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="job_time_id")
    private Long id;

    @Column(name="jt_user", length=32, nullable=false)
    private String user;

    @Column(name="job_name", nullable=false)
    private String jobName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_in", nullable=false)
    private Date timeIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_out", nullable=false)
    private Date timeOut;

    @Column(name="comment")
    private String comment;

    public JobTime() { }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getJobName() {
        return jobName;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
