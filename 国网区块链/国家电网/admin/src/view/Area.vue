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
      <el-table  :data="tableData" highlight-current-row  style="width:90%;margin: 0 auto;">
        <el-table-column width="160px" prop="manage" label="节点类型"  :formatter="nodeType" sortable></el-table-column>
        <el-table-column width="160px" prop="area_id" label="区域id"  sortable></el-table-column>
        <el-table-column width="200px" prop="super_address" label="区域超导地址 "  sortable></el-table-column>
        <el-table-column width="160px" prop="transaction_url" label="交易节点地址"  sortable></el-table-column>
        <el-table-column width="160px" prop="rpc_name" label="节点账号"  sortable></el-table-column>
        <el-table-column width="160px" prop="rpc_password" label="节点密码"  sortable></el-table-column>
        <el-table-column width="200px" prop="txid" label="交易Id"  sortable></el-table-column>
        <el-table-column width="160px" prop="note_port" label="超导服务端口"  sortable></el-table-column>
        <el-table-column width="200px" prop="area_address" label="区域打币地址"  sortable></el-table-column>
        <el-table-column fixed="right" inline-template :context="_self" label="操作" width="100">
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
      <el-form :model="editForm" label-width="180px" :rules="editFormRules" ref="editForm">
        <!--<el-form-item label="节点类型" style="width: 500px;">
          <el-radio-group v-model="radio2">
            <el-radio :label="3">备选项</el-radio>
            <el-radio :label="6">备选项</el-radio>
          </el-radio-group>
        </el-form-item>-->
        <el-form-item label="区域选择" style="width: 500px;">
          <el-select change="getAll"  v-model="editForm.area_id" placeholder="请选择区域" style="width: 300px;height: 40px">
            <el-option
              v-for="(item,index) in arealist"
              :label="item.name"
              :value="item.id"
              :key="item.index"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="交易节点地址" prop="transaction_url" >
          <el-input style="width: 300px;" v-model="editForm.transaction_url"></el-input>
        </el-form-item>
        <el-form-item label="节点账号" prop="rpc_name" >
          <el-input style="width: 300px;" v-model="editForm.rpc_name"></el-input>
        </el-form-item>
        <el-form-item label="交易节点密码" prop="rpc_password" >
          <el-input style="width: 300px;" v-model="editForm.rpc_password"></el-input>
        </el-form-item>
        <el-form-item label="超导服务端口" prop="note_port" >
          <el-input style="width: 300px;" v-model="editForm.note_port"></el-input>
        </el-form-item>
        <el-form-item label="建立超导链接端口" prop="super_port" >
          <el-input style="width: 300px;" v-model="editForm.super_port"></el-input>
        </el-form-item>
        <!--<el-form-item label="区域的打币地址" prop="area_address" >
          <el-input style="width: 300px;" v-model="editForm.area_address"></el-input>
        </el-form-item>-->
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
        },

        editFormVisible:false,//编辑界面显是否显示
        editFormTtile:'编辑',//编辑界面标题
        arealist:[],
        //编辑界面数据
        /**
         * 验证规则
         * @type {Object}
         */
        editForm: {
          id:'',
          manage:'',//1 主节点
          area_id:'', //区域id
          super_address:'', //区域超导地址
          transaction_url:'', //交易节点地址
          rpc_name:'', //节点账号
          rpc_password:'', //交易节点密码
          txid:'', //交易Id
          note_port:'', //超导服务端口
          super_port:'', //建立超导链接端口
          area_address:'', //区域的打币地址  出账（提币），进账 （一天发电量的币）地址
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
      // 节点类型
      nodeType(row){
        return row.manage==1?'主节点':row.manage==0?'普通节点':'未知';
      },
      // 获取单价类型
      getAll(){
        this.$api.get("Area/getList/310100").then(res=>{
          if(res.status == 200){
            this.arealist=res.body.list;
          }
        },res=>{
          alert(error)
        });
      },
      // 获取数据展示
      getList() {
        this.$api.post('nodeAddress/getList',this.pageInfo,(res)=>{
          if(res.body.status == 200){
            this.tableData = res.body.page.list;
            this.pageInfo.totalCount = res.body.page.recordCount;
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
          _this.$api.delete('nodeAddress/delete/'+arrayid).then((res)=>{
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
        this.$api.get('nodeAddress/getListById/'+row.id).then(res=>{
          if(res.body.status == 200){
            this.editForm = res.body.NodeAddress;
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
            _this.$api.post('nodeAddress/save',_this.editForm,(res)=>{
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
