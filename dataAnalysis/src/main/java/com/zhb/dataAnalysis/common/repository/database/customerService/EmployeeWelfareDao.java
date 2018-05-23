package com.zhb.dataAnalysis.common.repository.database.customerService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhb.dataAnalysis.common.repository.database.model.EmployeeWelfare;

/**
 * @author chunjie.huo
 * @time 2017年3月13日 上午11:44:22
 * 作用:员工福利
 */
@Repository("employeeWelfareDao")
public interface EmployeeWelfareDao {
	
	/**
	 * @param startDate 查询开始时间
	 * @param endDate 查询结束时间
	 * @param company 公司名称
	 * @return List<String>
	 */
	public List<Map<String,Object>> getEmployeeUsers(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String company);
	
	/**
	 * @param createTime 查询开始时间
	 * @param endDate 查询结束时间
	 * @param jobNumber 员工编号
	 * @return List<Map<String,Object>>
	 */
	public List<BigDecimal> getHistoryUsedPoint(@Param("startDate") String createTime, @Param("jobNumber") String jobNumber);

	public List<Map<String, Object>> getEmployeeTotalPoints(@Param("startDate") String startDate, @Param("endDate") String endDate);

	public Map<String, Object> getEmployeeInfo(@Param("userId") String userId, @Param("i") int i, @Param("company") String employeeNmae);

	public void insertEmployeeWelfare(EmployeeWelfare welfare);

	public List<EmployeeWelfare> getEmployeeWelfareList(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String employeeNmae, @Param("welfareName") String welfareName);

	public List<Map<String, String>> getEmployeeGift();

	public List<EmployeeWelfare> getEmployeeWelfare(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String employeeNmae, @Param("welfareName") String welfareName, @Param("page") int currentPage, @Param("rows") int pageSize);

	public Map<String, Object> getEmploySumList(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String employeeNmae, @Param("welfareName") String welfareName);

	public Map<String, Object> getSumSpecial(@Param("startDate") String startDate, @Param("endDate") String endDate);

	public void queryEmployee(@Param("startDate") String startDate, @Param("endDate") String endDate);

//	public void queryEmployee(Map<String, Object> map2);

	public List<Map<String, String>> getEmployeeGift1(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String employeeNmae, @Param("welfareName") String welfareName, @Param("page") int currentPage, @Param("rows") int pageSize);

	public void deleteEmployee(@Param("startDate") String startDate, @Param("endDate") String endDate);

	public Map<String, Object> getUserGiftByOrderNoSoSumPoint(@Param("orderNo") String orderNo, @Param("welfareName") String welfareName);

	int getOldUsePoint(@Param("createTime") String createTime, @Param("employeeNumber") String employeeNumber, @Param("welfareName") String welfareName, @Param("number") Integer number);

    Map<String,BigDecimal> getEmActivityLog(@Param("employeeNo") String employeeNo, @Param("welfareName") String welfareName);

	public List<EmployeeWelfare> getEmployeeWelfareExport(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("company") String employeeNmae, @Param("welfareName") String welfareName);

//	public List<Map<String, Object>> getOrderList(@Param("startDate")String startDate, @Param("endDate")String endDate, @Param("welfareName")String welfareName);
//
//	public Map<String, Object> getUserInfo(@Param("userId")String userId);
//
//	public Map<String, Object> getProductInfo(@Param("orderNo")String orderNo, @Param("productDetailId")String productDetailId);

}
