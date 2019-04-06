<template>
  <div class="CreateUser">
   <div class="c_box">
   	<div class="in"><span>用户名 </span><input type="text" placeholder="请输入用户名"/></div>
   	<div class="in"><span>姓&nbsp;&nbsp;&nbsp;名 </span><input type="text" placeholder="请输入姓名"/></div>
   	<div class="in"><span>手机号 </span><input type="text" placeholder="请输入手机号"/></div>
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