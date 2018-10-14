<template>
  <div id="x_related_reading">
    <div class="x_related_reading_title">
      <p>相关阅读：</p>
      <li v-for="(li,index) of list" :key="index" class="x_holding_list_li">
        <div class="x_holding_list_li_content">{{li.content}}</div>
        <div class="x_holding_list_li_time">{{li.time}}</div>
      </li>

    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: [
        {
          content: "我不想那么懒我能怎么办呀？",
          time: "2018-10-10"
        },

        {
          content: "我不想烂下去我能怎么办呀？",
          time: "2018-10-10"
        },
        {
          content: "我没有别人厉害我能怎么办呀？",
          time: "2018-10-10"
        },
        {
          content: "我没有别人厉害有没有别人努力我应该怎么办呀？",
          time: "2018-10-10"
        },
        {
          content: "我跟别人的差距越来越大我追不上别人了怎恶魔办呀?",
          time: "2018-10-10"
        },

        {
          content:
            "好像只能从这一刻起利用好所有时间不再浪费时间背靠背地完成这些事情，比别人更加努力完成这些事情！",
          time: "2018-10-10"
        }
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
#x_related_reading {
  padding: 5px;
}
.x_holding_list_li {
  margin: 10px;
  list-style: disc;
  &:hover {
    color: #e06a6a;
    cursor: pointer;
  }
}
p {
  font-weight: bold;
}
.x_holding_list_li_content,
.x_holding_list_li_time {
  display: inline-block;
}
.x_holding_list_li_content {
}
.x_holding_list_li_time {
  float: right;
  font-weight: 600;
}
</style>