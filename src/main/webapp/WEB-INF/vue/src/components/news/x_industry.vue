<template>
  <div id="x_industry">
      <div class="x_region">
          <p>地区</p>
          <div class="x_holding_list">
              <li v-for="(li,index) of list" :key="index" class="x_holding_list_li">{{li}}</li>
            </div>
      </div>
      <div class="x_industry">
          <p>行业</p>
                <div class="x_holding_list">
              <li v-for="(li,index) of list1" :key="index" class="x_holding_list_li">{{li}}</li>
            </div>
      </div>
  </div>
</template>

<script>


export default {
    data(){
        return{
        list:[
        "广州（）",
        "上海（）",
        "武汉（）",
        "合肥（）",
        "山东（）",
        "昆明（）",
        "汕头（）",
        "新疆（）",
        "浙江（）"
    ],
        list1:[
        "物流分拣（）",
        "汽车制造（）",
        "金属制品（）",
        "电子电气（）",
        "塑料橡胶（）",
        "食品（）",
        "智能家具（）",
        "医疗（）"

    ]

        }
    }
    
}
</script>

<style lang="scss" scoped>
    .x_holding_list_li{
        float: left;
        display: inline-block;
        margin:0 10px;
        color:blue;
        &:hover{
            color:#e06a6a;
            cursor: pointer;

        }

    }
    .x_holding_list{
        max-width:400px;
    }
    .x_region,.x-industry{

        display:block;
        height:150px;
    
    }
    #x_industry{
        padding:5px;
    }
     p{
            margin:0 0 50px 0;
        }
</style>