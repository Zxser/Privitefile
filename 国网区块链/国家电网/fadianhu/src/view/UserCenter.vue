<template>
    <div class="userCenter">
        <div class="content">
          <div class="meau">
            <ul>
              <router-link tag="li" to="/UserCenter/UserBasic?isShowMeau=1">个人基本信息</router-link>
              <router-link tag="li" to="/UserCenter/LoginPwd?isShowMeau=1">登录密码维护</router-link>
              <router-link tag="li" to="/UserCenter/MathPwd?isShowMeau=1">数字证书密码维护</router-link>
              <router-link v-if="isPersonal1" tag="li" to="/UserCenter/Withdrawals?isShowMeau=1">提现</router-link>
              <router-link v-if="isPersonal()" tag="li" to="/UserCenter/Infoaudit?isShowMeau=1">信息审核</router-link>
              <router-link tag="li" to="/UserCenter/MeterManagement?isShowMeau=1">电表管理</router-link>
              <router-link tag="li" to="/UserCenter/OrderManagement?isShowMeau=1">订单查询</router-link>
            </ul>
          </div>

          <div>
            <router-view></router-view>
          </div>
        </div>

    </div>
</template>

<script>
    export default {
        name: 'userCenter',
        data () {
            return {
              isPersonal1:-1,
            }
        },
      methods:{

          isPersonal(){
            let isPersonal;
            if(sessionStorage.getItem('personal') == 2){
              isPersonal = true;
              this.isPersonal1 = false;
              return isPersonal;
            }else if(sessionStorage.getItem('personal') == 1){
              isPersonal = false;
              return isPersonal;
            }
          },
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    padding: 0px;
    margin: 0;
    list-style: none;
  }
  a{
    text-decoration:none;
    color: #fff;
  }
  .userCenter{
    width: 90%;
    height: 636px;
    margin: 20px 84px;
    border: 1px solid #CCCCCC;
    margin-top:150px
  }
  .content{
    display: flex;
    justify-content:flex-start;
  }
  .xx{
    margin-left: 30px;
  }
  .meau{
    width: 201px;
    height: 636px;
    border-right: 1px solid #CCCCCC;
    background-color: #F2F2F2;
  }
  .meau ul{
    display: flex;flex: 1;flex-direction: column;justify-content: center;align-items: center;
  }
  .meau ul li{
    width:100%;height: 40px;display: flex;justify-content: center;align-items: center;
  }
  /*.meau ul li{
    height: 42px;
    line-height: 42px;
  }
  .meau ul li a{
    color: #AAAAAA;
  }
  .arrow{
    float: right;
    margin-right: 11px;
  }*/
  .icon1{
    background: url("../assets/images/personal.png") no-repeat left center;
  }
  .icon2{
    background: url("../assets/images/pwd.png") no-repeat left center;
  }
  .icon3{
    background: url("../assets/images/loginPwd.png") no-repeat left center;
  }
  .icon4{
    background: url("../assets/images/WithdrawalsChecked.png") no-repeat left center;
  }
  .router-link-active{
    background-color: #fff;
  }
</style>
