<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <!--<el-form-item>
          <el-input v-model="pageInfo.code" placeholder="类别名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getList">查询</el-button>
        </el-form-item>-->
        <el-form-item>
          <el-button @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="tableData" highlight-current-row  style="width:90%;margin: 0 auto;">
        <el-table-column
          prop="username"
          label="用户名"
          align="center"
        >
        </el-table-column>
        <!--<el-table-column
          prop="phone"
          label="手机号"
          align="center"
        >
        </el-table-column>-->
        <el-table-column
          prop="createTime"
          label="创建时间"
          align="center"
        >
        </el-table-column>
        <el-table-column inline-template :context="_self" label="操作" width="100">
					<span>
            <el-button type="text" size="small" @click="handleEdit(row)">编辑</el-button>
            <el-button type="text" size="small" @click="handleDel(row)">删除</el-button>
          </span>
        </el-table-column>
      </el-table>
    </template>

    <!--分页-->
    <paging
      :pageInfo="pageInfo"
      @monitorPaging = 'getList'
    ></paging>

    <!--编辑界面-->
    <el-dialog :title="editFormTtile" v-model="editFormVisible" :close-on-click-modal="false">
      <el-form :model="ruleForm2" label-width="100px" :rules="rules2" ref="ruleForm2">
        <el-form-item label="用户名" prop="username" >
          <el-input type="text" v-model="ruleForm2.username"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取 消</el-button>
        <el-button type="primary" @click.native="editSubmit">{{btnEditText}}</el-button>
      </div>
    </el-dialog>
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
          type:0
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
          area_id:'',
          tel:'',
          ismanager:'0',
          type:0
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
        this.$api.post('SysUserManage/getManageList',this.pageInfo,(res)=>{
          if(res.status == 200){
            this.tableData = res.body.page.list;
            this.pageInfo.totalCount = res.body.page.recordCount;
          }
        });
      },
      //删除记录
      handleDel:function(row){
        var arrayid = row.id;
        var _this=this;
        this.$confirm('确认删除该记录吗?', '提示', {
          //type: 'warning'
        }).then(() => {
          _this.$api.delete('SysUserManage/delete/'+arrayid).then((res)=>{
            _this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success'
            });
            _this.getList();
          }).then(()=>{});
        }).catch(() => {
        });
      },
      //显示编辑界面
      handleEdit:function(row){
        this.editFormVisible=true;
        this.editFormTtile='编辑';
        this.$api.get('SysUserManage/getById/'+row.id).then(res=>{
          if(res.body.status == 200){
            this.ruleForm2 = res.body.user;
          }
        },res=>{

        });
      },

      // 新增
      editSubmit(){
        var _this=this;
        _this.$refs.ruleForm2.validate((valid)=>{
          if(valid){
            _this.btnEditText='提交中';
            _this.ruleForm2.type = 0;
            _this.$api.post('SysUserManage/saveUser',_this.ruleForm2,(res)=>{
              _this.btnEditText='提 交';
              _this.editFormVisible = false;
              if(res.body.status == 1001){
                this.$notify.error({
                  title: '错误',
                  message: res.body.msg
                });
              }else{
                _this.getList();
              }
            },res=>{
            })
          }
        });

      },

      //显示新增界面
      handleAdd(){
        var _this=this;

        this.editFormVisible=true;
        this.editFormTtile='新增';
        this.$nextTick( () => {
          this.$refs['ruleForm2'].resetFields();
        })

        var edit = this.ruleForm2;
        for(var attr in  edit){
          edit[attr] = ''
        }
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
    padding: 10px 10px 0px 10px;
  }

  .input_ztree{
    height: 30px;
    border-radius: 4px;
    padding: 0 10px;
    border: 1px solid #ccc;
  }
</style>
