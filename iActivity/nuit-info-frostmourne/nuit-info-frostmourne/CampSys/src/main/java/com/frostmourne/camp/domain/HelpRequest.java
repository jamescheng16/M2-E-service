package com.frostmourne.camp.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * A help request is a people who need to find help
 * <p/>
 * Created by jamesRMBP on 04/12/14.
 */
@Entity
public class HelpRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * who wants to help
     */
    @OneToOne
    private User author;

    /**
     * which kind of help request
     */
    @Enumerated(EnumType.STRING)
    private HelpRequestType type;


    //private String type;

    private Date date;

    private String description;

    public HelpRequest() {
    }

    public long getId() {
        return id;
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public HelpRequestType getType() {
        return type;
    }

    public void setType(HelpRequestType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
