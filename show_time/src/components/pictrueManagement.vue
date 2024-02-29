<script setup>

import {get} from "../request/request.js";
import {ElMessage} from "element-plus";
import {UserData} from "../store.js";
import {onBeforeUpdate, onMounted, onUpdated, reactive} from "vue";
let User=UserData()
let result = reactive({data: [{username: '伟大的哇'}]})

function findPage() {
  get('findall', '', (data) => {
    result.data = data
  }, () => {
  })
}

/* 通过onMounted生命周期,自动加载一次 */
onMounted(() => {
  findPage()
})

function updateP(id){
  get('/user/updateP',{phone:id},()=>{User.refresh()},()=>{})
}
</script>

<template>
  <div class="main">
    <div class="block">
      <el-timeline-item :timestamp="item.id" placement="top" v-for="item in result.data" style="width: 100%;list-style: none">
        <el-card style="width: 100%">
          <img style="width: 90px ;height: 90px" :src=item.url>
          <el-button @click="updateP(item.id)">设为头像</el-button>
        </el-card>
      </el-timeline-item>
    </div>
  </div>
</template>

<style scoped>

.block {
  margin-right: 60px;
}
.main{

}
</style>


<script>
export default {
  data() {
    return {
      fileList: [{
        name: '',
        url: ''
      }]
    };
  },
  methods: {
    handleChange(file, fileList) {
      console.log(file)
      console.log(fileList)
      this.fileList = fileList.slice(-3);
    }
  }
}
</script>