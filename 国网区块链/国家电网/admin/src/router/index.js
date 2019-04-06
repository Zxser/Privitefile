import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/Login'
import ForgetPwdPersonal from '@/view/ForgetPwdPersonal'// 忘记密码
import selfNav from '@/view/selfNav'// 系统管理
import ManageTab from '@/view/ManageTab'// 系统管理导航
// import CreateUser from '@/view/CreateUser'// 创建用户
import RePassword from '@/view/RePassword'// 修改管理员密码
import AuthorityManage from '@/view/AuthorityManage'// 权限管理
import UserList from '@/view/UserList'// 用户列表
import PriceType from '@/view/PriceType'// 价格类型管理
import Price from '@/view/Price'// 价格管理
import Organization from '@/view/Organization'// 组织管理
import Area from '@/view/Area'// 区域管理
import G_list from '@/view/G_list'// 国网用户管理
import F_list from '@/view/F_list'// 发电户管理
import S_list from '@/view/S_list'// 系统管理

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',name: 'Login',component: Login},
    {path: '/ForgetPwdPersonal',name: 'ForgetPwdPersonal',component: ForgetPwdPersonal},
    {path: '/selfNav',component: selfNav,
      children:[
        {path: '/',component: ManageTab,
          children:[
            // {path:'/ManageTab/CreateUser',component:CreateUser},
            {path:'/ManageTab/RePassword',component:RePassword},
            {path:'/ManageTab/AuthorityManage',component:AuthorityManage},
            {path:'/ManageTab/UserList',component:UserList},
            {path:'/ManageTab/PriceType',component:PriceType},
            {path:'/ManageTab/Price',component:Price},
            {path:'/ManageTab/Organization',component:Organization},
            {path:'/ManageTab/Area',component:Area},
            {path:'/ManageTab/G_list',component:G_list},
            {path:'/ManageTab/F_list',component:F_list},
            {path:'/ManageTab/S_list',component:S_list},
          ]
        },
      ]
    },

  ]
})
