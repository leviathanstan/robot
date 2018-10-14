<template>
  <div id="job-table">
    <ul class="title">
      <li class="list_title" style="width:9%;">
        <a>职位</a>
      </li>
      <li class="list_title" style="width:19%;">
        <a>公司名称</a>
      </li>
      <li class="list_title" style="width:29%;">
        <a>岗位要求</a>
      </li>
      <li class="list_title" style="width:9%;">
        <a>薪资</a>
      </li>
      <li class="list_title" style="width:19%;">
        <a>工作地点</a>
      </li>
      <li class="list_title" style="width:9%;">
        <a>发布时间</a>
      </li>
    </ul>
    <ul class="content" v-for="(item,index) in items" @click="selectItem('/talent/talent-apply')">
      <li style="width:9%;"><a>{{item.job}}</a></li>
      <li style="width:19%;"><a>{{item.compony}}</a></li>
      <li style="width:29%;"><a>{{item.require}}</a></li>
      <li style="width:9%;"><a>{{item.pay}}</a></li>
      <li style="width:19%;"><a>{{item.address}}</a></li>
      <li style="width:9%;"><a>{{item.time}}</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "job-table",
  data() {
    return {
      items: [
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        },
        {
          job: "高级机械工程师",
          compony: "深圳库卡自动化设备有限公司",
          require:
            "1、项目前期验证，方案制作及报价核算；2、完成项目机械部分的设计;3、完成2D工程图及标准",
          pay: "12k-25k",
          address: "深圳",
          time: "2018-08-31"
        }
      ]
    };
  },
  methods:{
    selectItem:function(path){
      this.$emit('select',path);
    }
  }
};
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
  list-style: none;
}
@mixin whole {
  width: 100%;
  height: 100%;
}
#job-table {
  @include whole;
}
.active {
  color: #ed1c22 !important;
  border-bottom: 2px solid #ed1c22;
  padding-bottom: 4px;
}
.title {
  & {
    background: #7b7b7b;
    width: 100%;
  }
  li {
    & {
      display: inline-block;
    }
    a {
      color: #fff;
      cursor: default;
      font-size: 1em;
      font-weight: 500;
      line-height: 25px;
      vertical-align: middle;
      text-align: center;
      width: 100%;
      display: inline-block;
      box-sizing: border-box;
    }
  }
}
.content {
  & {
    width: 100%;
    margin: 5px 0;
  }
  &:focus a,
  &:hover a {
    white-space: initial;
    font-weight: 600;
  }
  li {
    & {
      display: inline-block;
    }
    a {
      font-size: 1em;
      color: #555555;
      font-weight: 500;
      line-height: 25px;
      vertical-align: middle;
      text-align: center;
      width: 100%;
      display: inline-block;
      box-sizing: border-box;
      max-height: 130px;
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
    }
  }
}
</style>
