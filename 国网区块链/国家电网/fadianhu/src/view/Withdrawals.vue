<template>
  <div class="userBasic">
    <!--个人基本信息-->
      <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
      	<el-form-item label="银行卡" prop="">
			    <el-button class="dbtn" v-for="(item,index) in bankList" :key="item.index" @click="bank(index)">{{item.address}}</el-button>
      	  <span style="color: #079678"><button class="btn" type="button"><router-link to="/UserCenter/AddBank">增加银行账号</router-link></button></span>
	      </el-form-item>
	      <el-form-item  prop="">
        <span style="margin-left: 16px;">总积分</span> <span class="jifen"  v-model="totalIntegral">{{totalIntegral}}积分</span> <span style="margin-left: 30px;">可兑换积分</span> <span class="jifen" v-model="allowIntegral">{{allowIntegral}}积分</span> <span style="margin-left:30px;">不可兑换积分</span> <span class="jifen" v-model="banIntegral">{{banIntegral}}积分</span>
      	</el-form-item>
      	<el-form-item label="兑换积分" prop="integral">
			    <el-input type="text" v-model="ruleForm2.integral" style="width: 300px;height: 40px;"></el-input>
			    <div style="width: 717px">你好根据国家规定收购电价:0.4359元/千瓦时;国家补贴电价:0.42元/千瓦时;上海地方补贴:个人0.4元/千瓦时;企业0.25元/千瓦时。<span style="color: #079678">系统规定1度电=1积分=1元</span>。</div>
	      </el-form-item>
    	  <el-form-item label="手机号" prop="tel">
			    <el-input type="text" v-model="ruleForm2.tel" style="width: 300px;height: 40px;"></el-input>
			    <div style="position: absolute;left:45%;top:0%"><el-button class="btn" type="button" @click="validate">获取手机验证码</el-button></div>
	      </el-form-item>
			   <el-form-item label="验证码" prop="code">
			    <el-input type="text" v-model="ruleForm2.code" style="width: 300px;height: 40px;"></el-input>
			  </el-form-item>
			   <el-form-item style="float: right;margin-right: 30%;">
			   	<el-button class="btnSave active" type="button" @click="submitForm('ruleForm2')">保存</el-button>
	        <el-button class="btnRest" type="button" @click="resetForm('ruleForm2')">取消</el-button>
			   </el-form-item>
      </el-form>
  </div>
</template>

<script>
  export default {
    name: 'userBasic',

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
      };
      var checkCode=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('验证码不能为空'));
        }else{
        	 if (this.ruleForm2.code !== '') {
//          this.$refs.ruleForm2.validateField('code');
          }
          callback();
        }
      };
      var checkIntegral=(rule, value, callback)=>{
      	if (!value) {
          return callback(new Error('兑换积分不能为空'));
        }else{
        	 if (this.ruleForm2.integral !== '') {
            if(this.ruleForm2.integral > this.allowIntegral){
            	return callback(new Error('请输入可兑换的积分'));
            }
          }
          callback();
        }
      };

      return {
      	bankList:[],
      	totalIntegral:'',
      	allowIntegral:'',
      	banIntegral:'',
      	ruleForm2:{
      		integral:'',
      		tel:'',
      		code:''
      	},
         rules2: {
         	integral:[{validator: checkIntegral, trigger: 'blur'}],
          tel:[{validator: checkTel, trigger: 'blur'}],
          code:[{validator: checkCode, trigger: 'blur'}]
        }

      }

      },
      mounted(){
          this.showBanklist(),
          this.getIntegral()
        },
      methods:{
        	getIntegral(){
        		 this.$api.get("userBank/getIntegral").then(res=>{
	        	if(res.status == 200){
	              this.totalIntegral=res.body.total.total_integral;
	              this.allowIntegral=res.body.total.allow_integral;
	              this.banIntegral=res.body.total.ban_integral;
	          	}
	        },res=>{

	          });
        	},
        // 删除银行列表
        	bank(index){
        		var tapid=this.bankList[index].id,
        		    tapbank=this.bankList[index].address,
        		    tapcardid=this.bankList[index].card_id,
        		    taptrustname=this.bankList[index].true_name;
        		this.$router.push({path:'/UserCenter/DeleteBank',query:{id:tapid,bank:tapbank,cardid:tapcardid,trustname:taptrustname}});
        	},
        // 获取银行列表
        	showBanklist(){
        	 this.$api.get("userBank/getUserBankList").then(res=>{
	        	if(res.status == 200){
	              this.bankList=res.body.list;
	          	}
	        },res=>{

	        });
           },
           validate(){
	        this.$api.get("phone/getCode/"+this.ruleForm2.tel).then(res=>{
	        	if(res.status == 200){
	          	  this.$message({
	                    type: 'success',
	                    message: res.body.msg
	              });
	              this.ruleForm2.code=res.body.code;
	          	}
	        },res=>{

	        });
	        },
	         submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
	        this.$api.post("userBank/withdrawals",{"integral":this.ruleForm2.integral,"phone":this.ruleForm2.tel,"sign":this.ruleForm2.code},(res)=>{
          	if(res.status == 200){
              this.$message({
                type: 'success',
                message: "保存成功"
              });
          	}
            var formData = this.ruleForm2;
            for(var attr in formData){
              formData[attr] = ''
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
  a{
    text-decoration: none;
    color: #fff;
  }
  .userBasic{
    margin-left: 118px;
    margin-top: 30px;
  }
  .userBasic ul li input{
    width: 300px;
    height: 22px;
    margin-left: 18px;
  }
  .userBasic ul li{
    margin-top: 20px;
  }
 .bank{
    padding: 5px;
    border: 1px solid #ccc;
    margin-left: 10px;
  }
  .dbtn,.btn{
    padding: 5px;
    border: none;
    outline: none;
    border-radius: 6px;
    margin-left: 10px;
  }

  .dbtn{
  	width: 100px;
  	height: 30px;
  	background-color: #CCC;
  	color: #000;
  }
  .btn{
  	 background-color: #079678;
  	 color: #fff;
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
  .jifen{
    color: #079678;font-family: MicrosoftYaHei-Bold;font-size: 18px
  }
</style>
