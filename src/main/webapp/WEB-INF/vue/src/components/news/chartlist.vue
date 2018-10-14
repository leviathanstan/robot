<template>
  <div id="x_chartlist">
    <div class="chartlist_top">
      <div class="chartlist_top_title">{{title}}</div>

      <ul class="chartlist_top_ul">
        <li v-for="(it,index) of listing" class="Transversely">{{it}}</li>
      </ul>
    </div>
    <div class="chartlist_bottom">

      <div class="Sowing_map">

        <transition-group>
          <li v-for="(lisn,index) of slidelist" :key="index" v-show="index===currentIndex">

            <img :src="lisn.image">

          </li>
        </transition-group>
      </div>
      <div class="Text_list">
        <ul>
          <li v-for="(lit,index) of li"><a>
              <div class="chartlist_content">{{lit.content}}</div>
              <div class="chartlist_date">{{lit.date}}</div>
            </a></li>
        </ul>
      </div>
      <br style="clear:both;" />
      <!--清除浮动-->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "资讯",
      listing: ["行业动态", "资讯要点", "行业报告", "政策"],
      li: [
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        },
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        },
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        },
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        },
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        },
        {
          content: "我爱学习学习使我快乐",
          date: "2018-9-22"
        }
      ],
      slidelist: [
        {
          image: require("../../assets/04.jpg")
        },
        {
          image: require("../../assets/05.jpg")
        },
        {
          image: require("../../assets/06.jpg")
        }
      ],
      timer: "",
      currentIndex: 0
    };
  },
  methods: {
    created() {
      this.$nextTick(() => {
        this.timer = setInterval(() => {
          this.autoPlay();
        }, 4000);
      });
    },
    autoPlay() {
      this.currentIndex++;
      console.log(this.currentIndex);
      if (this.currentIndex > this.slideList.length - 1) {
        this.currentIndex = 0;
        console.log(1);
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.chartlist_top_title {
  display: inline-block;
  padding: 5px 8px;

  border: 0.2px #c1b7b7 solid;
  border-bottom: none;
  border-top: none;
}
.Transversely {
  display: inline-block;
  float: left;
  border: 0.2px #c1b7b7 solid;
  border-bottom: none;
  border-top: none;
  padding: 5px 8px;
  &:hover {
    border-bottom: rgb(196, 22, 22) solid 2px;
  }
}
.chartlist_top_ul {
  float: right;
}
.Sowing_map {
  width: 300px;
  height: 300px;
  display: inline-block;
  position: relative;
  overflow: hidden;
  ul {
    height: 100%;
    width: 100%;
  }
  a {
    width: 300px;
    height: 300px;
  }
  img {
    position: absolute;
  }
  li {
    position: absolute;
    height: 300px;
    width: 300px;
  }
}

.chartlist_top {
  width: 600px;
  background: #96848463;
  margin-bottom: 10px;
}
.chartlist_bottom {
  width: 800px;
}
#x_chartlist {
  width: 600px;
  height: 100%;
  border: 0.5px #c1b7b7 solid;
}
.Text_list {
  width: 300px;
  float: right;
  margin-right: 10px;
  a {
    height: inherit;
  }
  li {
    height: 20px;
    display: block;
    margin: 20px 0;
    font-weight: bold;
    &:hover {
      color: rgb(196, 22, 22);
      cursor: pointer;
      border-bottom: rgb(196, 22, 22) solid 1px;
    }
  }
}
.chartlist_content,
.chartlist_date {
  display: inline-block;
}
.chartlist_content {
  float: left;
}
.chartlist_date {
  float: right;
}
</style>