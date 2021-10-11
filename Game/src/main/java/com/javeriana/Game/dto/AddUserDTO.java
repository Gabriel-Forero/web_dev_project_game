package com.javeriana.Game.dto;

import com.javeriana.Game.model.Team;
import com.javeriana.Game.model.User;

public class AddUserDTO {

	private String userName;

	private String userDocument;

	private String userPassword;

	private User.UserRoles userRole;

	private Boolean userAdmin;

	private Long teamId;

	public Boolean getUserAdmin() {

		return userAdmin;
	}

	public void setUserAdmin(final Boolean userAdmin) {

		this.userAdmin = userAdmin;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(final String userName) {

		this.userName = userName;
	}

	public String getUserDocument() {

		return userDocument;
	}

	public void setUserDocument(final String userDocument) {

		this.userDocument = userDocument;
	}

	public String getUserPassword() {

		return userPassword;
	}

	public void setUserPassword(final String userPassword) {

		this.userPassword = userPassword;
	}

	public User.UserRoles getUserRole() {

		return userRole;
	}

	public void setUserRole(final User.UserRoles userRole) {

		this.userRole = userRole;
	}

	public Long getTeamId() {

		return teamId;
	}

	public void setTeamId(final Long teamId) {

		this.teamId = teamId;
	}

	public Team getTeam() {

		return team;
	}

	public void setTeam(final Team team) {

		this.team = team;
	}

	private Team team;
}
