<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="pageInfo.code" placeholder="类别名称"></el-input>
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
        <el-table-column prop="code" label="价格类型代码"  sortable></el-table-column>
        <el-table-column prop="price" label="单价"  sortable></el-table-column>
        <el-table-column prop="create_date" label="创建日期"  sortable></el-table-column>
        <el-table-column prop="end_date" label="截止日期"  sortable></el-table-column>
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
        <el-form-item label="价格类型代码" style="width: 500px;">
          <el-select style="width: 300px;" v-model="editForm.code" placeholder="请选择价格类型代码">
            <el-option
              v-for="(item,index) in options"
              :key="item.id"
              :label="item.code"
              :value="item.code">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="单价" prop="price" >
          <el-input style="width: 300px;" v-model="editForm.price"></el-input>
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
        pageInfo:{
          pageNum: 1,
          pageSize: 5,
          totalCount: 0,
          code: '',
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
          price: '',
          end_date: '',
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
        options:[],
      };
    },
    components:{paging},
    mounted: function () {
      var  _this = this;
      this.$nextTick( () => {
        this.getList()
      })
      this.getAll()
    },
    methods: {
      // 获取单价类型
      getAll(){
          this.$api.get('priceType/getAll').then(res=>{
              if(res.body.status == 200){
                  this.options = res.body.list
              }
          },res=>{

          });
      },
      // 获取数据展示
      getList() {
        this.$api.post('Price/getList',this.pageInfo,(res)=>{
          if(res.body.status == 200){
            this.tableData = res.body.page.list;
            this.pageInfo.totalCount = res.body.page.recordCount;
            this.pageInfo.code = '';
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
          _this.$api.delete('Price/delete/'+arrayid).then((res)=>{
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
        this.$api.get('Price/getListById/'+row.id).then(res=>{
          if(res.body.status == 200){
            this.editForm = res.body.Price;
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
            _this.$api.post('Price/save',_this.editForm,(res)=>{
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
