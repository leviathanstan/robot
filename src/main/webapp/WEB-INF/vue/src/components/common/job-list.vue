<template>
  <div id="job-list">
    <ul>
      <li v-for="(item, index) in items">
        <a class="list_title"> {{item.job}} </a>
        <b class="pay" style="color: #gf971e;">{{item.pay}}</b>
        <b class="edu_record">{{item.edu_record}}</b>
        <b class="duration">{{item.duration}}</b>
      </li>
    </ul>
    <div class="more" @click="selectItem('/talent/talent-job')">
      更多
    </div>
  </div>
</template>
<script>
export default {
  name: "job-lost",
  data() {
    return {
      items: [
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        },
        {
          job: "产品经理/总监·紫外激光器", //工作职业
          pay: "5000-10000", //工资
          edu_record: "本科", //学历要求
          duration: "1-3年" //工作时长
        }
      ]
    };
  },
  methods: {
    selectItem(item) {
      this.$emit("select", item);
    }
  },
  components: {}
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
#job-list {
  @include whole;
}
#job-list ul {
  & {
    list-style-type: none;
    padding: 0 15px;
    text-align: left;
  }
  li {
    & {
      padding: 4px 0 3px 10px;
      margin-left: 20px;
      font-size: 13px;
      clear: both;
      list-style: disc;
    }
    b {
      color: #5e5757;
      float: left;
      padding: 0 5px;
      font-weight: 100;
      display: block;
      height: 15px;
      overflow: hidden;
      font-family: Verdana;
      padding: 0;
      margin: 0;
      border-top: none;
      line-height: 15px;
      padding: 4px 20px 3px 100px;
    }
    .list_title {
      color: #7b7b7b;
      float: left;
      padding: 0;
      margin: 0;
      border-top: none;
      line-height: 15px;
      padding: 4px 0 3px;
      display: inline-block;
      width: 200px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
      line-height: 15px;
      vertical-align: middle;
      cursor: pointer;
    }
    .list_title:hover {
      color: #ed1c23;
    }
  }
}
.more {
  cursor: pointer;
  text-align: center;
  box-sizing: border-box;
  margin: 15px auto;
  width: 150px;
  color: #ec5257;
  padding: 4px 7px;
  // border: 1px solid #ed1c23;
  box-shadow: 0 0 1px #f5272e;
  border-radius: 2px;
  text-decoration: none;
}
.more:hover {
  box-shadow: 0 0 1px #ed1c23;
}
</style>
