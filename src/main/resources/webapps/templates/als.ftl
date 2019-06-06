<@override name="content">
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">

                </div>

                <div class="col-md-7">
                    <div class="input-group">
                        <input id="movieId" type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                            <button id="watch" class="btn btn-default" type="button">前往观看</button>
                        </span>
                    </div>
                </div>
            </div>

            <br>
            <h4>推荐影片：</h4>
            <table id = "table" class="table table-hover"></table>

        </div>
    </div>
</@override>

<@override name="footer">
<script>
$('#table').bootstrapTable({
    url:"/index/listByPageAls",
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
<@extends name="/index.ftl"/>