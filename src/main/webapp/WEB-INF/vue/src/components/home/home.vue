<template>
  <div id="home">
    <!-- <m-header ref="c1"></m-header> -->
    <!-- 广告 -->
    <div class="advertise" style="background-color:lightblue;"></div>
    <!-- 资讯 -->
    <div class="box1" style="background-color:white;">
      <div class="box1-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-commenting" aria-hidden="true"></i>
            <span>资讯</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '资讯'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}" @click="routerLink(tab.path,tab)">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[0]" :my-message="tabMessage[0]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box1-right">
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
    </div> <!-- 协会 -->
    <div class="box1" style="background-color:white;">
      <div class="box1-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-users" aria-hidden="true"></i>
            <span>协会</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '协会'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}" @click="routerLink(tab.path,tab)">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[1]" :my-message="tabMessage[1]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box1-right">
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
    <!-- 广告 -->
    <div class="advertise" style="background-color:lightblue;"></div>
    <!-- 企业 -->
    <div class="box1" style="background-color:white;">
      <div class="box1-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-globe" aria-hidden="true"></i>
            <span>企业</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '企业'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[2]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box1-right">
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
    </div>
    <!-- 需求发布 -->
    <div class="box1" style="height: 125px;">
      <ul class="title">
        <li class="menu_title">
          <i class="fa fa-title fa-tachometer" aria-hidden="true" style="margin-top:-4px;"></i>
          <span>供需</span>
        </li>
        <li class="list_title">
          <a></a>
        </li>
      </ul>
    </div>
    <!-- 产品 -->
    <div class="box1" style="background-color:white;">
      <div class="box1-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-android" aria-hidden="true"></i>
            <span>产品</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '产品'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[3]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box1-right">
        <ul class="title">
          <li class="list_title">
            <a class="active" style="margin-left:15px;">产品库搜索</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-search></pb-search>
          </keep-alive>
        </div>
      </div>
    </div>
    <!-- 商城 -->
    <div class="box1" style="height: 125px;">
      <ul class="title">
        <li class="menu_title">
          <i class="fa fa-title fa-shopping-cart" aria-hidden="true"></i>
          <span>商城</span>
        </li>
        <li class="list_title">
          <a></a>
        </li>
      </ul>
    </div>
    <!-- 技术 -->
    <div class="box1" style="background-color:white;">
      <div class="box1-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-lightbulb-o" aria-hidden="true"></i>
            <span>技术</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '技术'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[4]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box1-right">
        <ul class="title">
          <li class="list_title">
            <a class="active" style="margin-left:15px;">新闻热点</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <normal-list></normal-list>
          </keep-alive>
        </div>
      </div>
    </div>
    <!-- 人才 -->
    <div class="box1" style="background-color:white;">
      <div class="box3-left">
        <ul class="title">
          <li class="menu_title">
            <i class="fa fa-title fa-lightbulb-o" aria-hidden="true"></i>
            <span>人才</span>
          </li>
          <li class="list_title" v-for="(tab,index) in tabs" v-if="tab.belong === '人才'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)" @click="routerLink(tab.path,tab)">
            <a :class="{active:tab.isActive}">{{tab.name}}</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <pb-list :is="currentTab[5]"></pb-list>
          </keep-alive>
        </div>
      </div>
      <div class="box3-right">
        <ul class="title">
          <li class="list_title">
            <a class="active" style="margin-left:15px;">最新招聘</a>
          </li>
        </ul>
        <div style="height:270px;width:100%;">
          <keep-alive>
            <job-list></job-list>
          </keep-alive>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MHeader from "@/components/common/m-header";
import PbList from "@/components/common/pb-list";
import UlList from "@/components/common/ul-list";
import PbList2 from "@/components/common/pb-list2";
import PersonList from "@/components/common/person-list";
import PicList from "@/components/common/pic-list";
import PbList3 from "@/components/common/pb-list3";
import PenList from "@/components/common/pen-list";
import JobList from "@/components/common/job-list";
import NormalList from "@/components/common/normal-list";
import PbSearch from "@/components/common/pb-search";

