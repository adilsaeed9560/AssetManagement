package com.adil.assetmanagement.model;

import java.util.Date;
import com.adil.assetmanagement.dao.model.AssignmentStatus;

public class Asset {

	String name;
	String assetId;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	Date date;
	String conditionNotes;
	Category category;
	AssignmentStatus assignmentStatus;

	@Override
	public String toString() {
		return "Asset [name=" + name + ", date=" + date + ", conditionNotes=" + conditionNotes + ", category="
				+ category + ", assignmentStatus=" + assignmentStatus + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getConditionNotes() {
		return conditionNotes;
	}
	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public AssignmentStatus getAssignmentStatus() {
		return assignmentStatus;
	}
	public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignmentStatus == null) ? 0 : assignmentStatus.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((conditionNotes == null) ? 0 : conditionNotes.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		if (assignmentStatus != other.assignmentStatus)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (conditionNotes == null) {
			if (other.conditionNotes != null)
				return false;
		} else if (!conditionNotes.equals(other.conditionNotes))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
