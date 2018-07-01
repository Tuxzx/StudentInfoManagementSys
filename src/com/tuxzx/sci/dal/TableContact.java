package com.tuxzx.sci.dal;

public class TableContact {
    public static final boolean DEBUG = true;

    public static final String TABLE_USER = "userinfo";
    public static final String TABLE_COURSE = "courseinfo";
    public static final String TABLE_ELECTIVE = "elective";


    //Table userinfo
    public static final String USER_ID = "uid";                     // primary key
    public static final String USER_NAME = "uname";
    public static final String USER_PASSWORD = "password";
    public static final String USER_GENDER = "gender";
    public static final String USER_AGE = "age";
    public static final String USER_TEL = "tel";
    public static final String USER_ROLE = "role";

    //Table courseinfo
    public static final String COURSE_ID = "cid";                   // primary key
    public static final String COURSE_NAME = "cname";
    public static final String COURSE_SCORE = "cscore";
    public static final String COURSE_THEORY_LESSON = "theorylesson";
    public static final String COURSE_PRACTICE_LESSON = "practicelesson";
    public static final String COURSE_TESTMETHOD = "testmethod";
    public static final String COURSE_TESTDATE = "testdate";

    //Table elective
    /**
     * uid reference userinfo(uid)
     * cid reference courseinfo(cid)
     * 级联更新删除
     * ON DELETE CASCADE
     * ON UPDATE CASCADE
     */
    public static final String ELECTIVE_USER_ID = "uid";            // primary key
    public static final String ELECTIVE_COURSE_ID = "cid";          // primary key
    public static final String ELECTIVE_RESLUT = "result";

}
