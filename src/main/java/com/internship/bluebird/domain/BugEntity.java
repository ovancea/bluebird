package com.internship.bluebird.domain;

import com.internship.bluebird.config.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "bug")
public class BugEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "estimation")
    private Integer estimation;
    @Column(name = "userStoryId")
    private Integer userStoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public Integer getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Integer userStoryId) {
        this.userStoryId = userStoryId;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
