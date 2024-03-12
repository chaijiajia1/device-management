import Vue from 'vue'
import VueRouter from 'vue-router'
import AppIndex from '../components/home/Appindex'
import Login from '../components/Login'
import home from '../components/home'
import reg from '../components/reg'
import configuration from "@/components/configuration/configuration"
import edit from "@/components/configuration/edit"
import create from "@/components/configuration/create"
import statistics from "@/components/statistics/statistics";
import map from "@/components/equipment/map"
//import {isChrome} from "vue/src/core/util/env";

Vue.use(VueRouter)

const routes = [
  {
    path: '/Login',
    name: 'Login',
    component: Login,
    meta:{
      requireAuth: false
    }
  },
  // {
  //   path:'/test',
  //   name:'test',
  //   component:HomeView,
  //   meta:{
  //     requireAuth: true
  //   }
  // },
  {
    path:'/reg',
    name:'reg',
    component:reg,
    meta:{
      requireAuth: false
    }
  },
  {
    path: '/',
    name: 'home',
    component: home,
    meta:{
      requireAuth: true
    },
    redirect:'/index',
    children:[
      {
        path: '/index',
        name: 'AppIndex',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: AppIndex,
        meta:{
          requireAuth: true
        }
      },
      {
        path:'configuration',
        name:'configuration',
        component:configuration,
        meta:{
          requireAuth: true
        },
        redirect:'/configuration/edit',
        children:[
          {
            path:'/configuration/edit',
            name:'edit',
            component:edit,
            meta:{requireAuth: true}
          },
          {
            path:'/configuration/create',
            name:'create',
            component:create,
            meta:{requireAuth: true}
          }
        ]
      },
      {
        path:'/statistics',
        name:'statistics',
        component: statistics,
        meta:{requireAuth: true}
      },
      {
        path:'/equipment',
        name:'equipment',
        component: map,
        meta:{requireAuth: true}
      }
    ]
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})



export default router
