<template>
  <div class="contactMe">
  	<div class="c_content">
  	 <h1>联系我们</h1>
  	 <div class="tel">
  	 	<img src="../assets/images/phone.png"/>
  	 </div>
  	 <div class="contactType">
  	 	<p>客服电话：010-56072926</p>
  	 	<p>项目咨询：yangtao@sgcc.com.cn</p>
  	 	<p>媒体合作：lu.lihua@sgcc.com.cn</p>
  	 	<p>人才招聘：ni.bo@sgcc.com.cn</p>
  	 </div>
  	 <div class="qrCode">
  	 	<img src="../assets/images/qr_code.png"/>
  	 	<span>扫一扫更多惊喜</span>
  	 </div>
  	</div>
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.contactMe{
	height: 206px;
	width: 100%;
  margin-bottom: 77px;
}
.c_content{
	width: 1000px;
	margin: 0 auto;
}
h1{
	font-weight: normal;
	margin-top: 60px;
	margin-bottom: 60px;
  text-align: center;
}
.tel{
	float: left;
	margin-right: 40px;
}
.contactType{
	float: left;
	font-size: 20px;
	text-align: left;
	margin-top:-5px;
}
p{
	padding: 5px 0;
	margin:0;
}
.qrCode{
	width: 378px;
	height: 140px;
	float:right;
	vertical-align:middle;
	/*position:relative;*/
}
span{
	font-size: 20px;
	/*position: absolute;
	top:0;
	right:0;*/
}
</style>
