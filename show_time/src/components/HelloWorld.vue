<script setup>
import {reactive, ref} from 'vue'
import {get, post} from "../request/request.js";
import {ElMessage} from "element-plus";
import {useRouter} from "vue-router";
import {UserData} from "../store.js";

let PiniaUser=UserData()
//User数据类型 与输入框v-model绑定
let User = reactive({
  username: '',
  password: ''
})

let RegistUser = reactive({
  username: '',
  password: '',
  nickname: ''
})

let flag=reactive(false)
let usernameMessage=reactive({data:''})

let result = [];
let router=useRouter()
//定义一个login方法与登录按钮@click绑定
let pinia=UserData()
function login() {
  if (!User.username || !User.password || !/^.{5,10}$/) {
    ElMessage.warning('请输入正确的格式')
  } else {
    //调用自定义post方法
    post('user/login', {
      password: User.password,
      username: User.username
    }, (data,message) => {
      localStorage.setItem('token',message)
      ElMessage.success("成功登录")
      router.push('/blogs')
      pinia.refresh()
    }, (data,message) => {
      ElMessage.warning(message)
    })
  }
}

function regist() {
  document.getElementById('id01').style.display = 'block'
}

function regist1() {
  if (/^.{2,25}$/.test(RegistUser.username)&&RegistUser.password&&RegistUser.nickname&&flag==true) {
    post('user/regist', {
      password: RegistUser.password,
      username: RegistUser.username,
      nickname: RegistUser.nickname
    }, (message) => {
      ElMessage.success(message)
      document.getElementById('id01').style.display ='none '
    }, (message) => {
      ElMessage.warning(message)
    })
  }
  else{
    console.log(checkUsername())
    ElMessage.warning('请输入2-25个字符的用户名，或检查用户名被占用')
  }
}
function  checkUsername(){
   get('user/checkusername',{username:RegistUser.username},(data,message)=>{
     usernameMessage.data=message
     flag=true
   },(message)=>{
     usernameMessage.data=message
     flag=false
   })

}
</script>

<template>
  <div>
    <div class="main">
<!--      <img src="../../public/jie.png">-->
      <div class="login">
        <h1 STYLE="font-size: 17px">欢迎来到登陆系统</h1>
        <el-input placeholder="请输入账号" style="margin-top: 20px" v-model="User.username"></el-input>
        <el-input placeholder="请输入密码" v-model="User.password " show-password style="margin-top: 20px"></el-input>
        <div class="button">
          <el-button type="primary" plain @click="login" style="margin-top: 20px ;width: 150px">登录</el-button>
          <el-button type="primary" plain @click="regist"
                     style="margin-top: 20px ;width: 150px;background-color: #4CAF50;color: white">注册
          </el-button>
        </div>
      </div>
    </div>
    <div id="id01" class="modal">
      <!--      <span onclick="document.getElementById('id01').style.display='none'" class="close"-->
      <!--            title="Close Modal">&times;</span>-->
      <div class="modal-content animate">
        <div class="container">
          <label><b>账号</b></label>
          <p class="mmm">{{usernameMessage.data}}</p>
          <input type="text" placeholder="Enter USERNAME" v-model="RegistUser.username" @blur="checkUsername">

          <label><b>密码</b></label>
          <input type="password" placeholder="Enter Password" v-model="RegistUser.password">

          <label><b>昵称</b></label>
          <input type="text" placeholder="ENTER NICKNAME" required v-model="RegistUser.nickname">
          <input type="checkbox" checked="checked"> Remember me

          <div class="clearfix">
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">
              取消
            </button>
            <button class="signupbtn" @click="regist1()">注册</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

.login{
  margin-left: 60px;
}

.main {
  display: flex;
  flex-direction: row;
  margin-left: 40px;
  margin-top: 40px;
}

.login {
  margin: 10px 10px 10px 10px;
}

.button {
  display: flex;
}

/* 宽屏输入字段 */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* 为所有按钮设置样式  */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* 取消按钮的其他样式 */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* 浮动取消和注册按钮，并添加一个相同的宽度 */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%
}

/* 向容器元素添加填充 */
.container {
  padding: 16px;
}

/* 注册弹框模型 */
.modal {
  display: none; /* 在默认情况下隐藏 */
  position: fixed; /* 生成绝对定位的元素，相对于浏览器窗口进行定位。 */
  /* z-index、left、top共同控制模型在所有内容的上方 */
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* 如果需要，启用滚动条 */
  background-color: rgb(0, 0, 0); /* 回退颜色 */
  background-color: rgba(0, 0, 0, 0.4); /* 黑色 */
  padding-top: 60px;
  padding-left: 40px;
}

/* 模型内容 */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 90%; /* Could be more or less, depending on screen size */
}

/* 定位关闭按钮 */
.close {
  position: absolute;
  right: 35px;
  top: 15px;
  color: #000;
  font-size: 40px;
  font-weight: bold;
}

/* 光标移动到关闭按钮 */
.close:hover,
.close:focus {
  color: red;
  /*光标呈现为指示链接的指针（一只手）*/
  cursor: pointer;
}

/* 设置浮动*/
.clearfix::after {
  content: "";
  clear: both;
  display: table; /*此元素会作为块级表格来显示（类似 <table>），表格前后带有换行符。*/
}

/* 添加缩放动画 */
.animate {

  -webkit-animation: animatezoom 0.6s; /*兼容-webkit-引擎浏览器*/
  -moz-animation: animatezoom 0.6s; /*兼容-moz-引擎浏览器*/
  -o-animation: animatezoom 0.6s; /*兼容-o-引擎浏览器*/
  animation: animatezoom 0.6s
}

/*
1. transform:scale(x,y)
x表示元素沿着水平方向（X轴）缩放的倍数，y表示元素沿着垂直方向（Y轴）缩放的倍数。
注意，Y是一个可选参数，如果没有设置Y值，则表示X、Y两个方向的缩放倍数是一样的（同时放大相同倍数）。

2. 关键词 "from" 和 "to"，等同于 0% 和 100%。
0% 是动画的开始，100% 是动画的完成。
*/

/*创建动画animatezoom,把它绑定到 animate 选择器*/
@keyframes animatezoom {
  from {
    transform: scale(0)
  }
  to {
    transform: scale(1)
  }
}

/* 设置动画兼容-webkit-引擎浏览器 Firefox */
@-webkit-keyframes animatezoom {
  from {
    transform: scale(0)
  }
  to {
    transform: scale(1)
  }
}

/*设置动画兼容-moz-引擎浏览器 Safari and Chrome*/
@-moz-keyframes animatezoom {
  from {
    transform: scale(0)
  }
  to {
    transform: scale(1)
  }
}

/*设置动画兼容-o-引擎浏览器 Opera*/
@-o-keyframes animatezoom {
  from {
    transform: scale(0)
  }
  to {
    transform: scale(1)
  }
}

/*
@media 可以针对不同的屏幕尺寸设置不同的样式，特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
这里，如果文档宽度小于 300 像素则操作修改，在额外的小屏幕上更改取消和注册按钮的样式 */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
    width: 100%;
  }
}

.mmm{
  font-size: 10px;
  color: #f44336;
}
</style>
