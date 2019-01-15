package com.robot.schedule;

import com.robot.bean.SpiderStatus;
import com.robot.scrapy.Spider;
import com.robot.scrapy.SpiderManager;
import com.robot.util.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.ConnectException;
import java.util.List;

public class ScheduleTask {

	@Autowired
	private SpiderManager spiderManager;
	/**
	 * 定期调用爬虫
	 * @param
	 */
	public void runSpider()  {
		try {
			LogHelper.scheduleTaskLog.info("启动爬虫...");
			SpiderStatus status = Spider.listprojects();
			if (Spider.isStatusError(status)) {
				if (status != null){
					LogHelper.scheduleTaskLog.error("状态异常：" + status.stackTrace());
				}
				throw new ConnectException("爬虫状态异常");
			}
			if (status.getProjects().contains("OfWeek")) {
				List<SpiderStatus> spiderStatuses = spiderManager.runSpider();
				if (Spider.isStatusError(status)) {
					LogHelper.scheduleTaskLog.error("爬虫状态异常：" + status.stackTrace());
				}
			} else {
				LogHelper.scheduleTaskLog.error("当前项目列表中没有目标爬虫。");
			}
		}catch (ConnectException e){
			LogHelper.scheduleTaskLog.error("连接不上scrapyd服务器！");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
