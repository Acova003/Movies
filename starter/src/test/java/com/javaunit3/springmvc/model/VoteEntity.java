package com.javaunit3.springmvc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voter_id")
    private Integer id;

    @Column(name = "voter_Name")
    private String voterName;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getVoterName(){
        return voterName;
    }

    public void setVoterName(String voterName){
        this.voterName = voterName;
    }
}
