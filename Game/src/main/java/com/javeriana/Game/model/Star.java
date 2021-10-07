package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

@Entity
@Table(name = "star")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "star_id")
    private Long starId;

    @Column(name= "star_name")
    private String starName;

    @OneToMany(mappedBy="star")
    @JsonIgnore
    private List<Planet> planets = new ArrayList<>();

    @Column(name= "star_position_x", columnDefinition = "Decimal(10,2) default '100.00'")
    private double starPositionX;

    @Column(name= "star_position_y", columnDefinition = "Decimal(10,2) default '100.00'")
    private double starPositionY;

    @Column(name= "star_position_z", columnDefinition = "Decimal(10,2) default '100.00'")
    private double starPositionZ;


    public Star() {}

    public Star(Long starId, String starName, List<Planet> planets, Long starPositionX, Long starPositionY, Long starPositionZ) {
        this.starId = starId;
        this.starName = starName;
        this.planets = planets;
        this.starPositionX = starPositionX;
        this.starPositionY = starPositionY;
        this.starPositionZ = starPositionZ;

    }
    
    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public double getStarPositionX() {
        return starPositionX;
    }

    public void setStarPositionX(double starPositionX) {
        this.starPositionX = starPositionX;
    }

    public double getStarPositionY() {
        return starPositionY;
    }

    public void setStarPositionY(double starPositionY) {
        this.starPositionY = starPositionY;
    }

    public double getStarPositionZ() {
        return starPositionZ;
    }

    public void setStarPositionZ(double starPositionZ) {
        this.starPositionZ = starPositionZ;
    }
}
