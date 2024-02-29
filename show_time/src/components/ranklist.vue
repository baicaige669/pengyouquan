<template>
  <div class="container">
    <div class="topLeadersList">

      <div class="leader">
        <div class="containerImage"><img class="image" loading="lazy" :src="rankuser.data[0].url">
          <div class="crown">
            <svg id="crown1" fill="#0f74b5" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 50">
              <polygon class="cls-1" points="12.7 50 87.5 50 100 0 75 25 50 0 25.6 25 0 0 12.7 50"></polygon>
            </svg>
          </div>
          <div class="leaderName">{{rankuser.data[0].nickname}}</div>
        </div>
      </div>

      <div class="leader">
        <div class="containerImage"><img class="image" loading="lazy" :src="rankuser.data[1].url">
          <div class="crown">
            <svg id="crown1" fill="#0f74b5" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 50">
              <polygon class="cls-1" points="12.7 50 87.5 50 100 0 75 25 50 0 25.6 25 0 0 12.7 50"></polygon>
            </svg>
          </div>
          <div class="leaderName">{{rankuser.data[1].nickname}}</div>
        </div>
      </div>

      <div class="leader">
        <div class="containerImage"><img class="image" loading="lazy" :src="rankuser.data[2].url">
          <div class="crown">
            <svg id="crown1" fill="#0f74b5" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 50">
              <polygon class="cls-1" points="12.7 50 87.5 50 100 0 75 25 50 0 25.6 25 0 0 12.7 50"></polygon>
            </svg>
          </div>
          <div class="leaderName">{{rankuser.data[2].nickname}}</div>
        </div>
      </div>
    </div>
    <div class="playerslist">
      <div class="table">
        <div>排名</div>
        <div>信息</div>
        <div>用户名</div>
        <div>发表数量</div>
      </div>
      <div class="list">
        <div class="player" v-for="(item ,index) in rankuser.data"><span> {{index+1}}</span>
          <div class="user"><img class="image" :src="item.url"><span>{{item.nickname}}</span></div>
          <span> {{item.username}} </span><span>{{item.number}}</span></div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.list::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #F5F5F5;
}

.list::-webkit-scrollbar {
  width: 6px;
  background-color: #F5F5F5;
}

.list::-webkit-scrollbar-thumb {
  background-color: #646464;
}

body {
  background-color: #b394c9;
  font-family: "Amatic SC";
}

#root {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container {
  width: 350px;
  height: 600px;
  background-color: black;
  margin: auto;
  font-family: "Amatic SC";
  margin: auto;
  padding: 1rem;
  border-radius: 5px;
  box-shadow: 7px 9px 7px #00000052;
}
.container .leader {
  display: flex;
}
.container .crown {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}
.container .crown svg {
  width: 3rem;
}
.container .image {
  height: 58px;
  object-fit: cover;
  width: 58px;
  background-color: black;
  border-radius: 50%;
}
.container .topLeadersList {
  display: flex;
  position: relative;
  min-height: 120px;
  padding-top: 3rem;
}
.container .topLeadersList .image {
  border-radius: 50%;
  border: 3px solid #b159ffcc;
}
.container .topLeadersList .leader:nth-child(1) {
  color: black;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}
.container .topLeadersList .leader:nth-child(1):after {
  content: "1";
  width: 30px;
  height: 30px;
  background: #ffc500;
  border-radius: 50%;
  position: absolute;
  right: 0;
  font-family: sans-serif;
  text-align: center;
  line-height: 30px;
  font-weight: 700;
  box-shadow: 1px 1px 4px black;
}
.container .topLeadersList .leader:nth-child(1) .image {
  width:115px;
  height: 115px;
}
.container .topLeadersList .leader:nth-child(1) .crown {
  top: -20%;
}
.container .topLeadersList .leader:nth-child(1) .crown svg {
  fill: #ffc500;
}
.container .topLeadersList .leader:nth-child(2) {
  color: black;
  position: absolute;
  left: 15%;
  transform: translateX(-15%);
  bottom: -65%;
}
.container .topLeadersList .leader:nth-child(2):after {
  content: "2";
  width: 30px;
  height: 30px;
  background: #d4d4d4;
  border-radius: 50%;
  position: absolute;
  right: 0;
  font-family: sans-serif;
  text-align: center;
  line-height: 30px;
  font-weight: 700;
  box-shadow: 1px 1px 4px black;
}
.container .topLeadersList .leader:nth-child(2) .image {
  width: 90px;
  height: 90px;
}
.container .topLeadersList .leader:nth-child(2) .crown {
  top: -25%;
}
.container .topLeadersList .leader:nth-child(2) .crown svg {
  fill: #d4d4d4;
}
.container .topLeadersList .leader:nth-child(3) {
  color: black;
  position: absolute;
  left: 85%;
  transform: translateX(-85%);
  bottom: -60%;
}
.container .topLeadersList .leader:nth-child(3):after {
  content: "3";
  width: 30px;
  height: 30px;
  background: #ab6528;
  border-radius: 50%;
  position: absolute;
  right: 0;
  font-family: sans-serif;
  text-align: center;
  line-height: 30px;
  font-weight: 700;
  box-shadow: 1px 1px 4px black;
}
.container .topLeadersList .leader:nth-child(3) .image {
  width: 90px;
  height: 90px;
}
.container .topLeadersList .leader:nth-child(3) .crown {
  top: -25%;
}
.container .topLeadersList .leader:nth-child(3) .crown svg {
  fill: #ab6528;
}
.container .leaderName {
  position: absolute;
  text-align: center;
  color: white;
  left: 50%;
  transform: translateX(-50%);
  font-size: 15px;
}
.container .player {
  background-color: #330b7775;
  display: grid;
  grid-template-columns: 1fr 3fr 3fr 3fr ;
  align-items: center;
  min-height: 42px;
  text-align: center;
  padding-right: 0.4rem;
}
.container .player .image {
  width: 40px;
  height: 40px;
  border: 1.5px solid white;
}
.container .table {
  margin-right: 0.1rem;
  display: grid;
  font-size: 14px;
  grid-template-columns: 1fr 3fr 3fr 3fr;
  text-align: center;
}
.container .table div:nth-child(2) {
  text-align: left;
  margin-left: 5px;
}
.container .table .image {
  width: 20px;
  height: 20px;
}
.container .playerslist {
  margin-top: 8rem;
  font-size: 12px;
  overflow: hidden;
  color: white;
  font-family: "Roboto Condensed", sans-serif;
}
.container .playerslist .player:nth-child(odd) {
  background-color: #b159ffcc;
  align-items: center;
}
.container .user {
  display: flex;
  align-items: center;
  gap: 4px;
}
.container .list {
  overflow: scroll;
  height: 20rem;
  overflow-x: hidden;
}

</style>

<script setup>

import {get} from "../request/request.js";
import {onBeforeMount, onMounted, reactive} from "vue";
let rankuser=reactive({
data:[{username: '诺克萨斯之首', nickname: '懦弱之举', url:""},{username: '诺克萨斯之首', nickname: '懦弱之举', url: ""},{username: '诺克萨斯之首', nickname: '懦弱之举', url: ""}]
})

get('rank',{},(data)=>{
  rankuser.data=data
},()=>{})
</script>