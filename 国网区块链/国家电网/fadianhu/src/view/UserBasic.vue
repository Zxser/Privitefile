<template>
    <div class="userBasic">
        <!--个人基本信息-->
      <ul>
        <li><span style="margin-left: 30px;">头像</span><img :src="head" alt="">
          <el-upload
            name="image"
            class="upload"
            :headers="token"
            :action="uploadUrl"
            :show-file-list="false"
            :on-preview="handlePreview"
            :on-success="handleScucess">
            <el-button size="">更换头像</el-button>
          </el-upload>
        </li>
        <li><span style="margin-left: 30px;">昵称</span>
          <input v-model="formData.nickname" type="text"><el-button type="text" @click="open3">修改昵称</el-button></li>
        <li><span>手机号码</span><input v-model="formData.phone" type="text"><el-button type="text" @click="open4">修改手机</el-button></li>
        <li v-if="xg"><span style="margin-left: 16px;">验证码</span><input type="text"><button class="btn" type="button">获取手机验证码</button></li>
        <li>
          <span>身份证号</span>
          <input type="text" v-model="formData.card_id" @blur="checkIDcard(formData.card_id)">
          <el-button type="text" @click="ToExamine">审核</el-button>
        </li>
        <li v-if="isShowPhone" style="float: right;margin-right: 108px;">
          <button class="btnSave active" type="button" @click="savePhone">保存</button>
          <button class="btnRest" type="button">取消</button>
        </li>
        <li v-if="!isShowPhone"><span>电表信息</span>
          <el-table
            :data="gridData"
            border
            height="220"
            style="width: 550px;float: right;margin-left: 10px;">
            <el-table-column
              prop="date"
              label="电表信息"
              width="130">
            </el-table-column>
            <el-table-column
              prop="name"
              label="电表ＩＤ"
              width="130">
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址"
            >
            </el-table-column>
            <el-table-column
              prop="state"
              label="状态"
            >
            </el-table-column>
            <el-table-column
              prop="remarks"
              label="备注"
            >
            </el-table-column>
          </el-table>
        </li>
        <li style="margin-top: 32px;">

        </li>
      </ul>

    </div>
</template>

