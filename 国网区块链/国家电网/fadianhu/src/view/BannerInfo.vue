<template>
  <div class="bannerInfo">
   <div class="i_content">
   	<div class="mypic"></div>
   	<div class="info">
   		<p>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<span>{{sysUser.username}}</span></p>
   		<p>装机容量：<span>2342</span></p>
   		<div class="key">
   			<img src="../assets/images/gongyue.png"/><span class="keyNum">23046736583438291732012343546457657681</span>
   			<p class="more">点击显示更多</p>
   		</div>
   	</div>
   	<div class="i_icon">
	    <div class="sumUser">
       <img src="../assets/images/fadianliang.png"/>
		   <p>发电量：<span class="user">{{userTotal.total_electricity}}</span></p>
		  </div>
		  <div class="sumNumber">
		  	 <img src="../assets/images/zongjifen.png"/>
		     <p>总积分：<span class="user">{{userTotal.total_integral}}</span></p>
		  </div>
		  <div class="sumElec">
		  	 <img src="../assets/images/guodianliang.png"/>
		     <p>购电量：<span class="user">{{userTotal.total_traffic}}</span></p>
		  </div>
		  <p class="warn">当日数据为预测值</p>
		 </div>
		 </div>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data () {
      return {
          // 用户基本信息
          sysUser:{},
        //获取总积分-总用户量-总发电量
          userTotal:{
            total_electricity:'',
            total_integral:'',
            total_traffic:'',
          }
      }
    },
    mounted(){
            this.getUserInfo();
            this.getUserTotal();
    },
    methods:{
        // 获取用户基本信息
        getUserInfo(){
            this.$api.get('userCenter/getUserInfo').then(res=>{
              this.sysUser = res.body.user;
            },res=>{

            });
        },
      //获取总积分-总用户量-总发电量
      getUserTotal(){
        this.$api.get('UserTotal/getUserTotal').then(res=>{
          this.userTotal = res.body.userTotal
        },res=>{

        });
      },
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.bannerInfo{
	height: 210px;
	width: 100%;
  background: -webkit-linear-gradient(#09ab7b 0px,#026a6f 637px); /* Safari 5.1 - 6.0 */
  background: -o-linear-gradient(#09ab7b 0px,#026a6f 637px); /* Opera 11.1 - 12.0 */
  background: -moz-linear-gradient(#09ab7b 0px,#026a6f 637px); /* Firefox 3.6 - 15 */
  background: linear-gradient(#09ab7b 0px,#026a6f 637px); /* 标准的语法（必须放在最后） */
}
.i_content{
	width: 1200px;
  margin-left: 10%;
	color: #FFF;
	position: relative;
}
.mypic{
	width: 60px;
	height: 60px;
	border: 3px solid #C3DCDD;
	border-radius: 50%;
	background: url(../assets/images/security-white.png) center center no-repeat;
	position: absolute;
	top:30px;
	left: 0;
}
.info{
	width: 250px;
  position: absolute;
  top:30px;
  left:100px;
  font-size: 18px;

}
.i_icon{
	float: right;
	font-size: 20px;
	font-weight: bold;
}
.sumUser,.sumNumber,.sumElec{
 display: inline-block;
 margin: 15px 50px;
}
.sumUser p,.sumNumber p,.sumElec p{
	margin-top: 30px;
}
a{
	text-decoration: none;
	color: #FFF;
}
.key img{
	/*vertical-align: middle;*/
	margin-top:-15px;
}
.keyNum{
	display: inline-block;
	width:150px ;
	height:50px;
	word-wrap : break-word;
	margin-left:60px;
/*	overflow-x: hidden;*/
}
.more{
	text-align: right;
	font-size: 12px;
	margin-top:10px;
}
p{
	margin-bottom: 10px;
}
.warn{
  text-align: right;
  font-size: 12px;
	font-weight: normal;
}


@-webkit-keyframes gogogo {
  0%{
    transform:translateY(28px);
    opacity: 0;
  }
  50%{
    transform:translateY(10px);
    opacity: .5;
  }
  100%{
    transform:translateY(0);
    opacity: 1;
  }
}

.user{
  -webkit-animation:gogogo 2s infinite linear ;
  display: inline-block;
  width: 100px;
  height: 20px;
}
</style>
