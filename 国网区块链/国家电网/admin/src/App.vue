<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
*{padding:0;margin:0;}
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
