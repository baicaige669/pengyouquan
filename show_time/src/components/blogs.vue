<!--基础不劳 地动天摇  <script>标签里要加setup 浪费我好长时间

let result = reactive({data: []});
let result = reactive([]);
不知道有啥区别 一个直接本身是数组 一个是有一个data数组变量
axois请求的数据放在第一种里可以渲染出来 放第二种就渲染不出来  不知道未来可以理解吗
-->

<script setup type="module">
import {onMounted, reactive} from "vue";
import {get} from "../request/request.js";
import {ElMessage} from "element-plus";
import {UserData} from "../store.js";

let result = reactive({data: []});
let USer=UserData()

get('findblogs',{},(data)=>{
    result.data=data
  },(message)=>{ElMessage.error("ERRO2")})


</script>


<template>
  <div class="block">
    <el-timeline>
      <el-timeline-item :timestamp="item.time" placement="top" v-for="item in result.data">
        <div class="usercontent">
          <img :src=item.url style="height: 40px;width: 40px ;border-radius: 50px">
          <a href="#">{{ item.nickname }}</a>
        </div>
        <el-card>
          <h4>{{ item.head}}</h4>
          <p>{{ item.content }}</p>
        </el-card>
        <el-button v-if="USer.nickname==item.nickname"  style="position: absolute;right: 10px">删除</el-button>
      </el-timeline-item>
    </el-timeline>
  </div>
</template>

<style scoped>


.block {
  margin: 20px 50px 20px 50px;
}

.usercontent {
  display: flex;
  flex-direction: row;
  align-items: center;
}
</style>