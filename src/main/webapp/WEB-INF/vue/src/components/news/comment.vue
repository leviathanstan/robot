<template>
    <div id="x_comment">
        <div class="comment_top">
            <div class="comment_outline">
                <div>我来说两句(共n条评论)</div>
                <div class="comment_exit">[退出]</div><div class="comment_account">用户xxx</div>
            </div>
            <textarea placeholder="请输入评论" ></textarea>
            <button class="sendcomment" src="#">发表评论</button>
        </div>
        <div class="comment_bottom">
            <div class="comment_show_top">
            <ul >
                <li @click="handleclick1" :class="[{border_red:isOn1}]">最新评论</li>
                <li @click="handleclick2" :class="[{border_red:isOn2}]">热门评论</li>
            </ul>
            </div>
            <div class="comment_show_down">暂无评论</div>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                isOn1:true,
                isOn2:false
            }
        },
    methods:{
        handleclick1:function(){
            this.isOn1=true
            this.isOn2=false
            console.log(1);
        },
         handleclick2:function(){
            this.isOn2=true
            this.isOn1=false
            console.log(1);
        }
    }
    
    }
</script>

<style lang="scss" scoped>
.comment_top{
    
   textarea{
       resize:none;
        width:100%;
        height:100px;
        padding:0;
        top:0;
        outline:none;
    }
  
    button{
        color:white;
        background: rgb(196, 22, 22);
        padding:5px 8px;
        border:none;
       box-shadow: 1px 1px 1px gray;
       font-size: 20px;
       float:right;
    }
}
  .comment_outline{
      background:#a49f9f2b;
  }
  .comment_outline{
      & div{
          display: inline-block;
          margin:5px 3px;
          vertical-align: top;
      }
      .comment_account{
          float:right;
      }
  }
        .comment_exit{
          display: inline-block;
          vertical-align: top;
          float:right;
          color:#0053ff;
      }
      .comment_bottom{
          margin-top:80px;
          width:100%;
      }
      .comment_show_top{
         
          background:#a49f9f2b;
          display: block;
          width:100%;
          height:45px;
          line-height: 30px;
          ul{
              height:inherit;
              height:30px;
          line-height: 30px;
          }
          li{
              float:left;
              display: inline-block;
             height:inherit;
          line-height: inherit;
              padding:6px;
              border:0.2px solid #d3d0d0;
              border-bottom:none;
              cursor: pointer;
              
          }
      }
      .border_red{
          border-top:red 3px solid!important;
      }
      .comment_show_down{
        border:0.6px gray solid;
        height: 100px;
      }
</style>