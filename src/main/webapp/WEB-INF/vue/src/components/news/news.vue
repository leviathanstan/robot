<template>
  <div id="news">

    <x_information></x_information>
  </div>
</template>

<script>
import MHeader from "@/components/common/m-header";

import x_information from "./information.vue";

export default {
  name: "news",
  data() {
    return {};
  },
  components: {
    MHeader,
    x_information
  }
};
</script>

<style lang="scss" scoped>
</style>

