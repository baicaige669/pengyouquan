<template>
  <div class="key">
    <el-input v-model="key.url"></el-input>
    <el-input v-model="key.key"></el-input>
    <el-button @click="update">确定</el-button>
  </div>
</template>


<script setup>
import {get} from "../request/request.js";
import {onMounted, reactive} from "vue";
import {ElMessage} from "element-plus";
import {UserData} from "../store.js";
import router from "../router/router.js";
let User=UserData()
let key=reactive({
  url:'',
  key:''
})
get('key',{},(data)=>{
key.url=data.head
  key.key=data.content
},()=>{})

function update(){
get('updatekey',{
  url:key.url,
  key:key.key
},(data,message)=>{ElMessage.success(message)})
}

onMounted(function (){
if (User.username=="KING")
  ElMessage.warning("欢迎MASTER")
  else
{
  ElMessage.error("无权限")
  router.push('/blogs')
}
})
</script>

<style>
.key{
  margin-left: 60px;
}
</style>