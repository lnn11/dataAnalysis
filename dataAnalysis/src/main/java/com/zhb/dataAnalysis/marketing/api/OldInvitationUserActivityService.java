package com.zhb.dataAnalysis.marketing.api;

import java.util.Map;

/**
 * Created by LLC on 2017/11/23.
 */
public interface OldInvitationUserActivityService {

    Map<String,Object> getOldInvitationUserActivity(String startTime, String endTime, String activityId);


}
