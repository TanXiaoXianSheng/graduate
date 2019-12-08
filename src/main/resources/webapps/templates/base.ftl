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

    <script src="/template/vendor/jquery/jquery.min.js"></script>
    <script src="/template/vendor/popper.js/popper.min.js"></script>
    <script src="/template/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/template/vendor/chart.js/chart.min.js"></script>
    <script src="/template/js/carbon.js"></script>
    <script src="/template/js/demo.js"></script>
    <!-- bootstrapTable -->
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css">
    <script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.14.2/dist/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <@block name="header">

    </@block>

    <div class="main-container">
        <@block name="sidebar"></@block>

        <@block name="content"></@block>
    </div>
</div>
<@block name="footer"></@block>
</body>
</html>
