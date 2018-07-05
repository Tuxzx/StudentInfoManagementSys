function addCourse(event) {
    // 获得当前点击的按钮
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;
    var cid = tr.childNodes[0].innerHTML;
    console.log("课程号："+cid);
    //对应的ajax实现
    $.ajax({
        type:"post",
        url:"/addCourseServletAjax",
        data:{"cid":cid},
        datatype:"json",
        success:function (data) {
            alert("选课成功");
            document.getElementById("added").innerHTML=data;
        }
    });
}

function removeCourse(event) {
    // 获得当前点击的按钮
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;
    var cid = tr.childNodes[0].innerHTML;
    console.log("课程号："+cid);
    $.ajax({
        type:"post",
        url:"/removeCourseServletAjax",
        data:{"cid":cid},
        datatype:"json",
        success:function (data) {
            alert("退选成功");
            var tbody = tr.parentNode;
            tbody.removeChild(tr);
        }
    });
}


// 用户信息修改
function updateUserinfo(event) {
    console.log("updateUserInfo");
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;

    var strUid = tr.childNodes[0].innerHTML;
    var strPassword = tr.childNodes[1].innerHTML;
    var strUsername = tr.childNodes[2].innerHTML;
    var strGender = tr.childNodes[3].innerHTML;
    var strAge = tr.childNodes[4].innerHTML;
    var strTel = tr.childNodes[5].innerHTML;
    var strRole = tr.childNodes[6].innerHTML;

    document.getElementById("uid").value = strUid;
    document.getElementById("username").value = strUsername;
    document.getElementById("password").value = strPassword;
    document.getElementById("gender").value = strGender;
    document.getElementById("age").value = strAge;
    document.getElementById("tel").value = strTel;
    document.getElementById("role").value = strRole;
    $("#myModal").modal("show");
}

function updateUserInfoAjax() {
    $.ajax({
        type:"post",
        url:"/UpdateUserInfoServletAjax",
        data:$("#modalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            $("#myModal").modal("show");
            document.getElementById("progress").style = "width: 100%;";
            alert("信息修改成功");
        }
    });
}

// 课程信息修改
function updateCourseinfo(event) {
    console.log("updateCourseinfo");
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;

    var strCid = tr.childNodes[0].innerHTML;
    var strCname = tr.childNodes[1].innerHTML;
    var strCscore = tr.childNodes[2].innerHTML;
    var strTheoryLesson = tr.childNodes[3].innerHTML;
    var strPracticeLesson = tr.childNodes[4].innerHTML;
    var strTestMethod = tr.childNodes[5].innerHTML;
    var strTestDate = tr.childNodes[6].innerHTML;

    document.getElementById("cid").value = strCid;
    document.getElementById("cname").value = strCname;
    document.getElementById("cscore").value = strCscore;
    document.getElementById("theorylesson").value = strTheoryLesson;
    document.getElementById("practicelesson").value = strPracticeLesson;
    document.getElementById("testmethod").value = strTestMethod;
    document.getElementById("testdate").value = strTestDate;
    $("#myModal").modal("show");
}

function updateCourseInfoAjax() {
    $.ajax({
        type:"post",
        url:"/UpdateCourseServletAjax",
        data:$("#modalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            document.getElementById("progress").style = "width: 100%;";
            alert("信息修改成功");
        }
    });
}

function updateElectiveinfo(event) {
    console.log("updateElectiveinfo");
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;

    var strUid = tr.childNodes[0].innerHTML;
    var strUname = tr.childNodes[1].innerHTML;
    var strCid = tr.childNodes[2].innerHTML;
    var strCname = tr.childNodes[3].innerHTML;

    document.getElementById("uid").value = strUid;
    document.getElementById("uname").value = strUname;
    document.getElementById("cid").value = strCid;
    document.getElementById("cname").value = strCname;
    $("#myModal").modal("show");
}

function updateElectiveInfoAjax(){
    $.ajax({
        type:"post",
        url:"/UpdateElectiveServletAjax",
        data:$("#modalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            document.getElementById("progress").style = "width: 100%;";
            alert("信息修改成功");
        }
    });
}

function addNewUserAjax() {
    $.ajax({
        type:"post",
        url:"/MgtAddUserServletAjax",
        data:$("#addmodalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            document.getElementById("addprogress").style = "width: 100%;";
            alert("信息修改成功");
        }
    });
}

function addNewCourseAjax() {
    $.ajax({
        type:"post",
        url:"/MgtAddUserServletAjax",
        data:$("#addmodalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            document.getElementById("addprogress").style = "width: 100%;";
            alert("信息修改成功");
        }
    });
}

function deleteUserAjax(event) {
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;

    var strUid = tr.childNodes[0].innerHTML;
    var strUname = tr.childNodes[1].innerHTML;
    var myconfirm = confirm("您确认要删除该学生？"+
        "\n学号"+strUid +
        "\n姓名"+strUname);
    if (myconfirm) {
        $.ajax({
            type:"post",
            url:"/MgtRemoveUserServletAjax",
            data:{"uid":strUid},
            datatype:"json",
            success:function (data) {
                document.getElementById("usertable").innerHTML = data;
                alert("用户"+strUid+"删除成功");
            }
        });
    }
}

function addCourseInfoAjax() {
    $.ajax({
        type:"post",
        url:"/MgtAddCourseServletAjax",
        data:$("#addmodalForm").serialize(),
        datatype:"json",
        success:function (data) {
            document.getElementById("usertable").innerHTML = data;
            document.getElementById("addprogress").style = "width: 100%;";
            alert("课程添加成功");
        }
    });
}

function deleteCourseAjax(event) {
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;

    var strCid = tr.childNodes[0].innerHTML;
    var strCname = tr.childNodes[1].innerHTML;
    var myconfirm = confirm("您确认要删除该课程？"+
        "\n课程号"+strCid +
        "\n课程名"+strCname);
    if (myconfirm) {
        $.ajax({
            type:"post",
            url:"/MgtRemoveCourseServletAjax",
            data:{"cid":strCid},
            datatype:"json",
            success:function (data) {
                document.getElementById("usertable").innerHTML = data;
                alert("用户"+strCid+"删除成功");
            }
        });
    }
}
