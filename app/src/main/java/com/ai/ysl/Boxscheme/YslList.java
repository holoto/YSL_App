package com.ai.ysl.Boxscheme;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class YslList {
	
	@Id(assignable = true)
	long id;
	 String name;
	 String pic;
	 Boolean picboolean;
	 String ysllink;
	
	public YslList(){
	
	}
	public YslList(String n,String y,String p,boolean picboolean1){
		name=n;
		pic=p;
		ysllink=y;
		picboolean=picboolean1;
	}
	
	public Boolean getPicboolean() {
		return picboolean;
	}
	
	public void setPicboolean(Boolean picboolean) {
		this.picboolean = picboolean;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPic() {
		return pic;
	}
	
	public String getYsllink() {
		return ysllink;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public void setYsllink(String ysllink) {
		this.ysllink = ysllink;
	}
}
