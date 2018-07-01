package com.tuxzx.sci.dal.impl;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.Grade;
import com.tuxzx.sci.dal.BaseDao;
import com.tuxzx.sci.dal.CourseDao;
import com.tuxzx.sci.dal.TableContact;
import com.tuxzx.sci.util.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {
    @Override
    public List<Course> getAllCourse() {
        String sql = "SELECT * FROM "+TableContact.TABLE_COURSE;
        List<Course> courseList = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                Course course = new Course();
                course.setCid(resultSet.getString(TableContact.COURSE_ID));
                course.setName(resultSet.getString(TableContact.COURSE_NAME));
                course.setScore(resultSet.getInt(TableContact.COURSE_SCORE));
                course.setTheoryLesson(resultSet.getInt(TableContact.COURSE_THEORY_LESSON));
                course.setPracticeLesson(resultSet.getInt(TableContact.COURSE_PRACTICE_LESSON));
                course.setTestMethod(resultSet.getString(TableContact.COURSE_TESTMETHOD));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return courseList;
    }

    @Override
    public Course getSingleCourse(String cid) {
        String sql = "SELECT * FROM "+TableContact.TABLE_COURSE+" WHERE "+TableContact.COURSE_ID+"= ?";
        Course course = new Course();
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cid);
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                course.setCid(resultSet.getString(TableContact.COURSE_ID));
                course.setName(resultSet.getString(TableContact.COURSE_NAME));
                course.setScore(resultSet.getInt(TableContact.COURSE_SCORE));
                course.setTheoryLesson(resultSet.getInt(TableContact.COURSE_THEORY_LESSON));
                course.setPracticeLesson(resultSet.getInt(TableContact.COURSE_PRACTICE_LESSON));
                course.setTestMethod(resultSet.getString(TableContact.COURSE_TESTMETHOD));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return course;
    }

    @Override
    public boolean selectCourse(String uid, String cid) {
        boolean sta = isSelected(uid, cid);
        System.out.println("isselected: "+sta);
        if (sta) {
            return true;
        }
        String sql = "INSERT INTO "+TableContact.TABLE_ELECTIVE+" ( "+TableContact.ELECTIVE_USER_ID+" , "+TableContact.ELECTIVE_COURSE_ID+" ) "+" VALUES (?, ?)";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            statement.setString(2, cid);
            System.out.println(statement);
            int status = statement.executeUpdate();
            if (status>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return false;
    }

    /**
     * 选课返回true
     * 未选返回false
     * @param uid
     * @param cid
     * @return
     */
    @Override
    public boolean isSelected(String uid, String cid) {
        String sql = "SELECT * FROM "+TableContact.TABLE_ELECTIVE+" WHERE "+TableContact.ELECTIVE_USER_ID+" = ? AND "+TableContact.ELECTIVE_COURSE_ID+" = ?";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            statement.setString(2, cid);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return false;
    }

    @Override
    public List<Course> getAllSelectedCourse(String uid) {
        String sql = "SELECT * FROM "+TableContact.TABLE_ELECTIVE+" NATURAL JOIN "+TableContact.TABLE_COURSE+" WHERE "+TableContact.ELECTIVE_USER_ID+" = ?";
        List<Course> courseList = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            debugMethod();
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                Course course = new Course();
                course.setCid(resultSet.getString(TableContact.COURSE_ID));
                course.setName(resultSet.getString(TableContact.COURSE_NAME));
                course.setScore(resultSet.getInt(TableContact.COURSE_SCORE));
                course.setTheoryLesson(resultSet.getInt(TableContact.COURSE_THEORY_LESSON));
                course.setPracticeLesson(resultSet.getInt(TableContact.COURSE_PRACTICE_LESSON));
                course.setTestMethod(resultSet.getString(TableContact.COURSE_TESTMETHOD));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return courseList;
    }

    @Override
    public boolean cancelSelectCourse(String uid, String cid) {
        if (!isSelected(uid, cid)) {
            return true;
        }
        String sql = "DELETE FROM "+TableContact.TABLE_ELECTIVE+" WHERE "+TableContact.ELECTIVE_USER_ID+" = ? AND "+TableContact.ELECTIVE_COURSE_ID+" =?";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            statement.setString(2, cid);
            debugMethod();
            int status = statement.executeUpdate();
            if (status>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return false;
    }

    @Override
    public List<Grade> getGrade(String uid) {
        String sql = "SELECT "+TableContact.COURSE_ID+", "+TableContact.COURSE_NAME+", "+TableContact.ELECTIVE_RESLUT+", "+TableContact.ELECTIVE_TESTDATE+
                " FROM "+TableContact.TABLE_COURSE+" NATURAL JOIN "+TableContact.TABLE_ELECTIVE+
                " WHERE "+TableContact.ELECTIVE_USER_ID+" = ?";
        List<Grade> gradeList = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            debugMethod();
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setCid(resultSet.getString(TableContact.COURSE_ID));
                grade.setCname(resultSet.getString(TableContact.COURSE_NAME));
                grade.setResult(resultSet.getShort(TableContact.ELECTIVE_RESLUT));
                grade.setTestDate(resultSet.getDate(TableContact.ELECTIVE_TESTDATE));
                gradeList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }
}
