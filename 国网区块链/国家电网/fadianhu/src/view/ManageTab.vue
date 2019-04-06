<template>
  <div class="ManageTab">
   <div class="s_content">
   	<div class="box">
   	<div class="tab">
   		<ul>
   			<li><a href="">创建用户</a></li>
   			<li><a href="">用户列表</a></li>
   			<li><a href="">权限管理</a></li>
   			<li><a href="">修改管理员密码</a></li>
   		</ul>
   	</div>
   	</div>
   </div>
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.ManageTab{
	width: 100%;
	height: 530px;
}
.s_content{
	width: 1000px;
	margin: 0 auto;
}
ul,li{
	list-style: none;
}
a{
	text-decoration: none;
	font-size: 14px;
	color: black;
	display: inline-block;
	width:200px ;
	height:40px ;
	line-height: 40px;
	text-align: center;
	border-bottom: 1px solid #CCC;
}
a:hover{
	color: #8dbd9a;
}
.box{
	width: 100%;
	height: 480px;
	border: 1px solid #CCC;
	margin: 30px 0;
}
.tab{
	width: 200px;
	height: 100%;
	border-right: 1px solid #CCC;
}
</style>