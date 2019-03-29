package com.service;

import com.robot.dao.InformationDao;

import com.robot.dto.InformationDto;
import com.robot.entity.Robot;
import com.robot.entity.RobotNews;
import com.robot.schedule.ScheduleTask;
import com.robot.service.InformationService;
import com.robot.util.CommonUtil;
import com.robot.util.LogHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class InformationServiceTest {

    @Autowired
    private InformationDao informationDao;
    @Autowired
    private ScheduleTask scheduleTask;
    @Autowired
    private InformationService informationService;

    @Test
    public void testList(){
        System.out.println(informationDao.getInformationList(1));
    }

    @Test
    public void testS() throws IOException, InvalidFormatException {
        //ArrayList<InformationDto> informationDtos = informationService.findInformationTop();
        Map map = new HashMap();
        map.put("number",10);
        map.put("categoryId",4);
        ArrayList<InformationDto> robotNewsList = informationDao.getIndexInformationWithContent(map);
        for(InformationDto robotNews:robotNewsList){
           robotNews.setContent(CommonUtil.getPreview(robotNews.getContent()));
        }
        String path = "E:/rdc/robot/excel/技术.xlsx";
        InputStream is = Files.newInputStream(Paths.get(path));
        Workbook workbook = WorkbookFactory.create(is);

        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for(InformationDto robotNews:robotNewsList){
            Row row = sheet.createRow(++i);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(robotNews.getTitle());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(robotNews.getLink());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(robotNews.getContent());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(robotNews.getPostDate());
        }
        OutputStream outputStream = Files.newOutputStream(Paths.get(path));
        workbook.write(outputStream);



    }

    @Test
    public void testE() throws IOException, InvalidFormatException {
        //ArrayList<InformationDto> informationDtos = informationService.findInformationTop();
        Map map = new HashMap();
        map.put("number",10);
        map.put("categoryId",1);
        ArrayList<InformationDto> robotNewsList = informationDao.getIndexInformationWithContent(map);
        for(InformationDto robotNews:robotNewsList){
            robotNews.setContent(CommonUtil.getPreview(robotNews.getContent()));
        }
        String path = "E:/rdc/robot/excel/产品.xlsx";
        InputStream is = Files.newInputStream(Paths.get(path));
        Workbook workbook = WorkbookFactory.create(is);

        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for(InformationDto robotNews:robotNewsList){
            Row row = sheet.createRow(++i);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(robotNews.getTitle());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(robotNews.getLink());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(robotNews.getContent());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(robotNews.getPostDate());
        }
        OutputStream outputStream = Files.newOutputStream(Paths.get(path));
        workbook.write(outputStream);



    }
}
