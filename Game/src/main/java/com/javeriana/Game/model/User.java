package com.javeriana.Game.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public enum UserRoles {
        MERCHANT, PILOT, CAPTAIN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private Long userId;

    @Column(name= "user_name")
    private String userName;

    @Column(name= "user_document", nullable = false, unique = true)
    private String userDocument;

    @Column(name= "user_password", nullable = false)
    private String userPassword;

    @Column(name= "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;

    @ManyToOne
    @JoinColumn(name="team_id")
    @JsonIgnore
    private Team team;

    @Column(name = "user_admin", columnDefinition="bit default 0")
    private Boolean userAdmin;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoles userRole) {
        this.userRole = userRole;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(Boolean userAdmin) {
        this.userAdmin = userAdmin;
    }
}
