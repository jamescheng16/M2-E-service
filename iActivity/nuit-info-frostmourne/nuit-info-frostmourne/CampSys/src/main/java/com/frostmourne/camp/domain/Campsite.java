package com.frostmourne.camp.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * A campsite is where people live in when war is happened and people should leave their home.
 * <p/>
 * Created by jamesRMBP on 04/12/14.
 */
@Entity
public class Campsite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;

    private long totalBedNb;

    /**
     * who live in this campsite
     */
    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> residents;

    /**
     * who can post information for the campsite
     */
    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> leaders;


    public Campsite() {
    }


    public long getId() {
        return id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTotalBedNb() {
        return totalBedNb;
    }

    public void setTotalBedNb(long totalBedNb) {
        this.totalBedNb = totalBedNb;
    }

    public Set<User> getResidents() {
        return residents;
    }

    public void setResidents(Set<User> residents) {
        this.residents = residents;
    }

    public Set<User> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<User> leaders) {
        this.leaders = leaders;
    }
}
