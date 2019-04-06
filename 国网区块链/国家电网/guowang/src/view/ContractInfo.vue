
<template>
  <div class="ContractInfo">
   <div class="c_content">
   	<div class="cMe_title">
   	 	<div class="cleft">
   	 		<div class="left"></div>
   	 		<span class="l"></span>
   	 	</div>
   	 	<span class="title">合约情况</span>
   	 	<div class="cright">
   	 		<span class="r"></span>
   	 		<div class="right"></div>
   	 	</div>
   	 </div>
   	<div class="area">
   		<span class="region">区域</span>
   		<ul>
   			<li><a href="">黄浦区</a></li>
   			<li><a href="">宝山区</a></li>
   			<li><a href="">许汇区</a></li>
   			<li><a href="">长宁区</a></li>
   		</ul><br />
   		<span class="region">用户类型</span>
   		<ul>
   			<li><a href="">个人</a></li>
   			<li><a href="">企业</a></li>
   		</ul><br />
   		<span class="region">业务类型</span>
   		<ul>
   			<li><a href="">全额上网</a></li>
   			<li><a href="">余量上网</a></li>
   		</ul><br />
   	</div>
   	<div class="tableContent">
   	<table border="1" cellspacing="0" cellpadding="0">
   		<thead>
   		<tr>
   			<th>用户名称</th>
   			<th>区域</th>
   			<th>用户类型</th>
   			<th>业务类型</th>
   			<th>合约名称</th>
   			<th>合约状态</th>
   		</tr>
   		</thead>
   		<tr>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   		</tr>
   	</table>
   </div>
   </div>
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.ContractInfo{
	height: 30%;
	width: 100%;
	text-align: left;
}
.c_content{
	width: 1000px;
	margin: 0 auto;
}
.cMe_title{
	height:25px;
}
.cleft,.cright{
	display: inline-block;
}
.left,.right{
	display: inline-block;
	width:400px;
	height: 2px;
}
.left{
	float:left ;
	background-image:linear-gradient(to right,#FFF,#0BB07E);
}
.right{
	float:right ;
	background-image:linear-gradient(to left,#FFF,#0BB07E);
}
.l,.r{
	width: 4px;
	height:4px;
  border-radius: 50%;
  background-color:#0BB07E ;
  margin-top: -1px;
}
.l{
	float:right ;
}
.r{
	float:left ;
}
.title{
	font-size: 20px;
	font-weight: bold;
	margin:0 40px;
}
.area{
	margin-top: 40px;
}
.region{
	display: inline-block;
	float:left;
	width: 80px;
	height: 20px;
	font-size: 14px;
	letter-spacing: 5px;
  padding-top: 30px;
}
 ul,li,a{
  padding: 0;
  margin: 0;
 }
ul{
	display: inline-block;
	list-style: none;
	margin-left: 60px;
	/*margin-bottom: 60px;*/
}
li{
	/*display: inline-block;*/
	float: left;
	border: 1px solid #CCCCCC;
	text-align: center;
	margin-right: 20px;
	margin-top:20px;
}
a{
	display: inline-block;
	width: 100px;
	height: 30px;
	line-height: 30px;
	text-decoration: none;
	font-size: 12px;
	font-weight: normal;
	color:black;
}
a:hover{
	background-color: #52A179;
	color: #FFF;
}
table {
    border: 1px solid #ccc;
    text-align: center;
    font-size: 12px;
  }
  thead{
  	 background-color: #F4F4F4;
  }
  table td,th {
    border: 1px solid #ccc;
    height: 30px;
    width: 190px;
  }
  .tableContent{
  	margin-top: 60px;
    display: flex;
    justify-content: center;
    align-content: center;
  }

</style>
