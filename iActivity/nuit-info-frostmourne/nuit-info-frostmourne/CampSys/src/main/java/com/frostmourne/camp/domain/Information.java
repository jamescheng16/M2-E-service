package com.frostmourne.camp.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Here we create an information entity to represent the message could be posted in application
 * <p/>
 * Created by jamesRMBP on 04/12/14.
 */
@Entity
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private InformationType type;


    //private String type;
    private String content;

    private String image;

    private Date date;

    /**
     * who post the information, can be a person or a organization
     */
    @OneToOne
    private User senderPerson;

    @OneToOne
    private Organization senderOrganization;

    public long getId() {
        return id;
    }


    public InformationType getType() {
        return type;
    }

    public void setType(InformationType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getSenderPerson() {
        return senderPerson;
    }

    public void setSenderPerson(User senderPerson) {
        this.senderPerson = senderPerson;
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }
}
