<template >
  <div style="width: 80%;">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="margin-left: 30px;">
      <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="pageInfo.code" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getAllPage">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table
        :data="tableData"
        border
        tooltip-effect="dark"
        style="margin-left: 30px;"
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
          width="140"
          show-overflow-tooltip>
        </el-table-column>
        <el-table-column
          prop="remark"
          label="备注 "
          width="140">
        </el-table-column>
        <el-table-column inline-template :context="_self" label="操作" width="100" >
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
      @monitorPaging = 'getAllPage'
    ></paging>

    <!--编辑界面-->
    <el-dialog :title="editFormTtile" v-model="editFormVisible" :close-on-click-modal="false">
      <el-form ref="form" :rules="rules" :model="form" label-width="100px" style="margin: 50px;">
        <el-form-item label="电表ID" prop="meter_ID">
          <el-input v-model="form.meter_ID"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="身份证号／注册证件号" prop="card_id">
          <el-input v-model="form.card_id"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input type="textarea" v-model="form.remark"></el-input>
        </el-form-item>
        <!--<el-form-item>
          <el-button class="btdb" @click="save" style="background-color:#0aaf7e;color: #fff; ">提交</el-button>
          <el-button style="background-color:#ccc;color: #fff; " @click="visible2 = false">取消</el-button>
        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取 消</el-button>
        <el-button type="primary" @click.native="editSubmit">{{btnEditText}}</el-button>
      </div>
    </el-dialog>
  </div>
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
        // 弹出框的表单字段
        form: {
          meter_ID:'', //电表id
          name:'', //用户名
          card_id:'', //身份证号
          phone:'', //手机号
          remark:'', //备注
        },

        // 验证
        rules:{
          meter_ID:[
            { required: true, message: '请输入电表ID', trigger: 'blur' },
          ],
          name:[
            { required: true, message: '请输入名称', trigger: 'blur' },
          ],
          card_id:[
            { required: true, message: '请输入身份证号／注册证件号', trigger: 'blur' },
          ],
          phone:[
            { required: true, message: '请输入手机号', trigger: 'blur' },
          ],
          remark:[
          ],
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
        this.getAllPage()
      })
    },
    methods: {
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
            _this.getAllPage();
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
            this.ruleForm2 = res.body.Price;
          }
        },res=>{

        });
      },
      // 新增
      editSubmit(){
        this.$refs['form'].validate((valid) => {
          if (valid) {
            this.$api.post('userMeter/save',this.form,(res)=>{
              if(res.body.status == 200){
                this.$refs['form'].resetFields();
                this.btnEditText='提 交';
                this.editFormVisible = false;
                this.getAllPage();
              }
            },res=>{
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });

      },
      //显示新增界面
      handleAdd(){
        var _this=this;

        this.editFormVisible=true;
        this.editFormTtile='新增';
        this.$nextTick( () => {
          this.$refs['form'].resetFields();
        })

        var edit = this.form;
        for(var attr in  edit){
          edit[attr] = ''
        }
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
