<template>
  <div class="userCenter">
    <div class="content">

      <div class="meau">
        <ul>
          <router-link tag="li" to="/ManageTab/S_list"><a href="javascript:;">系统管理员</a></router-link>
          <router-link tag="li" to="/ManageTab/G_list"><a href="javascript:;">国网用户管理</a></router-link>
          <router-link tag="li" to="/ManageTab/F_list"><a href="javascript:;">发电户管理</a></router-link>
          <router-link tag="li" to="/ManageTab/RePassword"><a href="javascript:;">修改管理员密码</a></router-link>
          <router-link tag="li" to="/ManageTab/PriceType"><a href="javascript:;">价格类型管理</a></router-link>
          <router-link tag="li" to="/ManageTab/Price"><a href="javascript:;">价格管理</a></router-link>
          <!--<router-link tag="li" to="/ManageTab/Organization">组织管理</router-link>-->
          <router-link tag="li" to="/ManageTab/Area"><a href="javascript:;">区域管理</a></router-link>
        </ul>
      </div>

      <div style="width: 85%">
        <router-view></router-view>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: 'userCenter',
    data () {
      return {
      }
    },
    methods:{

    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    padding: 0px;
    margin: 0;
    list-style: none;
  }
  a{
    text-decoration:none;
    color: #000;
    cursor: pointer;
  }
  .userCenter{
    width: 90%;
    height: 500px;
    margin: 20px 84px;
    border: 1px solid #CCCCCC;
  }
  .content{
    display: flex;
    justify-content:flex-start;
  }
  .xx{
    margin-left: 30px;
  }
  .meau{
    width: 201px;
    height: 500px;
    border: 1px solid #CCCCCC;
    background-color: #F2F2F2;
  }
  .meau ul{
    display: flex;flex: 1;flex-direction: column;justify-content: center;align-items: center;
  }
  .meau ul li{
    width:100%;height: 40px;display: flex;justify-content: center;align-items: center;
  }
  /*.meau ul li{
    height: 42px;
    line-height: 42px;
  }
  .meau ul li a{
    color: #AAAAAA;
  }
  .arrow{
    float: right;
    margin-right: 11px;
  }*/
  .router-link-active{
    background-color: #fff;
  }
</style>
