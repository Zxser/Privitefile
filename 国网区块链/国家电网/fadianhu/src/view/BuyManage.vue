<template>
    <div class="BuyManage">

   <el-form :model="ruleForm2"  ref="ruleForm2" label-width="100px" class="demo-ruleForm">

     <el-form-item label="卖家" prop="fmfldm">
       <el-select  v-model="ruleForm2.sell_meter_id"  placeholder="请选择" @change="">
         <el-option
           v-for="option in sellList"
           :key="option.id"
           :label="option.name"
           :value="option.id">
         </el-option>
       </el-select>
     </el-form-item>

	  <el-form-item label="电量" prop="num">
	    <el-input type="text" v-model="ruleForm2.num" style="width: 220px;height: 40px;"></el-input>
	  </el-form-item>
	  <el-form-item label="手机号码" prop="newpwd">
	    <el-input type="text" v-model="ruleForm2.tel" auto-complete="off"></el-input>
      <div style="position: absolute;left:100%;top:0%"><el-button class="btn" type="button" @click="validate">获取手机验证码</el-button></div>
	  </el-form-item>
	  <el-form-item label="验证码" prop="reNewpwd">
	    <el-input type="text" v-model="ruleForm2.code" auto-complete="off"></el-input>
	  </el-form-item>
	  <el-form-item style="display: flex;justify-content: flex-end">
	    <el-button class="btnSave active" type="button" @click="submitForm()">购买</el-button>
	  </el-form-item>
  </el-form>
    <!--购买成功弹窗-->
      <el-dialog
        title=""
        :visible.sync="dialogVisible"
        :modal="false"
        style="width:1700px !important;margin: 10px 0 0 -10%;"
        size="small"
        >
        <div v-if="flag">
            <!--<h3>购买成功</h3>-->
          <div>
            <div>
            <h2>资金监控</h2>
              <div style="margin-top: 10px">
                 <span>
                    山东电力公钥地址：
                   <input v-model="buy_address" disabled="readOnly" style="width: 450px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder=""></input>
                </span>
              </div>
              <div style="margin-top: 10px">
                <span>
                  天威保变公钥地址：
                  <input v-model="sell_address" disabled="readOnly" style="width: 450px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder=""></input>
                </span>
              </div>
              <div style="margin-top: 10px">
                <span>
                  交易id&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp
                  <a href="#" target="_blank" id="a" @click="href">
                    <input v-model="txid" disabled="readOnly" style="width: 500px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder="" @click="href"></input>
                  </a>
                </span>
              </div>
              <div style="margin-top: 10px">
                <span>
                  资金&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp
                  <input v-model="num" disabled="readOnly" style="width: 450px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder=""></input>
                </span>
              </div>

            </div>
            <div style="margin-top: 10px">
            <h2>物流监控</h2>
              <div>
                <div style="margin-top:10px ">
                  <span>
                    发货：
                    <input v-model="buy_meter_address" disabled="readOnly" style="width: 450px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder=""></input>
                  </span>
                </div>
                <div style="margin-top:50px ">
                  <span>
                    收货：
                    <input v-model="sell_meter_address" disabled="readOnly" style="width: 450px;background-color: #fff !important;border-color: #fff !important;border: none" placeholder=""></input>
                  </span>
                </div>
                <div style="margin-top:70px ">
                  <span>
                    安装：
                    BvN1N1HQViQ47P5Uho12SLpCbreBM6Nk
                  </span>
                </div>
              </div>
            </div>
          </div>
          <div style="float:left;margin-left:650px;margin-top: -310px">
            <el-steps :space="100" direction="vertical" :active="active">
              <el-step title="已交易"></el-step>
              <el-step title="已发货"></el-step>
              <el-step title="已收货"></el-step>
              <el-step title="已安装"></el-step>
            </el-steps>
          </div>
        </div>
        <div v-else="flag">
          <h3>购买失败</h3>
          <span>
						请您联系管理员
					</span>
        </div>
        <span slot="footer" class="dialog-footer">
    <el-button @click="closRefresh">关闭</el-button>
  </span>
  </span>
      </el-dialog>
    </div>
</template>

<script>
    export default {
        name: 'loginPwd',
        data () {


      return {
        number:1,
        active:1,
        buy_address:'',
        sell_address:'',
        txid:'',
        num:'',
        sell_meter_address:'',
        buy_meter_address:'',
        row:{
            id:'',
        },

          flag:'',
        dialogVisible: false,
        refreshId:'',
        ruleForm2: {
          tel:'',
	      code:'',
          buy_meter_id:'',
	      num:'',
          sell_meter_id:''
        },

        token:[],
        sellList:[],
        type:1,
      };

        },
      mounted(){
        let that = this;
          if (that.$route.query.buy_meter_id) {
            if (that.$route.query.buy_meter_id != 'null') {
              that.ruleForm2.buy_meter_id = that.$route.query.buy_meter_id;
            }
          }
          this.getSellList();
          this.token.Authorization = sessionStorage.getItem('accessToken')

      },
        methods:{
          getSellList(){
            let that = this;
            that.$api.get('userMeter/findByType/'+that.type).then(response => {
              if (response.status == 200) {
                that.sellList = response.body.userMeter
              }

            }, response => {

            });
          },
          href(){
//            document.getElementById("a").href="a.jsp?name="+name;
            document.getElementById("a").href="http://192.168.1.147:8080/tx/"+this.txid;
          },
          validate(){
            this.$api.get("phone/getCode/"+this.ruleForm2.tel).then(res=>{
              if(res.status == 200){
                this.$message({
                  type: 'success',
                  message: res.body.msg
                });
                this.ruleForm2.code=res.body.code;
              }
            },res=>{

            });
          },
          submitForm(){
            this.$api.post("electricitytrading/buy",this.ruleForm2,(res)=>{
                if(res.status==200){
                    this.dialogVisible = true;
                    this.flag = true;
                    this.row.id = res.body.id;
                    this.refresh();
                }
            },(res)=>{
            })
          },
          refresh(){

            this.$api.post('electricitytrading/findById',this.row,(res)=>{
              if(res.status==200){
              this.buy_address = res.body.electricitytrading.fromAddr;
              this.sell_address = res.body.electricitytrading.toAddr;
              this.txid = res.body.electricitytrading.txid;
              this.num = res.body.electricitytrading.num;
              this.buy_meter_address = res.body.electricitytrading.buyMeterAddr;
              this.sell_meter_address = res.body.electricitytrading.sellMeterAddr;
              this.active = res.body.electricitytrading.state;
              if(res.body.electricitytrading.state ==3){
                  if(res.body.electricitytrading.state ==3 && this.number ==2){
                    this.active = 4 ;
                  }
                this.number = 2;
              }
              }
            },(res)=>{
            })


              //刷新取数据
            this.refreshId = window.setTimeout(this.refresh,5000);
            console.log("1");

           },
          closRefresh(){
              window.clearTimeout(this.refreshId);
            this.dialogVisible = false;
          }
       }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .BuyManage{
    margin-left: 118px;
  }
  *{
    padding:0;
    margin: 0;
    list-style: none;
  }
  .loginPwd{
    margin-left: 118px;
    margin-top: 40px;
  }
  .loginPwd input{
    width: 300px;
    height: 40px;
    margin-left: 18px;
  }
  .form{
    line-height: 30px;
    margin-bottom: 20px;
    display: flex;justify-content: space-between
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
  .btnRest{
  	 background-color: #CCC;
  }
  .active{
    background-color: #01595D;
    color: #fff;
  }

</style>
