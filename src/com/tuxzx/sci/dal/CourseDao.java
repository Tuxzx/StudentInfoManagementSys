package com.tuxzx.sci.dal;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.Grade;

import java.util.List;

public interface CourseDao {
    // 获取所有课程信息
    List<Course> getAllCourse();

    // 查询单门课程信息
    Course getSingleCourse(String cid);

    // 选课
    boolean selectCourse(String uid, String cid);

    // 是否已选该门课程
    boolean isSelected(String uid, String cid);

    // 获取所有已选课程
    List<Course> getAllSelectedCourse(String uid);

    // 退选课程
    boolean cancelSelectCourse(String uid, String cid);

    // 获取所有成绩
    List<Grade> getGrade(String uid);

    // 更新课程信息
    boolean updateCourseInfo(Course course);

    // 更新选课信息
    boolean updateElectiveInfo(Elective elective);

    // 获得所有选课信息
    List<Elective> getAllElective();
}
