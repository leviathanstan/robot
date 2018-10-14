<template>
  <div id="job-search">
    <div class="current">
      <span>当前分类></span>
    </div>
    <div class="menus">
      <div class="row" :class="0 === index ? 'row-first' :''" v-for="(item,index) in items" :key="item.title">
        <div class="head">
          <span class="title" :title='item.title'>{{item.title}}</span>
        </div>
        <div class="body">
          <div class="items">
            <div class="item-inner">
              <li class="item" v-for="(tab,index) in tabs" v-if="tab.belong === item.title" :key="tab.name">
                <a :title="tab.name">{{tab.name}}</a>
              </li>
            </div>
          </div>
        </div>
        <div class="foot">

        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  naem: "job-search",
  data() {
    return {
      items: [
        {
          title: "地区："
        },
        {
          title: "职位："
        },
        {
          title: "行业："
        }
      ],
      tabs: [
        {
          name: "广东",
          belong: "地区："
        },
        {
          name: "苏州",
          belong: "地区："
        },
        {
          name: "销售人员",
          belong: "职位："
        },
        {
          name: "销售管理",
          belong: "职位："
        },
        {
          name: "计算机/互联网/通信",
          belong: "行业："
        },
        {
          name: "会计/金融/保险",
          belong: "行业："
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
.active {
  color: #ed1c22 !important;
}
#job-search {
  @include max;
  overflow: hidden;
  padding-bottom: 10px;
}
.current {
  padding: 5px 15px;
  color: #666;
  max-width: 80%;
}
.menus {
  & {
    border: 1px solid #e8e8e8;
    margin: 2px 5px;
    padding: 5px;
  }
  .row {
    & {
      position: relative;
      border-top: 1px dashed #dedede;
      margin: 0 5px;
    }
    .head {
      & {
        position: absolute;
        left: 11px;
        top: 9px;
        color: #999;
      }
      .title {
        float: left;
        max-width: 80px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        font-weight: 400;
      }
    }
    .body {
      & {
        padding: 0 80px 0 82px;
      }
      .items {
        & {
          height: 36px;
          overflow: hidden;
        }
        .item {
          & {
            float: left;
            margin: 9px 25px 9px 0;
            height: 18px;
            color: #000;
            text-decoration: none;
          }
          a {
            float: left;
            max-width: 140px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            cursor: pointer;
          }
          a:hover {
            @extend .active;
          }
        }
      }
    }
  }
  .row-first {
    border-top: none;
  }
}
</style>
