import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Header from '@/view/Header'
import ElectricityDetails from '@/view/ElectricityDetails'// 发电量明细
import HomeIndex from '@/view/HomeIndex'// 登录之后的首页
import Login from '@/view/Login'// 登录
import ForgetPwdPersonal from '@/view/ForgetPwdPersonal'// 忘记密码
import UserIndex from '@/view/UserIndex'// 个人用户首页
import Contract from '@/view/Contract'// 智能合约
import Count from '@/view/Count'// 统计分析
import UserCenter from '@/view/UserCenter'// 个人中心
import UserBasic from '@/view/UserBasic'// 个人基本信息
import LoginPwd from '@/view/LoginPwd'// 登录密码维护
import MathPwd from '@/view/MathPwd'// 数字证书登录密码维护
import Withdrawals from '@/view/Withdrawals'// 提现
import Infoaudit from '@/view/Infoaudit'// 用户审核
import Ammete from '@/view/Ammete'// 电表信息
import AddBank from '@/view/AddBank'// 增加银行账户
import DeleteBank from '@/view/DeleteBank'//删除银行账户
import EchartsMapProvince from  '@/components/EchartsMapProvince'
import EchartsAreaStack from  '@/components/EchartsAreaStack'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',name: 'Home',component: Home},
    {path: '/Login',name: 'Login',component: Login},
    {path: '/ForgetPwdPersonal',name: 'ForgetPwdPersonal',component: ForgetPwdPersonal},
    {path: '/Header',name: 'Header',component: Header,
      children:[
        // {path: '/',name: 'HomeIndex',component: HomeIndex},
        {path: '/Header/ElectricityDetails',name: 'ElectricityDetails',component: ElectricityDetails},
        {path: '/Header/Contract',name: 'Contract',component: Contract},
        {path: '/Header/Count',name: 'Count',component: Count},
        {path: '/Header/HomeIndex',name: 'HomeIndex',component: HomeIndex},
        {path: '/Header/UserCenter',name: 'UserCenter',component: UserCenter,
          children:[
            {path: '/UserCenter/UserBasic',name: 'UserBasic',component: UserBasic},
            {path: '/UserCenter/LoginPwd',name: 'LoginPwd',component: LoginPwd},
            {path: '/UserCenter/MathPwd',name: 'MathPwd',component: MathPwd},
            {path: '/UserCenter/Withdrawals',name: 'Withdrawals',component: Withdrawals},
            {path: '/UserCenter/Infoaudit',name: 'Infoaudit',component: Infoaudit},
            {path: '/UserCenter/Ammete',name: 'Ammete',component: Ammete},
            {path: '/UserCenter/DeleteBank',name: 'DeleteBank',component: DeleteBank},
            {path: '/UserCenter/AddBank',name: 'AddBank',component: AddBank},
          ]
        },
      ]
    },
    {path: '/UserIndex',name: 'UserIndex',component: UserIndex},
    {path: '/EchartsMapProvince',name: 'EchartsMapProvince',component: EchartsMapProvince},
    {path: '/EchartsAreaStack',name: 'EchartsAreaStack',component: EchartsAreaStack},
  ]
})
