<template>
    <!--统计分析-->
    <div class="Count">
      <integral-inquire></integral-inquire>
      <contract-info></contract-info>
    </div>
</template>

<script>
  import integralInquire from './integralInquire.vue'
  import contractInfo from './ContractInfo.vue'
    export default {
        name: 'Count',
        components:{integralInquire,contractInfo},
        data () {
            return {}
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .Count{
    margin-bottom: 30px;
    margin-top: 12%;
  }

</style>
