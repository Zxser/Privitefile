
<!--阀门列表-->
<template>
  <div>
    <el-col :span="24" class="toolbar">
      <!--<el-input v-model="input" placeholder="请输入内容"></el-input>-->
      <el-input v-model="pageInfo.id" placeholder="请输入要查询的订单号" style="width: 300px"></el-input>
      <el-button type="info" @click="" style="color: #fff;background-color: #1ea075;border-color: #1ea075;">查询</el-button>
    </el-col>
    <el-table
      :data="meterTable"
      @cell-click="mouseOver"
      stripe
      style="width: 100%">
      <el-table-column  type="selection" width="55">
      </el-table-column>
      <el-table-column prop="create_date" label="时间" width="180">
      </el-table-column>
      <el-table-column prop="id" label="订单号" width="180">
      </el-table-column>
      <el-table-column prop="num" label="电量"  width="180">
      </el-table-column>
      <el-table-column prop="num"  label="费用(元)">
      </el-table-column>
      <el-table-column prop="nickname"  label="卖家">
      </el-table-column>
      <el-table-column prop="address"  label="状态" :formatter="formatSex"  @cell-click="mouseOver">
      </el-table-column>
    </el-table>
    <div>
      <paging
        :pageInfo="pageInfo"
        @monitorPaging = 'getList'
      ></paging>
    </div>
    <el-dialog
      title="状态"
      :visible.sync="dialogVisible"
      :modal="false"
      size="small"
      >
      <el-steps :space="100" :active="active" finish-status="success">
        <el-step title="买家已支付"></el-step>
        <el-step title="卖家供电"></el-step>
        <el-step title="买家收电"></el-step>
        <el-step title="交易成功"></el-step>
      </el-steps>
      <span slot="footer" class="dialog-footer">
    <el-button @click="getList">取 消</el-button>
    <el-button type="primary" @click="getList">确 定</el-button>
  </span>
    </el-dialog>
  </div>
  <!--分页-->


</template>
<script>
  import  paging from '../common/paging'
  export default {
    components:{paging},
    data () {
      return {
        token:[],
        meterTable:[],
        dialogVisible:false,
        active:1,
        pageInfo:{
            id:'',
          pageNum:1,
          pageSize:10,
          totalCount:0,
        },
      }
    },
    mounted(){
      this.getList();
      this.token.Authorization = sessionStorage.getItem('accessToken')
    },
    methods: {
      getList(){
        let that = this;
        that.dialogVisible = false;
        that.$api.post('electricitytrading/findTradingByPage',that.pageInfo,(res)=>{
          if(res.status==200){
              that.meterTable = res.body.page.list;
              that.pageInfo.totalCount = res.body.page.recordCount;
          }
        },(res)=>{
        })
      },
      // 买电
      buy(row){
        this.$router.push({path:'/UserCenter/BuyManage',query:{buy_meter_id:row.id}});
      },
      //状态显示转换
      formatSex:function(row,column){
        return row.state==3?'已完成':'进行中';
      },
      mouseOver(row){
          this.dialogVisible =true;
        this.$api.post('electricitytrading/findById',row,(res)=>{
          if(res.status==200){
              if(res.body.electricitytrading.state == 3){
                this.active = 4;
              }else{
                this.active = res.body.electricitytrading.state
              }

          }
        },(res)=>{
        })


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