<script>
    export default {
        name: 'userBasic',
        data () {
            return {
              uploadUrl: this.$api.root + "/userCenter/uploadImage",
              head:'',/** 头像 */
              token:{},

              isShowPhone:false,// 是否显示保存

              target:-1,

              // form 基本信息
              formData:{
                /**昵称 */
                nickname:'',
                phone:'',
                card_id:'',// 身份证号
              },

              gridData: [],// 表格数据

              visible2: false,// 是否显示弹出框

              'xg':false,
              'ok':false,
              'ok':false,

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
              }
            }
        },
      mounted(){
        this.getUserInfo();
        this.token.Authorization = sessionStorage.getItem('accessToken')
      },
      methods:{
        // 验证身份证号
        checkIDcard(card){
          // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
          var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
          if(reg.test(card) === false)
          {
            this.$message.error('身份证输入不合法！');
            return  false;
          }
        },
        // 审核
        ToExamine(){
          if(this.formData.card_id !== undefined){
            // 去送审
            this.$api.post('userCenter/saveUserInfo',{"card_id":this.formData.card_id},(res)=>{
              if(res.status == 200){
                this.$message({
                  type: 'success',
                  message: '已送审'
                });
              }
            })
          }
        },
        // 手机号唯一性验证
        checkPhone(){
          let that = this;
          var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
          if(!this.formData.phone){
            this.$message.error('请输入手机号码！');
            this.target = 0;
          }else if(!myreg.test(this.formData.phone))
          {
            this.$message.error('请输入有效的手机号码！');
            this.target = 0;
          }
          this.$api.post('sysUser/checkPhone',{phone:this.formData.phone},(res)=>{
            if(res.status == 200){
              if(res.body.status == 0){
                this.target = 1
                this.$message.success('恭喜你，这是一条成功消息');
              }else{
                this.$message.error(res.body.msg);
                return false
              }
            }
          },res=>{
            this.$message({
              type: 'error',
              message: '请求失败，请稍后重试'
            });
          })
        },
        // 获取用户基本信息
        getUserInfo(){
            this.$api.get('userCenter/getUserInfo').then(res=>{
              if(res.body.status == 200){
                this.head = this.$api.rootImage + res.body.user.head;
                this.formData = res.body.user;
                this.gridData = res.body.userMeterList
              }
            },res=>{

            });
        },
        // 弹出是否审核框
        isOPen(){
          var layer=document.createElement("div");
          layer.id="layer";
          layer.innerHTML="已提交，请等待审核！";
          var style=
            {
              background:"#fff",
              border:"1px solid #ccc",
              color:"#333",
              position:"absolute",
              zIndex:10000,
              width:"730px",
              height:"250px",
              lineHeight:"250px",
              left:"28%",
              top:"400px",
              fontSize:"20px",
              textAlign:"center"
            }
          for(var i in style)
            layer.style[i]=style[i];
          if(document.getElementById("layer")==null)
          {
            document.body.appendChild(layer);

            setTimeout("document.body.removeChild(layer)",2000);
            this.ok=true;

          }
        },
        save() {
          this.$refs['form'].validate((valid) => {
            if (valid) {
              this.$api.post('userMeter/save',this.form,(res)=>{
                if(res.body.status == 200){
                  this.visible2 = false;
                  this.isOPen();
                  this.$refs['form'].resetFields();
                }
              },res=>{

              });
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
        // 修改昵称
        open3() {
          this.$prompt('请输入昵称', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
           // inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
            inputErrorMessage: '昵称格式不正确'
          }).then(({ value }) => {

              this.$api.post('userCenter/saveUserInfo',{"nickname":value},(res)=>{
                if(res.status == 200){
                  this.$message({
                    type: 'success',
                    message: '你的昵称是: ' + value,
                  });
                }
                this.getUserInfo();
              })

          }).catch(() => {
            this.$message({
              type: 'info',
              message: '取消输入'
            });
          });
        },
        open4() {
          this.isShowPhone = true;
          this.xg = true;
          this.formData.phone = '';
        },
        // 保存手机号
        savePhone(){
          // 验证手机号是否合法
          this.checkPhone();
          // 验证验证码是否正确
          // 不能为空
          // 入库保存
          if(this.target == 1){
            this.$api.post('userCenter/saveUserInfo',{"phone":this.formData.phone},(res)=>{
              if(res.status == 200){
                this.$message({
                  type: 'success',
                  message: '修改成功'
                });
              }
              this.isShowPhone = false;
              this.xg = false;
              this.getUserInfo();
            })
          }

        },
        /** 图片上传 **/
        handleScucess(res, file) {
          let that = this;
          that.formData.imagePath = res.imagePath;
					//console.log("上传成功：" + res.imagePath);
          that.head = that.$api.rootImage + that.formData.imagePath;

        },
        handlePreview(file) {
          console.log(file)
          const isJPG = file.type === 'image/jpeg';
          const isLt2M = file.size / 1024 / 1024 < 5;
          if(!isJPG) {
            this.$message.error('上传头像图片只能是 JPG 格式!');
          }
          if(!isLt2M) {
            this.$message.error('上传头像图片大小不能超过 2MB!');
          }
          return isJPG && isLt2M;
        },
        /** 图片上传 **/
      }
    }


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  *{
    padding:0;
    margin: 0;
    list-style: none;
  }
  .userBasic{
    margin-left: 118px;
  }
  .userBasic ul{
  }
  .userBasic ul li input{
    width: 300px;
    height: 40px;
    margin-left: 18px;
  }
  .userBasic ul li{
    margin-top: 32px;
  }
  .userBasic ul li img{
    border-radius: 50%;
    width: 50px;
    height: 50px;
    border: 1px solid #ccc;
    margin:0 10px;
  }
  .btn{
    padding: 5px;
    background-color: #079678;
    border: none;
    outline: none;
    border-radius: 6px;
    color: #fff;
    margin-left: 10px;
  }
  .btnSave,.btnRest{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
  }
  .active{
    background-color: #01595D;
    color: #fff;
  }


  .el-button--text{margin-left: 15px;color:#0aaf7e;}
  .el-button--text:hover{color:#0aaf7e;text-decoration: underline;}
  .userCenter{height: 622px;}
  .meau{height: 622px;}
  .el-popover[x-placement^=right]{
    padding: 50px;
  }
  .btdb:hover{color:#0aaf7e;;border: 1px solid #0aaf7e;}
  .btdb{color:#0aaf7e;;border: 1px solid #0aaf7e;}
  .el-table--border td, .el-table--border th{text-align: center;}
  .upload{
    float: right;
  }
</style>
