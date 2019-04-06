<template>
  <div class="sign" style="position: fixed; top:0px; left:0px;height:100%;width:100%; background-color: #1F2D3D; z-index:100">
    <!--个人用户忘记密码-->
    <div class="signBg">
      <div class="signHead">
        <h3>忘记密码</h3>
      </div>
      <div class="signContent">
        <div>
          <div>
            <label>手机号:</label>
            <input type="text" placeholder="请输入手机号" v-model="formData.phone">
            <button v-if="times" @click="timeClick" class="signBtn cd" id="btn"  type="button">获取手机验证码</button>
            <button v-else class="signBtn"  type="button">重新获取验证码({{time}}s)</button>
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
            <label>新密码:</label>
            <input type="password" placeholder="请输入密码" v-model="formData.password" onblur="checkpwd">
          </div>
        </div>
        <div>
          <div>
            <label>确认密码:</label>
            <input type="password" placeholder="请再次输入密码" v-model="formData.repassword">
          </div>
        </div>
      </div>
      <div class="signfooter">
        <input class="loginBtn" @click="signClick" type="button" value="登录">
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'sign',
    data () {
      return {
        time:5,
        times:true,
        formData:{
          username:'',/** 用户名 */
          password:'',/** 密码 */
         repassword:'',
          phone:'',/** 手机号 */
          code:''
        },
        alertContent:'您的公钥为XXXXXXXXXXXXXXXXXXXXXXXXXXXXX您的私钥可以在个人中心中导出',
      }
    },
    methods:{
      // 倒计时效果
      timeClick(){
        this.times = false;
        this.time = this.timers(this.time);
        this.$api.get("phone/getCode/"+this.formData.phone).then(res=>{
	        	if(res.status == 200){
	          	 console.log(res)
	          	  this.$message({
	                    type: 'success',
	                    message: res.body.msg
	             });
	              setTimeout(()=>{
	              	this.formData.code=res.body.code;
	              },5000)
	              
	          	}
	        },res=>{
	        	
	        });
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
      //密码验证
      checkpwd(){
      	
      },
      // 注册提交
      signClick(){
      	if(!this.formData.phone){
      		this.$message.error("手机号不能为空");
      	}else if(!this.formData.code){
      		this.$message.error("验证码不能为空");
      	}else if(!this.formData.password){
      		this.$message.error("新密码不能为空");
      	}else{
      		if(this.formData.password !== this.formData.repassword){
      		this.$message.error("请确认密码和新密码一致");
      	 }else{
      	 	 this.$api.post('home/register',this.formData).then(res=>{
          console.log(res.body)
          if(res.status == 200){
            this.$alert(this.alertContent, '注册成功', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: '已关闭'
                });
                this.$router.replace('/');
              }
            });
          }
        },res=>{
          console.log(res.status)
        });
      	 }
      	}
      	
       

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
