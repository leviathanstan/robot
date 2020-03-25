package com.robot.dao;

import com.robot.entity.Area;
import com.robot.entity.Industry;
import com.robot.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/19
 */
public interface PositionDao {
    ArrayList<Position> getIndex();
    ArrayList<Position> search(HashMap<String,String> map);
    Position getPositionInfo(int id);
    ArrayList<Area> getAreas(int parentId);
    ArrayList<Industry> getIndustry(int parentId);

    int addPosition(Position position);
    int addPositionRegion(Map<String,String> map);
    int updatePosition(Position position);
    int deletePosition(List<Integer> ids);
    int deletePositionRegion(List<Integer> positionIds);
    ArrayList<Position> findPosition(HashMap<String, Object> map);

    void insertMemberPosition(@Param("positionId")int positionId, @Param("userId")int userId);
    void deleteMemberPosition(List<Integer> ids);
    List<Integer> selectMemberPosition(int userId);
}
