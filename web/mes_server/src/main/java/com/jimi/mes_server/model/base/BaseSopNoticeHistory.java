package com.jimi.mes_server.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseSopNoticeHistory<M extends BaseSopNoticeHistory<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setSiteNumber(java.lang.String siteNumber) {
		set("site_number", siteNumber);
		return (M)this;
	}
	
	public java.lang.String getSiteNumber() {
		return getStr("site_number");
	}

	public M setSiteName(java.lang.String siteName) {
		set("site_name", siteName);
		return (M)this;
	}
	
	public java.lang.String getSiteName() {
		return getStr("site_name");
	}

	public M setLine(java.lang.String line) {
		set("line", line);
		return (M)this;
	}
	
	public java.lang.String getLine() {
		return getStr("line");
	}

	public M setWorkshop(java.lang.String workshop) {
		set("workshop", workshop);
		return (M)this;
	}
	
	public java.lang.String getWorkshop() {
		return getStr("workshop");
	}

	public M setFactory(java.lang.String factory) {
		set("factory", factory);
		return (M)this;
	}
	
	public java.lang.String getFactory() {
		return getStr("factory");
	}

	public M setPushTime(java.util.Date pushTime) {
		set("push_time", pushTime);
		return (M)this;
	}
	
	public java.util.Date getPushTime() {
		return get("push_time");
	}

	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
	}

	public M setContent(java.lang.String content) {
		set("content", content);
		return (M)this;
	}
	
	public java.lang.String getContent() {
		return getStr("content");
	}

	public M setPushPerson(java.lang.String pushPerson) {
		set("push_person", pushPerson);
		return (M)this;
	}
	
	public java.lang.String getPushPerson() {
		return getStr("push_person");
	}

}
