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
                        注册
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>
                            <input type="username" id="username" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">邮箱</label>
                            <input type="email" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input type="password" id="password" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">再次输入密码</label>
                            <input type="password" class="form-control">
                        </div>
                    </div>

                    <div class="card-footer">
                        <button id = "register" type="button" class="btn btn-success btn-block">提交</button>
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
    $("#register").click(function () {
        var data = get_para();
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
                    alert("注册失败，请重新注册")
                    window.location = result.url;
                }
            } ,
            error:function (result) {
                alert("注册时发生错误");
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
</script>
</body>
</html>

<@extends name="/base.ftl"/>
