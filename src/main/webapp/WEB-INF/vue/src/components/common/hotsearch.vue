<template>
    <div id="x_hotsearch">
    
        <!-- <m-header></m-header> -->
        <div class="hotsearch-leftpart"> 
          <div class="hotsearch-remind">热门搜索：</div>
          <ul class="hotsearch-recommend">
            <li v-for="(item,index) of List" >{{item}}</li>
          </ul>
        </div>
        <div class="hotsearch-rightpart">
          <li class="hotsearch-right-leftpart">
            <div>
              
                <div class="x-downlist-outline">
                <div class="x-downlist-all">全部</div>
                <div class="x-downlist" @click="handleclick"><img src="../../assets/seach-bot.jpg"></div>
                </div>
                <ul class="hotsearching-choose-list" v-if="show">
                  <li v-for="(item,index) of List" >{{item}}</li>
                </ul>
              <label>
                <input >
              </label>
            </div>
          </li>
          <li class="hotsearch-right-rightpart">
            <input value="搜索">
          </li>
        </div>
    </div>
</template>

<script>
    export default {
     data(){
       return{
         List:['产品推荐','行业报告','技术标准','政策'],
         show:false
         
       }
     },
       methods:{
         handleclick:function(){
           this.show=!this.show;
         }
       }

     
      
    }
</script>

<style lang="scss" scoped>
#x-hotsearch{
  width:100%;
  height:100%;
  padding:15px;
}
  .hotsearch-recommend {
    display: inline-block;
    margin:0;
    padding:0;
    li{
      display:inline-block;
      float: right;
      padding: 0 10px;
      &:hover{
        color:#ed1c23;
        cursor:pointer;
      }
    }
    
  }
  .hotsearch-remind{
    display:inline-block;
    vertical-align: top;
  }
  .x-downlist-outline{
    display:inline-block;
    background-color: white;
    line-height: inherit;
    height: inherit;
    
  }
  .x-downlist{
      display: inline-block;
    height: 20px;
    
    //display: inline-block;//span一定要设这个
   img{
     height:20px;
     width:40px;
   }
    
  }
  .hotsearching-choose-list{
    position: absolute;
    border:1px gray;
    li{
      padding:3px;
      text-align: center;
    }
  }
  .x-downlist-all{
    display: inline-block;
    vertical-align: top;
    
  }
  .hotsearch-leftpart,.hotsearch-rightpart,.hotsearch-right-leftpart,.hotsearch-right-rightpart{
    display: inline-block;
  }
  .hotsearch-right-leftpart {
   border-right:#ed1c23 2px solid;
   float:left;
  }
  .hotsearch-right-leftpart input{
    height:19.5px;
    vertical-align: top;
  
  }
  .hotsearch-right-rightpart{
    padding:2px;
    background-color: #ed1c23;
  }
  .hotsearch-right-rightpart input{
    background-color: #ed1c23;
    width:50px;
    
    text-align: center;
    border:solid 1px #ed1c23;
    color:white;
  }
  .hotsearch-rightpart{
    float:right;
    
  }
</style>
