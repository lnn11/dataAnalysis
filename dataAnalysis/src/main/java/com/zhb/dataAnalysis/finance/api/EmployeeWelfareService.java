package com.zhb.dataAnalysis.finance.api;

import java.util.List;
import java.util.Map;


/**
 * @author chunjie.huo
 * @time 2017年3月13日 下午5:25:45
 * 作用:员工福利service
 */
public interface EmployeeWelfareService {
	
	public Map<String, Object> getCompanyProducts(String startDate, String endDate, int currentPage, int pageSize, String employeeNmae, String welfareIndex);

	public Map<String, Object> getWelfareLisit(String startDate, String endDate, int currentPage, int pageSize, String employeeNmae, String welfareIndex);

	public List<Map<String, String>> getEmployeeGift();

	public List<Map<String, String>> getEmployeeGift1(String startDate, String endDate,
													  int i, int j, String employeeNmae, String welfareIndex);

	public void queryEmployee(String startDate, String endDate);

	public void deleteEmployee(String startDate, String endDate);




}
