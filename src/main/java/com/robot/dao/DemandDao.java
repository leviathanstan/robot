package com.robot.dao;

import com.robot.entity.Area;
import com.robot.entity.Demand;
import com.robot.entity.DmdCategory;
import com.robot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * create by 聪 on 2018/1/22
 */
public interface DemandDao {

    @Select("SELECT COUNT(*) FROM demand")
    int getAllDemandNums();

    @Select("SELECT * FROM demand ORDER BY dmd_time DESC LIMIT #{num},12")
    @ResultMap(value = "DemandResultsMap")
    List<Demand> getAllDemands(int num);

    @Select("SELECT COUNT(*) FROM demand WHERE dmd_type = #{dmdType} AND dmd_title LIKE '%/${content}%' ESCAPE '/'")
    int findDemandNums(@Param(value = "dmdType") int dmdType, @Param(value = "content") String content);

    @Select("SELECT COUNT(*) FROM demand WHERE dmd_type = #{dmdType} AND dmd_category_id = #{dmdCategoryId} AND dmd_title LIKE " +
            "'%/${content}%' ESCAPE '/'")
    int findDemandNumsByCategory(@Param(value = "dmdType") int dmdType, @Param(value = "dmdCategoryId") int dmdCategoryId
            , @Param(value = "content") String content);

    @Select("SELECT * FROM demand WHERE dmd_type = #{dmdType} AND dmd_category_id = #{dmdCategoryId} AND dmd_title LIKE " +
            "'%/${content}%' ESCAPE '/' ORDER BY dmd_time DESC LIMIT #{num},12")
    @ResultMap(value = "DemandResultsMap")
    List<Demand> findDemandByCategory(@Param(value = "dmdType") int dmdType, @Param(value = "dmdCategoryId") int dmdCategoryId
            , @Param(value = "content") String content, @Param(value = "num") int num);

    @Select("SELECT * FROM demand WHERE dmd_type = #{dmdType} AND dmd_title LIKE '%/${content}%' ESCAPE '/' " +
            "ORDER BY dmd_time DESC LIMIT #{num},12")
    @ResultMap(value = "DemandResultsMap")
    List<Demand> findDemand(@Param(value = "dmdType") int dmdType, @Param(value = "content") String content, @Param(value = "num") int num);

    @Select("SELECT COUNT(*) FROM demand WHERE user_id = #{id}")
    int getUserDemandNums(int id);

    @Select("SELECT * FROM demand WHERE user_id = #{id} ORDER BY dmd_time DESC LIMIT #{num},12")
    @ResultMap(value = "DemandResultsMap")
    List<Demand> getUserDemands(@Param(value = "id") int id, @Param(value = "num") int num);

    @Select("SELECT * FROM demand WHERE dmd_id = #{dmdId}")
    @ResultMap(value = "DemandResultsMap")
    Demand getDemand(int dmdId);

    @Insert("INSERT INTO demand(dmd_title,dmd_content,dmd_area,dmd_type,dmd_category_id,dmd_contact,dmd_contact_published,dmd_time, user_id) " +
        "VALUES(#{dmdTitle},#{dmdContent}, #{dmdArea.id}, #{dmdType},#{dmdCategoryId.dmdCategoryId},#{dmdContact},#{dmdContactPublished},#{dmdTime},#{user.id})")
    @SelectKey(keyProperty = "dmdId",before = false,statement = "SELECT LAST_INSERT_ID()",resultType=int.class)
    @Options(useGeneratedKeys = true)
    boolean saveDemand(Demand demand);

    @Select("SELECT id, username FROM user WHERE id = #{user_id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username")
    })
    User getUserById(int user_id);

    @Select("SELECT * FROM dmd_category WHERE dmd_category_id = #{dmdCategoryId}")
    @Results({
            @Result(column = "dmd_category_id", property = "dmdCategoryId"),
            @Result(column = "dmd_category_name", property = "dmdCategoryName")
    })
    DmdCategory getDmdCategory(int dmdCategoryId);

    @Select("SELECT id, name FROM region WHERE id = #{dmd_area}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name")
    })
    Area getAreaById(int dmd_area);
}
