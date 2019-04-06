<template>
  <div class="contract">
    <div class="cMe_title">
      <div class="cleft">
        <div class="left"></div>
        <span class="l"></span>
      </div>
      <span class="title">每日上网电量</span>
      <div class="cright">
        <span class="r"></span>
        <div class="right"></div>
      </div>
    </div>
    <span class="r-text" id="xx" @click="faDianLiang"><a href="javascript:;">上网电量明细查询</a></span>
    <div class="hello">
      <div id="main2" style="width: 100%;height:400px;"></div>
    </div>
  </div>
</template>

<script>
  import echarts from 'echarts';
  import {getPreMonth, getNextMonth} from '../common/Date';
  export default {
    name: 'hello',
    data() {
      return {
        // 修改
        editDate:{
          nowDate:'',
          oldDate:'',
        },
        // 时间
        parameterDate:{
          newDate:'',
        },
        // 传参时间
        parameterData:{
          startDate:'',
          endDate:'',
        },
        xAxisData:[],
        seriesData:[],
      }
    },
    methods: {
      // 第一次加载请求数据，展示echarts
      getEeacher(obj){
//        this.$api.post('trafficElectricity/getByMonth',obj,(res)=>{
//          if (res.body.num == '') {
//          //alert(this.editDate.nowDate);
//          let nowDate = this.editDate.oldDate;
//          let oldDate = getPreMonth(nowDate);
//          let longOldDate = getPreMonth(oldDate);
//
//          //alert(nowDate+'----'+oldDate)
//          this.getEeacher({startDate: oldDate, endDate: longOldDate});
//          nowDate = oldDate;
//          oldDate = longOldDate;
//          this.editDate.oldDate = longOldDate;
//        }else{
//          if (res.body.month.split(',').length <= 1) {
//            this.parameterData.endDate = this.xAxisData[0];
//          } else {
//            this.xAxisData = res.body.month.split(',');
//          }
//          if (res.body.month.split(',').length <= 1) {
//            this.parameterData.startDate = this.xAxisData[this.xAxisData.length - 1];
//          } else {
//            this.seriesData = res.body.num.split(',');
//          }
//          this.draw();
//        }
//        },function (res) {
//        });
      },
      // 发电量明细
      faDianLiang(){
        this.$router.push({path:'/Header/ElectricityDetails',query:{isShowMeau:1,searchSign:2}});
      },
      // 获取当前时间日期
      getDate(){
        let Dates = new Date();
        let nowDate = Dates.getFullYear()+"-"+(Dates.getMonth()+1)+"-"+Dates.getDate();
        let oldDate = Dates.getFullYear()+"-"+(Dates.getMonth()+1)+"-"+(Dates.getDate()-1);
        this.parameterDate.newDate = nowDate;
        this.editDate.nowDate = nowDate;
        this.editDate.oldDate = oldDate;
      },
      getOption() {
        let _this = this;
        return {
          graphic: [{
            id: 'left-btn',
            type: 'image',
            style: {
              image: this.$api.rootImage+'/map.png',
              width: 20,
              height: 260,
              opacity: 1
            },
            left:159,
            bottom:64,
            onclick: function() {
              _this.parameterData.endDate = _this.xAxisData[0];
              _this.getEeacher(_this.parameterData);
            }
          }, {
            id: 'right-btn',
            type: 'image',
            style: {
              image: this.$api.rootImage+'/map.png',
              width: 20,
              height: 260,
              opacity: 1
            },
            bottom:64,
            right: 134,
            onclick: function() {
              _this.parameterData.startDate = _this.xAxisData[_this.xAxisData.length-1];
              _this.getEeacher(_this.parameterData);
            }
          }],
          series: []
        };
      },
      draw() {
        let that = this;
        that.chart = echarts.init(document.getElementById('main2'));
        that.chart.setOption(that.getOption());
        that.chart.setOption({
          tooltip : {
            trigger: 'axis',
            formatter: "{a}为 : {c}千瓦",
            axisPointer: {
              type: 'cross',
              label: {
                backgroundColor: '#6a7985'
              }
            }
          },
          legend: {
            data: ['今日发电量']
          },

          grid: {
            bottom: '12%',
            containLabel: true
          },
          xAxis: [
            {
              type: 'category',
              axisLabel: {
                interval: 0,
                rotate: 60
              },
              data:this.xAxisData
            }],
          yAxis: [{
            name:'千瓦',
            type: 'value'
          }],
          series: [{
            name: '今日发电量',
            type: 'line',
            label: {
              normal: {
                show: true,
                position: 'top'
              }
            },
            itemStyle: {
              normal: {
                color:'#0aaf7e'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: that.seriesData
          }]
        })
      }
    },
    mounted() {
      let that = this;
      this.getDate();
      this.getEeacher(this.parameterData);
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .xian{

  }
  .contract{
    padding-bottom: 30px;
    background-color: #f3f9f9;
  }
  .cMe_content{
    width: 1200px;
    margin: 0 auto;
  }
  .cMe_title{
    height:25px;
    clear: both;
    width: 1200px;
    margin: 0 auto;
    margin-bottom: 30px;
  }
  .cleft,.cright{
    display: inline-block;
  }
  .left,.right{
    display: inline-block;
    width:488px;
    height: 2px;
  }
  .left{
    float:left ;
    background-image:linear-gradient(to right,#FFF,#0BB07E);
  }
  .right{
    float:right ;
    background-image:linear-gradient(to left,#FFF,#0BB07E);
  }
  .l,.r{
    width: 4px;
    height:4px;
    border-radius: 50%;
    background-color:#0BB07E ;
    margin-top: -1px;
  }
  .l{
    float:right ;
  }
  .r{
    float:left ;
  }
  .title{
    font-size: 25px;
    margin:0 28px;
  }
  .r-text{display:block;
    padding: 5px 10px;
    display: flex;
    justify-content: flex-end;
    /*background-color: #02676F;*/
    color: #02676F;
    /*float: right;*/
    margin-right: 10%;
    font-size: 12px;
  }
</style>
