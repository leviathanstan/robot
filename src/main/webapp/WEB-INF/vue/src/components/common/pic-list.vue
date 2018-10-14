<template>
  <div id="pic-list">
    <ul class="pics">
      <li v-for="(message, index) in messages">
        <img :src='message.imgArray'>
        <p class="product-title">{{message.introduce}}</p>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "pic-list",
  data() {
    return {
      messages: [
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
        },
        {
          imgArray: "/static/PICS/timg4.jpg",
          introduce: "这一段没有啥可介绍"
        },
        {
          imgArray: "/static/PICS/timg4.jpg",
          introduce: "这一段没有啥可介绍"
        },
        {
          imgArray: "/static/PICS/timg2.jpg",
          introduce: "这是一段可爱的介绍"
        },
        {
          imgArray: "/static/PICS/timg3.jpg",
          introduce: "这是一段神奇的介绍"
        },
        {
          imgArray: "/static/PICS/timg4.jpg",
          introduce: "这一段没有啥可介绍"
        }
      ]
    };
  },
  components: {}
};
</script>
<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
  list-style: none;
}
@mixin whole {
  width: 100%;
  height: 100%;
}
#pic-list {
  @include whole;
  border-bottom: #ccc thin solid;
}
.pics {
  float: left;
  margin: 5px 25px;
}
.pics li {
  display: inline-block;
  padding: 0 5px 0 5px;
}
.pics img {
  padding-left: 15px;
  width: 160px;
  height: 100px;
}
.pics p {
  margin: 0;
  text-align: center;
  padding: 1px 2px 3px 2px;
  font-size: 0.8em;
  cursor: pointer;
}
.pics p:hover {
  color: #ed1c23;
}
// #pic-list ul {
//   list-style-type: none;
//   padding: 0 15px;
//   text-align: left;
//   float: left;
//   width: 540px;
// }
// #pic-list ul li {
//   background: none;
//   padding: 0;
//   margin: 0;
//   border-top: none;
//   line-height: 15px;
//   padding: 8px 0 7px;
//   font-size: 13px;
//   clear: both;
// }
// .list_title {
//   color: #3f3f3f;
//   display: inline-block;
//   max-width: 350px;
//   overflow: hidden;
//   padding: 0 10px;
//   text-overflow: ellipsis;
//   white-space: nowrap;
//   line-height: 15px;
//   vertical-align: middle;
//   cursor: pointer;
// }
// .list_title:hover {
//   color: #ed1c23;
// }
// #pic-list ul li b {
//   float: right;
//   padding: 5px 15px;
//   font-weight: 100;
//   display: block;
//   height: 15px;
//   overflow: hidden;
//   font-family: Verdana;
//   text-overflow: ellipsis;
// }
// .big {
//   color: #df171e;
//   padding: 4px 0;
//   font-size: 16px;
//   padding: 5px 10px;
//   font-weight: bold;
//   overflow: hidden;
//   text-overflow: ellipsis;
//   white-space: nowrap;
// }
</style>
