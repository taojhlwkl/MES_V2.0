package com.jimi.mes_server.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("daily_completion", "id", DailyCompletion.class);
		arp.addMapping("DataRelativeSheet", "IMEI1", DataRelativeSheet.class);
		arp.addMapping("DataRelativeUnique", "DATA1", DataRelativeUnique.class);
		arp.addMapping("file_type", "id", FileType.class);
		arp.addMapping("Gps_AutoTest_AntiDup", "SN", GpsAutotestAntidup.class);
		arp.addMapping("Gps_AutoTest_Result", "Id", GpsAutotestResult.class);
		arp.addMapping("Gps_AutoTest_Result2", "Id", GpsAutotestResult2.class);
		arp.addMapping("Gps_AutoTest_Result3", "Id", GpsAutotestResult3.class);
		arp.addMapping("Gps_CartonBoxTwenty_Result", "Id", GpsCartonboxtwentyResult.class);
		arp.addMapping("Gps_CoupleTest_Result", "Id", GpsCoupletestResult.class);
		arp.addMapping("Gps_ManuCpParam", "ID", GpsManucpparam.class);
		arp.addMapping("Gps_ManuOrderParam", "Id", GpsManuorderparam.class);
		arp.addMapping("Gps_ManuPrintParam", "ID", GpsManuprintparam.class);
		arp.addMapping("Gps_ManuSimDataParam", "ID", GpsManusimdataparam.class);
		arp.addMapping("Gps_TestResult", "Id", GpsTestresult.class);
		arp.addMapping("line", "id", Line.class);
		arp.addMapping("LUserAccount", "Id", LUserAccount.class);
		arp.addMapping("model_capacity", "id", ModelCapacity.class);
		arp.addMapping("order_file", "id", OrderFile.class);
		arp.addMapping("order_status", "id", OrderStatus.class);
		arp.addMapping("orders", "id", Orders.class);
		arp.addMapping("process", "id", Process.class);
		arp.addMapping("process_group", "id", ProcessGroup.class);
		arp.addMapping("scheduling_plan", "id", SchedulingPlan.class);
		arp.addMapping("scheduling_plan_status", "id", SchedulingPlanStatus.class);
		arp.addMapping("WebUserType", "TypeId", WebUserType.class);
	}
}
