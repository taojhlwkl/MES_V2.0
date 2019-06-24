package com.jimi.mes_server.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseGpsCoupletestResult<M extends BaseGpsCoupletestResult<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer Id) {
		set("Id", Id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("Id");
	}

	public M setSN(java.lang.String SN) {
		set("SN", SN);
		return (M)this;
	}
	
	public java.lang.String getSN() {
		return getStr("SN");
	}

	public M setIMEI(java.lang.String IMEI) {
		set("IMEI", IMEI);
		return (M)this;
	}
	
	public java.lang.String getIMEI() {
		return getStr("IMEI");
	}

	public M setZhiDan(java.lang.String ZhiDan) {
		set("ZhiDan", ZhiDan);
		return (M)this;
	}
	
	public java.lang.String getZhiDan() {
		return getStr("ZhiDan");
	}

	public M setSoftModel(java.lang.String SoftModel) {
		set("SoftModel", SoftModel);
		return (M)this;
	}
	
	public java.lang.String getSoftModel() {
		return getStr("SoftModel");
	}

	public M setVersion(java.lang.String Version) {
		set("Version", Version);
		return (M)this;
	}
	
	public java.lang.String getVersion() {
		return getStr("Version");
	}

	public M setResult(java.lang.Integer Result) {
		set("Result", Result);
		return (M)this;
	}
	
	public java.lang.Integer getResult() {
		return getInt("Result");
	}

	public M setTesterId(java.lang.String TesterId) {
		set("TesterId", TesterId);
		return (M)this;
	}
	
	public java.lang.String getTesterId() {
		return getStr("TesterId");
	}

	public M setComputer(java.lang.String Computer) {
		set("Computer", Computer);
		return (M)this;
	}
	
	public java.lang.String getComputer() {
		return getStr("Computer");
	}

	public M setTestSetting(java.lang.String TestSetting) {
		set("TestSetting", TestSetting);
		return (M)this;
	}
	
	public java.lang.String getTestSetting() {
		return getStr("TestSetting");
	}

	public M setTestTime(java.util.Date TestTime) {
		set("TestTime", TestTime);
		return (M)this;
	}
	
	public java.util.Date getTestTime() {
		return get("TestTime");
	}

	public M setRemark(java.lang.String Remark) {
		set("Remark", Remark);
		return (M)this;
	}
	
	public java.lang.String getRemark() {
		return getStr("Remark");
	}

}