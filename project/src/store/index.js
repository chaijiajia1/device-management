import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({//在其他组件中，可以通过Vuex的辅助函数获取该store中的user信息
    state: {
        user: {  //user 对象，
            username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username //username属性值从本地储存获取，若不存在，为空字符串
        }//只要不清空缓存，登录状态保持
    },
    mutations: {
        login (state, user) {  //为user赋值的方法
            state.user = user
            window.localStorage.setItem('user', JSON.stringify(user))
        },
        logout (state) {
            state.user = { username: '' };  // 清除state中的用户数据
            window.localStorage.removeItem('user');  // 从localStorage中删除用户数据
        }
    }
})
