<template>
  <div id="app">
    <div style="position: absolute;z-index:10000;top: 37px;right: 82px "><weather></weather></div>
    <router-view ></router-view>
  </div>
</template>

<script>
  import weather from './view/Weather'
export default {
  name: 'app',
  components:{weather},
  data(){
      return{
      }
  },
  /*watch :{
    '$route':function (to,from,next) {
//            console.log(to);
//            console.log(from);
            this.isShowHeader  = true;;
//            console.log(this.isShowHeader);
    }
  }*/
}
</script>

<style>
    *{
      padding: 0;
      margin: 0;
      font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    }
    a{
      text-decoration: none;
      color: #000;
    }
    ::-webkit-input-placeholder { /* WebKit browsers */
      color: rgb(100, 193, 173);
    }
    :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
      color: rgb(100, 193, 173);
    }
    ::-moz-placeholder { /* Mozilla Firefox 19+ */
      color: rgb(100, 193, 173);
    }
    :-ms-input-placeholder { /* Internet Explorer 10+ */
      color: rgb(100, 193, 173);
    }
</style>
