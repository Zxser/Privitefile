<template>
  <div class="CreateUser">
   <div class="c_box">

  <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
  	 <!-- <el-form-item label="创建用户" prop="ismanager" style="text-align: left;">
			<el-radio class="radio" v-model="ruleForm2.ismanager" label="1">管理员</el-radio>
			<el-radio class="radio" v-model="ruleForm2.ismanager" label="0" style="margin-left: 60px;">国网用户</el-radio>
     </el-form-item>-->
	  <el-form-item label="用户名" prop="username" >
	    <el-input type="text" v-model="ruleForm2.username"></el-input>
	  </el-form-item>
	  <!--<el-form-item label="姓名" prop="trustname" v-if="isShowArea">-->
	    <!--<el-input type="text" v-model="ruleForm2.trustname"></el-input>-->
	  <!--</el-form-item>-->
	   <el-form-item label="区域" prop="area" v-if="isShowArea">
    <el-select v-model="ruleForm2.area" placeholder="请选择区域" style="width: 300px;height: 40px">
              <el-option
                v-for="(item,index) in arealist"
                :label="item.name"
                :value="item.id"
                :key="item.index"
                >
              </el-option>
     </el-select>
   </el-form-item>
	  <!--<el-form-item label="手机号" prop="tel" v-if="isShowArea">
	    <el-input type="text" @blur="checkPhone" v-model.number="ruleForm2.tel"></el-input>
	  </el-form-item>-->

	  <el-form-item  style="display: flex;justify-content: flex-end">
	    <el-button class="btnSave active"  @click="submitForm('ruleForm2')">保存</el-button>
	    <el-button class="btnRest" @click="resetForm('ruleForm2')">取消</el-button>
	  </el-form-item>
  </el-form>
   </div>

  </div>
</template>

<script>
 export default{
 	name:'CreateUser',
 	data(){
 		return{
      isShowSign:false,
      isShowArea:true,// 区域是否显示
 			arealist:[],
 			ruleForm2: {
          username:'',
       	  trustname:'',
          area:'',
          tel:'',
          ismanager:'0'
        },
        rules2:{
        	ismanager:[{ required: true, message: '请选择管理员是否', trigger: 'change' }],
        	username:[ { required: true, message: '请输入用户名', trigger: 'blur' }],
        	trustname:[{ required: true, message: '请输入真实姓名', trigger: 'blur' }],
//      	area:[{ required: true, message: '请选择区域', trigger: 'change' }],
//      	area:[{validator: checkArea, trigger: 'change'}],
      	  tel:[{type:'number', required: true, message: '请输入手机号', trigger: 'blur' }]

        },
 		}
 	},
 	mounted(){
          this.showArealist()
        },
 	methods:{
    /*// 验证用户名唯一性
    checkUserName(){
      this.$api.post('sysUser/checkUserName',{username:this.ruleForm2.username},(res)=>{
        if(res.status == 200){
          if(res.body.status == 0){
            return true
          }else{
            this.$message.error(res.body.msg);
            return false
          }
        }
      },res=>{
        alert(123)
      })
    },*/
    // 验证手机号唯一性
    checkPhone(){
       var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
      if(!this.ruleForm2.tel){
        this.$message.error('请输入手机号码！');
      }else if(!myreg.test(this.ruleForm2.tel))
      {
        this.$message.error('请输入有效的手机号码！');
        return false;
      }
      /*this.$api.post('sysUser/checkPhone',{phone:this.ruleForm2.tel},(res)=>{
        if(res.status == 200){
          if(res.body.status == 0){
            return true
          }else{
            this.$message.error(res.body.msg);
            return false
          }
        }
      },res=>{
      })*/
    },
 		showArealist(){
 			 this.$api.get("Area/getList/310100").then(res=>{
	        	if(res.status == 200){
	          	  this.arealist=res.body.list;
	          	}
	        },res=>{
	        	alert(error)
	          });
 		},
 		getAreaid(index){
 			this.ruleForm2.areaid=this.arealist[index].id;
 			console.log(this.ruleForm2.areaid);
 		},
 		submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.checkPhone();
          	var data={
          		"type":this.ruleForm2.ismanager,
          		"username":this.ruleForm2.username,
          		"phone":this.ruleForm2.tel,
          		"area_id":this.ruleForm2.area
          	};
            this.$api.post("SysUserManage/saveUser",data,(res)=>{
              if(res.status == 200){
                if(res.body.status == 500){
                  this.$message.error(res.body.msg);
                  return false;
                }
                if(res.body.msg=='success'){
                   this.$message({
                        type: 'success',
                        message: "保存成功"
                  });
                }

              }
             },function(){
              return false;
            });
          }else{
            return false;
          }
        });
         },
    resetForm(formName) {
        this.$refs[formName].resetFields();
 		},
 	},
  watch:{
    'ruleForm2.ismanager':function(newValue,oldValue){
      //console.log(newValue,oldValue)
      if(newValue == 1){
        this.isShowArea = false;
      }else{
        this.isShowArea = true;
      }
    }
  }
 }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.CreateUser{
	width: 800px;
	height: 530px;
	margin: 0 auto;
	text-align: center;
}
.c_box{
	width: 400px;
	height: 250px;
	margin:100px auto;
}
.in{
	margin-bottom:20px ;
}
input{
	display: inline-block;
	width: 300px;
	height: 35px;
	background:none;
	outline:none;
	border:1px solid #CCC;
	margin-left: 30px;
}
.btn{
	margin-top: 100px;
	text-align: right;
}
.btnSave,.btnRest{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
    margin-right: 20px;
  }
  .btnRest{
  	 background-color: #CCC;
  }
  .active{
    background-color: #01595D;
    color: #fff;
  }
  ::-webkit-input-placeholder { /* WebKit browsers */
    color:    #A9A9A9;
}
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   color:    #A9A9A9;
   opacity:  1;
}
::-moz-placeholder { /* Mozilla Firefox 19+ */
   color:    #A9A9A9;
   opacity:  1;
}
:-ms-input-placeholder { /* Internet Explorer 10+ */
   color:    #A9A9A9;
}
</style>
