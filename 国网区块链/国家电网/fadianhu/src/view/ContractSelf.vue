<template>
  <div class="contractSelf">
   <div class="cMe_content">
   	 <div class="cMe_title">
   	 	<div class="cleft">
   	 		<div class="left"></div>
   	 		<span class="l"></span>
   	 	</div>
   	 	<span class="title">智能合约</span>
   	 	<div class="cright">
   	 		<span class="r"></span>
   	 		<div class="right"></div>
   	 	</div>
   	 </div>
   	 <ul>
   	 	<li><p>012345678</p>合约编号</li>
   	 	<li><p>余量上网</p>结算原则</li>
   	 	<li><p>2,542KWH</p>装机容量</li>
   	 	<li><p>2016-02-25</p>签约日</li>
   	 	<li><p>2020-02-25</p>到期日</li>
   	 </ul>
   </div>
   
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.contractSelf{
	height: 425px;
	width: 100%;
	text-align: center;
	background-color: #F3F9F9;
}
.cMe_content{
	width: 1200px;
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
	width:500px;
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
	font-size: 25px;
	margin:0 40px;
}
ul{
	margin-top:104px;
}
li{
	list-style: none;
	display: inline-block;
	width: 130px;
	height: 135px;
	border-radius: 50%;
	border: 5px solid #C3DCDD;
	background-color:#19A584;
	margin-right: 95px;
	color: #FFF;
	text-align: center;
	font-size: 16px;
}
p{
 padding:45px 0 15px;
 font-size: 17px;
 font-weight: bold;
}
</style>