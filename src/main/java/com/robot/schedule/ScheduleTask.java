package com.robot.schedule;

import com.robot.bean.SpiderStatus;
import com.robot.scrapy.Spider;
import com.robot.scrapy.SpiderManager;

import java.net.ConnectException;
import java.util.List;

public class ScheduleTask {

	/**
	 * 定期调用爬虫
	 * @param
	 */
	public void runSpider()  {
		try {
			System.out.println("启动爬虫...");
			SpiderStatus status = Spider.listprojects();
			if (Spider.isStatusError(status)) {
				if (status != null){
					System.out.println("状态异常：" + status.stackTrace());
				}
				throw new ConnectException("爬虫状态异常");
			}
			if (status.getProjects().contains("robot")) {
				List<SpiderStatus> spiderStatuses = SpiderManager.runSpider();
				if (Spider.isStatusError(status)) {
					System.out.println("爬虫状态异常：" + status.stackTrace());
				}
			} else {
				throw new Exception("当前项目列表中没有目标爬虫。");
			}
		}catch (ConnectException e){
			System.out.println("连接不上scrapyd服务器！");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
