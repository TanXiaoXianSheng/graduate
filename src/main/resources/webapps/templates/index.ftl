<@override name="header">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="#">
            <#--<img src="/template/imgs/logo.png" alt="logo">-->
            <h1>电影推荐系统</h1>
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">
            <#--个人-->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="/template/imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                    <span id="username" class="small ml-1 d-md-down-none">John Smith</span>
                </a>

            </li>
        </ul>
    </nav>
</@override>

<@override name="sidebar">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-title">导航条</li>

                <li class="nav-item">
                    <a href="/index/" class="nav-link active">
                        <i class="icon icon-speedometer"></i> 首页
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/index/ALS" class="nav-link active">
                        <i class="icon icon-speedometer"></i> 协同过滤
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/index/itemRec" class="nav-link active">
                        <i class="icon icon-speedometer"></i> 基于内容的推荐
                    </a>
                </li>

            </ul>
        </nav>
    </div>
</@override>

<@override name="content">
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">

                </div>

                <div class="col-md-7">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row ">

            </div>


            <table id = "table" class="table table-hover"></table>

        </div>
    </div>
</@override>

<@override name="footer">
<script>

$('#table').bootstrapTable({
    url:"/index/listByPage",
    queryParams:"queryParams",
    toolbar: "#toolbar",
    sidePagination: "true",
    striped: true, // 是否显示行间隔色
    //search : "true",
    uniqueId: "ID",
    pageSize: "10",
    pagination: true, // 是否分页
    sortable: true, // 是否启用排序
    columns: [{
        field: 'movieId',
        title: '电影编号',
        width: "20%"
    },
    {
        field: 'movieName',
        title: '电影名',
        width: "40%"
    },
    {
        field: 'movieLabel',
        title: '电影标签',
        width: "40%"
    }]
});

</script>
</@override>

<!--继承的模板要写在最下面-->
<@extends name="/base.ftl"/>