<template>
  <div id="pb-list2">
    <div class="pics">
      <div v-for="(item, index) in items" v-if="index<2">
        <img src="/static/PICS/timg3.jpg" alt="">
        <p :title="item.title">{{item.title}}</p>
      </div>
    </div>
    <ul>
      <li v-for="(item, index) in items" v-if="index<9 && index>1">
        <a class="list_title" :class="{ big: item.isBig }" @click="routerLink(item.urlId)"> {{item.title}} </a>
        <b>{{item.postDate}}</b>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "pb-list2",
  props: ["myMessage"],
  data() {
    return {
      items: [
        //   {
        //     content:
        //       "聚焦机器人投资风向，2018机器人投资发展论2018机器人投资发展论2018机器人投资发展论",
        //     time: "2018-09-20",
        //     isBig: true
        //   },
        //   {
        //     content: "关于举办广东工业机器人技术及应用论坛 ---",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "关于转发《广东省经济和信息化委关于组织参",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "广东省机器人协会关于廉迎战兼任职务调整的...",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "广东省机器人协会关于廉迎战兼任职务调整的",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "关于组织企业申请注册专利资源库的通知...",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20",
        //     isBig: false
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20",
        //     isBig: false
        //   }
      ]
    };
  },
  methods: {
    init() {
      // console.log(this.myMessage);
      this.items = this.myMessage;
      // console.log(this.items);
    },
    routerLink(messageId){
      console.log(messageId)
      this.$router.push({path: '/industry_dynamic_text',query:{messageId}})
    }
  },
  activated() {
    this.init();
  },
  mounted() {
    this.init();
  }
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
#pb-list2 {
  @include whole;
  border-bottom: #ccc thin solid;
}
.pics {
  float: left;
  margin: 5px 25px;
}
.pics img {
  padding-left: 15px;
  width: 160px;
  height: 100px;
}
.pics p {
  margin: 0;
  text-align: center;
  max-width: 160px;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  padding: 1px 2px 3px 15px;
  font-size: 0.8em;
  cursor: pointer;
}
.pics p:hover {
  color: #ed1c23;
}
#pb-list2 ul {
  list-style-type: none;
  padding: 0 15px;
  text-align: left;
  float: left;
  width: 540px;
  box-sizing: border-box;
}
#pb-list2 ul li {
  background: none;
  padding: 0;
  margin: 0;
  border-top: none;
  line-height: 15px;
  padding: 8px 0 7px;
  font-size: 13px;
  clear: both;
}
.list_title {
  color: #3f3f3f;
  display: inline-block;
  max-width: 350px;
  overflow: hidden;
  padding: 0 10px;
  text-overflow: ellipsis;
  white-space: nowrap;
  line-height: 15px;
  vertical-align: middle;
  cursor: pointer;
}
.list_title:hover {
  color: #ed1c23;
}
#pb-list2 ul li b {
  float: right;
  padding: 5px 15px;
  font-weight: 100;
  display: block;
  height: 15px;
  overflow: hidden;
  font-family: Verdana;
  text-overflow: ellipsis;
}
.big {
  color: #df171e;
  padding: 4px 0;
  font-size: 16px;
  padding: 5px 10px;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
