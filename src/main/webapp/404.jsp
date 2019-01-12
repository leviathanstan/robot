<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0031)https://www.zhihu.com/asdfasdfa -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>ROBOT</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://static.zhihu.com/static/img/favicon.ico">
    <script>
        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-20961733-1']);
        _gaq.push(['_setSampleRate', '0.1']);
        _gaq.push(['_trackPageview', "/404" + document.location.pathname + document.location.search ]);

        (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' === document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();

        (function() {
            var backButton = document.getElementById('js-history-back')
            backButton.onclick = function() {
                history.go(-1)
            }
        }());

        (function() {
            if (zap) {
                zap.config({
                    'apiHost': 'https://zhihu-web-analytics.zhihu.com/api/v1',
                    'product': 'Zhihu',
                })
                zap.trackPageShow()
                zap.trackMonitor({}, {
                    'monitor': {
                        'statusCode': 404
                    }
                })
            }
        }());
    </script>
    <style>
        body {
            margin: 0;
            color: #222;
            font: 16px/1.7 'Helvetica Neue', Helvetica, Arial, Sans-serif;
            background: #eff2f5;
        }

        img {
            border: none;
        }

        a {
            text-decoration: none;
            color: #105cb6;
        }

        a:hover {
            text-decoration: underline;
        }

        .error {
            margin: 169px auto 0;
            width: 404px;
        }

        .error-wide {
            width: 500px;
        }

        @media (max-width: 500px) {
            .error {
                width: 98%;
            }
        }

        .error .header {
            overflow: hidden;
            font-size: 1.8em;
            line-height: 1.2;
            margin: 0 0 .33em .33em;
        }

        .error .header img {
            vertical-align: text-bottom;
        }

        .error .header .mute {
            color: #999;
            font-size: .5em;
        }

        .error hr {
            margin: 1.3em 0;
        }

        .error p {
            margin: 0 0 1.7em;
            color: #999;
        }

        .error p:last-child {
            margin-bottom: 0;
        }

        .error strong {
            font-size: 1.1em;
            color: #000;
        }

        .error .content {
            padding: 2em 1.25em;
            border: 1px solid #babbbc;
            border-radius: 5px;
            background: #f7f7f7;
            text-align: center;
        }

        .error .content .single {
            margin: 3em 0;
            font-size: 1.1em;
            color: #666;
        }
    </style>
  </head>
  <body>
    <div class="page">
      <div class="error">
        <h1 class="header">
          <a href="http://122.13.4.239" class="logo">
            <img src="./404_files/logo_black_trans.png" srcset="//static.zhihu.com/static/img/logo_black_trans@2x.png 2x" alt="机器人">
          </a>
          - 404
        </h1>
        <div class="content">
         <p>
           <strong>你似乎来到了没有知识存在的荒原…</strong>
         </p>
         <p>来源链接是否正确？用户、话题或问题是否存在？</p>
         <hr>
         <p>
           <a href="http://122.13.4.239">返回首页</a>
           <span>或者</span>
           <a href="javascript:;" id="js-history-back">返回上页</a>
         </p>
       </div>
      </div>
    </div>
</body></html>