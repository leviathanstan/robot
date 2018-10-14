<template>
  <div id="slide" v-on:mouseover="stop()" v-on:mouseout="move()">
    <div class="slideshow">
      <transition-group tag="ul" name="image">
        <li v-for="(message, index) in messages" v-show=" index === mark" :key="index">
          <a href="#">
            <img :src='message.imgArray'>
            <span class="product-title">{{message.introduce}}</span>
          </a>
        </li>
      </transition-group>
    </div>
    <transition name="show">
      <div class="bar" v-show=" bar_show == 1 ">
        <span v-for="(message, index) in messages" :class="{'show': index === mark }" @click="change(index)" :key="index"></span>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "slide",
  data() {
    return {
      timer: null, //定时器
      mark: 0, //比对图片的索引
      bar_show: 0,
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
        }
      ]
    };
  },
  mounted() {},
  methods: {
    autoPlay() {
      this.mark++;
      if (this.mark === 4) {
        //当遍历到最后一张图片置零
        this.mark = 0;
      }
    },
    play() {
      this.timer = setInterval(this.autoPlay, 2500);
    },
    change(i) {
      this.mark = i;
    },
    stop() {
      clearInterval(this.timer);
      this.bar_show = 1;
    },
    move() {
      this.timer = setInterval(this.autoPlay, 2500);
      this.bar_show = 0;
    }
  },
  created() {
    this.play();
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
#slide {
  @include whole;
  margin: 0 auto;
  position: relative;
  overflow: hidden;
}
.slideshow {
  @include whole;
}
li {
  position: absolute;
  @include whole;
}
li a {
  @include whole;
  margin: 0;
  padding: 0;
  position: absolute;
}
img {
  @include whole;
}
.product-title {
  display: block;
  position: absolute;
  top: auto;
  right: 0;
  bottom: 0;
  left: 0;
  width: auto;
  padding: 10px 15px 11px;
  height: 20px;
  line-height: 20px;
  background: rgba(0, 0, 0, 0.35);
  color: #fff;
  font-size: 14px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.bar {
  position: absolute;
  width: 100%;
  box-sizing: border-box;
  bottom: 10px;
  padding: 0 15px 0 0;
  z-index: 10;
  text-align: right;
}
.bar span {
  width: 13px;
  height: 13px;
  border-radius: 5px;
  border: 1px solid rgba(0, 0, 0, 0.685);
  background: white;
  display: inline-block;
  margin-right: 5px;
  cursor: pointer;
}
.show {
  background: red !important;
}
// 过渡效果
.image-enter-active {
  transform: translateX(0);
  transition: all 1.5s ease;
}
.image-leave-active {
  transform: translateX(-100%);
  transition: all 1.5s ease;
}
.image-enter {
  transform: translateX(100%);
}
.image-leave {
  transform: translateX(0);
}
.show-enter-active,
.show-leave-active {
  transition: all 0.5s;
}
.show-enter,
.show-leave-to {
  margin-left: 100px;
}
.show-enter-to,
.show-leave {
  margin-left: 0px;
}
</style>