export default {
  name: "home",
  data() {
    return {
      tabMessage: ["", "", "", "", "", "", "", ""],
      currentTab: [
        "pb-list",
        "pb-list",
        "pb-list2",
        "pb-list",
        "pb-list3",
        "pen-list",
        "normal-list",
        ""
      ], //各小标题块内容
      tabs: [
        {
          name: "行业动态",
          belong: "资讯", //归属的小标题
          path: '/industry_dynamic', //点击跳转
          tocpn: "pb-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "咨询热点",
          belong: "资讯", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "政策",
          belong: "资讯",
          path: null,
          tocpn: "pb-list2",
          message: null,
          isActive: false
        },
        {
          name: "行业报告",
          belong: "资讯",
          path: null,
          tocpn: "pb-list2",
          message: null,
          isActive: false
        },
        {
          name: "通知公告",
          belong: "协会", //归属的小标题
          path: "/industry_dynamic", //点击跳转
          tocpn: "pb-list", //子组件名
          message: [
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            },
            {
              content: "聚焦机器人投资风向，2018机器人投资发展论...",
              time: "2018-09-20"
            }
          ], //组件内容，对象数组
          isActive: true
        },
        {
          name: "协会动态",
          belong: "协会", //归属的小标题
          path: "/industry_dynamic", //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "协会会员",
          belong: "协会", //归属的小标题
          path: null, //点击跳转
          tocpn: "person-list", //子组件名
          message: "123", //组件内容，对象数组
          isActive: false
        },
        {
          name: "协会之窗",
          belong: "协会", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "教育培训",
          belong: "协会", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "企业新闻",
          belong: "企业", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "品牌展厅",
          belong: "企业", //归属的小标题
          path: null, //点击跳转
          tocpn: "pic-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "会员动态",
          belong: "企业", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "产品推荐",
          belong: "产品", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "产品新闻",
          belong: "产品", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "产品评测",
          belong: "产品", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list2", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "产品库",
          belong: "产品", //归属的小标题
          path: null, //点击跳转
          tocpn: "person-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "技术研讨",
          belong: "技术", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list3", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "基础知识",
          belong: "技术", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list3", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "案例库",
          belong: "技术", //归属的小标题
          path: null, //点击跳转
          tocpn: "pb-list3", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "专家库",
          belong: "人才", //归属的小标题
          path: "/talent/talent-list", //点击跳转
          tocpn: "pen-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "专家智点",
          belong: "人才", //归属的小标题
          path: null, //点击跳转
          tocpn: "ul-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "高校",
          belong: "人才", //归属的小标题
          path: "/talent/talent-list", //点击跳转
          tocpn: "pen-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "用户中心",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "normal-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "订阅资讯",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "normal-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "我的交易",
          belong: "用户", //归属的小标题
          path: null, //点击跳转
          tocpn: "normal-list", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "近期活动",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          message: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "协会活动",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "其他",
          belong: "活动", //归属的小标题
          path: null, //点击跳转
          tocpn: "", //子组件名
          message: null, //组件内容，对象数组
          isActive: false
        }
      ]
    };
  },
  methods: {
    init() {
      var url = this.HOST + "/common/getIndex";
      this.axios
        .get(url)
        .then(response => {
          // console.log(response)
          this.tabs[5].message = response.data.message.news;
          // console.log(this.tabs[5])
        })
        .catch(function(response) {
          console.log(response);
        });
    },
    routerLink(path, data) {
      if (path) {
        let address = path;
        let item = JSON.stringify(data); //传递跳转数据
        this.$router.push({ path: address, query: { item } }); //路由跳转
      }
    },
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
      //更改组件内容
      var t = 0;
      if (this.tabs[index].belong == "资讯") t = 0;
      else if (this.tabs[index].belong == "协会") t = 1;
      else if (this.tabs[index].belong == "企业") t = 2;
      else if (this.tabs[index].belong == "产品") t = 3;
      else if (this.tabs[index].belong == "技术") t = 4;
      else if (this.tabs[index].belong == "人才") t = 5;
      else if (this.tabs[index].belong == "用户") t = 6;
      else if (this.tabs[index].belong == "活动") t = 7;

      this.currentTab[t] = this.tabs[index].tocpn;
      this.tabMessage[t] = this.tabs[index].message;
      // console.log(this.tabMessage[t]);
      //更改小标题块内容
    }
  },
  // computed: {
  //   filterTabs: function() {
  //     var tabs = this.tabs;
  //     return tabs.filter(function(tab) {
  //       return tab.belong == "资讯";
  //     });
  //   }
  // },
  components: {
    MHeader,
    PbList,
    PbList2,
    UlList,
    PersonList,
    PicList,
    PbList3,
    PenList,
    JobList,
    NormalList,
    PbSearch
  },
  mounted() {
    this.init();
  }
  // mounted() {
  //   send(){
  //     axios({
  //       method:'get',
  //       url:''
  //     }).then(function(res){
  //       console.log(res.data);
  //     });
  //   }
  // }
};
</script>

<style lang="scss" scoped>
@mixin adv {
  margin: 5px auto;
  width: 1200px;
  height: 125px;
  overflow: hidden;
}
@mixin w-box {
  margin: 5px auto;
  width: 1200px;
  height: 312px;
  overflow: hidden;
  margin-bottom: 18px;
}
@mixin i-box {
  box-shadow: 0 0 1px #bebebe;
  height: 100%;
  overflow: hidden;
  box-sizing: border-box;
}
@mixin border {
  -webkit-box-shadow: 0 0 1px #bebebe;
  box-shadow: 0 0 1px #bebebe;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  border: 1px solid rgba(204, 204, 204, 0.377);
}
.active {
  color: #ed1c22 !important;
  border-bottom: 2px solid #ed1c22;
  padding-bottom: 4px;
}
.advertise {
  @include adv;
}
.box1 {
  @include w-box;
  @include border;
}
.box1-left {
  width: 795px;
  float: left;
  @include i-box;
  @include border;
}
.box1-right {
  @include i-box;
  @include border;
  width: 390px;
  float: right;
}
.box2-left {
  @include i-box;
  @include border;
  width: 406px;
  float: left;
}
.box2-right {
  @include i-box;
  @include border;
  width: 375px;
  float: left;
  margin-left: 15px;
}
.box3-left {
  @include i-box;
  width: 390px;
  float: left;
  @include border;
}
.box3-right {
  width: 795px;
  float: right;
  @include border;
  @include i-box;
}

.fa-title {
  // margin-top: 2px;
  vertical-align: middle;
  font-size: 1.5em;
  color: #333;
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
.menu_title {
  float: left;
  display: inline-block;
  padding: 0 10px;
  margin-right: 40px;
  cursor: default;
}
.menu_title span {
  font-size: 1em;
  font-weight: 500;
  color: #404040;
  line-height: 25px;
  vertical-align: middle;
}
.list_title a {
  cursor: pointer;
  color: #7b7b7b;
  font-size: 1em;
  font-weight: 500;
  line-height: 25px;
  vertical-align: middle;
  margin-right: 10px;
}
.list_title a:hover {
  color: #ed1c22;
  border-bottom: 2px solid #ed1c22;
  padding-bottom: 4px;
}
</style>

