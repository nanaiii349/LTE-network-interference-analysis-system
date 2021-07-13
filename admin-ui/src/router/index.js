import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import db_main from '@/components/views/data_process_main'
import db_out from '@/components/views/data_process_out'
import db_usercontrol from '@/components/views/data_usercontrol'
import usercontrol from '@/components/views/usercontrol'
import login from '@/components/views/login'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/db_main',
      name: 'db_main',
      component: db_main,
      meta:{
        loginRequest:true
      }
    },
    {
      path: '/db_out',
      name: 'db_out',
      component: db_out,
      meta:{
        loginRequest:true
      }
    },
    {
      path: '/db_usercontrol',
      name: 'db_usercontrol',
      component: db_usercontrol,
      meta:{
        loginRequest:true
      }
    },
    {
      path: '/usercontrol',
      name: 'usercontrol',
      component: usercontrol,
      meta:{
        loginRequest:true
      }
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },

  ]
})


