package cn.edu.hqu.cst.javaee.HuaMent.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class HquerMsg {
	private Long id=0L;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public HquerMsg(String message, Date time) {
		this.id=null;
		this.message = message;
		this.time = time;
		this.latitude = null;
		this.longitude = null;
	}
	public HquerMsg(Long id,String message, Date time, Double latitude, Double longitude) {
		this.id=id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"id","time");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}

}
