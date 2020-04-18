package com.vicky.apps.datapoints.ui.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Issue extends BaseResponse {




	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("title")
	private String title;







	@SerializedName("number")
	private int number;



	@SerializedName("updated_at")
	private String updatedAt;



	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private String state;



	@SerializedName("locked")
	private boolean locked;

	@SerializedName("user")
	private User user;

	@SerializedName("node_id")
	private String nodeId;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
}