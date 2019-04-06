<template>
  <div class="selfNav">
   <div class="s_content">
   	<ul>
   		<li><a href="javascript:;">系统管理</a></li>
   	</ul>
   </div>
    <div>
      <router-view></router-view>
    </div>
    <myfooter></myfooter>
  </div>
</template>

<script>
  import myfooter from './Footer.vue'
  export  default{
      name:'selfNav',
      components:{myfooter}
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.selfNav{
	width: 100%;
	height: 40px;
  background-color:#3ABE7B;
  border-bottom: 6px solid #1E8550;
  line-height: 40px;
}
.s_content{
	width: 1000px;
	margin: 0 auto;
}
 ul{
    padding: 0;
    list-style: none;
  }
  li {
    display: inline-block;
    margin-right:60px;
  }
  a{
  	text-decoration: none;
  	color:#FFF;
  	font-size:18px;
  	font-weight: bold;
  }
  /*.one{
  	color:#1E8550;
  }*/
  a:hover{
  	color:#1E8550;
  }
</style>
