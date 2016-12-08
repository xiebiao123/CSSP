package com.soshow.ssi.redis.dto;

import java.util.Map;

public class RedisDto extends BaseModel {
	private static final long serialVersionUID = -1959528436584592183L;
	private String keyString;
	private String valueString;
	private Map<Object, Object> valueMap;

	public String getKeyString() {
		return keyString;
	}

	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	public Map<Object, Object> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<Object, Object> valueMap) {
		this.valueMap = valueMap;
	}

}