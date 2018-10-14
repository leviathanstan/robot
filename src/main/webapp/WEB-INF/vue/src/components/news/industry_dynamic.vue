<template>
  <div id="x_industry_dynamic">
    <div class="out_line">
      <div class="hot_search">
        <x_hotsearch></x_hotsearch>
      </div>

      <!--左边长列表-->
      <div class="box1-left">
        <div class="box2-left">
          <x_currentlocation></x_currentlocation>
        </div>
        <div class="box3-left"></div>
        <!--下面分页插件-->
        <div class="box-paging">
          <paging></paging>
        </div>
      </div>
      <!--右边长列表-->
      <div class="box4-right">
        <div class="box5-right">
          <x_singlesidebar></x_singlesidebar>
        </div>
        <div class="box6-right">
          <x_tab_switch></x_tab_switch>
        </div>
        <div class="box7-right">
          <x_tab_switch></x_tab_switch>
        </div>
        <div class="box8-right">
          <x_singlesidebar></x_singlesidebar>
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
import Title from "@/components/news/Title.vue";
import x_Text from "@/components/news/Text.vue";
import x_related_reading from "@/components/news/related_reading.vue";
import x_statement from "@/components/news/x_statement.vue";
import x_comment from "@/components/news/comment.vue";
import x_chartlist from "@/components/news/chartlist.vue";
import paging from "@/components/common/paging.vue";

export default {
  name: "policy_text",
  data() {
    return {};
  },
  methods: {
    init() {
      var data = JSON.parse(this.$route.query.item); //接收跳转数据
      console.log(data);
    }
  },
  components: {
    MHeader,
    x_currentlocation,
    x_singlesidebar,
    x_tab_switch,
    x_hotsearch,
    Title,
    x_Text,
    x_related_reading,
    x_statement,
    x_comment,
    x_chartlist,
    paging
  },
  activated() {
    this.init();
  } //组件被激活时调用
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

  height: 50px;
}
.box1-left {
  width: 795px;
  float: left;
  @include i-box;
}
.box2-left {
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
  float: right;
}
.box5-right,
.box6-right,
.box7-right,
.box8-right {
  @include litter_one_tab_box;
}
.box5-right {
  margin-top: 0;
}
.box-paging {
  margin: 10px 0;
}
</style>