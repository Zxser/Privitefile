<template>
  <div class="RePassword">
   <div class="R_box">	
   	<div class="in">
   		<span>手机号 </span><input type="text" placeholder="请输入手机号"/>
   		<button type="submit" class="code active">获取手机验证码</button>
   	</div>
   	<div class="in"><span>验证码 </span><input type="text" placeholder="请输入验证码"/></div>
   	<div class="in"><span>原密码 </span><input type="password" placeholder="请输入原密码"/></div>
   	<div class="in"><span>新密码</span><input type="password" placeholder="请输入新密码"/></div>
   	<div class="in"><span>确认密码 </span><input type="password" placeholder="确认密码"/></div>
   	<div class="btn">
   		<button class="btnSave active" type="button">保存</button>
      <button class="btnRest" type="button">取消</button>
   </div>
   </div>
   
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.RePassword{
	width: 800px;
	height: 530px;
	margin: 0 auto;
	text-align: left;
}
.R_box{
	width: 600px;
	height: 250px;
	margin:100px auto;
}
.in{
	margin-bottom:20px ;
}
span{
	display: inline-block;
	width: 100px;
	height: 35px;
}
input{
	display: inline-block;
	width: 300px;
	height: 35px;
	background:none; 
	outline:none; 
	border:1px solid #CCC;
/*	margin-left: 30px;*/
}
.btn{
	margin-top: 100px;
	margin-left: 220px;
}
.btnSave,.btnRest{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
    margin-right: 20px;
  }
 .code{
 	width: 110px;
  height: 30px;
 	border: none;
  outline: none;
  text-align: center;
  margin-left: 20px;
  border-radius: 10% 10%;
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