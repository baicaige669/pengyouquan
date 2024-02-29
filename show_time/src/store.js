import {defineStore} from "pinia";
import {get} from "./request/request.js";
/*  储存全局变量 用户信息 */
export const UserData=defineStore(
    {
        id:'user',
        state:()=>{
            return{
                userid:'',
                username:'未登录',
                nickname:'未登录',
                url:'http://47.117.175.240:8082/files/user.jpg',
                createtime:null
            }
        },
        /*刷新信息的方法*/
        actions:{
            refresh(){
                get("user/findmore",{},(data)=>{
                    console.log(data)
                    this.url=data.url
                    this.username=data.username
                    this.nickname=data.nickname
                    this.createtime=data.createtime
                },()=>{})
            }
        }
    }
)
