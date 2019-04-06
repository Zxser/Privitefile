<template>
    <div class="sign" style="position: fixed; top:0px; left:0px;height:100%;width:100%; background-color: #1F2D3D; z-index:100">
      <div class="signBg">
        <div class="signHead">
          <h3>手机注册</h3>
        </div>
        <div class="signContent">
          <div>
            <div style="margin-top: 10px;">
              <label>用户名:</label>
              <input type="text" placeholder="请输入用户名" v-model="formData.username">
            </div>
          </div>
          <div>
            <div>
              <label>手机号:</label>
              <input type="text"
                     placeholder="请输入手机号"
                     v-model="formData.phone"
                     @blur="checkPhone"
                >
              <button v-if="times" @click="timeClick" class="signBtn cd" id="btn"  type="button">获取手机验证码</button>
              <button v-else class="signBtn"  type="button"  v-model="time">重新获取验证码({{time}}s)</button>
            </div>
          </div>
          <div>
            <div>
              <label>验证码:</label>
              <input type="text" placeholder="请输入验证码" v-model="formData.code">
            </div>
          </div>
          <div>
            <div>
              <label>密码:</label>
              <input type="password" placeholder="请输入密码" v-model="formData.password">
            </div>
          </div>
          <div>
            <div>
              <label>确认密码:</label>
              <input type="password" placeholder="请再次输入密码"v-model="formData.repassword" @keyup.enter="signClick">
            </div>
          </div>
        </div>
        <div class="signfooter">
          <input class="loginBtn" v-if="isShowSign" @click="signClick" type="button" value="注册">
        </div>
      </div>
    </div>
</template>

<script>

  export default {
    name: 'sign',
    data () {
        return {
            time:6,
            times:true,
            formData:{
              username:'',/** 用户名 */
              password:'',/** 密码 */
              repassword:'',
              phone:'',/** 手机号 */
             code:''
            },
            isShowSign:true,
            alertContent:'您的公钥为XXXXXXXXXXXXXXXXXXXXXXXXXXXXX您的私钥可以在个人中心中导出',
        }
    },
    methods:{
      // 倒计时效果
      timeClick(){
        this.times = false;
        this.time = this.timers(this.time);
       
      },
      timers(timer){
         let  that = this;
        if(timer === 0){
          this.times = true;
        }else{
          this.time = timer;
          timer--;
          setTimeout(function() {
            that.timers(timer)
            },1000)
        }
      },
      // 注册提交
      signClick(){
      	if(!this.formData.username){
      		this.$message.error("请输入用户名");
      	}else if(!this.formData.phone){
      		this.$message.error("请输入手机号");
      	}else if(!this.formData.code){
      		this.$message.error("请输入验证码");
      	}else if(!this.formData.password){
      		this.$message.error("请输入密码");
      	}else if(!this.formData.repassword){
      		this.$message.error("请输入确认密码");
      	}else if(this.formData.repassword!==this.formData.password){
      		this.$message.error("请输入确认密码与密码一致");
      	}else{
      		this.$api.post('home/register',this.formData,(res)=>{
            if(res.status == 200){
          this.$alert(this.alertContent, '注册成功', {
              confirmButtonText: '确定',
              callback: action => {
              this.$message({
              type: 'info',
              message: '已关闭'
            });
          // 登录成功之后保存一个变量，显示菜单
          // 成功之后返回一个标识，是个人还是国网
          this.$router.replace({path:'/Header/HomeIndex',query:{isShowMeau:1}});
          // 登录成功之后，保存tock
          sessionStorage.setItem('accessToken', res.body.token);
          sessionStorage.setItem('personal', res.body.type);
//                  sessionStorage.setItem('isShowMeau', true);
          sessionStorage.setItem('nickname', res.body.nickname);
        }
        });
        }
         });
      	}
          
          

      },

      // 手机号唯一性验证
      checkPhone(){
        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(!this.formData.phone){
        	his.$message.error('请输入手机号码！');
        }else if(!myreg.test(this.formData.phone))
        {
          this.$message.error('请输入有效的手机号码！');
          return false;
        }
          this.$api.post('sysUser/checkPhone',{phone:this.formData.phone},(res)=>{
            if(res.status == 200){
              if(res.body.status == 0){
                this.isShowSign = true;
                this.$message.success('恭喜你，这是一条成功消息');
              }else{
                this.$message.error(res.body.msg);
                this.isShowSign = false;
                return false
              }
            }
          },res=>{
              alert(123)
        })
      },


    }

  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    border: none;
    outline: none;
  }
  .sign{
    width: 1366px;
    height:767px;
    background:url('../assets/images/login-bg.png')  no-repeat;
    color: #fff;
    font-family:'MicrosoftYaHeiBold', 'Microsoft YaHei Bold', 'Microsoft YaHei';
  }
  .signBg{
    width: 402px;
    height: 475px;
    background-color: #0d645b;
    border-radius: 15px;
    position: relative;
    top:15%;
    left:35%;
  }
  .signHead{
    text-align: center;
    width: 402px;
    height:76px;
    line-height: 76px;
    vertical-align: middle;
    border-bottom: 1px solid #2c7f72;
  }
  .signContent{
  }
  .signContent div{
    width: 402px;
    height:60px;
    line-height: 40px;
    padding-left: 20px;
  }
  .signContent div label{
  }
  .signContent div input{
    width: 258px;
    height: 40px;
    background-color: transparent;
    font-family: 'ArialMT', 'Arial';
    font-weight: 400;
    font-style: normal;
    font-size: 13px;
    text-decoration: none;
    color: #FFFFFF;
    text-align: left;
    border-color: transparent;
    border-bottom: 1px solid #ccc;
    margin-left: 10px;
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
  }
  /*.loginBtn:hover{
    background-color: olivedrab;
  }*/
  .signBtn{
    padding: 5px;
    position: absolute;
    top: 30%;
    right: 8%;
    text-rendering: optimizeLegibility;
    background-color: #328175;
    color: #fff;
  }
</style>
