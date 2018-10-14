<template>
  <div id="pb-list">
    <div class="ul_list">
      <p v-for="item in items" class="perpon-name">
        {{item.name}}
      </p>
    </div>
  </div>
</template>

<script>
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
}
.ul_list {
  width: 100%;
  float: right;
  box-sizing: border-box;
}
.perpon-name {
  display: inline-block;
  width: 160px;
  margin: 0 auto;
  padding: 4px 10px;
  text-align: center;
  color: #7b7b7b;
  cursor: pointer;
}
.perpon-name:hover {
  color: #2e2d2d;
}
</style>
