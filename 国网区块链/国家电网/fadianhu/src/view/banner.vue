<template>
  <div class="banner">
   <div class="b_icon">
   </div>
   <div class="sumUser scroll">
     <h2 class="user">
       {{userTotal.integralToal}}
     </h2>
     <span class="user1">用户量</span>
   </div>
   <div class="sumNumber">
     <h2 class="user">
      {{userTotal.integralToal}}
     </h2>
   	<span class="number">总积分</span>
   </div>
   <div class="sumElec">
     <h2 class="user">
       {{userTotal.integralToal}}
     </h2>
   	<span class="elec">总电量</span>
   </div>
  </div>
</template>

<script>
  export default{
    data(){
        return{
          //首页总数
          userTotal:{
            electricityToal: '1',
            userTotal: '1',
            integralToal: '1'
          }
        }
    },
    mounted(){
      this.getUserTotal();


    },
    methods:{
      // 获取首页数据
      getUserTotal(){
        this.$api.get('userCenter/indexTotal').then(res=>{
          this.userTotal = res.body.total;
        },res=>{

        });
      },
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  @-webkit-keyframes gogogo {
    0%{
      transform:translateY(20px);
      opacity: 0;
    }
    50%{
      transform:translateY(8px);
      opacity: 0;
    }
    100%{
      transform:translateY(0);
      opacity: 1;
    }
  }

  .user{
    -webkit-animation:gogogo 1s infinite linear ;
  }


 .banner{
 	width: 100%;
 	height: 743px;
 	position:relative;
 	background-image: url(../assets/images/index-bg.png);
 }
 .b_icon{
 	width: 1068px;
 	height: 426px;
 	background-image: url(../assets/images/index-icon.png);
  position: absolute;
  top:150px;
  left:165px;
 }
 h2{
 	font-size: 30px;
 	color: #F7FF0F;
   margin-top: 25px;
 }
 .user1,.number,.elec{
   display:block;
   text-align: center;
 }
 span{
 	font-size: 20px;
 	color: #9ABCB3;
 }
 .sumUser{
 	position: absolute;
  top:430px;
  left:250px;

 }
 .sumNumber{
 	position: absolute;
  top:320px;
  left:640px;
 }
 .sumElec{
  position: absolute;
  top:430px;
  left:1060px;
 }

</style>
