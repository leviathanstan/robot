<template>
  <div id="pb-list">
    <!-- <ul class="title">
      <li class="menu_title">
        <slot name="title">
        </slot>
      </li>
      <li class="list_title" v-for=""></li>
    </ul> -->
    <div class="slide">
      <slide></slide>
    </div>
    <div class="ul_list">
      <ul-list v-bind="$attrs"></ul-list>
    </div>
  </div>
</template>

<script>
import Slide from "@/components/common/slide";
import UlList from "@/components/common/ul-list";

export default {
  name: "pb-list",
  data() {
    return {};
  },
  components: {
    Slide,
    UlList
  },
};
</script>

<style lang="scss" scoped>
@mixin max {
  width: 100%;
  height: 100%;
}
#pb-list {
  @include max;
  // border: 1px solid rgba(204, 204, 204, 0.575);
}
// .fa-title {
//   // margin-top: 2px;
//   vertical-align: middle;
//   font-size: 1.5em;
//   color: #333;
// }
// .title {
//   margin-bottom: 10px;
//   width: 100%;
//   height: 28px;
//   line-height: 28px;
// }
// .title li {
//   float: left;
// }
// .title .active {
//   color: #ed1c22;
//   border-bottom: 2px solid #ed1c22;
//   cursor: pointer;
//   padding-bottom: 4px;
// }
// .menu_title {
//   float: left;
//   display: inline-block;
//   padding: 0 10px;
//   margin-right: 60px;
// }
// .menu_title span {
//   font-size: 1em;
//   font-weight: 500;
//   color: #404040;
//   line-height: 25px;
//   vertical-align: middle;
// }
.slide {
  width: 350px;
  float: left;
  height: 250px;
  overflow: hidden;
}
.ul_list {
  width: 440px;
  float: right;
}
</style>
