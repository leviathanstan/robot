package com.robot.dao;

import com.robot.dto.InformationDto;
import com.robot.entity.Report;
import com.robot.entity.RobotNews;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hua
 * @date 2018/9/24
 */
public interface InformationDao {

    RobotNews findInformationInfo(int id);
    ArrayList<RobotNews> getInformationList(int categoryId);
    ArrayList<RobotNews> getIndexInformation(Map<String,Integer> map);
    ArrayList<RobotNews> getIndexCover(Map<String,Integer> map);
    ArrayList<RobotNews> find(HashMap<String,Object> args);
    int searchCount(String content);
    int searchCategoryCount(HashMap<String,Object> args);
    List<String> findRelatedKeyword(int informationId);
    List<RobotNews> findRelatedInformation(int informationId);
    ArrayList<InformationDto> getIndexDiscuss();
    InformationDto getDiscussInfo(int id);
    List<InformationDto> getDiscussList();
    ArrayList<InformationDto> getIndexInformationWithContent(Map<String,Integer> map);
    int deleteInformation(List<Integer> ids);
    int deleteContent(List<Integer> ids);
    int add(RobotNews robotNews);
    int addContent(HashMap map);
    int update(RobotNews robotNews );
    int updateContent(Map<String,String> map);
    String findInformationById(int id);
    int addCount(int id);
    ArrayList<RobotNews> findRelatedHot();
    ArrayList<Report> findReportTop();
    ArrayList<Report> findReportList();
    Report  findReportInfo(int id);
    int addReport(Report report);
    int updateReport(Report report);
    void insertMemberReport(@Param("reportId")int reportId, @Param("userId")int userId);
    ArrayList<String> findRepRelatedKeyword(int reportId);
    int addCountRep(int id);
    int addCountDis(int id);
    List<Integer> selectMemberInformation(int userId);
    void deleteMemberInformation(List<Integer> ids);
    void insertMemberInformation(@Param("informationId")int informationId, @Param("userId")int userId);
    List<Integer> selectMemberInformationByUIds(List<Integer> userIds);
    List<RobotNews> selectIndexMemberInformation(@Param("categoryId") int categoryId,@Param("list") List<Integer> informationIds,@Param("number") int number);
}
