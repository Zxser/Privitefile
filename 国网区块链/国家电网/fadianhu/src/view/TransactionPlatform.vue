<template>
  <div class="platform">
   <div class="p_content">
	   <p>上海电力光伏发电区块链交易平台</p>
	   <div class="p_box">
		   <div class="contract">
		   	<img src="../assets/images/Intelligent-contract-green.png" alt="" />
		   	<h4>合约模板</h4>
		   	<span>光电发电智能合约条款</span>
		   </div>
		   <div class="integral">
		   	<img src="../assets/images/Integral-rule-green.png" alt="" />
		   	<h4>积分规则</h4>
		   	<span>光电发电积分累计规则</span>
		   </div>
		   <div class="question">
		   	<img src="../assets/images/common-problem-green.png" alt="" />
		   	<h4>常见问题</h4>
		   	<span>光伏发电交易常见问题解答</span>
		   </div>
		  </div>
	  </div>
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.platform{
	width: 100%;
	height: 635%;
}
.p_content{
	width: 1200px;
	margin: 0 auto;
	position: relative;
	text-align: center;
}
p{
	font-size: 30px;
	margin-top:90px ;
	/*padding: 90px auto;*/
}
.contract{
	position: absolute;
	left:20px;
	top:120px;
}
.integral{
	position: absolute;
	left:390px;
	top:120px;
}
.question{
	position: absolute;
	left:760px;
	top:120px;
}
h4{
	font-size: 20px;
}
span{
	color:#848484;
}
</style>