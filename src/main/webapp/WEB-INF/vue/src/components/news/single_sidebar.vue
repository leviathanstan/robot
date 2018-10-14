<template>
  <div id="x_singlesidebar">
      <div class="x_singlesidebar">
          <div class="x_singlesiderbar_title"><a>{{title}}</a></div>
          <span class="x_singlesiderbar_title_more"><a>更多</a></span>
      </div>
      <div class="x_singlesiderbar_content">
          <li class="x_singlesiderbar_title_list_first"><a>{{list_first}}</a></li>
          <li v-for="(li,index) of list" :key="index" class="x_singlesiderbar_li"><a>{{li}}</a><a></a></li>
      </div>
  </div>
</template>

<script>


export default {
    data(){
        return {
            title:"广告招商",
            list_first:"世界机器人大会背后的中国制造",
            list:["我好懒啊天呀",
            "我好懒啊天呀",
            "我好懒啊天呀",
            "我好懒啊天呀",
            "我好懒啊天呀",
            "我好懒啊天呀"
            
            ]

        }
    }
}
</script>

<style lang="scss" scoped>
*{
    font: 13px/22px "微软雅黑";
}
.x_singlesiderbar_title_list_first a{
    font-size: 16px;
    width: 400px;
    height: 20px;
    padding-left: 10px;
    display: block;
    margin-top: 15px;
    font-weight: bold;
    color: #3f3f3f;
    cursor: pointer;
    text-overflow: ellipsis;
    margin-bottom:15px;
}

    .x_singlesidebar{
       

        color: #3f3f3f;
        background: #FFF;
        background: transparent;
        height: 31px;
        display: block;
        width: 100%;
    }
    .x_singlesiderbar_title{
            float: left;
        line-height: 31px;
        
    }
    .x_singlesiderbar_title_more a{
    font-size: 14px;
    float: right;
    height: 31px;
    line-height: 31px;
    display: block;
    margin-right: 15px;
    padding-left: 20px;
    }
     .x_singlesiderbar_title_more :before {
    content: "+";
    display: inline-block;
    color: #ed1c22;
    text-align: center;
    vertical-align: top;
    position: static;
    font-size: 20px;
    width: 20px;
    height: 29px;
    line-height: 27px;
    /* background: url(../images/picxi.png) no-repeat -3px -586px; 图片旋转*/
    transition: all 0.2s;
    -webkit-transition: all 0.2s;
    -moz-transition: all 0.2s;
    -ms-transition: all 0.2s;
    -o-transition: all 0.2s;
    transition: all 0.2s;
}
    .x_singlesiderbar_title_more a{
            cursor: pointer;

    }
    .x_singlesiderbar_title a{
    color: #454545;
    text-align: center;
    height: 30px;
    line-height: 30px;
    display: block;
    padding: 0 15px;
    margin: 0 !important;
     background: #FFF;
    color: #ed1c22 !important;
     font-weight: bold;
     font-size: 16px;
    }
    .x_singlesiderbar_content{
        min-height:200px;
    }
    .x_singlesiderbar_li{
        font-weight: bold;
        width: auto;
        padding: 0 15px;
        height: 20px;
        font-size: 13px;
        
        margin: 0 !important;
        border-top: 1px solid #dedede;
        padding: 3px 0;
        a{overflow: hidden;
        padding-left:10px;
        text-overflow: ellipsis;
        white-space: nowrap;}

       
        &:hover{
            color:#e06a6a;
            cursor: pointer;

        }

    }

</style>

