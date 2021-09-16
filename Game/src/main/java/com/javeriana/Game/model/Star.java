package com.javeriana.Game.model;
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
    @JsonManagedReference
    private List<Planet> planets = new ArrayList<>();

    @Column(name= "star_position_x", columnDefinition = "Decimal(10,2) default '000.00000'")
    private Long starPositionX;

    @Column(name= "star_position_y", columnDefinition = "Decimal(10,2) default '000.00000'")
    private Long starPositionY;

    @Column(name= "star_position_z", columnDefinition = "Decimal(10,2) default '000.00000'")
    private Long starPositionZ;


    @OneToMany
    @JoinTable(name="star_connection",
            joinColumns=@JoinColumn(name="star_id"),
            inverseJoinColumns=@JoinColumn(name="connected_star")
    )
    private List<Star> connectedStars;

    @OneToMany
    @JoinTable(name="star_connection",
            joinColumns=@JoinColumn(name="star_id"),
            inverseJoinColumns=@JoinColumn(name="star_of")
    )
    @JsonManagedReference
    private List<Star> connectedStarFrom;

    public Star() {}

    public Star(Long starId, String starName, List<Planet> planets, Long starPositionX, Long starPositionY, Long starPositionZ, List<Star> connectedStars, List<Star> connectedStarFrom) {
        this.starId = starId;
        this.starName = starName;
        this.planets = planets;
        this.starPositionX = starPositionX;
        this.starPositionY = starPositionY;
        this.starPositionZ = starPositionZ;
        this.connectedStars = connectedStars;
        this.connectedStarFrom = connectedStarFrom;
    }

    public List<Star> getConnectedStars() {
        return connectedStars;
    }

    public void setConnectedStars(List<Star> connectedStars) {
        this.connectedStars = connectedStars;
    }

    public List<Star> getConnectedStarFrom() {
        return connectedStarFrom;
    }

    public void setConnectedStarFrom(List<Star> connectedStarFrom) {
        this.connectedStarFrom = connectedStarFrom;
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

    public Long getStarPositionX() {
        return starPositionX;
    }

    public void setStarPositionX(Long starPositionX) {
        this.starPositionX = starPositionX;
    }

    public Long getStarPositionY() {
        return starPositionY;
    }

    public void setStarPositionY(Long starPositionY) {
        this.starPositionY = starPositionY;
    }

    public Long getStarPositionZ() {
        return starPositionZ;
    }

    public void setStarPositionZ(Long starPositionZ) {
        this.starPositionZ = starPositionZ;
    }
}
