<template>
  <div id="x_policy_text">
    <div class="out_line">
      <div class="hot_search">

      </div>

      <!--左边长列表-->
      <div class="box1-left">
        <div class="box2-left" style="background-color:red"></div>
        <div class="box3-left" style="background-color:yellow"></div>
      </div>
      <!--右边长列表-->
      <div class="box4-right">
        <div class="box5-right" style="background-color:green"></div>
        <div class="box6-right" style="background-color:gray"></div>
        <div class="box7-right" style="background-color:blue"></div>
      </div>

    </div>
  </div>

  </div>
</template>

<script>
import MHeader from "@/components/common/m-header";

export default {
  name: "policy_text",
  data() {
    return {};
  },
  components: {
    MHeader
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
  height: 350px;
  float: right;
  margin: 10px 0;
}
.hot_search {
  @include adv;
  background-color: aqua;
  height: 50px;
}
.box1-left {
  width: 795px;
  float: left;
  @include i-box;
}
.box2-left {
  @include i-box;
  height: 50px;
  margin: 10px 0;
}
.out_line {
  @include adv;
  height: 100%;
}
/*左边文章样式*/
.box3-left {
  @include i-box;
  height: 1000px;
  margin: 10px 0;
}
.box4-right {
  width: 390px;
  @include i-box;
  float: right;
}
.box5-right,
.box6-right,
.box7-right {
  @include litter_one_tab_box;
}
</style>
