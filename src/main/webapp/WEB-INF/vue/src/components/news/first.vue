<template>
  <div id="x_first">
    <li v-for="(li,index) in list " :key="index">{{li}}</li>
  </div>
</template>

<script>

export default {
  
  data(){
    return {
        list:[
            "这是一条机器人信息",
            "这是一条机器人信息",
            "这是一条机器人信息",
            "这是一条机器人信息",
            "这是一条机器人信息",
            "这是一条机器人信息"

        ]
    }
  }
}
</script>

<style lang="scss" scoped>

</style>