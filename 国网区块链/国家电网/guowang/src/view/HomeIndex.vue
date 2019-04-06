<template>
    <div class="HomeIndex">
        <banner></banner>
        <echarts-map-province></echarts-map-province>
        <contact-me></contact-me>
    </div>
</template>

<script>
    import banner from './Banner.vue'
    import echartsMapProvince from '../components/EchartsMapProvince.vue'
    import contactMe from '../view/contactMe.vue'
    export default {
        name: 'HomeIndex',
        components:{banner,echartsMapProvince,contactMe},
        data () {
            return {

            }
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .HomeIndex{
    /*margin-top:120px*/
  }
</style>
