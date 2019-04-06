<template>
    <div class="userindex">




      <!--智能合约-->
      <div class="content">
        <span class="bgRight"></span>
        <span style="padding:0 10px">结算价格</span>
        <span class="bgLeft"></span>
      </div>
    </div>
</template>

<script>
//    import transactionPlatform from './TransactionPlatform.vue'
    export default {
        name: 'userindex',
//        components:{transactionPlatform},
        data () {
            return {}
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .content{
    display: flex;
    text-align: center;
    vertical-align: middle;
    margin: 600px auto;
  }
  .bgRight{
    background-image:linear-gradient(to left,#0aaf7e,#fff);
    width: 45%;
    height:2px;
    margin-top:10px;
  }
  .bgLeft{
    background-image:linear-gradient(to right,#0aaf7e,#fff);
    width: 45%;
    height:2px;
    margin-top:10px;
  }
</style>
