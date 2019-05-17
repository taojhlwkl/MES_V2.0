package com.jimi.mes_report.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseActionLog<M extends BaseActionLog<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setIp(java.lang.String ip) {
		set("ip", ip);
		return (M)this;
	}
	
	public java.lang.String getIp() {
		return getStr("ip");
	}

	public M setUrl(java.lang.String url) {
		set("url", url);
		return (M)this;
	}
	
	public java.lang.String getUrl() {
		return getStr("url");
	}

	public M setParameters(java.lang.String parameters) {
		set("parameters", parameters);
		return (M)this;
	}
	
	public java.lang.String getParameters() {
		return getStr("parameters");
	}

	public M setAction(java.lang.String action) {
		set("action", action);
		return (M)this;
	}
	
	public java.lang.String getAction() {
		return getStr("action");
	}

	public M setTime(java.util.Date time) {
		set("time", time);
		return (M)this;
	}
	
	public java.util.Date getTime() {
		return get("time");
	}

	public M setResultCode(java.lang.Integer resultCode) {
		set("result_code", resultCode);
		return (M)this;
	}
	
	public java.lang.Integer getResultCode() {
		return getInt("result_code");
	}

}