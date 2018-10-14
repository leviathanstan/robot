<template>
  <div id="normal-list">
    <ul>
      <li v-for="(item, index) in items">
        <a class="list_title"> {{item.content}} </a>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "normal-list",
  data() {
    return {
      items: [
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
        },
        {
          content: "聚焦机器人投资风向，2018机器人投资发展论...",
          time: "2018-09-20"
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
#normal-list {
  @include whole;
}
#normal-list ul {
  & {
    list-style-type: none;
    padding: 0 15px;
    text-align: left;
    width: 100%;
    height: 100%;
    box-sizing: border-box;
  }
  li {
    & {
      padding: 6px 0 5px 10px;
      margin-left: 5px;
      font-size: 13px;
      clear: both;
      line-height: 20px;
    }
    .list_title {
      color: #3f3f3f;
      float: left;
      padding: 0;
      margin: 0;
      border-top: none;
      line-height: 15px;
      padding: 6px 0 5px;
      display: inline-block;
      width: 380px;
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
  }
}
</style>
