<template>
  <div class="login" style="position: fixed; top:0px; left:0px;height:100%;width:100%; background-color: #1F2D3D; z-index:100">
    <div class="loginBg">
      <div class="loginTitle">用户登录</div>
      <div class="loginContent">
        <p><span>用户名:</span><input v-model="formData.username" type="text" placeholder="请输入您的手机号"></p>
        <p><span style="margin-left: 16px;">密码:</span><input
          v-model="formData.password"
          type="password"
          placeholder="请输入您的密码"
          @keyup.enter="Submit"></p>
        <!--<p class="loginMean"><span> <router-link style="color:rgb(80, 182, 161);text-decoration: none" to="/ForgetPwdPersonal">忘记密码</router-link> </span></p>-->
      </div>
      <div ><button
        class="loginBtn"
        @click="Submit"
      >登录</button></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data () {
      return {
        formData:{
          username:'',/** 用户名 */
          password:'',/** 密码 */
        },
      }
    },
    methods:{
      Submit(){
        this.$api.post('manage/login',this.formData,(res)=>{
          if(res.status == 200){
            if(res.body.status == 1){
              this.$message.error(res.body.msg);
              return false
            }else{
                console.log(res.body)
              // 到系统管理员页面
              this.$notify({
                title: '成功',
                message: '登录成功',
                type: 'success'
              });
              // 登录成功之后，保存tock
              this.$http.headers.common['Authorization'] = res.body.token;
              sessionStorage.setItem('accessToken', res.body.token);
              this.$router.replace({path:'/selfNav'});
            }
          }
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .login{
    width: 1366px;
    height:767px;
    background:url('../assets/images/login-bg.png')  no-repeat;
    color: #fff;
    font-family:'MicrosoftYaHeiBold', 'Microsoft YaHei Bold', 'Microsoft YaHei';

  }
  .loginBg{
    width: 402px;
    height: 352px;
    background-color: #0d645b;
    border-radius: 15px;
    position: relative;
    top:28%;
    left:35%;
    opacity:0.8;
  }
  .loginTitle{
    font-weight:700;
    text-align: center;
    width: 402px;
    height:76px;
    line-height: 76px;
    vertical-align: middle;
    border-bottom: 1px solid #2c7f72;
  }
  .loginContent p{
    margin-top: 10px;
    display: flex;
    align-items:center;
    height: 60px;
    line-height: 60px;
    padding-left: 40px;
  }
  .loginContent p input{
    width: 245px;
    height: 40px;
    border-radius: 20px;
    border:1px solid #84b0ab;
    outline: none;
    padding-left:10px;
    margin-left: 10px;
    background-color: transparent;
    color: #fff;
  }
  .loginMean{
    display: flex;
    justify-content: space-between;
    padding-right:40px;
    color: #64c1ad;
  }
  .loginBtn{
    width: 325px;
    height:50px;
    color: #fff;
    font-weight: 600;
    font-size: 16px;
    background-color: #11c690;
    vertical-align: middle;
    text-align: center;
    margin-left: 28px;
    border-radius: 30px;
    border: none;
    outline: none;
  }
  /*.loginBtn:hover{
    background-color: olivedrab;
  }*/
</style>
