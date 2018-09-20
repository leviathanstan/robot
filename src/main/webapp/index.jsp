<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/navbar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--导航栏 begin-->
<div class="container">
    <header>
        <section class="top clrfix">
            <div id="unlogin" class="login_switch">
                <a href="${pageContext.request.contextPath}/account/login">登录</a>
                <a href="${pageContext.request.contextPath}/account/register">注册</a>
            </div>
            <div id="user" class="login_switch">
                <a class="username" accountId = "${account.accountId}">${account.accountName}</a>
                <a id="loginout">退出</a>
            </div>
            <form class="navbar-form searcher" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入关键字">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </section>
        <nav class="nav navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle nav_toggole" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav nav_grids nav-justified">
                        <li class="active"><a class="nav_item" href="#">首页</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/information/">资讯</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/case/">案例</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/company/">企业</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/expert/">专家</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/product/">产品</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/demand/">需求</a></li>
                        <li><a class="nav_item" href="${pageContext.request.contextPath}/account/about">关于我们</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</div>
<!--导航栏 end-->
<!--首页主体内容 begin-->
<div class="container main_container">
    <!--最新资讯-->
    <div class="panel panel-default clrfix">
        <div class="panel-heading panel_header">最新资讯
            <a href="${pageContext.request.contextPath}/information/">+更多</a>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="information_1">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/information/detail?InfoId='+item.infoId">{{item.infoTitle}}</a>
                </li>

            </ul>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="information_2">
                <li class="list-group-item fa fa-caret-right"  v-for="item in items">
                    <a :href="'/robot/information/detail?InfoId='+item.infoId">{{item.infoTitle}}</a>
                </li>

            </ul>
        </div>
    </div>
    <!--热门案例-->
    <div class="panel panel-default clrfix">
        <div class="panel-heading panel_header">热门案例
            <a href="${pageContext.request.contextPath}/case/">+更多</a>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="case_1">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/case/detail?caseId='+item.caseId">{{item.caseTitle}}</a>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <ul class="list-group"  id="case_2">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/case/detail?caseId='+item.caseId">{{item.caseTitle}}</a>
                </li>
            </ul>
        </div>
    </div>
    <!--最新产品-->
    <div class="panel panel-default clrfix">
        <div class="panel-heading panel_header">最新产品
            <a href="${pageContext.request.contextPath}/product/">+更多</a>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="product_1">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/product/getProductIntroduce?proId='+item.productId">{{item.productName}}</a>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <ul class="list-group"  id="product_2">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/product/getProductIntroduce?proId='+item.productId">{{item.productName}}</a>
                </li>
            </ul>
        </div>
    </div>
    <!--最新需求-->
    <div class="panel panel-default clrfix">
        <div class="panel-heading panel_header">最新需求
            <a href="${pageContext.request.contextPath}/demand/">+更多</a>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="demand_1">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/demand/getDemand?dmdId='+item.dmdId">{{item.dmdTitle}}</a>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <ul class="list-group" id="demand_2">
                <li class="list-group-item fa fa-caret-right" v-for="item in items">
                    <a :href="'/robot/demand/getDemand?dmdId='+item.dmdId">{{item.dmdTitle}}</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--首页主体内容 end-->

<!--页脚 begin-->
<footer>
    <div class="container">
        <nav class="footer_nav">
            <a href="#">首页</a>
            <span>|</span>
            <a href="${pageContext.request.contextPath}/account/about" >关于我们</a>
            <span>|</span>
            <a class="collection">加入收藏</a>
        </nav>
        <div class="copyright">
            <p>© 版权所有 ******</p>
        </div>
    </div>
</footer>
<!--页脚 end-->
<!--返回顶部 top-->
<div id="back_top">回顶部</div>
<!--返回顶部end-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/js/navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>