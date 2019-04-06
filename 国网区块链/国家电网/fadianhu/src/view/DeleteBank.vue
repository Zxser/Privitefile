<template>
    <div class="deleteBank">
   <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
   	  <el-form-item label="开户行" prop="bankid">
	    <el-input type="text" v-model="ruleForm2.bankid"placeholder="请输入开户行"></el-input>
	  </el-form-item>
	  <el-form-item label="银行卡号" prop="banknum">
	    <el-input type="text" v-model="ruleForm2.banknum"placeholder="请输入银行卡号"></el-input>
	  </el-form-item>
	  <el-form-item label="真实姓名" prop="trustname">
	    <el-input type="text" v-model="ruleForm2.trustname"placeholder="请输入真实姓名"></el-input>
	  </el-form-item>
   	  <el-form-item label="手机号" prop="tel">
	    <el-input type="text" v-model="ruleForm2.tel" placeholder="请输入手机号" style="width: 300px;height: 40px;"></el-input>
	    <div style="position: absolute;right:-50%;top:0%"><el-button class="btn" type="button" @click="validate">获取手机验证码</el-button></div>
	  </el-form-item>
	  <el-form-item label="验证码" prop="code">
	    <el-input type="text" v-model="ruleForm2.code" placeholder="请输入验证码"></el-input>
	  </el-form-item>
	  
	  <el-form-item style="display: flex;justify-content: flex-end">  
	    <el-button class="btnSave active" type="button" @click="submitForm('ruleForm2')">删除</el-button>
	    <el-button class="btnRest" type="button" @click="backInfo">返回</el-button>
	  </el-form-item>	
  </el-form>
    	
 
    </div>
</template>

<script>
    export default {
        name: 'deleteBank',
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
      };
      var checkCode=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('验证码不能为空'));
       }else{
          callback();
        }
      };
   
      return {
        ruleForm2: {
          id:'',
          bankid:'',
          banknum:'',
          trustname:'',
          tel:'',
	      code:''
        },
        rules2: {
          bankid:[  { required: true, message: '请输入开户行', trigger: 'blur' }],
          banknum:[  { required: true, message: '请输入银行卡号', trigger: 'blur' }],
          trustname:[{ required: true, message: '请输入真实姓名', trigger: 'blur' }],
          tel:[{ required: true, message: '请输入手机号', trigger: 'blur' }],
//        tel:[{validator: checkTel, trigger: 'blur'}],
          code:[{validator: checkCode, trigger: 'blur'}]
        }
      };
        	
       },
       mounted(){
         this.ruleForm2.id = this.$route.query.id,
         this.ruleForm2.bankid = this.$route.query.bank,
         this.ruleForm2.banknum = this.$route.query.cardid,
         this.ruleForm2.trustname = this.$route.query.trustname
       },
        methods:{ 
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm2.id)
	        this.$api.get("userBank/delete/"+this.ruleForm2.id).then(res=>{
	        	if(res.status == 200){
	          	 console.log(res)
	          	 if(res.body.msg=="success"){
	          	 	this.$message({
	                    type: 'success',
	                    message:'删除成功！'
	               });
	               setTimeout(()=>{
	               	this.$router.go(-1);
	               },1000);
	               
	          	 }
	          	  
	          	}
	        },res=>{
	        	
	        });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      backInfo(){
      	setTimeout(()=>{
	               	this.$router.go(-1);
	         },1000);
      },
      resetForm(formName) {
//      this.$refs[formName].resetFields();
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
  .deleteBank{
    margin-left: 118px;
    margin-top: 40px;
  }
  .deleteBank input{
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
