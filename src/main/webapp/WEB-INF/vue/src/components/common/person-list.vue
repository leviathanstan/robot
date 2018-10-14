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
      <p v-for="item in items" class="perpon-name">
        {{item.name}}
      </p>
    </div>
  </div>
</template>

<script>
import Slide from "@/components/common/slide";

export default {
  name: "pb-list",
  data() {
    return {
      items: [
        { name: "张三丰" },
        { name: "李四" },
        { name: "斯柯达" },
        { name: "阿尔法" },
        { name: "杰克逊" },
        { name: "史密斯" },
        { name: "阿达瓦" },
        { name: "阿凡达" },
        { name: "闪电侠" },
        { name: "小飞侠" },
        { name: "helloworld" },
        { name: "奥特曼" },
        { name: "abc" },
        { name: "bcs" },
        { name: "bcs" },
        { name: "abc" },
        { name: "bcs" },
        { name: "abc" }
      ]
    };
  },
  components: {
    Slide
  }
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
  box-sizing: border-box;
}
.perpon-name {
  display: inline-block;
  width: 200px;
  margin: 0 auto;
  padding: 4px 10px;
  text-align: center;
  color: #7b7b7b;
  cursor: pointer;
}
.perpon-name:hover{
  color:#2e2d2d;
}
</style>
