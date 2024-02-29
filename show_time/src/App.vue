<script setup>
import Nav from "./components/Nav.vue";
</script>

<template>
  <div>
<!--    <HelloWorld></HelloWorld>-->
<!--    <Managemnet></Managemnet>-->
<!--     <blog></blog>-->

    <div class="main">
      <Nav></Nav>
      <div class="view">
        <router-view name="key"></router-view>
        <router-view name="blogs"></router-view>
        <router-view name="main1"></router-view>
        <router-view name="pictrue"></router-view>
        <router-view name="publish"></router-view>
        <router-view name="user"></router-view>
        <router-view name="ranklist"></router-view>
      </div>

    </div>


  </div>
</template>

<style scoped>

.main{
  display: flex;
  flex-direction: row;
  width: 100%;
}
.view{
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
}
</style>
