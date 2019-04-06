
<!--阀门列表-->
<template>
  <div class="BuyManage">
    <!--<div style="height:20px;">-->
      <!--<span>-->

      <!--</span>-->
    <!--</div>-->
    <el-col :span="24" class="toolbar">
    <!--<el-input v-model="input" placeholder="请输入内容"></el-input>-->
      <el-button type="info" @click="" style="color: #fff;background-color: #1ea075;border-color: #1ea075;">添加</el-button>
      <el-button type="info" @click="" style="color: #fff;background-color: #1ea075;border-color: #1ea075;">删除</el-button>
    </el-col>
    <!--<div style="height:50px;">-->
      <!--<span>-->

      <!--</span>-->
    <!--</div>-->
  <el-table
    :data="meterTable"
    stripe
    style="width: 100%">
      <el-table-column  type="selection" width="55">
      </el-table-column>
      <el-table-column prop="name" label="电表名称" >
      </el-table-column>
      <el-table-column prop="pub_key" label="公钥" >
      </el-table-column>
      <el-table-column prop="status" label="状态"  :formatter="formatSex" >
      </el-table-column>
      <el-table-column prop="address"  label="地址">
      </el-table-column>

      <el-table-column inline-template :context="_self" label="操作" width="200">
        <span>
            <el-button type="text" size="small" @click="buy(row)">购电</el-button>
        </span>
      </el-table-column>
    </el-table>



  </div>
  </template>
<script>
  import  paging from '../common/paging'
  export default {
    components:{paging},
    data () {
      return {
        dialogVisible: false,
          token:[],
        meterTable:[],
      }
    },
    mounted(){
        this.getList();
      this.token.Authorization = sessionStorage.getItem('accessToken')
    },
    methods: {
      getList(){
        let that = this;

        that.$api.get('userMeter/getUserMeter').then(response => {
          if (response.status == 200) {
            that.meterTable = response.body.userMeter
          }

        }, response => {

        });
      },

      // 买电
      buy(row){
        this.$router.push({path:'/UserCenter/BuyManage',query:{buy_meter_id:row.id}});
      },
      //状态显示转换
      formatSex:function(row,column){
        return row.stockstate==0?'正常':'正常';
      },

    }
  }
</script>
<style scoped>

  .toolbar .el-form-item {
    margin-bottom: 10px;
  }

  .toolbar {
    background: #fff;
    padding: 10px 10px 10px 10px;
  }
</style>
