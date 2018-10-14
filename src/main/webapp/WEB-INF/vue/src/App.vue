<template>
  <div id="app">
    <m-header ref="c1"></m-header>
    <keep-alive>
      <router-view></router-view>>
    </keep-alive>
    <!-- <m-footer></m-footer> -->
  </div>
</template>

<script>
import MHeader from "./components/common/m-header";



export default {
  name: "hello",
  components: {
    MHeader,
    //'m-title':Title,
    //'x-text':Text,
    //'x-picture':Picture,
    //'x-hotsearch':hotsearch
    //x_singlesidebar
  
    

  },
  //监听路由变化获取当前路由
  watch: {
    $route() {
      // 获取当前路径
      let path = this.$route.path;
      // 检索当前路径
      this.$refs.c1.checkRouterLocal(path);
    }
  },
  mounted: function() {
    // 获取当前路径
    let path = this.$route.path;
    // console.log(path);
    // 检索当前路径
    this.$refs.c1.checkRouterLocal(path);
  },//确保刷新后页面初始化不出错
  data() {
    return {
      path: ""
    };
  }
};
</script>

<style lang="scss">
body {
  margin: 0;
  font-size: 16px;
  font-family: "微软雅黑", "Microsoft Yahei", Verdana, sans-serif;
  background-color: #ffffff;
  min-width: 1002px;
  // background: url(/static/PICS/body_bg.png) center top repeat rgb(255, 255, 255);
}
ul,
li {
  padding: 0;
  margin: 0;
  list-style: none;
}
input:focus {
  outline: none;
}
a {
  text-decoration: none;
  color: inherit;
}
</style>
