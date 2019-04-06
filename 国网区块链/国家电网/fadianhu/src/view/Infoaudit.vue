<template>
  <div class="UserList">
    <div class="u_box">
      <div class="tab">
        <ul>
          <li ><a href="javascript:;" @click="changeTab('0')">全部</a></li>
          <li><a href="javascript:;" @click="changeTab('1')">已审批</a></li>
          <li><a href="javascript:;" @click="changeTab('2')">未审批</a></li>
          <li><a href="javascript:;" @click="changeTab('3')">已拒绝</a></li>
        </ul>
      </div>
      <div class="tabCont">
        <div id="cont0" class="cont0">
          <el-table
            :data="tableData"
            border
            tooltip-effect="dark"
            style="width: 95%"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              prop="meter_ID"
              label="电表id  "
              width="80">
            </el-table-column>
            <el-table-column
              prop="name"
              label="用户名 "
              width="100">
            </el-table-column>
            <el-table-column
              prop="phone"
              label="手机号 "
              width="100">
            </el-table-column>
            <el-table-column
              prop="status"
              label="状态 "
              width="100"
              :formatter="formatSex">
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址"
              show-overflow-tooltip>
            </el-table-column>
            <el-table-column
              prop="remark"
              label="备注 "
              width="140">
            </el-table-column>
          </el-table>
        </div>
      </div>

      <!--分页-->
      <paging
        :pageInfo="pageInfo"
        @monitorPaging = 'getAllPage'
      ></paging>

      <!--操作按钮-->
      <div class="Lbtn">
        <button class="btnSave active" @click="agree(1)" type="button">审批</button>
        <button class="btnRest"  @click="agree(2)" type="button">拒绝</button>
      </div>
    </div>
  </div>
</template>

<script>
  import  paging from '../components/Paging.vue'
  export default{
    name:'',
    components:{paging},
    data() {
      return {
        remark:'',
        isPersonal:sessionStorage.getItem('personal'),
        tableData: [],
        multipleSelection: [],
        pageInfo:{
          pageNum: 1,
          pageSize: 5,
          totalCount: 0,
          status:''
        },
      }
    },
    mounted(){
      this.getAllPage();
    },
    methods:{
      // 获取全部数据
      getAllPage(){
        this.$api.post('userMeter/getAllPage',this.pageInfo,(res)=>{
            if(res.body.status == 200){
              let body = res.body;
              this.tableData = body.page.list;
              this.pageInfo.totalCount = res.body.page.recordCount;
            }
        },res=>{

        });
      },

      // 审核和拒绝
      agree(row){
        if(row == 2){
          this.remark = '拒绝'
        }
        this.$api.post('userMeter/agree',{arrayId:this.multipleSelection,status:row,remark:this.remark},(res)=>{
            if(res.body.status == 200){
              this.$notify({
                title: '成功',
                type: 'success'
              });
              this.getAllPage()
            }
        },res=>{

        });
      },

      //状态显示转换
      formatSex:function(row,column){
        return row.status==1?'已审核':row.status==0?'待审核':'已拒绝';
      },
      // 多选
      handleSelectionChange(val) {
        var arr = [];
        val.forEach(function(element){
          arr.push(element.id);
        });
        this.multipleSelection = arr;
      },
      changeTab(tabCon_num){
        if(tabCon_num == 0){
          this.pageInfo.status = '';
          this.getAllPage();
        }else if(tabCon_num == 1){
          this.pageInfo.status = 1;
          this.getAllPage();
        }else if(tabCon_num == 2){
          this.pageInfo.status = 0;
          this.getAllPage();
        }else if(tabCon_num == 3){
          this.pageInfo.status = 2;
          this.getAllPage();
        }
      }

    }
  }


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .UserList{
    width: 800px;
    height: 500px;
    margin: 0 auto;
    text-align: center;
    /*border: 1px solid #CCC;*/
  }
  .u_box{
    margin-top:10px;
    margin-left: 20px;
  }
  ul{
    overflow: hidden;
  }
  li{
    float: left;
    list-style: none;
  }
  a{
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
    color: #068964;
    display: inline-block;
    width:180px ;
    height:40px ;
    line-height: 40px;
    text-align: center;
    border: 1px solid #CCC;
  }
  a:hover{
    background-color: #068964;
    border: 1px solid #068964;
    color: #FFF;
  }
  .tabCont{
    margin-top: 30px;
    clear: both;
  }
  #cont1,#cont2,#cont3{
    display: none;
  }
  table {
    border: 1px solid #ccc;
    text-align: center;
    font-size: 12px;
  }
  thead{
    background-color: #F4F4F4;
  }
  table td, table th {
    border: 1px solid #ccc;
    height: 30px;
    width: 260px;
  }
  .el-table--border td, .el-table--border th{text-align: center;}
  .el-pagination{margin-top: 15px;float: right;  margin-right: 5%;}
  .btnSave,.btnRest{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
    color: #fff;
    background-color: #ccc;
  }
  .active{
    background-color: #068964;
  }
  .Lbtn{
    clear: both;
    float: left;margin-bottom: 20px;
  }
</style>
