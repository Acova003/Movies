package com.javaunit3.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class VoteEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "voter_name")
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
