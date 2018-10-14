<template>
  <div id="talent-apply">
    <div class="left_block">
      <!-- 位置路径 -->
      <div class="box1">
        <div class="curr_position">
          当前位置：
          <a @click="selectItem('/home')">服务平台</a>
          <span>></span>
          <a @click="selectItem('/talent')">人才</a>
          <span>></span>
          <a @click="selectItem('/talent/talent-job')">招聘</a>
          <span>></span>
          <a>职位招聘</a>
        </div>
      </div>
      <!-- 最新招聘 -->
      <div class="box3">
        <ul class="about">
          <li class="first">发布时间：<span>2018-07-01</span></li>
          <li>截止时间：<span>2015-08-17</span></li>
          <li style="width:23s%;border-right:none;">已浏览 <span>1860次</span></li>
        </ul>
        <ul class="itme">
          <li class="first"><span>高级机械工程师</span></li>
          <li class="job-compony"><span>深圳库卡自动化设备有限公司</span></li>
          <li class="job-width">公司规模：<span>1-49人</span></li>
          <li class="job-class">公司性质：<span>民营</span></li>
          <li class="job-type">公司行业：<span>工程/机械/能源</span></li>
        </ul>
        <ul class="pay">
          <li>
            <div>薪资待遇：<span>13-25k/月</span></div>
            <div>招聘职位：<span>技术研发工程师</span></div>
          </li>
          <li>
            <div>学历要求：<span>大专</span></div>
            <div>
              招聘人数：<span>3人</span></div>
          </li>
          <li>工作年龄：<span></span></li>
          <li>联系电话<span></span></li>
          <div class="supply">立即申请</div>
          <span></span>
        </ul>
        <ul class="job-title">
          <li :class="{active2:tab.isActive}" v-for="(tab,index) in tabs" v-if="tab.belong === '职位'" :key="tab.name" @mouseover="tabLink(index,tab.tocpn)">
            <a>{{tab.name}}</a>
          </li>
        </ul>
        <div class="job-content" style="width:100%;">

        </div>
        <div class="job-more">

        </div>
        <div>

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
import NormalList from "@/components/common/normal-list";

export default {
  name: "talent-apply",
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
        },
        {
          name: "职位描述",
          belong: "职位", //归属的小标题
          path: null, //点击跳转
          tocpn: null, //子组件名
          content: null, //组件内容，对象数组
          isActive: true
        },
        {
          name: "公司介绍",
          belong: "职位", //归属的小标题
          path: null, //点击跳转
          tocpn: null, //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        },
        {
          name: "公司其他职位",
          belong: "职位", //归属的小标题
          path: null, //点击跳转
          tocpn: null, //子组件名
          content: null, //组件内容，对象数组
          isActive: false
        }
      ]
    };
  },
  methods: {
    selectItem(item) {
      this.$emit("select", item);
    }, //将item通过select传给父组件
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
      if (tocpn != null) {
        var t = 6;
        if (this.tabs[index].belong == "用户") t = 6;
        else if (this.tabs[index].belong == "活动") t = 7;

        this.currentTab[t] = this.tabs[index].tocpn;
        //更改小标题块内容
      }
    }
  },
  components: {
    NormalList
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
.active2 {
  & {
    box-sizing: border-box;
    color: #535353;
    font-weight: 600;
  }
  &::after {
    content: "";
    position: absolute;
    bottom: -3px;
    left: 0;
    width: 100%;
    height: 4px;
    border-bottom: #ec252c 3px solid;
    z-index: 99;
  }
}
#talent-apply {
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
.box3 {
  color: #404040;
  padding: 0 15px;
}
@mixin class1 {
  width: 100%;
  overflow: hidden;
  box-sizing: border-box;
  margin: 5px 0;
  padding: 10px 0;
  border-bottom: #ccc 3px solid;
}
.about {
  & {
    @include class1;
  }
  .first {
    margin-left: -15px;
  }
  li {
    text-align: center;
    display: inline-block;
    box-sizing: border-box;
    padding-right: 15px;
    width: 30%;
    border-right: #ada2a2 2px solid;
    line-height: 15px;
  }
}
.itme {
  & {
    @include class1;
    padding: 5px 0 10px 0;
  }
  .first {
    font-weight: bold;
    display: block;
    font-size: 17px;
  }
  .job-compony {
    display: block;
  }
  li {
    text-align: left;
    padding: 3px 5px;
    display: inline-block;
    box-sizing: border-box;
    padding-right: 35px;
  }
}
.pay {
  & {
    @include class1;
    border-bottom: none;
  }
  li {
    & {
      text-align: left;
      padding: 3px 5px;
      box-sizing: border-box;
      padding-right: 90px;
    }
    div {
      display: inline-block;
      width: 40%;
    }
  }
  .supply {
    display: inline-block;
    color: #fff;
    background: #ec252c;
    font-weight: 500;
    font-size: 18px;
    padding: 10px 13px;
    margin: 10px 0;
    border-radius: 5px;
    cursor: pointer;
  }
}
.job-title {
  & {
    @include class1;
    overflow: initial;
    padding: 0;
  }
  li {
    & {
      font-size: 18px;
      display: inline-block;
      text-align: left;
      padding-bottom: 10px;
      font-weight: 500;
      margin-right: 20px;
      color: #404040;
      cursor: pointer;
      user-select: none;
      position: relative;
    }
    // &:hover {
    //   box-sizing: border-box;
    //   color: #535353;
    //   font-weight: 600;
    // }
    // &:hover::after {
    //   content: "";
    //   position: absolute;
    //   bottom: -3px;
    //   left: 0;
    //   width: 100%;
    //   height: 4px;
    //   border-bottom: #ec252c 3px solid;
    //   z-index: 99;
    // }
    a {
      text-align: left;
    }
  }
}
.job-content {
  @include i-box;
  height: 200px;
  margin-top: 20px;
  padding: 0 10px;
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