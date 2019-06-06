<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <link rel="stylesheet" href="/template/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/template/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/template/css/styles.css">
</head>

<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        登录
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>
                            <input id = "username" type="email" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input id = "password" type="password" class="form-control">
                        </div>

                        <div class="custom-control custom-checkbox mt-4">
                            <#--<input type="checkbox" class="custom-control-input" id="login">-->
                            <label class="custom-control-label" for="login">记住密码</label>
                        </div>
                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button id="login" type="button" class="btn btn-primary px-5">登录</button>
                            </div>

                            <div class="col-6">
                                <a href="/registerPre">注册</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/template/vendor/jquery/jquery.min.js"></script>
<script src="/template/vendor/popper.js/popper.min.js"></script>
<script src="/template/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/template/vendor/chart.js/chart.min.js"></script>
<script src="/template/js/carbon.js"></script>
<script src="/template/js/demo.js"></script>

<script>
$("#login").click(function () {
    var data = get_para();
    $.ajax({
        url:"/login",
        type:"POST",
        dataType:"json",
        data:JSON.stringify(data),
        contentType:"application/json;charset=UTF-8",
        success:function (result) {
            if(result.msgCode == "1"){
                window.location = result.url;
            }else if(result.msgCode == "0"){
                alert("登录失败，请重新登录")
                window.location = result.url;
            }
        } ,
        error:function (result) {
            alert("发生错误");
        }
    });
});

function get_para() {
    var username = $("#username").val().trim();
    var password = $("#password").val().trim();
    return {
        'username': username,
        'password': password
    }
}

$("#register").click(function () {
    $.ajax({
        url:"/register",
        type:"POST",
        dataType:"json",
        data:JSON.stringify(data),
        contentType:"application/json;charset=UTF-8",
        success:function (result) {
            if(result.msgCode == "1"){
                window.location = result.url;
            }else if(result.msgCode == "0"){
                alert("登录失败，请重新登录")
                window.location = result.url;
            }
        } ,
        error:function (result) {
            alert("发生错误");
        }
    });
});

</script>
</body>
</html>