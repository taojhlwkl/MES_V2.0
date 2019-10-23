package com.jimi.mes_server.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;
import com.jimi.mes_server.annotation.Access;
import com.jimi.mes_server.entity.Constant;
import com.jimi.mes_server.entity.SopFileState;
import com.jimi.mes_server.entity.vo.LUserAccountVO;
import com.jimi.mes_server.exception.OperationException;
import com.jimi.mes_server.exception.ParameterException;
import com.jimi.mes_server.service.SopService;
import com.jimi.mes_server.util.CommonUtil;
import com.jimi.mes_server.util.ResultUtil;
import com.jimi.mes_server.util.TokenBox;

public class SopController extends Controller {

	private static SopService sopService = Enhancer.enhance(SopService.class);


	@Access({ "SopManager" })
	public void addFactory(String factoryAlias, String abbreviation, String fullName) {
		if (StringUtils.isAnyBlank(factoryAlias, abbreviation, fullName)) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.addFactory(factoryAlias, abbreviation, fullName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteFactory(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteFactory(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectFactory(Integer pageNo, Integer pageSize, String factoryAlias, String abbreviation, String fullName) {
		renderJson(ResultUtil.succeed(sopService.selectFactory(pageNo, pageSize, factoryAlias, abbreviation, fullName)));
	}


	@Access({ "SopManager" })
	public void editFactory(Integer id, String factoryAlias, String abbreviation, String fullName) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editFactory(id, factoryAlias, abbreviation, fullName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void addWorkshop(Integer factoryId, String workshopNumber, String workshopName) {
		if (factoryId == null || StringUtils.isAnyBlank(workshopNumber, workshopName)) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.addWorkshop(factoryId, workshopNumber, workshopName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteWorkshop(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteWorkshop(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectWorkshop(Integer pageNo, Integer pageSize, Integer factoryId, String workshopNumber, String workshopName) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectWorkshop(pageNo, pageSize, factoryId, workshopNumber, workshopName)));
	}


	@Access({ "SopManager" })
	public void editWorkshop(Integer id, Integer factoryId, String workshopNumber, String workshopName) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editWorkshop(id, factoryId, workshopNumber, workshopName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void addSite(String siteNumber, String siteName, Integer processOrder, Integer lineId, Integer playTimes, Integer switchInterval, String mac) {
		if (processOrder == null || lineId == null || switchInterval == null || StringUtils.isAnyBlank(siteNumber, siteName, mac)) {
			throw new ParameterException("参数不能为空");
		}
		if (!CommonUtil.isMac(mac)) {
			throw new ParameterException("MAC地址无效");
		}
		if (sopService.addSite(siteNumber, siteName, processOrder, lineId, playTimes, switchInterval, mac)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteSite(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteSite(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectSite(Integer pageNo, Integer pageSize, String siteNumber, String siteName, Integer processOrder, Integer lineId) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectSite(pageNo, pageSize, siteNumber, siteName, processOrder, lineId)));
	}


	@Access({ "SopManager" })
	public void editSite(Integer id, String siteNumber, String siteName, Integer processOrder, Integer lineId, Integer playTimes, Integer switchInterval, String mac) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editSite(id, siteNumber, siteName, processOrder, lineId, playTimes, switchInterval, mac)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void addCustomer(String customerNumber, String customerName, Integer factoryId) {
		if (factoryId == null || StringUtils.isAnyBlank(customerNumber, customerName)) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.addCustomer(customerNumber, customerName, factoryId)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteCustomer(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteCustomer(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectCustomer(Integer pageNo, Integer pageSize, String customerNumber, String customerName, Integer factoryId) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectCustomer(pageNo, pageSize, customerNumber, customerName, factoryId)));
	}


	@Access({ "SopManager" })
	public void editCustomer(Integer id, String customerNumber, String customerName, Integer factoryId) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editCustomer(id, customerNumber, customerName, factoryId)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void addSeriesModel(String seriesModelName) {
		if (StrKit.isBlank(seriesModelName)) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.addSeriesModel(seriesModelName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteSeriesModel(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteSeriesModel(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectSeriesModel(Integer pageNo, Integer pageSize, String seriesModelName) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectSeriesModel(pageNo, pageSize, seriesModelName)));
	}


	@Access({ "SopManager" })
	public void editSeriesModel(Integer id, String seriesModelName) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editSeriesModel(id, seriesModelName)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void addProductModel(String productModelName, Integer seriesModelId) {
		if (StrKit.isBlank(productModelName) || seriesModelId == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.addProductModel(productModelName, seriesModelId)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteProductModel(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteProductModel(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectProductModel(Integer pageNo, Integer pageSize, String productModelName, Integer seriesModelId) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectProductModel(pageNo, pageSize, productModelName, seriesModelId)));
	}


	@Access({ "SopManager" })
	public void editProductModel(Integer id, String productModelName, Integer seriesModelId) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.editProductModel(id, productModelName, seriesModelId)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void importFiles() {
		List<UploadFile> uploadFiles = getFiles();
		if (uploadFiles == null || uploadFiles.isEmpty()) {
			throw new ParameterException("请添加文件");
		}
		for (UploadFile uploadFile : uploadFiles) {
			if (!uploadFile.getOriginalFileName().endsWith(".xls") && !uploadFile.getOriginalFileName().endsWith(".xlsx")) {
				throw new ParameterException("只能上传Excel文件");
			}
		}
		if (sopService.importFiles(uploadFiles)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteFile(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteFile(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectFiles(Integer pageNo, Integer pageSize, String fileNumber, String fileName, String version, String customer, String seriesModel, String productModel, String reviewer, String state, String startTime, String endTime) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectFiles(pageNo, pageSize, fileNumber, fileName, version, customer, seriesModel, productModel, reviewer, state, startTime, endTime)));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectFilePictures(Integer pageNo, Integer pageSize, Integer fileId) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		if (fileId == null) {
			throw new ParameterException("参数不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.selectFilePictures(pageNo, pageSize, fileId)));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void editFileState(Integer id, String state) {
		if (id == null || StrKit.isBlank(state)) {
			throw new ParameterException("参数不能为空");
		}
		if (!state.equals(SopFileState.REVIEWED_STATE.getName()) || !state.equals(SopFileState.INVALID_STATE.getName())) {
			throw new OperationException("无效的状态修改操作");
		}
		String tokenId = getPara(TokenBox.TOKEN_ID_KEY_NAME);
		LUserAccountVO userVO = TokenBox.get(tokenId, UserController.SESSION_KEY_LOGIN_USER);
		if (state.equals(SopFileState.REVIEWED_STATE.getName()) && "SopManager".equals(userVO.getTypeName())) {
			throw new ParameterException("当前角色无法审核文件");
		}
		if (sopService.editFileState(id, state, userVO)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void downloadFile(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		CommonUtil.downloadFile(sopService.downloadFile(id), getResponse());
		renderNull();
	}


	@Access({ "SopManager" })
	public void downloadPicture(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		CommonUtil.downloadFile(sopService.downloadPicture(id), getResponse());
		renderNull();
	}


	@Access({ "SopManager" })
	public void addNotice(String title, String content, String startTime, String endTime) {
		if (StringUtils.isAnyBlank(title, content)) {
			throw new ParameterException("参数不能为空");
		}
		Map<String, Date> timeMap = getStartAndEndTime(startTime, endTime);
		if (sopService.addNotice(title, content, timeMap.get("start"), timeMap.get("end"))) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopManager" })
	public void deleteNotice(Integer id) {
		if (id == null) {
			throw new ParameterException("参数不能为空");
		}
		if (sopService.deleteNotice(id)) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectNotice(Integer pageNo, Integer pageSize, String title, String content, String startTimeFrom, String startTimeTo, String endTimeFrom, String endTimeTo, Boolean isAllSite) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectNotice(pageNo, pageSize, title, content, startTimeFrom, startTimeTo, endTimeFrom, endTimeTo, isAllSite)));
	}


	@Access({ "SopManager" })
	public void editNotice(Integer id, String title, String content, String startTime, String endTime) {
		if (id == null || StringUtils.isAnyBlank(title, content)) {
			throw new ParameterException("参数不能为空");
		}
		Map<String, Date> timeMap = getStartAndEndTime(startTime, endTime);
		if (sopService.editNotice(id, title, content, timeMap.get("start"), timeMap.get("end"))) {
			renderJson(ResultUtil.succeed());
		} else {
			renderJson(ResultUtil.failed());
		}
	}


	/**@author HCJ
	 * 查询接口日志
	 * @param currentPage 当前页
	 * @param pageSize 页大小
	 * @param ascBy 以哪个字段增序
	 * @param descBy 以哪个字段降序
	 * @param filter 查询条件
	 * @date 2019年9月24日 下午3:26:34
	 */
	@Access({ "SopReviewer", "SopManager" })
	public void selectActionLog(Integer pageNo, Integer pageSize, String ascBy, String descBy, String filter) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectActionLog(pageNo, pageSize, ascBy, descBy, filter)));
	}


	private Map<String, Date> getStartAndEndTime(String startTime, String endTime) {
		Map<String, Date> map = Collections.synchronizedMap(new HashMap<String, Date>());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = null;
		Date end = null;
		if (startTime != null && endTime != null) {
			try {
				start = dateFormat.parse(startTime);
				end = dateFormat.parse(endTime);
			} catch (ParseException e) {
				throw new ParameterException("时间格式出错");
			}
			if (start.compareTo(end) >= Constant.INTEGER_ZERO) {
				throw new ParameterException("开始时间不能晚于或者等于结束时间");
			}
		}
		map.put("start", start);
		map.put("end", end);
		return map;
	}


	public void addFaceInformation(String userName, String feature) {
		if (StringUtils.isAnyBlank(userName, feature)) {
			throw new OperationException("用户名和人脸特征不能为空");
		}
		if (sopService.addFaceInformation(userName, feature)) {
			renderJson(ResultUtil.succeed("保存成功"));
		} else {
			renderJson(ResultUtil.failed(412, "保存失败"));
		}
	}


	public void getFaceInformation() {
		renderJson(ResultUtil.succeed(sopService.getFaceInformation()));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectLoginLog(Integer pageNo, Integer pageSize, String startTime, String endTime, String userName, String siteNumber, String type) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectLoginLog(pageNo, pageSize, startTime, endTime, userName, siteNumber, type)));
	}


	@Access({ "SopManager" })
	public void dispatchFile(String list) throws Exception {
		if (StrKit.isBlank(list)) {
			throw new OperationException("参数不能为空");
		}
		String tokenId = getPara(TokenBox.TOKEN_ID_KEY_NAME);
		LUserAccountVO userVO = TokenBox.get(tokenId, UserController.SESSION_KEY_LOGIN_USER);
		renderJson(sopService.dispatchFile(list, userVO));
	}


	@Access({ "SopManager" })
	public void recycleFile(String id) throws Exception {
		if (StrKit.isBlank(id)) {
			throw new OperationException("参数不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.recycleFile(id)));
	}


	@Access({ "SopManager" })
	public void previewSite(Integer id) throws Exception {
		if (id == null) {
			throw new OperationException("参数不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.previewSite(id)));
	}


	@Access({ "SopManager" })
	public void previewDispatchingFile(String list) throws Exception {
		if (StrKit.isBlank(list)) {
			throw new OperationException("参数不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.previewDispatchingFile(list)));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectFileHistory(Integer pageNo, Integer pageSize, Integer fileId, String startTime, String endTime, String pushPerson) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		if (fileId == null) {
			throw new ParameterException("文件ID不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.selectFileHistory(pageNo, pageSize, fileId, startTime, endTime, pushPerson)));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectFileHistoryDetail(Integer fileHistoryId) {
		if (fileHistoryId == null) {
			throw new ParameterException("文件历史ID不能为空");
		}
		renderJson(ResultUtil.succeed(sopService.selectFileHistoryDetail(fileHistoryId)));
	}


	@Access({ "SopReviewer", "SopManager" })
	public void selectNoticeHistory(Integer pageNo, Integer pageSize, String siteNumber, String siteName, String line, String workshop, String factory, String startTime, String endTime, String title, String content, String pushPerson) {
		if (pageNo == null || pageSize == null) {
			throw new ParameterException("页码和页大小不能为空");
		}
		if (pageNo <= 0 || pageSize <= 0) {
			throw new ParameterException("页码与页大小均需要大于0");
		}
		renderJson(ResultUtil.succeed(sopService.selectNoticeHistory(pageNo, pageSize, siteNumber, siteName, line, workshop, factory, startTime, endTime, title, content, pushPerson)));
	}

}
