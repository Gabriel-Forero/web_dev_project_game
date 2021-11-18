package com.javeriana.Game.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public enum UserRoles {
        MERCHANT, PILOT, CAPTAIN, ADMIN;
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

    @Column(name= "user_role")
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

    @Override public boolean equals(final Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getUserName(), user.getUserName())
                && Objects.equals(getUserDocument(), user.getUserDocument()) && Objects.equals(getUserPassword(),
                                                                                               user.getUserPassword())
                && getUserRole() == user.getUserRole() && Objects.equals(getTeam(), user.getTeam()) && Objects.equals(
                getUserAdmin(), user.getUserAdmin());
    }

    @Override public int hashCode() {

        return Objects.hash(getUserId(), getUserName(), getUserDocument(), getUserPassword(), getUserRole(), getTeam(), getUserAdmin());
    }

    @Override public String toString() {

        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userDocument='" + userDocument + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                ", team=" + team +
                ", userAdmin=" + userAdmin +
                '}';
    }
}
