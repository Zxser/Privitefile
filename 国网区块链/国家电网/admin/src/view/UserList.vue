<template>
  <div class="UserList">
   <div class="u_box">
   	<div class="tab">
   		<ul>
   			<li ><a href="javascript:;" @click="changeTab('0')">发电户</a></li>
   			<li><a href="javascript:;" @click="changeTab('1')">国网用户</a></li>
   			<li><a href="javascript:;" @click="changeTab('2')">系统管理员</a></li>
   		</ul>
   	</div>
     <!--列表-->
   	<div class="tabCont">
       <div id="cont0" class="cont0">
          <el-table
            :data="personList"
            border
            height="300"
            style="width:80%;">
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
              width="200"
            >
            </el-table-column>
            <el-table-column
              prop="createTime"
              label="创建时间"
              align="center"
            >
            </el-table-column>
          </el-table>
       </div>
       <div id="cont1" class="cont1">
          <el-table
            :data="countryList"
            border
            height="300"
            style="width:80%;">
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
              width="200"
            >
            </el-table-column>
            <el-table-column
              prop="createTime"
              label="创建时间"
              align="center"
            >
            </el-table-column>
          </el-table>
       </div>
       <div id="cont2" class="cont2">
          <el-table
            :data="managerList"
            border
            height="300"
            style="width:80%;">
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
              prop="createTime"
              label="创建时间"
              align="center"
            >
            </el-table-column>
             <el-table-column
					      fixed="right"
					      label="操作"
					      align="center"
					      width="120">
					      <template scope="scope">
					        <el-button
					          @click.native.prevent="deleteRow(scope.$index, managerList)"
					          type="text"
					          size="small">
					                       移除
					        </el-button>
					      </template>
            </el-table-column>
          </el-table>
       </div>
   	</div>

   </div>
  </div>
</template>

<script>
export default{
	name:'',
	data(){
		return{
			personList:[],
			countryList:[],
			managerList:[]
		}
	},
	 mounted(){
     this.getPersonlist();
     this.getCountrylist();
     this.getManagerlist();
   },
	methods:{
		getPersonlist(){
			 this.$api.post('sysuser/getUserList',{"type":0},(res)=>{
		          	if(res.status == 200){
		              this.personList=res.body.page.list;
		          	}
		      	});
		},
		getCountrylist(){
			 this.$api.post('sysuser/getUserList',{"type":1},(res)=>{
		          	if(res.status == 200){
		              this.countryList=res.body.page.list;
		          	}
		      	});
		},
		getManagerlist(){
			 this.$api.post('SysUserManage/getList',{},(res)=>{
		          	if(res.status == 200){
		              this.managerList=res.body.page.list;
		          	}
		      	});
		},
	changeTab(tabCon_num){
  for(var i=0;i<3;i++) {
   document.getElementById("cont"+i).style.display="none"; //将所有的层都隐藏
   }
   document.getElementById("cont"+tabCon_num).style.display="block";//显示当前层
 },
 deleteRow(index, rows) {
        rows.splice(index, 1);
      }

	}
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.UserList{
	width: 800px;
	height: 530px;
	margin: 0 auto;
	text-align: center;
}
.u_box{
	margin-top:30px;
	margin-left: 20px;
}
ul{
	overflow: hidden;
}
li{
	float: left;
	list-style: none;
}
a{
	text-decoration: none;
	font-size: 16px;
	font-weight: bold;
	color: #068964;
	display: inline-block;
	width:200px ;
	height:40px ;
	line-height: 40px;
	text-align: center;
	border: 1px solid #CCC;
}
a:hover{
	background-color: #068964;
	border: 1px solid #068964;
	color: #FFF;
}
.active{
  background-color: #068964;
  border: 1px solid #068964;
  color: #FFF;
}
.tabCont{
	margin-top: 30px;
	clear: both;
}
#cont1,#cont2{
	display: none;
}
 table {
    border: 1px solid #ccc;
    text-align: center;
    font-size: 12px;
  }
  thead{
  	 background-color: #F4F4F4;
  }
  table td, table th {
    border: 1px solid #ccc;
    height: 30px;
    width: 260px;
  }
</style>
