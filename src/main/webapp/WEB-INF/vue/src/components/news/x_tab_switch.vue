<template>
  <div id="x_tab_switch">

    <nav>
      <ul class="x_tab_switch_ul">
        <li class="x_tab_switch_li"><a href="javascript:void(0)" @mouseover="toggleTabs(first,0);" v-bind:class="{active:this.current==0}">{{title1}}</a></li>

        <li class="x_tab_switch_li"><a href="javascript:void(0)" @mouseover="toggleTabs(second,1);" v-bind:class="{active:this.current==1}">{{title2}}</a></li>

        <li class="x_tab_switch_li"><a href="javascript:void(0)" @mouseover="toggleTabs(third,2);" v-bind:class="{active:this.current==2}">{{title3}}</a></li>

      </ul>
      <transition mode="out-in">
        <first :is="currentView" keep-alive></first>
      </transition>

    </nav>

  </div>
</template>

<script>
import first from "./first.vue";

import second from "./second.vue";

import third from "./third.vue";

export default {
  data() {
    return {
      title1: "前端",
      first: "first",

      title2: "后台",
      second: "second",

      title3: "安卓",
      third: "third",

      currentView: "first",
      isHide: false,
      current: 0
    };
  },

  components: {
    first,

    second,

    third
  },

  methods: {
    toggleTabs(tabText, index) {
      this.currentView = tabText; //切换组件

      this.current = index;
      //m.currentTarget.setAttribute("class","active");
    }
  }
};
</script>

<style lang="scss" scoped>
#x_tab_switch {
  margin-left: 15px;
  overflow: hidden;
  text-align: left;
  min-height: 277px;
}

nav {
  width: 600px;

  background: white;

  padding: 0 10px;

  &：a {
    text-decoration: none;

    color: #000;

    display: inline-block;

    width: 150px;

    text-align: center;

    background: #aaaaaa;

    padding: 10px;
  }
}
.v-enter,
.v-leave-to {
  opacity: 0;
  transform: translateX(200px);
}
.v-enter-active,
.v-leave-active {
  transition: all 1s ease;
}
ul {
  display: block;
  height: 30px;
  padding: 5px;
}
.x_tab_switch_li {
  margin: 0 8px;
  font-size: 14px;
  list-style: none;
  padding: 0;
  float: left;
  font-family: "微软雅黑", "Microsoft Yahei" !important;
}
li a {
  color: #7b7b7b;
  cursor: default;
  font-size: 14px;
  list-style-type: none;
  text-align: left;
  line-height: 28px;
}
a {
  margin: 10px 0;
}
li {
  margin: 10px 0;
}
.active {
  color: #ed1c22;
  border-bottom: 2px solid #ed1c22;
  cursor: default;
  padding-bottom: 4px;
  transition: 0.5s;
}
</style>