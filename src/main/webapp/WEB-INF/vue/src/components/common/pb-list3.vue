<template>
  <div id="pb-list3">
    <!-- <ul class="title">
      <li class="list_title" class="menu_title">
        <slot name="title">
        </slot>
      </li>
      <li class="list_title" class="list_title" v-for=""></li>
    </ul> -->
    <div>
      <div class="list_left">
        <div class="list_top">
          <li class="list_title" v-for="(item, index) in items" v-if="index<=3">
            {{item.content}}
          </li>
        </div>
        <div class="list_bottom">
          <li class="list_title" v-for="(item, index) in items" v-if="index > 3 && index < 9">
            {{item.content}}
          </li>
        </div>
      </div>
      <div class="list_right">
        <div class="list_top">
          <img :src='pic.imgArray' v-for="pic in pics">
          <!-- <span class="product-title">{{pic.introduce}}</span> -->
        </div>
        <div class="list_bottom">
          <li class="list_title" v-for="(item, index) in items" v-if="index >9">
            {{item.content}}
          </li>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "pb-list3",
  data() {
    return {
      items: [
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" },
        { content: "广东省机器人协会关于廉迎战兼任职务调整的" }
      ],
      pics: [
        {
          imgArray: "/static/PICS/timg5.jpg",
          introduce: "这是一段精辟的介绍"
        },
        {
          imgArray: "/static/PICS/timg2.jpg",
          introduce: "这是一段可爱的介绍"
        },
        {
          imgArray: "/static/PICS/timg3.jpg",
          introduce: "这是一段神奇的介绍"
        }
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
@mixin max {
  width: 100%;
  height: 100%;
}
#pb-list3 {
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
.list_left {
  width: 395px;
  float: left;
  height: 270px;
  overflow: hidden;
  box-sizing: border-box;
  padding: 10px 10px 10px 20px;
}
.list_right {
  & {
    width: 395px;
    float: right;
    box-sizing: border-box;
    padding: 10px 10px;
  }
  img {
    padding-left: 15px;
    width: 100px;
    height: 100px;
    display: inline-block;
  }
}
.list_top {
  box-sizing: border-box;
  height: 110px;
  padding: 0 5px 10px 0;
}
.list_bottom {
  box-sizing: border-box;
  height: 140px;
  padding: 10px 5px 0 0;
}
.list_title {
  color: #3f3f3f;
  display: inline-block;
  max-width: 345px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  line-height: 15px;
  vertical-align: middle;
  cursor: pointer;
  letter-spacing: 1px;
  line-height: 15px;
  padding: 4px 0 3px 10px;
  font-size: 13px;
  clear: both;
}
.list_title:hover {
  color: #ed1c23;
}
</style>