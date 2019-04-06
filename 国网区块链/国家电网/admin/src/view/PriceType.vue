<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="pageInfo.name" placeholder="类别名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getList">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="tableData" highlight-current-row  style="width:90%;margin: 0 auto;">
        <el-table-column prop="code" label="类型代码"  sortable>
        </el-table-column>
        <el-table-column prop="name" label="类别名称"  sortable>
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
      <el-form :model="editForm" label-width="100px" :rules="editFormRules" ref="editForm">
        <el-form-item label="类型代码" prop="code">
          <el-input v-model="editForm.code"></el-input>
        </el-form-item>
        <el-form-item label="类别名称" prop="name">
          <el-input v-model="editForm.name"></el-input>
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
          name: '',
        },

        editFormVisible:false,//编辑界面显是否显示
        editFormTtile:'编辑',//编辑界面标题
        //编辑界面数据
        /**
         * 验证规则
         * @type {Object}
         */
        editForm: {
          id:'',
          code: '',
          name: '',
        },
        editLoading:false,
        btnEditText:'提 交',
        editFormRules:{
          code:[
            { required: true, message: '请输入类型代码', trigger: 'blur' }
          ],
          name:[
            { required: true, message: '请输入类别名称', trigger: 'blur' }
          ],
        },

        tableData: [],
      };
    },
    components:{paging},
    mounted: function () {
      var  _this = this;
      this.$nextTick( () => {
        // 代码保证 this.$el 在 document 中
        this.getList()
      })
    },
    methods: {
      // 获取数据展示
      getList() {
        this.$api.post('priceType/getList',this.pageInfo,(res)=>{
          if(res.body.status == 200){
            this.tableData = res.body.page.list;
            this.pageInfo.totalCount = res.body.page.recordCount;
            this.pageInfo.name = '';
          }
        },res=>{

        })
      },
      //删除记录
      handleDel:function(row){
        var arrayid = row.id;
        var _this=this;
        this.$confirm('确认删除该记录吗?', '提示', {
          //type: 'warning'
        }).then(() => {
          _this.$api.delete('priceType/delete/'+arrayid).then((res)=>{
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
        this.$api.get('priceType/getById/'+row.id).then(res=>{
          if(res.body.status == 200){
              this.editForm = res.body.priceType;
          }
        },res=>{

        });
      },

      //编辑 or 新增
      editSubmit(){
        var _this=this;
        var params = {
          id:_this.editForm.id,
          code:_this.editForm.username,
          realname:_this.editForm.realname,
          password:_this.editForm.password,
          confirm_password:_this.editForm.confirm_password,
          status:_this.editForm.status,
          roleId:_this.editForm.roleId,
          organizationId:this.parentId
        }
        // console.log(params.roleId)
        _this.$refs.editForm.validate((valid)=>{
          if(valid){
            _this.btnEditText='提交中';
            _this.$api.post('priceType/save',_this.editForm,(res)=>{
              _this.btnEditText='提 交';
              _this.editFormVisible = false;

              _this.getList();
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
          this.$refs['editForm'].resetFields();
        })

        var edit = this.editForm;
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
