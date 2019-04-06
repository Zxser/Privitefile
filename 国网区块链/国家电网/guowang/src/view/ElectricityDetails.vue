<template>
  <!--发电量明细-->
  <div>

   <div v-if="searchSign !== 1" class="ElectricityDetailss">
     <div class="backIndex">首页》<span style="color: #058675">{{name}}明细表查询</span></div>
     <div class="content">
       <span class="bgRight" style="width: 44.5%"></span>
       <span style="padding:0 10px">{{name}}明细查询</span>
       <span class="bgLeft"></span>
     </div>
    <div class="InternetContent">
      <a class="mingxi" href="javascript:;">点击电表进入相应的明细信息</a>
      <table class="InternetElet" border="1" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>电表信息</th>
            <th>电表ID</th>
            <th>地址</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><span @click="desc">电表1</span></td>
            <td>A</td>
            <td>上海市宝山区</td>
          </tr>
          <tr>
            <td>电表2</td>
            <td>B</td>
            <td>上海市浦东新区</td>
          </tr>
        </tbody>
      </table>
    </div>
   </div>

    <div v-else class="ElectricityDetails">
        <div class="backIndex">首页》<span style="color: #058675">{{name}}明细表查询</span></div>
        <div class="content">
          <span class="bgRight"></span>
          <span style="padding:0 10px">{{name}}明细查询</span>
          <span class="bgLeft"></span>
        </div>

        <div class="searchTerm">
          <div>
            <span>年</span>
            <el-select v-model="value" placeholder="请选择">
              <el-option
                v-for="(item,index) in options"
                :label="item.label"
                :value="item.value"
                :key="item.index">
              </el-option>
            </el-select>
            <span>月</span>
            <el-select v-model="value2" placeholder="请选择">
              <el-option
                v-for="(item,index) in options2"
                :label="item.label"
                :value="item.value"
                :key="item.index">
              </el-option>
            </el-select>
            <button class="btnSave active" type="button" @click="timeSearch">查询</button>

            <span>自定义</span>
            <el-date-picker
              v-model="value6"
              type="daterange"
              placeholder="选择日期范围">
            </el-date-picker>
            <button class="btnSave active" type="button" @click="customizeSearch">查询</button>
          </div>
          <div style="margin-left: 30px">
            <el-button>打印</el-button>
            <el-button>导出</el-button>
          </div>
        </div>

        <div class="tableContent Price">
          <el-table
            :data="tableData"
            border
            style="width:80%;text-align: center;">
            <el-table-column
              prop="create_date"
              label="日期"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="num"
              :label="name"
              align="center"
            >
            </el-table-column>

          </el-table>
        </div>

        <div class="backIndex">
          <router-link style="color: #058675" to="">返回</router-link>
        </div>
      </div>

  </div>
</template>

