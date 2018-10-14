<template>
  <div id="talent-job">
    <div class="left_block">
      <!-- 位置路径 -->
      <div class="box1">
        <div class="curr_position">
          当前位置：
          <a @click="selectItem('/home')">服务平台</a>
          <span>></span>
          <a @click="selectItem('/talent')">人才</a>
          <span>></span>
          <a>招聘</a>
        </div>
      </div>
      <!-- 最新招聘 -->
      <div class="box3">
        <ul class="title">
          <li class="list_title">
            <a class="active" style="margin-left:15px;">最新招聘</a>
          </li>
          <span class="more" @click="selectItem('/talent/talent-job')">-更多></span>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <job-list v-on="$listeners"></job-list>
          </keep-alive>
        </div>
      </div>
      <!-- 职位搜索 -->
      <div class="box2">
        <ul class="title">
          <li class="list_title">
            <a class="active" style="margin-left:15px;">职位搜索</a>
          </li>
        </ul>
        <div style="width:100%;">
          <keep-alive>
            <job-search></job-search>
          </keep-alive>
        </div>
      </div>
      <!-- 职位列表 -->
      <div class="box3">
        <div style="min-height:270px;width:100%;">
          <keep-alive>
            <job-table v-on="$listeners"></job-table>
          </keep-alive>
        </div>
      </div>
    </div>
    <div class="right_block">
      <!-- 广告招收 -->
      <div class="box4">
        <ul class="title">
          <li class="list_title">
            <a style="margin-left:15px;">广告招收栏目</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <!-- <advertise-list></advertise-list> -->
          </keep-alive>
        </div>
      </div>
      <!-- 用户 -->
      <div class="box4">
        <ul class="title" style="margin-left:15px;">
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '用户'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[6]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <!-- 活动 -->
      <div class="box4">
        <ul class="title" style="margin-left:15px;">
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '活动'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[7]"></pb-list>
          </keep-alive>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MHeader from "@/components/common/m-header";
import JobList from "@/components/common/job-list";
import NormalList from "@/components/common/normal-list";
import JobSearch from "@/components/common/job-search";
import JobTable from "@/components/common/job-table"

export default {
  name: "talent-job",
  data() {
    return {
      currentTab: [
        "pb-list",
        "pb-list",
        "pb-list2",
        "pb-list",
        "pb-list3",
        "pen-list",
        "",
        ""
      ], //各小标题块内容
      tabs: [
        {
          name: "用户中心",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          content: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "订阅资讯",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "normal-list", //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "我的交易",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "normal-list", //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "近期活动",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          content: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "协会活动",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "其他",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        }
      ]
    };
  },
  methods: {
    selectItem(item){
      this.$emit('select',item);
    },//将item通过select传给父组件
    // routerLink(path){
    //   this.$router.push(path);//路由跳转
    // },
    tabLink(index, tocpn) {
      //更改高亮标签
      this.$set(
        this.tabs,
        this.tabs[index],
        (this.tabs[index].isActive = true)
      );
      for (var i = 0; i < this.tabs.length; i++) {
        if (this.tabs[i].belong == this.tabs[index].belong && i != index) {
          this.$set(this.tabs, this.tabs[i], (this.tabs[i].isActive = false)); //解决methods中无法更改data数据的问题
        }
      }
      var t = 6;
      if (this.tabs[index].belong == "用户") t = 6;
      else if (this.tabs[index].belong == "活动") t = 7;

      this.currentTab[t] = this.tabs[index].tocpn;
      //更改小标题块内容
    }
  },
  components: {
    MHeader,
    JobList,
    NormalList,
    JobSearch,
    JobTable
  }
};
</script>

<style lang="scss" scoped>
@mixin left {
  margin: 5px auto;
  width: 795px;
  float: left;
  box-sizing: border-box;
  overflow: hidden;
}
@mixin right {
  margin: 5px auto;
  width: 390px;
  float: right;
  box-sizing: border-box;
  overflow: hidden;
}
@mixin i-box {
  -webkit-box-shadow: 0 0 1px #bebebe;
  box-shadow: 0 0 1px #bebebe;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  border: 1px solid rgba(204, 204, 204, 0.377);
  height: 100%;
  overflow: hidden;
  box-sizing: border-box;
}
.active {
  color: #ed1c22 !important;
  border-bottom: 2px solid #ed1c22;
  padding-bottom: 4px;
}
#talent-job {
  margin: 5px auto;
  width: 1200px;
  overflow: hidden;
}
.left_block {
  @include left;
}
.right_block {
  @include right;
}
.box1,
.box2,
.box3 {
  @include left;
  @include i-box;
}
.box1 {
  & {
    color: #404040;
    font-weight: 500;
    padding: 0 15px;
    overflow: hidden;
  }
  .curr_position {
    & {
      margin-top: 14px;
      margin-bottom: 15px;
    }
    a {
      text-decoration: none;
      cursor: pointer;
    }
  }
}
.box4 {
  @include right;
  @include i-box;
}
.title {
  margin-bottom: 12px;
  margin-top: 2px;
  width: 100%;
  height: 28px;
  line-height: 28px;
}
.title li {
  float: left;
}
.more {
  & {
    color: #666;
    font-size: 14px;
    float: right;
    padding: 2px 10px 0 2px;
    cursor: pointer;
  }
  &:hover {
    color: #ed1c22;
  }
}
.menu_title {
  float: left;
  display: inline-block;
  padding: 0 10px;
  margin-right: 40px;
}
.menu_title span {
  font-size: 1em;
  font-weight: 500;
  color: #404040;
  line-height: 25px;
  vertical-align: middle;
}
.list_title a {
  color: #7b7b7b;
  cursor: default;
  font-size: 1em;
  font-weight: 500;
  line-height: 25px;
  vertical-align: middle;
  margin-right: 10px;
}
.list_title a:hover {
  color: #ed1c22;
  border-bottom: 2px solid #ed1c22;
  cursor: default;
  padding-bottom: 4px;
}
</style>

