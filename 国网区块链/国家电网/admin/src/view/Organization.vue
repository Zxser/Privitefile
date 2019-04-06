<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="pageInfo.name" placeholder="模块名称"></el-input>
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
    <!--<template>
      <table border="1" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
          <th>组织名称</th>
          <th>组织代码</th>
          <th>简称</th>
          <th>创建日期</th>
          <th>开始日期</th>
          <th>截止日期</th>
          <th>相关操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in tableData" :key="item.id">
          <td>{{item.name}}</td>
          <td>{{item.code}}</td>
          <td>{{item.abbreviation}}</td>
          <td>{{item.create_date}}</td>
          <td>{{item.start_date}}</td>
          <td>{{item.end_date}}</td>
          <td>
            <el-button type="text" size="small" @click="handleEdit(row)">编辑</el-button>
            <el-button type="text" size="small" @click="handleDel(row)">删除</el-button>
          </td>
        </tr>
        </tbody>

      </table>
    </template>-->
    <template>
      <el-table height="400" @row-click="rowData" :data="tableData" highlight-current-row  style="width:90%;margin: 0 auto;">
        <el-table-column prop="name" label="名称"  sortable></el-table-column>
        <el-table-column prop="code" label="组织代码"  sortable></el-table-column>
        <el-table-column prop="abbreviation" label="简称"  sortable></el-table-column>
        <el-table-column prop="create_date" label="创建日期"  sortable></el-table-column>
        <!--<el-table-column prop="start_date" label="开始日期"  sortable></el-table-column>
        <el-table-column prop="end_date" label="截止日期"  sortable></el-table-column>-->
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
        <el-form-item label="上级菜单" style="width: 500px;">
          <el-input readonly style="width: 300px;" v-model="editForm.meau"></el-input>
          <el-tree v-if="isShowTrees" style="width: 300px;" :data="treeData" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
          <el-button @click="isShowTree" style="position: absolute;right:5%;top: 3%;">选择</el-button>
        </el-form-item>
        <el-form-item label="名称" prop="name" >
          <el-input style="width: 300px;" v-model="editForm.name"></el-input>
        </el-form-item>
        <el-form-item label="简介" prop="abbreviation" >
          <el-input style="width: 300px;" v-model="editForm.abbreviation"></el-input>
        </el-form-item>
        <el-form-item label="开始日期" prop="end_date" >
          <el-date-picker style="width: 300px;" type="date" placeholder="选择日期" v-model="editForm.start_date" ></el-date-picker>
        </el-form-item>
        <el-form-item label="截止日期" prop="end_date" >
          <el-date-picker style="width: 300px;" type="date" placeholder="选择日期" v-model="editForm.end_date" ></el-date-picker>
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
        isShowTrees:false,// 是否显示菜单
        pageInfo:{
          pageNum: 1,
          pageSize: 10,
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
          pid:'',// --顶级--
          code: '',//组织代码
          name: '',//名称
          abbreviation:'',//简称
          start_date:'',//开始日期
          end_date:'',//截止日期
          meau:'',//菜单名称
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
        // 树形菜单
        treeData:[],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      };
    },
    components:{paging},
    mounted: function () {
      var  _this = this;
      this.$nextTick( () => {
        this.getList()
      })
      this.fingAllByTree()
    },
    methods: {
      // 点击某一行
      rowData(val){
          console.log(val)
      },
      // 点击是否显示tree
      isShowTree(){
          this.isShowTrees = !this.isShowTrees;
      },
      // 获取组织信息
      fingAllByTree(){
        this.$api.get('sysOrganization/fingAllByTree').then(res=>{
          if(res.body.status == 200){
            this.treeData = res.body.list
          }
        },res=>{

        });
      },
      // 获取数据展示
      getList() {
        this.$api.post('sysOrganization/list',this.pageInfo,(res)=>{
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
          _this.$api.delete('sysOrganization/delete/'+arrayid).then((res)=>{
              if(res.status == 200){
                if(res.body.status == 500){
                  this.$message.error(res.body.msg);
                }else{
                  _this.$notify({
                    title: '成功',
                    message: '删除成功',
                    type: 'success'
                  });
                }

              }

            _this.getList();
          }).then((res)=>{

          });
        }).catch(() => {
        });
      },
      //显示编辑界面
      handleEdit:function(row){
        this.editFormVisible=true;
        this.editFormTtile='编辑';
        this.$api.get('sysOrganization/getById/'+row.id).then(res=>{
          if(res.body.status == 200){
            this.editForm = res.body.sysOrganization;
            this.editForm.meau = res.body.sysOrganization.parent.name;
          }
        },res=>{

        });
      },

      //编辑 or 新增
      editSubmit(){
        var _this=this;
        _this.$refs.editForm.validate((valid)=>{
          if(valid){
            _this.btnEditText='提交中';
            _this.$api.post('sysOrganization/save',_this.editForm,(res)=>{
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
          this.isShowTrees = false;
        })

        var edit = this.editForm;
        for(var attr in  edit){
          edit[attr] = ''
        }
      },

      // 树形菜单
      handleNodeClick(data) {
        //console.log(data);
        this.editForm.meau = data.name;
        this.editForm.pid = data.id;
      }
    }
  }
</script>

<style scoped>
  table{
    border-color: #ccc;
    margin-left: 14px;
  }
  table td,th {
    border: 1px solid #ccc;
    height: 45px;
    width: 200px;
  }
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
