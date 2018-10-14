<template>
  <div id="paging">
    <div class="home_page" @click="first" :class="[{pagingcurrent: pageIndex === 1}]">首页</div>
    <div class="Previous_page" @click="prev" :class="[{pagingcurrent: pageIndex === 1}]">上一页</div>
    <ul class="Numeric_list">
      <li v-for="item1 of list1" @click="go(item1)" :class="[{isshow:isOn1,pagingcurrent: pageIndex === item1}]">{{item1}}</li>
      <li v-for="item2 of list2" @click="go(item2)" :class="[{pagingcurrent: pageIndex === item2}]"><a sec="#">{{item2}}</a></li>
      <li v-for="item3 of list3" @click="go(item3)" :class="[{isshow:isOn2,pagingcurrent:pageIndex === item3}]">{{item3}}</li>
    </ul>
    <div class="next_page" @click="next" :class="[{pagingcurrent: pageIndex === pagecount}]">下一页</div>
    <div class="last_page" @click="last" :class="[{pagingcurrent: pageIndex === pagecount}]">末页</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagecount: 2686, //模拟一下父组件传值的页码总数
      pageIndex: 1, //当前页面
      pagecenter: 5,
      isOn1: false,
      isOn2: false
    };
  },
  computed: {
    list2: function() {
      //一开始初始化计算要生成多少个小的li
      var list2 = [];
      if (this.pagecount >= 9) {
        for (var i = this.pagecenter - 2; i <= this.pagecenter + 2; i++) {
          list2.push(i);
        }
        return list2;
      }
      if (this.pagecount >= 5) {
        this.pagecenter = this.pagecount;
        for (var i = 3; i <= this.pagecount - 2; i++) {
          list2.push(i);
        }
        return list2;
      }
      if (this.pagecount < 5) {
        for (var i = 1; i <= this.pagecount; i++) {
          list2.push(i);
        }
        return list2;
      }
    },
    list1: function() {
      var list1 = [];
      if (this.pagecount >= 5) {
        for (var i = 1; i <= 2; i++) {
          list1.push(i);
        }
        return list1;
      } else {
        return list1;
        ison1: true;
      }
    },
    list3: function() {
      var list3 = [];
      if (this.pagecount >= 5) {
        for (var i = this.pagecount - 1; i <= this.pagecount; i++) {
          list3.push(i);
        }
        return list3;
      } else {
        return list3;
        ison2: true;
      }
    }
  },
  methods: {
    prev() {
      if (this.pageIndex < this.pagecount - 4 && this.pageIndex >= 6) {
        this.pageIndex--;
        this.pagecenter = this.pageIndex;
      } else if (this.pageIndex < 6 || this.pageIndex > this.pagecount - 4) {
        this.pageIndex--;
      }
    },
    next() {
      if (this.pageIndex < this.pagecount - 4 && this.pageIndex >= 6) {
        this.pageIndex++;
        this.pagecenter = this.pageIndex;
      } else if (this.pageIndex < 6 || this.pageIndex > this.pagecount - 4) {
        this.pageIndex++;
      }
    },
    go(pager) {
      if (pager > this.pagecount - 4) {
        this.pageIndex = pager;
        this.pagecenter = this.pagecount - 4;
        console.log(this.pageIndex);
      }
      if (pager < 6) {
        this.pageIndex = pager;
        this.pagecenter = 5;
      }
      if (pager < this.pagecount - 4 && pager >= 6) {
        this.pageIndex = pager;
        this.pagecenter = this.pageIndex;
        console.log(this.pageIndex);
      }
    },
    first: function() {
      this.pageIndex = 1;
      this.pagecenter = 5;
    },
    last: function() {
      this.pageIndex = this.pagecount;
      this.pagecenter = this.pagecount - 4;
    }
  },
  watch: {
    pageIndex(val) {}
  }
};
</script>

<style lang="scss" scoped>
#paging {
  text-align: center;
  div {
    display: inline-block;
  }
  ul {
    display: inline-block;
  }
  div,
  ul li {
    text-decoration: none;
    background: #fff;
    border-radius: 3px;
    padding: 5px 8px;
    border: 1px solid #bebebe;
    &:hover {
      border: 1px solid #ed1c23;
      color: #ed1c23;
      cursor: pointer;
    }
  }
  a {
    color: #3f3f3f;
    outline: none;
  }
}
.Previous_page {
}
.Numeric_list {
  li {
    display: inline-block;
    padding: 5px 10px;
    margin: 0 4px;
  }
}
.home_page {
}
.isshow {
  display: none;
}
.pagingcurrent {
  color: #e1e1dc;
}
</style>
