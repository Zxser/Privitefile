<template>
  <div class="header">
    <div class="hConent">
      <div class="logoBox">
        <img class="logo" src="../assets/images/logo.png"/>
      </div>
      <div class="hnav" v-if="isShowMeau">
        <!--isShowHeader-->
        <ul>
          <li><router-link to="/Header/HomeIndex?isShowMeau=1">首页</router-link></li>
          <li><router-link to="/Header/Contract?isShowMeau=1">智能合约</router-link></li>
          <li v-if="isPersonal == 2"><router-link to="/Header/Count?isShowMeau=1">统计分析</router-link></li>
          <li><router-link to="/Header/UserCenter?isShowMeau=1">个人中心</router-link></li>
        </ul>
      </div>
      <div v-if="!isShowMeau" class="hlogin">
        <ul>
          <li><router-link to="/Login">登录</router-link></li>
          <li><router-link to="/sign">注册数字证书</router-link></li>
        </ul>
      </div>
      <div v-else class="hlogin">
        <ul>
          <li><a href="javascript:;">欢迎您,{{nickname}}</a></li>
          <li><a href="javascript:;" @click="signOut">退出</a></li>
        </ul>
      </div>
    </div>

    <div>
      <router-view></router-view>
    </div>
    <myfooter v-if='isShowMeau'></myfooter>
  </div>
</template>

<script>
  import myfooter from './Footer.vue'
  export default {
    name: 'header',
    components:{myfooter},
    data () {
      return {
        isShowMeau:this.$route.query.isShowMeau,
        isPersonal:sessionStorage.getItem('personal'),
        nickname:sessionStorage.getItem('nickname'),
      }
      },
    /*mounted(){
      sessionStorage.getItem('isShowMeau')
    },*/
    methods:{
        // 退出登录
      signOut(){
          /*this.$api.get('home/logout').then(res=>{

          },res=>{

          });*/

        this.$confirm('确定退出吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '退出成功!'
          });
          this.$router.push({path:'/'});// ,query:{checkId:row.id,viewState:2}
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出'
          });
        });
      },
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .header{
    height: 120px;
    width: 100%;
    background-color: #1ea075;
    position: absolute;
    top:0;
    left:0;
    z-index: 100;
  }
  .hConent{
    width: 90%;
    margin: 0 auto;
    position: relative;
    z-index: 100;
  }
  .logoBox{
    height: 120px;
    width: 174px;
    float:left;
    padding-left: 5%;
  }
  .logo{
    border: 0;
    vertical-align: middle;
    padding-top: 28px;
  }
  a{
    color: #FFF;
    text-decoration: none;
  }
  a:hover{
    font-weight: bold;
  }
  ul, ol {
    padding: 0;
    list-style: none;
  }

  li {
    display: inline-block;
    margin-top: 10px;
  }
  .hnav{
    font-size: 20px;
    float:left;
    margin-left: 5%;
    padding-top: 28px;
  }
  .hnav li{
    margin-right: 50px;
  }
  .hlogin{
    font-size:12px;
    float: right;
  }
  .hlogin li{
    margin-right: 20px;
  }
  .router-link-active{
    color: #FFFFFF;
    font-family: MicrosoftYaHei;
    font-weight: bold;
  }
</style>
