<template>
  <div id="Picture">
    <!-- <m-header></m-header> -->
    <div class="x-picture_1"><img src="../../assets/images.jpg"></div>
    <div class="x-title-right">
        <div class="x-picture-outline"><i class="fa fa-font-awesome fa-3x"></i><h1 class="x-picture_title">{{title}}</h1></div>
        <div class="x-preview">{{preview}}</div>
        <div class="x-category">{{category}}</div>
        <div class="x-time">{{time}}</div>
        <div class="x-comments">评论</div>
    </div>
  </div>

</template>

<script>


export default {
  
  data(){
    return {
        title:"直击世界机器人大会:人机共荣会更美好吗？",
        preview:"九月十八日十时，天空中响起了凄厉的防空警报，足足响了20分钟，这天是我们的国耻日。此刻，我们就翻开这中国历史上最沉重的一页。1931年9月18日清晨，日本关东军以“柳条湖事件”为借口，大举进犯沈阳，短短四个月内，长春，锦州，哈尔滨等各大城市，在蒋介石的一声“不许抵抗”中相继沦陷。美丽的东北三省和三千万勤劳的人民就这样简单地成了日军的“战利品”。人民的眼睛是雪亮的，他们不甘愿做日寇的奴隶。东北沦陷后不久，各地区的抗日武装如雨后春笋般冒出头来，涌现出杨靖宇，赵尚志等无数抗日民族英雄。东北人民在14年的水深火热后，经过浴血奋战，最后把日本人赶回了老家。",
        category:"工业机器人",
        time:"2018-09-20 18:00"


    }
  },
  
}
</script>

<style lang="scss" scoped>
    #Picture{
        width:100%;
        height:100%;
        margin-bottom: 10px;
        border-bottom: 2px #aba1a1 solid;
    }
    .x-picture_1{
        display: inline-block;
        float: left;
        width:30%;

        img{
            width:100%;
            height:100%;
            display: inline-block;
            float: left;

        }
    }
    .x-title-right{
        display: inline-block;
        float:right;
        width:70%;
    }
    .x-category,.x-time,.x-comments{
        display:inline-block;
        margin:8px;
        color:gray;
    }
    .x-comments{
        float:right;
    }
    .x-category{
        margin-left:0;
        color:black;
        padding-right:10px;
        border-right: 2px solid gray;
    }
    .x-picture-outline{
        margin:10px 0;
        &:hover{
            color:red;
            cursor: pointer;
        }
        i{
            color:red;
        }
        h1,i{
            display: inline-block;
        }
        h1{
            margin:0;
        }
    }
    .x-preview{
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    margin:13px 0;
    color:gray;
    }


</style>

