package com.frostmourne.camp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * A donation can be made and traced, this entity represent a donation
 * <p/>
 * Created by jamesRMBP on 04/12/14.
 */
@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date;

    /**
     * the objective of the donation
     */
    private String objective;

    /**
     * the amount of donation
     */
    private int amount;

    /**
     * who donate the money, can be a person or a organization
     */
    @OneToOne
    private User donorsPerson;

    @OneToOne
    private Organization donorsOrganization;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Campsite> receiverCamp;

    public long getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getDonorsPerson() {
        return donorsPerson;
    }

    public void setDonorsPerson(User donorsPerson) {
        this.donorsPerson = donorsPerson;
    }

    public Organization getDonorsOrganization() {
        return donorsOrganization;
    }

    public void setDonorsOrganization(Organization donorsOrganization) {
        this.donorsOrganization = donorsOrganization;
    }

    public Set<Campsite> getReceiverCamp() {
        return receiverCamp;
    }

    public void setReceiverCamp(Set<Campsite> receiverCamp) {
        this.receiverCamp = receiverCamp;
    }
}
