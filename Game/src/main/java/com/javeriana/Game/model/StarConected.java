package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "StarConected")
public class StarConected {
   

  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long starConectedId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "StarFrom")
    private Star starFrom;

    @ManyToOne
    @JoinColumn(name = "StarTo")
    private Star starTo;

    public StarConected() {
    }

    public StarConected(Long starConectedId, Star starFrom, Star starTo) {
        this.starConectedId = starConectedId;
        this.starFrom = starFrom;
        this.starTo = starTo;
    }

    public Long getStarConectedId() {
        return starConectedId;
    }

    public void setStarConectedId(Long starConectedId) {
        this.starConectedId = starConectedId;
    }

    public Star getStarFrom() {
        return starFrom;
    }

    public void setStarFrom(Star starFrom) {
        this.starFrom = starFrom;
    }

    public Star getStarTo() {
        return starTo;
    }

    public void setStarTo(Star starTo) {
        this.starTo = starTo;
    }

    
}






