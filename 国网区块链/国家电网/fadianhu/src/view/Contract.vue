<template>
  <div class="contract">
    <div class="content">
      <span class="bgRight"></span>
      <span style="padding:0 10px">合约列表</span>
      <span class="bgLeft"></span>
    </div>
    <div class="tableContent">
      <table border="1" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
          <th>合约编号</th>
          <th>用户名称</th>
          <th>装机容量</th>
          <th>地点</th>
          <th>结算原则</th>
          <th>签约日</th>
          <th>到期日</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>01234548</td>
          <td>张胜男</td>
          <td>2053</td>
          <td>上海市黄浦区</td>
          <td>全额上网</td>
          <td>2016-02-05</td>
          <td>2020-02-05</td>
        </tr>
        <tr>
          <td>01234548</td>
          <td>张胜男</td>
          <td>2053</td>
          <td>上海市黄浦区</td>
          <td>全额上网</td>
          <td>2016-02-05</td>
          <td>2020-02-05</td>
        </tr>
        </tbody>

      </table>
    </div>

    <div class="content">
      <span class="bgRight"></span>
      <span style="padding:0 10px">结算价格</span>
      <span class="bgLeft"></span>
    </div>
    <div class="tableContent Price">
      <table border="1" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
          <th>类型</th>
          <th>金额</th>
          <th>开始时间</th>
          <th>结束时间</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>国家补贴</td>
          <td>0.439元/千瓦时</td>
          <td>2016-02-05</td>
          <td>2020-02-05</td>
        </tr>
        <tr>
          <td>国家补贴</td>
          <td>0.439元/千瓦时</td>
          <td>2016-02-05</td>
          <td>2020-02-05</td>
        </tr>
        </tbody>

      </table>
    </div>

  </div>
</template>

<script>
  export default {
    name: 'contract',
    data () {
      return {}
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .contract{
    margin-bottom: 30px;
    margin-top:150px
  }
  .content{
    display: flex;
    text-align: center;
    vertical-align: middle;
    margin: 60px auto;
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
  table {
    border: 1px solid #09ae7d;
    text-align: center;
    font-size: 12px;
  }
  table td,th {
    border: 1px solid #ccc;
    height: 45px;
  }
  .tableContent{
    display: flex;
    justify-content: center;
    align-content: center;
  }
  table th, td{
    height: 40px;
  }
  thead{
    background-color: #abe3d3;
  }
  thead th{
    width: 174px;
  }
  .Price thead th{
    width: 300px;
  }
</style>
