<template>
  <section style="width: 80%;">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="margin-left: 30px;">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="pageInfo.code" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getList">查询</el-button>
        </el-form-item>
        <!--<el-form-item>
          <el-button @click="handleAdd">新增</el-button>
        </el-form-item>-->
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="tableData" highlight-current-row  style="margin-left: 30px;">
        <el-table-column
          prop="username"
          label="用户名"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="phone"
          label="手机号"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="card_id"
          label="身份证号"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="createTime"
          label="创建时间"
          align="center"
        >
        </el-table-column>
        <el-table-column inline-template :context="_self" label="操作" width="200" >
					<span>
            <el-button type="text" size="small" @click="agree(1)">通过</el-button>
            <el-button type="text" size="small" @click="agree(2)">拒绝</el-button>
            <el-button type="text" size="small" @click="handleDesc(row)">电表详情</el-button>
          </span>
        </el-table-column>
      </el-table>
    </template>

    <!--分页-->
    <paging
      :pageInfo="pageInfo"
      @monitorPaging = 'getList'
    ></paging>

  </section>
</template>



<script>
  import  paging from '../components/Paging.vue'
  export default {
    data() {
      return {
        pageInfo:{
          pageNum: 1,
          pageSize: 5,
          totalCount: 0,
          code: '',
          type:'1'
        },

        editFormVisible:false,//编辑界面显是否显示
        editFormTtile:'编辑',//编辑界面标题
        //编辑界面数据
        /**
         * 验证规则
         * @type {Object}
         */
        arealist:[],
        ruleForm2: {
          username:'',
          trustname:'',
          area:'',
          tel:'',
          ismanager:'0'
        },
        rules2:{
          ismanager:[{ required: true, message: '请选择管理员是否', trigger: 'change' }],
          username:[ { required: true, message: '请输入用户名', trigger: 'blur' }],
          trustname:[{ required: true, message: '请输入真实姓名', trigger: 'blur' }],
//      	area:[{ required: true, message: '请选择区域', trigger: 'change' }],
//      	area:[{validator: checkArea, trigger: 'change'}],
          tel:[{type:'number', required: true, message: '请输入手机号', trigger: 'blur' }]

        },
        editLoading:false,
        btnEditText:'提 交',

        tableData: [],
        options:[],
      };
    },
    components:{paging},
    mounted: function () {
      var  _this = this;
      this.$nextTick( () => {
        this.getList()
      })
    },
    methods: {
      // 获取数据展示
      getList() {
        this.$api.post('SysUserManage/getUserList',this.pageInfo,(res)=>{
          if(res.status == 200){
            this.tableData = res.body.page.list;
            this.pageInfo.totalCount = res.body.page.recordCount;
          }
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
      // 电表详情
      handleDesc(userId){
        this.$router.push({path:'/UserCenter/Ammete',query:
          {isShowMeau:1,userId:userId.id}});
      }

    }
  }
</script>

<style scoped>
  .toolbar .el-form-item {
    margin-bottom: 10px;
  }

  .toolbar {
    background: #fff;
    padding: 10px 10px 0px 10px;
  }

  .input_ztree{
    height: 30px;
    border-radius: 4px;
    padding: 0 10px;
    border: 1px solid #ccc;
  }
</style>
