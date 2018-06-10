package com.restassured.common;

public interface CommonRecord {
	
	/*
	 *  "createdUserId": {"type": "string"},
      "createdTms": {"type": "string"},
      "modifiedUserId": {"type": "string"},
      "modifiedTms": {"type": "string"},
	 */

	public String getCreatedUserId();

	public void setCreatedUserId(String createdUserId);

	public String getCreatedTms();

	public void setCreatedTms(String createdTms);

	public String getModifiedUserId();

	public void setModifiedUserId(String modifiedUserId);

	public String getModifiedTms();

	public void setModifiedTms(String modifiedTms);
}
