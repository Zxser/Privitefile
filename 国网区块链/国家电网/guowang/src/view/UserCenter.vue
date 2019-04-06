<template>
    <div class="userCenter">
      <div style="padding-top: 20px"></div>
        <div class="content">

          <div class="meau">
            <ul>
              <router-link tag="li" to="/UserCenter/UserBasic?isShowMeau=1">个人基本信息</router-link>
              <router-link tag="li" to="/UserCenter/LoginPwd?isShowMeau=1">登录密码维护</router-link>
              <router-link tag="li" to="/UserCenter/MathPwd?isShowMeau=1">数字证书密码维护</router-link>
              <router-link tag="li" to="/UserCenter/Infoaudit?isShowMeau=1">用户审核</router-link>
            </ul>
          </div>

          <div>
            <router-view class="main"></router-view>
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
    clear: both;
    width: 90%;
    height: 636px;

    margin: 0 auto;

  }
  .content{
    display: flex;
    width: 100%;
    border: 1px solid #CCCCCC;
  }
  .xx{
    margin-left: 30px;
  }
  .meau{
    width: 20%;
    height: 592px;
    border-right: 1px solid #CCCCCC;
    background-color: #F2F2F2;
  }
  main{
    width:80%;
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
