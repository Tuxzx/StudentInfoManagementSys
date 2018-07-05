package com.tuxzx.sci.dal.impl;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.Grade;
import com.tuxzx.sci.dal.BaseDao;
import com.tuxzx.sci.dal.CourseDao;
import com.tuxzx.sci.dal.TableContact;
import com.tuxzx.sci.util.JDBCUtils;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  CourseDaoImpl extends BaseDao implements CourseDao {
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
                course.setTestDate(resultSet.getDate(TableContact.COURSE_TESTDATE));
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
                course.setTestDate(resultSet.getDate(TableContact.COURSE_TESTDATE));
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
                course.setTestDate(resultSet.getDate(TableContact.COURSE_TESTDATE));
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
        String sql = "SELECT "+TableContact.COURSE_ID+", "+TableContact.COURSE_NAME+", "+TableContact.ELECTIVE_RESLUT+", "+TableContact.COURSE_TESTDATE+
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
                grade.setTestDate(resultSet.getDate(TableContact.COURSE_TESTDATE));
                gradeList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return gradeList;
    }

    @Override
    public boolean updateCourseInfo(Course course) {
        String sql = "UPDATE "+TableContact.TABLE_COURSE+" SET "+
                TableContact.COURSE_NAME+" = ? , "+
                TableContact.COURSE_SCORE+" = ? , "+
                TableContact.COURSE_THEORY_LESSON+" = ? , "+
                TableContact.COURSE_PRACTICE_LESSON+" = ? , "+
                TableContact.COURSE_TESTMETHOD+" = ? , "+
                TableContact.COURSE_TESTDATE+" = ? "+
                " WHERE "+ TableContact.COURSE_ID+" = ?";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setInt(2, course.getScore());
            statement.setInt(3, course.getTheoryLesson());
            statement.setInt(4, course.getPracticeLesson());
            statement.setString(5, course.getTestMethod());
            statement.setDate(6, course.getTestDate());
            statement.setString(7, course.getCid());
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
    public boolean updateElectiveInfo(Elective elective) {
        String sql = "UPDATE "+TableContact.TABLE_ELECTIVE+" SET "+TableContact.ELECTIVE_RESLUT+" =? " +
                "WHERE "+TableContact.ELECTIVE_USER_ID+" =? AND "+TableContact.ELECTIVE_COURSE_ID+" =? ";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, elective.getResult());
            statement.setString(2, elective.getUid());
            statement.setString(3, elective.getCid());
            int status = statement.executeUpdate();
            if (status>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Elective> getAllElective() {
        String sql = "SELECT "+TableContact.TABLE_ELECTIVE+"."+TableContact.ELECTIVE_USER_ID+
                ", "+TableContact.TABLE_USER+"."+TableContact.USER_NAME+
                ", "+TableContact.TABLE_ELECTIVE+"."+TableContact.ELECTIVE_COURSE_ID+
                ", "+TableContact.TABLE_COURSE+"."+TableContact.COURSE_NAME+
                ", "+TableContact.TABLE_ELECTIVE+"."+TableContact.ELECTIVE_RESLUT+
                " FROM "+TableContact.TABLE_ELECTIVE+", "+
                TableContact.TABLE_USER+", "+
                TableContact.TABLE_COURSE+
                " WHERE "+TableContact.TABLE_ELECTIVE+"."+TableContact.ELECTIVE_USER_ID+" = "+TableContact.TABLE_USER+"."+TableContact.USER_ID+
                " AND "+TableContact.TABLE_ELECTIVE+"."+TableContact.ELECTIVE_COURSE_ID+" = "+TableContact.TABLE_COURSE+"."+TableContact.COURSE_ID;
        List<Elective> electiveList = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            debugMethod();
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                Elective elective = new Elective();
                elective.setUid(resultSet.getString(TableContact.ELECTIVE_USER_ID));
                elective.setUname(resultSet.getString(TableContact.USER_NAME));
                elective.setCid(resultSet.getString(TableContact.ELECTIVE_COURSE_ID));
                elective.setCname(resultSet.getString(TableContact.COURSE_NAME));
                elective.setResult(resultSet.getInt(TableContact.ELECTIVE_RESLUT));
                electiveList.add(elective);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return electiveList;
    }

    @Override
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO "+TableContact.TABLE_COURSE+" VALUES (?,?,?,?,?,?,?)";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.getCid());
            statement.setString(2, course.getName());
            statement.setInt(3, course.getScore());
            statement.setInt(4, course.getTheoryLesson());
            statement.setInt(5, course.getPracticeLesson());
            statement.setString(6, course.getTestMethod());
            statement.setDate(7, course.getTestDate());
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
    public boolean removeCourse(String cid) {
        String sql = "DELETE FROM "+TableContact.TABLE_COURSE+" WHERE "+TableContact.COURSE_ID+" =? ";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cid);
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
}
