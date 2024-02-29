<!--          action="http://47.117.175.240:6904"-->
<template>
    <el-card class="main">
      <img style="width: 200px;height: 200px" :src=user.url>
      <el-button @click="router.push('/pictrue')">头像大全</el-button>

      <el-upload
          class="upload-demo"
          ref="upload"
          action=""
          :on-success="success"
          :on-change="upload"
          :auto-upload="false">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <div slot="tip" class="el-upload__tip" >只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>

      <div class="card">
        <span>账号</span>
        <el-input v-model="user.username" :disabled="true"></el-input>
      </div>
      <div class="card">
        <span>昵称</span>
        <el-input v-model="user.nickname"></el-input>
      </div>
      <div class="card">
        <span>创建时间:{{user.createtime}}</span>
      </div>
      <el-button style="margin-top: 15px" @click="change">确认修改</el-button>
    </el-card>
</template>
<script setup>
import {UserData} from "../store.js";
import {get, post} from "../request/request.js";
import {ElMessage} from "element-plus";
import router from "../router/router.js";
let user=UserData()
let token=localStorage.getItem("token")
function change(){
  get('user/update',{
    nickname:user.nickname,
    id:user.userid
  },()=>{ElMessage.success("修改成功")},()=>{})
}


function upload(file){
  let formdata=new FormData()
  formdata.append('file',file.raw)
  post('upload',formdata,()=>{
    user.refresh()
  },()=>{})
  console.log(formdata)
}


</script>

<style>
.main{
  width: auto;
  height: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-left: 20px;
  margin-top: 50px;
}

</style>
