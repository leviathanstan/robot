<template>
  <div class="m-header">
    <div class="m-header1">
      <div class="icon">
        <a href="#" title="wechat">
          <i class="ex1 fa fa-weixin" aria-hidden="true"></i>
        </a>
      </div>
      <div class="media">
        <span class="ex1">注册</span>
        <span class="vertical_line"></span>
        <span class="ex1">登录</span>
      </div>
    </div>
    <div class="m-header2">
      <div class="headering">
        <div class="title">
          <h1 @click="click('/')">智能装备</h1>
          <h2>公众服务平台</h2>
        </div>
        <div class="searching" :class="menuIndex != 0 ? 'none' :''">
          <!-- 导航栏搜索框 -->
          <div class="search">
            <li class="sw1">
              <div class="spw1">
                <label>
                  <input type="text" id="searching1" placeholder="请输入关键字">
                </label>
                <label>
                  <ul class="down_menu" @mouseover="function(){isHide = false;}" @mouseout="function(){isHide = true;}">
                    <span :class="{background: isBank}">{{chosen}}</span>
                    <div :class="{none: isHide}">
                      <li v-for="menu in menus" @click="function(){isBank = false;chosen = menu.name}">{{menu.name}}</li>
                    </div>
                  </ul>
                </label>
              </div>
            </li>
            <li class="sw2">
              <input type="submit" value="搜索">
            </li>
          </div>
          <div id="m">M</div>
          <div class="m">商城</div>
          <div class="m">需求发布</div>
        </div>
      </div>
      <div class="menu">
        <ul class="menu_list">
          <li v-for="(menu,index) in menus" @click="routerLink(index,menu.path)" :class="menuIndex === index ? 'active' :''">
            <i v-bind:class="menu.icon" class="fa-2x fa" aria-hidden="true"></i>
            <span>{{menu.name}}</span>
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "m-header",
  data() {
    return {
      menus: [
        {
          name: "首页",
          path: "/home",
          isActive: false,
          icon: "fa-home"
        },
        {
          name: "资讯",
          path: "/news",
          isActive: false,
          icon: "fa-commenting"
        },
        {
          name: "政策",
          path: "/policy",
          isActive: false,
          icon: "fa-file-text"
        },
        {
          name: "协会",
          path: "/association",
          isActive: false,
          icon: "fa-users"
        },
        {
          name: "企业",
          path: "/enterprise",
          isActive: false,
          icon: "fa-globe"
        },
        {
          name: "产品",
          path: "/product",
          isActive: false,
          icon: "fa-android"
        },
        {
          name: "技术",
          path: "/tech",
          isActive: false,
          icon: "fa-lightbulb-o"
        },
        {
          name: "供需",
          path: "/io",
          isActive: false,
          icon: "fa-tachometer"
        },
        {
          name: "商城",
          path: "/mall",
          isActive: false,
          icon: "fa-shopping-cart"
        },
        {
          name: "人才",
          path: "/talent",
          isActive: false,
          icon: "fa-id-badge "
        },
        {
          name: "展会",
          path: "/exhibition",
          isActive: false,
          icon: "fa-tasks"
        },
        {
          name: "会议",
          path: "/meeting",
          isActive: false,
          icon: "fa-pencil-square-o"
        },
        {
          name: "公众号",
          path: "/public",
          isActive: false,
          icon: "fa-weixin "
        },
        {
          name: "关于我们",
          path: "/about",
          isActive: false,
          icon: "fa-address-book"
        }
      ],
      menuIndex: 0,
      isHide: true,
      isBank: true,
      chosen: ""
    };
  },
  methods: {
    routerLink(index, path) {
      this.$router.push(path); //路由跳转
      this.menuIndex = index; //给menuIndex赋值点击的路由下标
    },
    //检索当前路径
    checkRouterLocal(path) {
      //查找当前路由下标高亮
      // console.log(this.menuIndex);
      this.menuIndex = this.menus.findIndex(menu => menu.path === path || path.indexOf(menu.path) != -1);
    }
  }
};
</script>

