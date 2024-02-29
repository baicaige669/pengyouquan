<style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      min-height: 100vh;
      background-color: var(--body-color);
      transition: all 0.3s ease;
    }

    /* 设置全局变量 */
    :root {
      --body-color: #E4E9F7;
      --shell-color: #FFF;
      --primary-color: #fe5c74;
      --primary-color-light: #F6F5FF;
      --toggle-color: #DDD;
      --text-color: #707070;
    }

    /* 深色主题变量 */
    .dark {
      --body-color: #202224;
      --shell-color: #171717;
      --primary-color: #3a3b3c;
      --primary-color-light: #3a3b3c;
      --toggle-color: #fff;
      --text-color: #ccc;
    }

    .shell {
      position: fixed;
      top: 0;
      left: 0;
      height: 100%;
      width: 150px;
      padding: 1px 1px;
      background: var(--shell-color);
      transition: all 0.3s ease;
      z-index: 100;
    }

    .close {
      width: 40px;
    }

    .shell li {
      height: 50px;
      list-style: none;
      display: flex;
      align-items: center;
      margin-top: 10px;
    }

    .image,
    svg {
      min-width: 40px;
      border-radius: 6px;
    }

    svg {
      min-width: 35px;
      border-radius: 6px;
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
      font: 300 23px '';
    }

    .text,
    svg {
      color: var(--text-color);
      transition: all 0.3s ease;
    }

    .text {
      white-space: nowrap;
      opacity: 1;
    }

    .shell.close .text {
      opacity: 0;
    }

    header {
      position: relative;
    }

    .image-text {
      display: flex;
      align-items: center;
    }

    .logo-text {
      display: flex;
      flex-direction: column;
    }

    .name {
      margin-top: 2px;
      font: 600 18px '';
    }

    .software {
      font-size: 20px;
      margin-top: -2px;
      display: block;
    }

    .image {
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .image img {
      width: 40px;
      border-radius: 6px;
    }

    .toggle {
      position: absolute;
      top: 50%;
      right: -25px;
      transform: translateY(-50%) rotate(180deg);
      height: 35px;
      width: 25px;
      background-color: antiquewhite;
      color: var(--shell-color);
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 15px;
      cursor: pointer;
      transition: all 0.3s ease;
    }

    .toggle {
      color: #ccc;
    }

    .shell.close .toggle {
      transform: translateY(-50%) rotate(0deg);
    }

    .menu {
      margin-top: 5px;
    }

    .shell li a {
      list-style: none;
      height: 100%;
      background-color: transparent;
      display: flex;
      align-items: center;
      height: 100%;
      width: 100%;
      border-radius: 6px;
      text-decoration: none;
      transition: all 0.3s ease;
    }

    .shell li a:hover {
      background-color: var(--primary-color);
    }

    .shell li a:hover svg,
    .shell li a:hover .text {
      color: var(--shell-color);
    }

    .menu-bar {
      height: calc(100% - 55px);
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      overflow-y: scroll;
    }

    .menu-bar::-webkit-scrollbar {
      display: none;
    }


    .zhuxiao{
      margin-bottom: 60px;
    }

  </style>

<template>
  <nav class="shell close">
    <header>
      <div class="image-text">
                <span class="image">
                    <img :src="USer.url" alt="">
                </span>
        <div class="text logo-text">
          <span class="name">{{USer.username}}</span>
          <span class="software">{{USer.nickname}}</span>
        </div>
      </div>
      <svg  @click="click"  t="1708076229856" class="toggle" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2700" width="200" height="200"><path d="M670.976 546.133333a34.133333 34.133333 0 0 1-24.064-9.984L328.874667 218.112a34.133333 34.133333 0 1 1 48.213333-48.298667l318.037333 318.037334A34.133333 34.133333 0 0 1 670.976 546.133333z" p-id="2701"></path><path d="M353.024 864.170667a34.133333 34.133333 0 0 1-24.149333-58.282667l318.037333-318.037333a34.133333 34.133333 0 0 1 48.213333 48.298666L377.088 854.186667a34.133333 34.133333 0 0 1-24.064 9.984z" p-id="2702"></path></svg>

    </header>
    <div class="menu-bar">
      <div class="menu">
        <ul class="menu-links">
          <li class="nav-link">
            <a @click="router.push('/blogs')">
              <svg  style="height: 50px;width: 50px"t="1707815505563" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1728" width="200" height="200"><path d="M515.5 510.5m-434.5 0a434.5 434.5 0 1 0 869 0 434.5 434.5 0 1 0-869 0Z" fill="#3D6CE2" p-id="1729"></path><path d="M782.7 413.5L634.29 304.61c-0.28-0.21-0.56-0.41-0.85-0.6-42.49-28.7-79.65-41.38-116.94-39.89-34.85 1.38-70.35 14.94-115.1 44-0.24 0.15-0.47 0.31-0.71 0.48L250.33 413.11a26.69 26.69 0 1 0 30.48 43.83l14.89-10.35 2.15 29.41c3.14 57.18 8.19 115.42 9.67 133.87l2.8 35A96.72 96.72 0 0 0 399 733.62l35 2.8q41.13 3.29 82.41 3.27 41 0 81.92-3.27l35-2.8a96.72 96.72 0 0 0 88.72-88.72l2.8-35c1.47-18.45 6.53-76.69 9.67-133.87l2.13-30 14.36 10.54a26.7 26.7 0 0 0 31.69-43.07zM588 661.2a23.27 23.27 0 0 1-20.82 23.14c-40.48 4.29-78.92 2-101.63-0.23a23.27 23.27 0 0 1-21-23.15v-52.41a71.72 71.72 0 0 1 71.72-71.72A71.72 71.72 0 0 1 588 608.55z" fill="#FFFFFF" p-id="1730"></path></svg>
              <span class="text nac-text">主页</span>
            </a>
          </li>

          <li  @click="router.push('/publish')">
            <a href="#">
              <svg style="height: 50px;width: 50px" t="1707815549616" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1872" width="200" height="200"><path d="M515.5 510.5m-434.5 0a434.5 434.5 0 1 0 869 0 434.5 434.5 0 1 0-869 0Z" fill="#3D6CE2" p-id="1873"></path><path d="M773.83 431.28L771.66 404a131.9 131.9 0 0 0-121-121l-27.24-2.18C591 278.3 545 277 512.47 277s-78.49 1.3-111 3.89l-27.24 2.18a131.9 131.9 0 0 0-121 121l-2.38 29.79c-2.41 30.29-2.41 79.84 0 110.13l2.38 29.79a131.9 131.9 0 0 0 121 121l27.24 2.17c13.67 1.1 29.69 2 46.1 2.59l43.77 39.11a35 35 0 0 0 46.62 0l44-39.28c14.81-0.62 29.14-1.42 41.52-2.41l27.24-2.17a131.9 131.9 0 0 0 121-121l2.17-27.24c2.71-18.21 2.54-82.78-0.06-115.27z m-408.6 95.12a39.56 39.56 0 1 1 39.56-39.55 39.55 39.55 0 0 1-39.56 39.55z m147.23 0A39.56 39.56 0 1 1 552 486.85a39.55 39.55 0 0 1-39.54 39.55z m147.23 0a39.56 39.56 0 1 1 39.56-39.55 39.55 39.55 0 0 1-39.56 39.55z" fill="#FFFFFF" p-id="1874"></path></svg>
              <span class="text nac-text">发布信息</span>
            </a>
          </li>

          <li class="nav-link">
            <a @click="router.push('/ranklist')">
              <svg style="height: 50px;width: 50px" t="1708052777132" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1582" width="200" height="200"><path d="M514.5 511.5m-434.5 0a434.5 434.5 0 1 0 869 0 434.5 434.5 0 1 0-869 0Z" fill="#63D13F" p-id="1583"></path><path d="M358.58 426H307.1a26.45 26.45 0 0 0-26.24 23.11l-27.45 216.36a26.44 26.44 0 0 0 26.23 29.77h64A26.44 26.44 0 0 0 370 670.62l15-216.34A26.44 26.44 0 0 0 358.58 426zM783.48 665.85l-23-162.67a26.44 26.44 0 0 0-26.18-22.75h-40a26.45 26.45 0 0 0-26.3 28.28l11.26 162.67A26.45 26.45 0 0 0 705.61 696h51.69a26.45 26.45 0 0 0 26.18-30.15zM611 320.57A30.68 30.68 0 0 0 580.37 292h-115.8A30.69 30.69 0 0 0 434 320.57l-28.61 342.62A30.69 30.69 0 0 0 436 696h172.93a30.69 30.69 0 0 0 30.61-32.81z m-64.79 309a24.47 24.47 0 0 1-48.93 0V556.4a24.46 24.46 0 0 1-11.07-47.4l22.87-7.89a22.94 22.94 0 0 1 2.51-0.71 24.44 24.44 0 0 1 34.6 22.26z" fill="#FFFFFF" p-id="1584"></path></svg>
              <span class="text nac-text">排行榜</span>
            </a>
          </li>

          <li class="nav-link">
            <a @click="router.push('/user')">
              <svg style="height: 50px;width: 50px" t="1708054006537" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1875" width="200" height="200"><path d="M511.5 511.5m-434.5 0a434.5 434.5 0 1 0 869 0 434.5 434.5 0 1 0-869 0Z" fill="#DB3131" p-id="1876"></path><path d="M773.56 408.83a173 173 0 0 0-158.72-158.72Q563.39 246 511.78 246t-103.06 4.11A173.05 173.05 0 0 0 250 408.83q-4.11 51.45-4.11 103.06T250 615a173.06 173.06 0 0 0 158.72 158.68q51.61 4.11 103.37 4.11 51.42 0 102.75-4.11A173.05 173.05 0 0 0 773.56 615q4.13-51.45 4.12-103.06t-4.12-103.11zM511.78 652.54c-65.68 0-118.92-6.8-118.92-55.52 0-31 21.88-58.07 54.6-73.76 0 0 7.11-4.43 21.13-8.22-17.09-14.63-28.12-37.73-28.12-63.72 0-44.23 31.93-80.08 71.31-80.08s71.32 35.85 71.32 80.08c0 26.17-11.18 49.41-28.48 64 13.73 3.72 21.48 7.92 21.48 7.92C608.82 539 630.71 566 630.71 597c0 48.74-53.25 55.54-118.93 55.54z" fill="#FFFFFF" p-id="1877"></path></svg>
              <span class="text nac-text">个人信息</span>
            </a>
          </li>
          <li class="nav-link">
            <a @click="router.push('/key')">
              <svg style="height: 50px;width: 50px" t="1708053152666" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1728" width="200" height="200"><path d="M515.5 511.5m-434.5 0a434.5 434.5 0 1 0 869 0 434.5 434.5 0 1 0-869 0Z" fill="#63D13F" p-id="1729"></path><path d="M762.43 725.59H365.58a88.81 88.81 0 0 1-88.71-88.71v-301a23.87 23.87 0 0 1 47.74 0v301a41 41 0 0 0 41 41h396.82a23.88 23.88 0 0 1 0 47.75z" fill="#FFFFFF" p-id="1730"></path><path d="M360.06 499.42v118.37a25.1 25.1 0 0 0 25.1 25.11h329.65a25.11 25.11 0 0 0 25.11-25.11V356.57c0-22-27.37-32.26-41.82-15.61L621 429.87a27.82 27.82 0 0 1-35 5.85l-69.6-40.3a50.2 50.2 0 0 0-57.4 4.94l-86.49 72.32a34.85 34.85 0 0 0-12.45 26.74z" fill="#FFFFFF" p-id="1731"></path></svg>
              <span class="text nac-text">后台管理</span>
            </a>
          </li>
        </ul>
      </div>
      <div class="bottom-content">
        <li class="zhuxiao">
          <a @click="logout">
            <i class="iconfont icon-zhuxiaoyuan icon"></i>
            <span class="text nac-text" style="font-size: 20px">注销</span>
          </a>
        </li>

      </div>
    </div>

  </nav>

</template>

<script setup>

import {useRouter} from "vue-router";
import {UserData} from "../store.js";
import {onBeforeUpdate, onMounted, onUpdated, reactive} from "vue";
import {get} from "../request/request.js";
let shell
let toggle
let router=useRouter()
function click(){
  shell = body.querySelector('nav'), toggle = body.querySelector(".toggle"),
  shell.classList.toggle("close");
}
  const body = document.querySelector('body'),
  // 点击toggle元素时触发事件

let USer=reactive(UserData()
)
onMounted(function (){
get("user/findmore",{},(data)=>{
  console.log(data)
  USer.url=data.url
  USer.username=data.username
  USer.nickname=data.nickname
  USer.createtime=data.createtime
  console.log(USer.username)
},()=>{})
})



function logout(){
  window.localStorage.removeItem('token')
  location.reload()
}
</script>

