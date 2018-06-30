function addCourse(event) {
    var httpRequest;
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else {
        alert("该浏览器不支持ajax，请您更新浏览器再尝试选课");
    }
    // 获得当前点击的按钮
    var btn = event.target;
    // 获得表格中的课程号
    var td = btn.parentNode;
    var tr = td.parentNode;
    var cid = tr.childNodes[0].innerHTML;
    console.log("课程号："+cid);
    //
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                alert("选课成功");
                document.getElementById("added").innerHTML=httpRequest.responseText;
            } else {
                alert("something wrong...");
            }
        }
    }
    httpRequest.open("POST","/addCourseServletAjax",true);
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    httpRequest.send("cid="+cid);

    //对应的ajax实现
    // $.ajax({
    //     type:"post",
    //     url:"/addCourseServletAjax",
    //     data:{"cid":cid},
    //     datatype:"json",
    //     success:function (data) {
    //         alert(data);
    //     }
    // })
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
    })
}