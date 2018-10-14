<template>
  <div id="ul-list">
    <ul>
      <li v-for="(item, index) in items">
        <a class="list_title"> {{item.content}} </a>
        <b>{{item.time}}</b>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "ul-list",
  props: ["myMessage"],
  methods: {
    init() {
      // console.log(this.myMessage);
      // console.log(this.items);
      this.items = this.myMessage;
    }
  },
  data() {
    return {
      items: [
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   },
        //   {
        //     content: "聚焦机器人投资风向，2018机器人投资发展论...",
        //     time: "2018-09-20"
        //   }
      ]
    };
  },
  components: {},
  activated() {
    this.init();
    // console.log(this.myMessage);
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
#ul-list {
  @include whole;
}
#ul-list ul {
  list-style-type: none;
  padding: 0 15px;
  text-align: left;
}
#ul-list ul li {
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
  max-width: 70%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  line-height: 15px;
  vertical-align: middle;
  cursor: pointer;
}
.list_title:hover {
  color: #ed1c23;
}
#ul-list ul li b {
  float: right;
  padding: 0 5px;
  font-weight: 100;
  display: block;
  height: 15px;
  overflow: hidden;
  font-family: Verdana;
}
</style>
