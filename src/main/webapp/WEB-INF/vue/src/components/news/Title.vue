<template>
  <div id="Title">
    <!-- <m-header ref="c1"></m-header> -->
    <h1>{{title}}</h1>
    <div class="x_time">{{time}}</div>
    <div class="x_coming_from_2">来源：</div>
    <div class="x_coming_from_1">{{coming}}</div>
    <div class="x_sharing">分享</div>
    <div class="x_erroring">纠错</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      time: "2018-08-16",
      title: "直击世界机器人大会：人机共融已是大势所趋",
      coming: ""
    };
  }
};
</script>

<style lang="scss" scoped>
.x_time {
  & {
    display: inline-block;
    margin: 5px;
  }
  float: left;
}
.x_coming_from_1,
.x_coming_from_2,
.x_sharing,
.x_erroring {
  display: inline-block;
  margin: 5px;
  padding: 0 10px;
  border-right: 1px solid #ccc;
}
.x_erroring,
.x_sharing {
  margin: 5px 10px;
  float: right;
}
#Title {
  border-bottom: 1px dashed #ccc;
  width: 100%;
  height: 100%;
}
</style>