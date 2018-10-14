<template>
  <div id="talent">
    <keep-alive>
      <router-view @select="routerLink"></router-view>
    </keep-alive>
  </div>
</template>

<script>


export default {
  name: "talent",
  data() {
    return {
    //   currentTab: [
    //     "pb-list",
    //     "pb-list",
    //     "pb-list2",
    //     "pb-list",
    //     "pb-list3",
    //     "pen-list",
    //     "",
    //     ""
    //   ], //各小标题块内容
    //   tabs: [
    //     {
    //       name: "用户中心",
    //       belong: "用户", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: true
    //     },
    //     {
    //       name: "订阅资讯",
    //       belong: "用户", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "normal-list", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: false
    //     },
    //     {
    //       name: "我的交易",
    //       belong: "用户", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "normal-list", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: false
    //     },
    //     {
    //       name: "近期活动",
    //       belong: "活动", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: true
    //     },
    //     {
    //       name: "协会活动",
    //       belong: "活动", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: false
    //     },
    //     {
    //       name: "其他",
    //       belong: "活动", //归属的小标题
    //       path: null, //点击跳转
    //       tocpn: "", //子组件名
    //       content: null, //组件内容，对象数组
    //       isActive: false
    //     }
    //   ]
    };
  },
  methods: {
    routerLink(path){
      this.$router.push(path);//路由跳转
    },
    // tabLink(index, tocpn) {
    //   //更改高亮标签
    //   this.$set(
    //     this.tabs,
    //     this.tabs[index],
    //     (this.tabs[index].isActive = true)
    //   );
    //   for (var i = 0; i < this.tabs.length; i++) {
    //     if (this.tabs[i].belong == this.tabs[index].belong && i != index) {
    //       this.$set(this.tabs, this.tabs[i], (this.tabs[i].isActive = false)); //解决methods中无法更改data数据的问题
    //     }
    //   }
    //   var t = 6;
    //   if (this.tabs[index].belong == "用户") t = 6;
    //   else if (this.tabs[index].belong == "活动") t = 7;

    //   this.currentTab[t] = this.tabs[index].tocpn;
    //   //更改小标题块内容
    // }
  },
  components: {
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

</style>

