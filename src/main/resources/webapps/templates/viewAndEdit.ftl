<@override name="content">

    <div  class="content card-body">
        <div>
            <div>
                <div>
                    <label for="placeholder-input" class="form-control-label require">电影编号：</label>
                    <input id="movieId" class="form-control" placeholder="编号">
                </div>
            </div>

            <div>
                <div>
                    <label for="textarea">电影名</label>
                    <textarea id="movieName" class="form-control" rows="6"></textarea>
                </div>
            </div>

            <div>
                <div>
                    <label for="single-select">电影标签</label>
                    <select id="movieLabel" class="form-control">

                    </select>
                </div>
            </div>

            <div class="mb-4">
                <button id="save" onclick="save()" class="btn btn-primary" style="display: none">保存</button>
                <button id="temp" onclick="temp()" class="btn btn-secondary" style="display: none">草稿</button>
                <button id="cancel" onclick="cancel()" class="btn" style="display: none">取消</button>
                <button id="exit" onclick="exit()" class="btn" style="display: none">退出</button>
            </div>
        </div>
    </div>
</@override>

<@override name="footer">
<script src="/template/js/index.js"></script>
<script>
$(document).ready(function(){
    var entity = ${entity};
    $("#movieId").val(entity.movieId)
    $("#movieName").val(entity.movieName)
    $("#mvoieLabel").val(entity.movieLabel)

    var type = ${type}
    switch (type.type) {
        case "view":
            $("#movieId").attr("disabled","disabled")
            $("#movieName").attr("disabled","disabled")
            $("#movieLabel").attr("disabled","disabled")
            $("#exit").css("display","inline")
            break
        case "edit":
            $("#save").css("display","inline")
            $("#temp").css("display","inline")
            $("#cancel").css("display","inline")
            break
    }

    movieLabel()
})
</script>
</@override>
<@extends name="/index.ftl"/>