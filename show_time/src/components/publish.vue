<template>
<div class="show">
  请输入文章的标题<el-input
      type="textarea"
      minlength="3"
      autosize
      placeholder="请输入内容" v-model="content.head">
  </el-input>
  <div style="margin: 40px 0;"></div>
  请输入文章内容<el-input
      type="textarea"
      minlength="8"
      :autosize="{ minRows: 6, maxRows: 8}"
      placeholder="请输入内容" v-model="content.content">


  </el-input>

  <el-button style="margin-top: 20px" @click="submit" >点击发表</el-button >
  <span v-if="flag.i==true">每次请间隔10秒</span>
  <el-button @click="random" :disabled=flag.i>随机生成一个句美文</el-button>
</div>
</template>

<style scoped>

.show{
  margin-left: 60px;
  margin-right: 40px;
  width: 100%;
}
</style>

<script setup>
import {get, post} from "../request/request.js";
import {ElMessage} from "element-plus";
import {reactive} from "vue";
import router from "../router/router.js";
import axios from "axios";
let flag=reactive({i:false})
let content=reactive({  head:'',
  content:'',
  userid:''})
function submit(){
  if(!/^.{2,25}$/.test(content.head)||!/^.{2,100}$/.test(content.content.length))
    ElMessage.warning("请输入完整信息")
  else {
    content.userid=window.localStorage.getItem('id')
    console.log(content.userid)
    post('insertblog',{
      head:content.head,
      content:content.content,
      userid:content.userid
    },()=>{
      ElMessage.success("ok")
      router.push('/blogs')
    },()=>{ElMessage.warning("Wrong")})
  }

}

function random(){
  let key={
    url:'',
    key:''
  }
  get('key',{},(data)=>{
    console.log(data)
    key.url=data.head
    key.key=data.content
    console.log(key)
    axios.get(key.url,{params:{'key':key.key}}).then((data)=>{

      content.content=data.data.result.content
      content.head=data.data.result.author
      flag.i=true
      setTimeout(function() {
        flag.i = false
      }, 1000 * 10);
    })
  },()=>{})

}
</script>