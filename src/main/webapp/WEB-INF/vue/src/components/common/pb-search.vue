<template>
  <div id="pb-search">
    <form action="" name="search_form">
      <li class="item">
        <label for="brand">品牌</label>
        <div class="box">
          <input type="text" id="brand" name="brand">
          <ul class="down_menu" @mouseover="function(){isHide[0] = false;}" @mouseout="function(){isHide[0] = true;}">
            <span></span>
            <div :class="{none: isHide[0]}">
              <li v-for="menu in menus">{{menu.name}}</li>
            </div>
          </ul>
        </div>
      </li>
      <li class="item">
        <label for="use">用途</label>
        <div class="box">
          <input type="text" id="use" name="use">
          <ul class="down_menu" @mouseover="function(){isHide[1] = false;}" @mouseout="function(){isHide[1] = true;}">
            <span></span>
            <div :class="{none: isHide[1]}">
              <li v-for="menu in menus">{{menu.name}}</li>
            </div>
          </ul>
        </div>
      </li>
      <li class="item">
        <label for="load">负载</label>
        <div class="box">
          <input type="text" id="load" name="load">
          <ul class="down_menu" @mouseover="function(){isHide[2] = false;}" @mouseout="function(){isHide[2] = true;}">
            <span></span>
            <div :class="{none: isHide[2]}">
              <li v-for="menu in menus">{{menu.name}}</li>
            </div>
          </ul>
        </div>
      </li>
      <li class="item">
        <label for="axial">轴数</label>
        <div class="box">
          <input type="text" id="axial" name="axial">
          <ul class="down_menu" @mouseover="function(){isHide[3] = false;}" @mouseout="function(){isHide[3] = true;}">
            <span></span>
            <div :class="{none: isHide[3]}">
              <li v-for="menu in menus">{{menu.name}}</li>
            </div>
          </ul>
        </div>
      </li>
      <li class="item">
        <label for="mold">类型</label>
        <div class="box">
          <input type="text" id="mold" name="mold">
          <ul class="down_menu" @mouseover="function(){isHide[4] = false;}" @mouseout="function(){isHide[4] = true;}">
            <span></span>
            <div :class="{none: isHide[4]}">
              <li v-for="menu in menus">{{menu.name}}</li>
            </div>
          </ul>
        </div>
      </li>
      <input type="submit" value="搜索" class="submit">
    </form>
  </div>
</template>

<script>
export default {
  name: "pb-search",
  data() {
    return {
      isHide: [true, true, true, true, true],
      menus: []
    };
  }
};
</script>

<style lang="scss" scoped>
$red: #e21c22;
#pb-search {
  & {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    color: rgb(94, 94, 94);
    font-size: 15px;
  }
  form {
    & {
      margin: 30px 10px;
      text-align: center;
    }
    .item {
      & {
        margin-left: -10px;
        padding: 8px 20px;
      }
      label {
        padding: 0 20px 0 15px;
      }
      .box {
        & {
          margin: 0;
          width: 190px;
          border: 1px solid rgb(178, 178, 178);
          -webkit-appearance: textfield;
          box-sizing: content-box;
          border-radius: 5px;
          box-shadow: 0px 1px 4px 0px rgba(168, 168, 168, 0.6) inset;
          transition: all 0.2s linear;
          position: relative;
          display: inline-block;
          text-align: left;
        }
        input {
          margin: 0;
          width: 165px;
          border: none;
          -webkit-appearance: textfield;
          box-sizing: content-box;
          border-radius: 5px;
          transition: all 0.2s linear;
          position: relative;
          display: inline-block;
          padding-left: 5px;
        }
        ul {
          & {
            width: 20px;
            height: auto;
            display: inline-block;
            float: right;
            border-radius: 5px;
            overflow: hidden;
            cursor: pointer;
          }
          span {
            z-index: 99999;
            width: 20px;
            height: 19px;
            line-height: 29px;
            display: block;
            background: url(../../assets/seach-bot.jpg) no-repeat center;
            border: none;
          }
        }
      }
    }
  }
}
.submit {
  margin: 10px 0 5px 5px;
  text-align: center;
  border: 1px solid rgb(178, 178, 178);
  outline: none;
  cursor: pointer;
  padding: 3px 15px;
  color: white;
  border-radius: 5px;
  background-color: $red;
  box-shadow: 0px 1px 4px 0px $red inset;
  transition: all 0.2s linear;
}
.submit:active {
  position: relative;
  bottom: 0.5px;
  right: 0.5px;
  background-color: #f0262d;
}
.active {
  color: $red !important;
}
.none {
  display: none;
}
</style>
