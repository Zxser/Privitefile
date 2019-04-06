<template>
  <div class="UserList">
   <div class="u_box">
   	<div class="tab">
   		<ul>
   			<li ><a href="javascript:;" @click="changeTab('0')">发电户</a></li>
   			<li><a href="javascript:;" @click="changeTab('1')">国网用户</a></li>
   			<li><a href="javascript:;" @click="changeTab('2')">系统管理员</a></li>
   		</ul>
   	</div>
   	<div class="tabCont">
   		<div id="cont0" class="cont0">
        <table border="" cellspacing="0" cellpadding="0">
        	<thead>
        		<tr>
        			<th>姓名</th>
        			<th>用户名</th>
        			<th>手机号</th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>张三</td>
        			<td>张三</td>
        			<td>18977387123</td>
        		</tr>
        		<tr>
        			<td>李四</td>
        			<td>李四</td>
        			<td>18977387123</td>
        		</tr>
        	</tbody>
        </table>
   		</div>
   		<div id="cont1" class="cont1">
        <table border="" cellspacing="0" cellpadding="0">
        	<thead>
        		<tr>
        			<th>姓名</th>
        			<th>用户名</th>
        			<th>手机号</th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>张三</td>
        			<td>张三</td>
        			<td>18977387123</td>
        		</tr>
        		<tr>
        			<td>李四</td>
        			<td>李四</td>
        			<td>18977387123</td>
        		</tr>
        		<tr>
        			<td>王五</td>
        			<td>王五</td>
        			<td>18977387123</td>
        		</tr>
        	</tbody>
        </table>
   		</div>
   		<div id="cont2" class="cont2">
        <table border="" cellspacing="0" cellpadding="0">
        	<thead>
        		<tr>
        			<th>姓名</th>
        			<th>用户名</th>
        			<th>手机号</th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>张三</td>
        			<td>管理员1</td>
        			<td>18977387123</td>
        		</tr>
        		<tr>
        			<td>李四</td>
        			<td>管理员2</td>
        			<td>18977387123</td>
        		</tr>
        	</tbody>
        </table>
   		</div>
   	</div>
   </div> 
  </div>
</template>

<script>
export default{
	name:'',
	methods:{
	changeTab(tabCon_num){
  for(var i=0;i<3;i++) { 
   document.getElementById("cont"+i).style.display="none"; //将所有的层都隐藏 
   } 
   document.getElementById("cont"+tabCon_num).style.display="block";//显示当前层 
  } 

	}
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.UserList{
	width: 800px;
	height: 530px;
	margin: 0 auto;
	text-align: center;
	border: 1px solid #CCC;
}
.u_box{
	margin-top:55px;
	margin-left: 20px;
}
ul{
	overflow: hidden;
}
li{
	float: left;
	list-style: none;
}
a{
	text-decoration: none;
	font-size: 16px;
	font-weight: bold;
	color: #068964;
	display: inline-block;
	width:200px ;
	height:40px ;
	line-height: 40px;
	text-align: center;
	border: 1px solid #CCC;
}
a:hover{
	background-color: #068964;
	border: 1px solid #068964;
	color: #FFF;
}
.tabCont{
	margin-top: 30px;
	clear: both;
}
#cont1,#cont2{
	display: none;
}
 table {
    border: 1px solid #ccc;
    text-align: center;
    font-size: 12px;
  }
  thead{
  	 background-color: #F4F4F4;
  }
  table td, table th {
    border: 1px solid #ccc;
    height: 30px;
    width: 260px;
  }
</style>