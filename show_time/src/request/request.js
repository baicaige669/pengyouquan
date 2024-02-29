import axios from "axios"
import {ElMessage} from "element-plus";
const defaultFailure=(message)=>ElMessage.warning()
const defaultErro=()=>ElMessage.error("服务器错误，联系管理员")
//这个data是客户端发送的data
let failure=function (){}


function post(url,data,success,failure=defaultFailure()){
    //封装一个post方法，传入参数
    const token=localStorage.getItem("token")
    //从本地浏览器中取出token

    /*  axios.post().then().catch()  then回调函数 接收数据及其处理  catch捕获异常  */
    axios.post(url,data,
        {headers:{'token':token}
            //携带请求头token
        }).then(({data})=>{
        console.log(data)
        //这个data是接受服务器返回的数据
        if(data.code==200) {
            success(data.data, data.message)
        }
        else if (data.code==444){
            ElMessage.error("Token过期重新登录")
            localStorage.clear("token")
        }
        else {
            failure(data.data, data.message)
        }
       }).catch(function (error){
        ElMessage.error(error)
    })
}

function get(url,param,success,failure){
    const token=localStorage.getItem("token")
    axios.get(url,{
        params:param,
        headers:{'token':token}
    },).then(({data})=>{
        //这个data是接受服务器返回的数据
        if(data.code==200) {
            success(data.data,data.message)
        }
        else if (data.code==444){
            ElMessage.error("Token过期重新登录")
            localStorage.clear("token")
        }
        else {
            failure(data.message)
        }
    })
}


export {post,get}