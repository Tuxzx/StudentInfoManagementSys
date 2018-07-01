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

function updateUserinfo(event) {
    console.log("updateUserInfo");
    // var btn = event.target;
    // // 获得表格中的课程号
    // var td = btn.parentNode;
    // var tr = td.parentNode;
    // var uid = tr.childNodes[0].innerHTML;
    // $.ajax({
    //     type:"post",
    //     url:"/GetUserInfoServletAjax",
    //     data:{"uid":uid},
    //     datatype:"json",
    //     success:function (data) {
    //         console.log("updateUserInfo: success");
    //         $("#myModal").modal("show");
    //     }
    // });
}