<style lang="scss" scoped>
$red: rgb(196, 22, 22);
.active {
  color: $red !important;
}
.none {
  display: none;
}
.background {
  background: url(../../assets/seach-bot.jpg) no-repeat 0;
}
.fa-2x {
  font-size: 1.7em;
  color: inherit;
}
.m-header {
  .m-header1 {
    & {
      min-width: 1200px;
      background-color: rgb(51, 51, 51);
      color: white;
      padding: 6px 120px;
      box-sizing: border-box;
      width: 100%;
      white-space: nowrap;
      line-height: 1.3;
      zoom: 1;
    }
    &:after {
      display: block;
      content: ".";
      clear: both;
      line-height: 0;
      visibility: hidden;
    }
    .icon {
      float: left;
      overflow: hidden;
    }
    .media {
      float: right;
      text-align: right;
      overflow: hidden;
      margin-right: -7px;
    }
    .ex1 {
      margin-right: 8px;
    }
    /*竖直分割线*/
    .vertical_line {
      padding: 0 6px;
      border-left: 1px white solid;
      vertical-align: middle;
    }
  }
  .m-header2 {
    & {
      margin: 0 auto;
      width: 1200px;
      background: white;
    }
    .headering {
      & {
        zoom: 1;
        margin-bottom: 15px;
      }
      &:after {
        @extend .m-header1:after;
      }
      .title {
        & {
          float: left;
          margin: 10px;
        }
        &::after {
          content: " ";
          display: block;
          width: 100%;
          height: 2px;
          margin-top: 10px;
          background: -moz-linear-gradient(
            left,
            rgba(147, 184, 189, 0) 0%,
            rgba(147, 184, 189, 0.8) 20%,
            rgba(147, 184, 189, 1) 53%,
            rgba(147, 184, 189, 0.8) 79%,
            rgba(147, 184, 189, 0) 100%
          );
          background: -webkit-gradient(
            linear,
            left top,
            right top,
            color-stop(0%, rgba(147, 184, 189, 0)),
            color-stop(20%, rgba(147, 184, 189, 0.8)),
            color-stop(53%, rgba(147, 184, 189, 1)),
            color-stop(79%, rgba(147, 184, 189, 0.8)),
            color-stop(100%, rgba(147, 184, 189, 0))
          );
          background: -webkit-linear-gradient(
            left,
            rgba(147, 184, 189, 0) 0%,
            rgba(147, 184, 189, 0.8) 20%,
            rgba(147, 184, 189, 1) 53%,
            rgba(147, 184, 189, 0.8) 79%,
            rgba(147, 184, 189, 0) 100%
          );
          background: -o-linear-gradient(
            left,
            rgba(147, 184, 189, 0) 0%,
            rgba(147, 184, 189, 0.8) 20%,
            rgba(147, 184, 189, 1) 53%,
            rgba(147, 184, 189, 0.8) 79%,
            rgba(147, 184, 189, 0) 100%
          );
          background: -ms-linear-gradient(
            left,
            rgba(147, 184, 189, 0) 0%,
            rgba(147, 184, 189, 0.8) 20%,
            rgba(147, 184, 189, 1) 53%,
            rgba(147, 184, 189, 0.8) 79%,
            rgba(147, 184, 189, 0) 100%
          );
          background: linear-gradient(
            left,
            rgba(147, 184, 189, 0) 0%,
            rgba(147, 184, 189, 0.8) 20%,
            rgba(147, 184, 189, 1) 53%,
            rgba(147, 184, 189, 0.8) 79%,
            rgba(147, 184, 189, 0) 100%
          );
        }
      }
      h1 {
        color: rgb(196, 22, 22);
        cursor: pointer;
        user-select: none;
        background: -webkit-repeating-linear-gradient(
          -45deg,
          rgb(163, 18, 18),
          rgb(163, 19, 19) 20px,
          rgb(203, 64, 64) 20px,
          rgb(203, 64, 64) 40px,
          rgb(163, 18, 18) 40px
        );
        -webkit-text-fill-color: transparent;
        -webkit-background-clip: text;
        display: inline-block;
        margin: 20px 75px 0 65px;
        font-weight: 500;
        text-align: left;
        font-size: 2em;
      }
      h2 {
        color: #888;
        margin: 4px 75px 5px 65px;
        text-align: left;
        font-weight: 500;
        font-size: 1.05em;
        letter-spacing: 0.3em;
      }
      .searching {
        zoom: 1;
        float: left;
      }
      .search::after {
        @extend .m-header1:after;
      }
      .search {
        & {
          float: left;
          width: 506px;
          height: 80px;
          margin: 40px 25px 0 40px;
        }
        li.sw1 {
          width: 386px;
          height: 30px;
          border: 4px solid #ed1c23;
          border-right: none;
          display: block;
          float: left;
          border-top-left-radius: 20px;
          border-bottom-left-radius: 20px;
        }
        li.sw1 label {
          float: left;
          margin: 0;
          padding: 0;
        }
        .spw1 {
          width: 386px;
          height: 30px;
        }
        .sw1 input {
          width: 323px;
          height: 30px;
          border: 1px solid #e6e6e6;
          border-right: none;
          box-sizing: border-box;
          display: block;
          padding-left: 15px;
          border-top-left-radius: 20px;
          border-bottom-left-radius: 20px;
          outline: none;
          border: none;
          -webkit-box-shadow: inset 0px 0px 0px 30px #fff;
          -moz-box-shadow: inset 0px 0px 0px 30px #fff;
          box-shadow: inset 0px 0px 0px 30px #fff;
        }
        .down_menu {
          width: 60px;
          height: auto;
          position: relative;
          z-index: 99999;
          cursor: pointer;
        }
        .down_menu span {
          width: 60px;
          height: 30px;
          line-height: 29px;
          text-align: center;
          display: block;
          border: none;
          border-left: 1px solid #dcdcdc;
        }
        li.sw2 {
          width: 100px;
          height: 38px;
          line-height: 40px;
          background: #ed1c23;
          text-align: center;
          display: block;
          float: left;
          border-top-right-radius: 20px;
          border-bottom-right-radius: 20px;
          cursor: pointer;
        }
        .sw2 input {
          border: none;
          background: #ed1c23;
          cursor: pointer;
          color: #fff;
          font: 20px "微软雅黑";
          box-sizing: border-box;
        }
        .down_menu li {
          display: block;
          float: left;
          cursor: pointer;
          width: 60px;
          height: 29px;
          background: #fff;
          line-height: 29px;
          text-align: center;
          position: relative;
          z-index: 9999;
          left: 0;
          border: 1px solid #c7c7c7;
          border-top: none;
          border-bottom: none;
          font-size: 12px;
          user-select: none;
        }
        .down_menu li:hover {
          background: #eb2721;
          color: #fff;
        }
      }
      #m {
        font-style: italic;
        float: left;
        font-size: 38px;
        color: #eb2721;
        margin: 32px 10px 0 10px;
        user-select: none;
      }
      .m {
        float: left;
        font-size: 20px;
        color: #a3a3a3;
        font-weight: 500;
        margin: 45px 10px 0 40px;
      }
    }
    .menu {
      & {
        zoom: 1;
      }
      &::after {
        content: " ";
        display: block;
        width: 100%;
        height: 0.5px;
        margin-top: 10px;
        background: -moz-linear-gradient(
          left,
          rgba(196, 22, 22, 0) 0%,
          rgba(196, 22, 22, 0.8) 20%,
          rgba(196, 22, 22, 1) 53%,
          rgba(196, 22, 22, 0.8) 79%,
          rgba(196, 22, 22, 0) 100%
        );
        background: -webkit-gradient(
          linear,
          left top,
          right top,
          color-stop(0%, rgba(196, 22, 22, 0)),
          color-stop(20%, rgba(196, 22, 22, 0.8)),
          color-stop(53%, rgba(196, 22, 22, 1)),
          color-stop(79%, rgba(196, 22, 22, 0.8)),
          color-stop(100%, rgba(196, 22, 22, 0))
        );
        background: -webkit-linear-gradient(
          left,
          rgba(196, 22, 22, 0) 0%,
          rgba(196, 22, 22, 0.8) 20%,
          rgba(196, 22, 22, 1) 53%,
          rgba(196, 22, 22, 0.8) 79%,
          rgba(196, 22, 22, 0) 100%
        );
        background: -o-linear-gradient(
          left,
          rgba(196, 22, 22, 0) 0%,
          rgba(196, 22, 22, 0.8) 20%,
          rgba(196, 22, 22, 1) 53%,
          rgba(196, 22, 22, 0.8) 79%,
          rgba(196, 22, 22, 0) 100%
        );
        background: -ms-linear-gradient(
          left,
          rgba(196, 22, 22, 0) 0%,
          rgba(196, 22, 22, 0.8) 20%,
          rgba(196, 22, 22, 1) 53%,
          rgba(196, 22, 22, 0.8) 79%,
          rgba(196, 22, 22, 0) 100%
        );
        background: linear-gradient(
          left,
          rgba(196, 22, 22, 0) 0%,
          rgba(196, 22, 22, 0.8) 20%,
          rgba(196, 22, 22, 1) 53%,
          rgba(196, 22, 22, 0.8) 79%,
          rgba(196, 22, 22, 0) 100%
        );
      }
      .menu_list {
        & {
          display: block;
          margin: 0 auto;
          width: 100%;
          box-sizing: border-box;
          height: auto;
          margin-top: 1px;
          -webkit-padding-start: 0px;
          padding: 3px 0;
        }
        &:after {
          @extend .m-header1:after;
        }
        li {
          & {
            user-select: none;
            cursor: pointer;
            width: 84px;
            height: auto;
            line-height: 1.6;
            float: left;
            display: block;
            text-align: center;
            margin-right: 1px;
            color: rgb(51, 51, 51);
          }
          &:hover i,
          &:hover {
            color: $red;
          }
          span {
            display: block;
            font-weight: 500;
          }
        }
      }
    }
  }
}
</style>