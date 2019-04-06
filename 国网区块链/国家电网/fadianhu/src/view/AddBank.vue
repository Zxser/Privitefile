<!--
	时间：2017-05-02
	描述：添加银行卡
-->
<template>
  <div class="addBank">
   <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
   <el-form-item label="开户行" prop="bank">
    <el-select v-model="ruleForm2.bank" placeholder="请选择银行" style="width: 300px;height: 40px">
              <el-option
                v-for="(item,index) in banklist"
                :label="item.label"
                :value="item.value"
                :key="item.index"
                >
              </el-option>
     </el-select>
   </el-form-item>
   <el-form-item label="银行卡号" prop="banknum">
	    <el-input type="text" v-model="ruleForm2.banknum"placeholder="请输入银行卡号"></el-input>
	  </el-form-item>
	  <el-form-item label="真实姓名" prop="trustname">
	    <el-input type="text" v-model="ruleForm2.trustname"placeholder="请输入真实姓名"></el-input>
	  </el-form-item>
	  <el-form-item label="证号号码" prop="cardnum">
	  	<el-select v-model="ruleForm2.cardtype"  style="width: 90px;height: 40px;">
              <el-option
                v-for="(item,index) in cardlist"
                :label="item.label"
                :value="item.value"
                :key="item.index"
                >
              </el-option>
     </el-select>
	    <el-input type="text" v-model="ruleForm2.cardnum" placeholder="请输入身份证号" style="width: 210px;height: 40px;"></el-input>
	  </el-form-item>
   	<el-form-item label="手机号" prop="tel">
	    <el-input type="text" v-model="ruleForm2.tel" placeholder="请输入手机号"></el-input>
	    <div style="position: absolute;right:-50%;top:0%"><el-button class="btn" type="button" @click="validate">获取手机验证码</el-button></div>
	  </el-form-item>
	  <el-form-item label="验证码" prop="code">
	    <el-input type="text" v-model="ruleForm2.code" placeholder="请输入验证码"></el-input>
	  </el-form-item>
	  <el-form-item style="display: flex;justify-content: flex-end">
	    <el-button class="btnSave active" type="button" @click="submitForm('ruleForm2')">保存</el-button>
	    <el-button class="btnRest" type="button" @click="resetForm('ruleForm2')">取消</el-button>
	  </el-form-item>
  </el-form>

  </div>
</template>

<script>
  export default {
    name: 'addBank',
    data () {
      return {
      	banklist:[{
      		value: '中国银行',
          label: '中国银行'
      	},
      	{
      		value: '中国建设银行',
          label: '中国建设银行'
      	},
      	{
      		value: '中国工商银行',
          label: '中国工商银行'
      	},
      	{
      		value: '中国农业银行',
          label: '中国农业银行'
      	},
      	{
      		value: '招商银行',
          label: '招商银行'
      	},
      	{
      		value: '广发银行',
          label: '广发银行'
      	},
      	{
      		value: '北京银行',
          label: '北京银行'
      	},
      	{
      		value: '晋商银行',
          label: '晋商银行'
      	},
      	{
      		value: '交通银行',
          label: '交通银行'
      	},
      	{
      		value: '民生银行',
          label: '民生银行'
      	}
        ],
        cardlist:[{
        	value: '身份证',
          label: '身份证'
        },{
        	value: '护照',
          label: '护照'
        },{
        	value: '军官证',
          label: '军官证'
        }
        ],
       ruleForm2: {
       	  bank:'',
       	  banknum:'',
       	  trustname:'',
          cardtype:'',
          cardnum:'',
          tel:'',
	        code:''
        },
        rules2:{
        	bank:[ { required: true, message: '请选择银行', trigger: 'change' }],
        	banknum:[  { required: true, message: '请输入银行卡号', trigger: 'blur' }],
        	trustname:[{ required: true, message: '请输入真实姓名', trigger: 'blur' }],
        	cardtype:[{ required: true, message: '请选择证件类型', trigger: 'change' }],
        	cardnum:[{ required: true, message: '请输入身份证号', trigger: 'blur' }],
        	tel:[{ required: true, message: '请输入手机号', trigger: 'blur' }],
        	code:[{ required: true, message: '请输入验证码', trigger: 'blur' }]
        },

      }
    },
    methods:{
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
	        submitForm(formName) {
		        this.$refs[formName].validate((valid) => {
		          if (valid) {
					    var data={
				        	"address":this.ruleForm2.bank,
				        	"bank_num":this.ruleForm2.banknum,
				        	"true_name":this.ruleForm2.trustname,
				        	"card_id":this.ruleForm2.cardnum,
				         	"phone":this.ruleForm2.tel,
				         	"sign":this.ruleForm2.code,
				         };
				        this.$api.post("userBank/save",data,(res)=>{
			          	if(res.status == 200){
			          	    if(res.body.status == 500){
                        this.$message({
                          showClose: true,
                          message: res.body.msg,
                          type: 'error'
                        });
                      }else{
                        this.$message({
                          type: 'success',
                          message: "保存成功！"
                        });
                        setTimeout(()=>{
                          this.$router.go(-1);
                        },1000);
                      }
			          	}
			      	  });
		          } else {
		            console.log('error submit!!');
		            return false;
		          }
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
  .addBank{
    margin-left: 118px;
    margin-top: 30px;
  }
  .addBank input{
    width: 300px;
    height: 30px;
    margin-left: 18px;
  }
  .addBank select{
    width: 300px;
    height: 30px;
    margin-left: 16px;
  }
  .form{
    line-height: 30px;
    margin-bottom: 20px;
    display: flex;justify-content: flex-start;
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
  .sj{
    margin-left: 18px;
  }
</style>
