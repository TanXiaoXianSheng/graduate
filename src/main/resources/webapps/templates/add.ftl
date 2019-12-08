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
                <button onclick="save()" class="btn btn-primary">保存</button>
                <button onclick="temp()" class="btn btn-secondary">草稿</button>
                <button onclick="cancel()" class="btn">取消</button>
            </div>
        </div>
    </div>
</@override>

<@override name="footer">
<script src="/template/js/index.js"></script>
<script>
$(document).ready(function () {
    movieLabel()
})
</script>
</@override>
<@extends name="/index.ftl"/>