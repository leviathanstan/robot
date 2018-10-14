<template>
  <div id="x_information">
    <div class="out_line">
      <div class="hot_search">
        <x_hotsearch></x_hotsearch>
      </div>

      <!--左边长列表-->
      <div class="box1-left">
        <div class="box2-left">
          <x_currentlocation></x_currentlocation>
        </div>
        <div class="box3-left">
          <x_singlesidebar></x_singlesidebar>
        </div>
        <div class="box8-left">
          <x_singlesidebar></x_singlesidebar>
        </div>
        <div class="box9-left">
          <x_singlesidebar></x_singlesidebar>
        </div>
        <div class="box10-left">
          <x_singlesidebar></x_singlesidebar>
        </div>
      </div>
      <!--右边长列表-->
      <div class="box4-right">
        <div class="box5-right">
          <x_tab_switch></x_tab_switch>
        </div>
        <div class="box6-right">
          <x_tab_switch></x_tab_switch>
        </div>
        <div class="box7-right">
          <x_tab_switch></x_tab_switch>
        </div>
      </div>

    </div>
  </div>

  </div>
</template>

<script>
import MHeader from "@/components/common/m-header";
import x_currentlocation from "./currentlocation.vue";
import x_singlesidebar from "./single_sidebar.vue";
import x_tab_switch from "./x_tab_switch.vue";
import x_hotsearch from "@/components/common/hotsearch.vue";

export default {
  name: "information",
  data() {
    return {};
  },
  components: {
    MHeader,
    x_currentlocation,
    x_singlesidebar,
    x_tab_switch,
    x_hotsearch
  }
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
  height: 280px;
  overflow: hidden;
  margin-bottom: 18px;
}
@mixin i-box {
  box-shadow: 0 0 1px #bebebe;
  height: 100%;
  overflow: hidden;
}
/*右边小框重复样式*/
@mixin litter_one_tab_box {
  @include i-box;
  width: 390px;
  height: 300px;
  float: right;
  margin: 10px 0;
}

.hot_search {
  @include adv;
  height: 100%;
}
.box1-left {
  width: 795px;
  float: left;
  height: 100%;
  @include i-box;
}
.box2-left {
  margin: 10px 0;
}
.out_line {
  @include adv;
  height: 100%;
}
/*左边四个小框样式*/
.box3-left,
.box8-left,
.box9-left,
.box10-left {
  @include i-box;
  height: 320px;
  margin: 10px 0;
}
.box4-right {
  width: 390px;

  float: right;
}
.box5-right,
.box6-right,
.box7-right {
  @include litter_one_tab_box;
}
.box5-right {
  margin-top: 0;
}
</style>