package com.javaunit3.springmvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "maturity_rating")
    private String maturityRating;

    @Column(name = "genre")
    private String genre;
    
    public String getMaturityRating(){
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating){
        this.maturityRating = maturityRating;
    }
    
}
