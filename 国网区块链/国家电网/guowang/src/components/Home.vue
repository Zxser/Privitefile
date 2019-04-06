<template>
  <div class="hello">
    <myhead></myhead>
    <banner></banner>
    <platform></platform>
    <trust-platform></trust-platform>
    <contact-me></contact-me>
    <myfooter></myfooter>
  </div>
</template>
<!--  -->
<script>
  import myhead from '../view/Header.vue'
  import banner from '../view/Banner.vue'
  import platform from '../view/Platform.vue'
  import trustPlatform from '../view/TrustPlatform.vue'
  import contactMe from '../view/contactMe.vue'
  import myfooter from '../view/Footer.vue'

export default {
  name: 'hello',
  components:{myhead,banner,platform,trustPlatform,contactMe,myfooter},
  data () {
    return {
//	isShowMeau:sessionStorage.getItem('isShowMeau') ? sessionStorage.getItem('isShowMeau') : false,
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
