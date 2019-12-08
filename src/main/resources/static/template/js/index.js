function save() {
    debugger
    var data = getPara()
    $.ajax({
        url:"/index/save?type=save",
        type:"POST",
        dataType:"json",
        data:JSON.stringify(data),
        contentType:"application/json;charset=UTF-8",
        success:function (result) {
            debugger
            if(result.msgCode == "1"){
                window.location = result.url;
            }else if(result.msgCode == "0"){
                alert(result.msg)
                window.location = result.url;
            }
        } ,
        error:function (result) {
            debugger
            alert("发生错误")
        }
    })
}

function temp() {
    var data = getPara()
    $.ajax({
        url:"/index/save?type=temp",
        type:"POST",
        dataType:"json",
        data:JSON.stringify(data),
        contentType:"application/json;charset=UTF-8",
        success:function (result) {
            if(result.msgCode == "1"){
                window.location = result.url;
            }else if(result.msgCode == "0"){
                alert(result.msg)
                window.location = result.url;
            }
        } ,
        error:function (result) {
            alert("发生错误")
        }
    })
}

function getPara() {
    return {
        'movieId':$("#movieId").val().trim(),
        'movieName':$("#movieName").val().trim(),
        'movieLabel':$("#movieLabel").val().trim()
    }
}

function cancel() {
    window.location = "/index/"
}

function movieLabel() {
    $.ajax({
        url:"/index/movieLabel",
        type:"GET",
        success:function (result) {
            if ("1" == result.msgCode){
                result.arr.forEach(function (item,index,arr) {
                    document.getElementById('movieLabel').options.add(new Option(item.label,item.id))
                })
            } else if ("0" == result.msgCode){
                alert("获取电影标签，发生错误")
            }
        },
        error:function (result) {
            alert("获取电影标签，发生错误")
        }
    })
}