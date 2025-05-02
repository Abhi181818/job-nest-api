package com.jobnest.dvo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String status;

    private String coverLetter;

    @ManyToOne
    @JsonBackReference("user-applications")
    private User user;

    @ManyToOne
    @JsonBackReference("job-applications")
    private Job job;

    public Application() {
    }

    public Application(String applicantName, String jobTitle, String status, User user, Job job) {
        this.applicantName = applicantName;
        this.jobTitle = jobTitle;
        this.status = status;
        this.user = user;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @JsonProperty("userId")
    public int getUserId() {
        return user != null ? user.getId() : null;
    }

    @JsonProperty("jobId")
    public Long getJobId() {
        return job != null ? job.getId() : null;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", status='" + status + '\'' +
                ", coverLetter='" + coverLetter + '\'' +
                ", user=" + user +
                ", job=" + job +
                '}';
    }
}
