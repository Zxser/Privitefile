<template>
  <div class="AuthorityManage">
   <div class="a_box">
   	<div class="in">
   		<span>选择用户 </span>
   		<select name="" id="">
          <option value="">张三</option>
          <option value="">李思</option>
          <option value="">王五</option>
          <option value="">李静</option>
          <option value="">梁行</option>
          <option value="">吕锋</option>
          <option value="">白晶晶</option>
       </select>
   	</div>
   	<div class="in">
   		<span>查看范围</span>
   	   <input type="radio" name="area" checked />全国
   	   <input type="radio" name="area"  />省市区
   	</div>
   	<div class="btn">
   		<button class="btnSave active" type="button">确定</button>
      <button class="btnRest" type="button">取消</button>
   </div>
   </div>
   
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.AuthorityManage{
	width: 800px;
	height: 530px;
	margin: 0 auto;
	text-align: left;
	/*border: 1px solid #CCC;*/
}
.a_box{
	/*width: 400px;
	height: 250px;*/
	margin:100px 50px;
	
}
.in{
	margin-bottom:20px ;
}
select{
	display: inline-block;
	width: 200px;
	height: 25px;
	background:none; 
	outline:none; 
	border:1px solid #CCC;
	margin-left: 30px;
}
.in input{
	margin-left: 25px;
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
</style>