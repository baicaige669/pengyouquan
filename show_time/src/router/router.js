import {createRouter, createWebHistory} from "vue-router";
import Managemnet from "../components/Managemnet.vue";
import HelloWorld from "../components/HelloWorld.vue";
import blogs from '../components/blogs.vue'
import pictrueManagemnet from '../components/pictrueManagement.vue'
import {ElMessage} from "element-plus";
import publish from '../components/publish.vue'
import user from '../components/user.vue'
import ranklist from  '../components/ranklist.vue'
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            components: {
                blogs:blogs
            }
        },
        {
            path: '/key',
            components: {
                key:Managemnet
            }
        },
        {
            path: '/main',
            components: {
                main1:HelloWorld
            }
        },
        {
            path: '/blogs',
            components: {
                blogs:blogs
            }
        },
        {
            path: '/pictrue',
            components: {
                pictrue:pictrueManagemnet
            }
        },
        {
            path: '/publish',
            components: {
                publish:publish
            }
        },
        {
            path: '/user',
            components: {
                user:user
            }
        },
        {
            path: '/ranklist',
            components: {
                ranklist:ranklist
            }
        }
    ]
})
/* 路由守卫 */
router.beforeEach((to,from,next)=>{

    if(to.path == '/blogs'||to.path=='/main'||localStorage.getItem("token")!=null||to.path=='/'){
        next()

    }
    else{
            ElMessage.warning("请先登录再操作")
            next('/main')
        }
})

export default router