<template>
  <div class="mathPwd">
  	 <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
   	  <!--<el-form-item label="手机号" prop="tel">
	    <el-input type="text" v-model="ruleForm2.tel" style="width: 300px;height: 40px;"></el-input>
	    <div style="position: absolute;right:-50%;top:0%"><el-button class="btn" type="button" @click="validate">获取手机验证码</el-button></div>
	  </el-form-item>
	  <el-form-item label="验证码" prop="code">
	    <el-input type="text" v-model="ruleForm2.code"></el-input>
	  </el-form-item>
	  <el-form-item label="身份证号" prop="cardid">
	    <el-input type="text" v-model="ruleForm2.cardid"></el-input>
	  </el-form-item>-->
	  <el-form-item label="原密码" prop="oldpassword">
	    <el-input type="password" v-model="ruleForm2.oldpassword" style="width: 300px;height: 40px;"></el-input>
	  </el-form-item>
	  <el-form-item label="新密码" prop="newpassword">
	    <el-input type="password" v-model="ruleForm2.newpassword" auto-complete="off"></el-input>
	  </el-form-item>
	  <el-form-item label="确认密码" prop="reNewpwd">
	    <el-input type="password" v-model="ruleForm2.reNewpwd" auto-complete="off"></el-input>
	  </el-form-item>
	  <el-form-item style="display: flex;justify-content: flex-end">
	    <el-button class="btnSave active" type="button" @click="submitForm('ruleForm2')">保存</el-button>
	    <el-button class="btnRest" type="button" @click="resetForm('ruleForm2')">取消</el-button>
	  </el-form-item>
  </el-form>
    <!--数字证书密码维护-->

  </div>
</template>

<script>
  export default {
    name: 'mathPwd',
    data () {
    	var checkTel=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('手机号不能为空'));
       }else{
        	 if (this.ruleForm2.tel !== '') {
        	 	var reg=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        	 	if(!reg.test(this.ruleForm2.tel)){
        	 	  return callback(new Error('请输入正确手机号'));
        	 	}
//          this.$refs.ruleForm2.validateField('tel');
          }
          callback();
        }
      }
      var checkCode=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('验证码不能为空'));
        }else{
        	 if (this.ruleForm2.code !== '') {
//          this.$refs.ruleForm2.validateField('code');
          }
          callback();
        }
      }
      var checkCardId=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('身份证号不能为空'));
       }else{
        	 if (this.ruleForm2.cardid !== '') {
        	 	var reg=/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
        	 	if(!reg.test(this.ruleForm2.cardid)){
        	 	  return callback(new Error('请输入正确身份证号'));
        	 	}
//          this.$refs.ruleForm2.validateField('cardid');
          }
          callback();
        }
      }

      var oldPass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入原密码'));
        } else {
          if (this.ruleForm2.oldpassword !== '') {
//          this.$refs.ruleForm2.validateField('oldpassword');
          }
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
          if (this.ruleForm2.newpassword !== '') {
//          this.$refs.ruleForm2.validateField('newpassword');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.newpassword) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
       return {
        ruleForm2: {
          tel:'',
	      code:'',
	      cardid:'',
	      oldpassword:'',
	      newpassword:'',
	      reNewpwd:''
        },
        rules2: {
          tel:[{validator: checkTel, trigger: 'blur'}],
          code:[{validator: checkCode, trigger: 'blur'}],
          cardid:[{validator: checkCardId, trigger: 'blur'}],
          oldpassword:[{ validator: oldPass, trigger: 'blur' }],
          newpassword: [
            { validator: validatePass, trigger: 'blur' }
          ],
          reNewpwd: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        }
      };

        },
        mounted(){
          this.$message({
            showClose: true,
            message: '提现密码和登录密码一致'
          });
        },
        methods:{
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
		        this.$api.post("userCenter/saveNewPayPwd",this.ruleForm2,(res)=>{
	          	if(res.status == 200){
                this.$message({
                  type: 'success',
                  message: '修改成功'
                });
                var formData = this.ruleForm2;
                for(var attr in formData){
                  formData[attr] = ''
                }
	          	}
	      	  });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
       validate(){
	        console.log(this.tel)
	        this.$api.get("phone/getCode/"+this.ruleForm2.tel).then(res=>{
	        	if(res.status == 200){
	          	 console.log(res)
	          	  this.$message({
	                    type: 'success',
	                    message: res.body.msg
	              });
	              this.ruleForm2.code=res.body.code;
	          	}
	        },res=>{

	        });
	        },

       }
    }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    padding:0;
    margin: 0;
    list-style: none;
  }
  .mathPwd{
    margin-left: 118px;
    margin-top: 30px;
  }
  .mathPwd input{
    width: 300px;
    height: 40px;
    margin-left: 18px;
  }
  .form{
    line-height: 30px;
    margin-bottom: 10px;
    display: flex;justify-content: space-between
  }
  .btn{
    padding: 5px;
    background-color: #079678;
    border: none;
    outline: none;
    border-radius: 6px;
    color: #fff;
    margin-left: 10px;
  }
  .btnSave,.btnRest{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
  }
  .btnRest{
  	 background-color: #CCC;
  }
  .active{
    background-color: #01595D;
    color: #fff;
  }
</style>