<script>

 export default {
// 	  name:'',
    data() {
      return {
      	name:this.tableHead(),
searchSign:-1,      	tableData:[],
        options: [{
          value: '2017',
          label: '2017'
        }, {
          value: '2016',
          label: '2016'
        }, {
          value: '2015',
          label: '2015'
        }, {
          value: '2014',
          label: '2014'
        }, {
          value: '2013',
          label: '2013'
        }],
         options2: [{
          value: '1',
          label: '1'
        }, {
          value: '2',
          label: '2'
        }, {
          value: '3',
          label: '3'
        }, {
          value: '4',
          label: '4'
        }, {
          value: '5',
          label: '5'
        },
         {
          value: '6',
          label: '6'
        },
         {
          value: '7',
          label: '7'
        },
          {
          value: '8',
          label: '8'
        }, {
          value: '9',
          label: '9'
        }, {
          value: '10',
          label: '10'
        }, {
          value: '11',
          label: '11'
        },
        {
          value: '12',
          label: '12'
        }
        ],
         	value: '',
          value2:'',
          value6:''
      }
    },
   mounted(){
      this.searchSign = this.$route.query.searchSign
   },
     methods:{
 	      // 点击查看详细信息
       desc(){
         this.searchSign = 1;
       },
        tableHead(){
        	var interKey=this.$route.query.searchSign;
        	var headArr=["发电量","积分","上网电量"];
        	return headArr[interKey];
        },
        interfaceArr(){
        	var interKey=this.$route.query.searchSign;
         	//接口集合  发电量/积分/上网电量
         	var interArr=["productionElectricity/getDate","Integral/getDate","trafficElectricity/getDate"];
         	return interArr[interKey];
         },
        	timeSearch(){
        	//清除自定义查询
        	this.value6=[];
        	//请求数据 	
        	var interKey=this.$route.query.searchSign;	
        	this.$api.post(this.interfaceArr(),{"year":this.value,"month":this.value2},(res)=>{
          	if(res.status == 200){
          		console.log(res)
          //数据渲染
              this.tableData=res.body.bean;
          	}
      	  })
        	},
        	customizeSearch(){
        		 this.value="";
        		 this.value2="";
					   var startDate=this.formatDate(this.value6[0]);
					   var endDate=this.formatDate(this.value6[1]);
					   
		        this.$api.post(this.interfaceArr(),{"startDate":startDate,"endDate":endDate},(res)=>{
		          	if(res.status == 200){
		          		console.log(res)
		              this.tableData=res.body.bean;
		          	}
		      	 })
        	},
        	formatTen(num){
        		return num > 9 ? (num + "") : ("0" + num);
        	},
        	formatDate(date){
        		var year = date.getFullYear();
            var month = date.getMonth() + 1;
						var day = date.getDate();
						return year + "-" + this.formatTen(month) + "-" + this.formatTen(day);
        	}
        }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .ElectricityDetailss{
    margin-bottom: 30px;
    margin-top:150px;
  }
  .ElectricityDetails{
    margin-bottom: 30px;
    margin-top:150px;
  }
  .content{
    display: flex;
    text-align: center;
    vertical-align: middle;
    margin: 30px auto;
  }
  .bgRight{
    background-image:linear-gradient(to left,#0aaf7e,#fff);
    width: 45%;
    height:2px;
    margin-top:10px;
  }
  .bgLeft{
    background-image:linear-gradient(to right,#0aaf7e,#fff);
    width: 45%;
    height:2px;
    margin-top:10px;
  }
  .btnSave{
    width: 80px;
    height: 30px;
    border: none;
    outline: none;
  }
  .active{
    background-color: #01595D;
    color: #fff;
  }
  .searchTerm{
    display: flex;
    justify-content:flex-start;
    width: 90%;
    margin: 0 auto;
  }
  .searchTerm select{
    width: 72px;
    height: 20px;
  }
  .searchTerm span{
    color: #09AE7D;
    font-family: MicrosoftYaHei;
  }
    table {
    border: 1px solid #09ae7d;
    text-align: center;
    font-size: 12px;
  }
  table td,th {
    border: 1px solid #ccc;
    height: 45px;
  }
  .tableContent{
    display: flex;
    justify-content: center;
    align-content: center;
    margin-top: 20px;
  }
  table th, td{
    height: 40px;
  }
  thead{
    background-color: #abe3d3;
  }
  thead th{
    width: 174px;
  }
  .Price thead th{
    width: 600px;
  }
  .backIndex{
    display: flex;
    justify-content: flex-start;
    margin-left: 4%;
    margin-top: 18px;
  }

  /****0413 by秋月****/
  .InternetContent{
    width: 84.5%;
    margin: 0 auto;
  }
.mingxi{
  text-decoration: none;
  font-size: 12px;
  color:#0aaf7e;
}
  .InternetElet{
    width: 100%;
    margin-top: 10px;
    border: 0px;
    border-collapse: collapse;
  }
  .InternetElet td,.InternetElet th{height: 50px;border: 1px solid #ccc;}
  .InternetElet th{background-color: #f0f8f6;}
</style>
