<template>
    <div class="HomeIndex">
      <!--
        判断是否是个人用户或者是国网用户
        登录之后判断是个人还是国网用户，在路径之后穿参数
        如果是true显示个人界面，否者显示国网界面
      -->

      <div>
        <banner-info></banner-info>
        <echarts-area-stack></echarts-area-stack>
        <echarts-daily-integration></echarts-daily-integration>
        <echarts-up-internet></echarts-up-internet>
        <contract-self></contract-self>
      </div>
      <!--<router-link to="/Header/ElectricityDetails?isShowMeau=1">发电量明细查询</router-link>-->
    </div>
</template>

<script>
    import bannerInfo from './BannerInfo.vue'
    import echartsAreaStack from '../components/EchartsAreaStack'
    import echartsDailyIntegration from '../components/EchartsDailyIntegration'
    import echartsUpInternet from '../components/EchartsUpInternet'
    import contractSelf from './ContractSelf.vue'

    export default {
        name: 'HomeIndex',
        components:{bannerInfo,echartsAreaStack,echartsDailyIntegration,echartsUpInternet,contractSelf},
        data () {
            return {
            }
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .HomeIndex{
    margin-top:120px
  }
</style>
