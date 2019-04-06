<template>
    <div class="loginPwd">
   <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
	  <el-form-item label="原密码" prop="oldpwd">
	    <el-input type="password" style="width: 300px;height: 40px;" v-model="ruleForm2.oldpwd"></el-input>
	  </el-form-item>
	  <el-form-item label="新密码" prop="newpwd">
	    <el-input type="password" v-model="ruleForm2.newpwd" auto-complete="off"></el-input>
	  </el-form-item>
	  <el-form-item label="确认密码" prop="reNewpwd">
	    <el-input type="password" v-model="ruleForm2.reNewpwd" auto-complete="off"></el-input>
	  </el-form-item>
	  <el-form-item style="display: flex;justify-content: flex-end">
	    <el-button class="btnSave active" type="button" @click="submitForm('ruleForm2')">保存</el-button>
	    <el-button class="btnRest" type="button" @click="resetForm('ruleForm2')">取消</el-button>
	  </el-form-item>
  </el-form>

        <!--登录密码维护-->

    </div>
</template>

<script>
    export default {
        name: 'loginPwd',
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
          }
          callback();
        }
      }
      var checkCode=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('验证码不能为空'));
       }else{
          callback();
        }
      }
      var oldPass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入原密码'));
        } else {
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.newpwd) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm2: {
          tel:'',
	      code:'',
	      oldpwd:'',
	      newpwd:'',
	      reNewpwd:''
        },
        rules2: {
          tel:[{validator: checkTel, trigger: 'blur'}],
          code:[{validator: checkCode, trigger: 'blur'}],
          oldpwd:[{ validator: oldPass, trigger: 'blur' }],
          newpwd: [
            { validator: validatePass, trigger: 'blur' }
          ],
          reNewpwd: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        }
      };

        },
        methods:{
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$api.post("SysUserManage/saveNewpwd",{"oldpassword":this.ruleForm2.oldpwd,"password":this.ruleForm2.newpwd,"phone":this.ruleForm2.tel,"sign":this.ruleForm2.code},(res)=>{
              console.log(res.body)
            if(res.body.status == 500){
              this.$notify.error({
                title: '错误',
                message: res.body.msg
              });
              let forms = this.ruleForm2;
              for(var attr in forms){
                forms[attr] = ''
              }
            }

              if(res.body.status == 200){
                if(res.body.status == 200){
                  this.$notify.success({
                    title: '成功',
                    message: res.body.msg
                  });
                  let forms = this.ruleForm2;
                  for(var attr in forms){
                    forms[attr] = ''
                  }
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
  .loginPwd{
    margin-left: 118px;
    margin-top: 40px;
  }
  .loginPwd input{
    width: 300px;
    height: 40px;
    margin-left: 18px;
  }
  .form{
    line-height: 30px;
    margin-bottom: 20px;
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
