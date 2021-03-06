package com.robot.dao;

import com.robot.entity.Enterprise;
import com.robot.entity.Member;
import com.robot.entity.RepresentativeWork;
import com.robot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {

    Integer register(User user);
    User login(User user);
    int resetPassword(@Param("password") String password, @Param("email") String email);
    int editEmail(@Param("id") Integer id, @Param("email") String email);
    ArrayList<User> find(User user);
    int addSubscribe(Map<String,Integer> map);
    int deleteSubscribe(Map<String,Integer> map);
    Integer selectSubscribeInfo(Map<String,Integer> map);
    ArrayList<Integer> getUserSubscribe(int userId);
    ArrayList<Map> getUserSubscribeInfo(int userId);
    ArrayList<Map> getAllSubscribe();
    int insertMemberProducts(List<RepresentativeWork> representativeWorks);
    int insertMemberProduct(RepresentativeWork representativeWork);
    int isExist(User user);
    int insertMember(Member member);
    int isExistMember(String enterpriseName);
    int insertMemberUser(@Param("userId") Integer userId, @Param("memberId") Integer memberId);
    Map<String, Object> getMemberInfo(Integer memberId);
    int judgeMember(Member member);
    int judgeUser(User user);
    List<Member> getMemberList();
    List<HashMap<String, Object>> getMemberListStatus();
    int insertEnterpriseInfo(Enterprise enterprise);
    void insertMemberProxy(User user);
    Member selectMemberByName(String memberName);
    List<Integer> selectUIds(int memberId);
    User getUser(int id);
    Integer getMemberIdByUid(int userId);
    Enterprise getEnterprise(int memberId);
    int updateEnterprise(Enterprise enterprise);
    int updateMember(Member member);
    List<RepresentativeWork> getRepresentativeWork(Integer enterpriseId);
    int updateRepresentativeWork(RepresentativeWork representativeWork);
    Integer count();
    List<Map> countEnterpriseType();
}
