<template>
  <div class="hello">
    <div>
      <el-card class="box-card">
        <!--<div v-for="o in 3" class="text item">
          {{'列表内容 ' + o }}
        </div>-->
        <div class="text item">用户量 <span>123456</span></div>
        <div class="text item">总积分 <span>123456</span></div>
        <div class="text item">总发电量 <span>123456</span></div>
      </el-card>
    </div>
    <div id="main" style="margin:0 auto; width:800px;height:600px;" ></div>

  </div>
</template>

<script>
  export default {
    name: 'hello',
    data() {
      return {
        currentIdx: 0,
        oldIdx:-1,
        option:{},
        chart : null
      }
    },
    methods: {
      draw() {
        let that = this;
        that.chart = echarts.init(document.getElementById('main'));
        that.chart.on('click', function (params) {
//          alert("aa");
          //console.log(params)
        });
        that.chart.setOption({

          tooltip : {
            formatter: '{b}',

          },
          dataRange: {
            min: 1000,
            max: 10000,
            color:['#153a3c','#01585d','#04b385'],
            // 文本，默认为数值文本
            calculable : false,
            x:"right",
            textStyle:{
              fontSize:12,
              fontWeight:'bolder',
              color:'#000'
            }

          },
          legend: {
            orient: 'vertcail',
            x:'left',
            data:[
              {
                name:'市区',
                textStyle:{
                  fontSize:12,
                  fontWeight:'bolder',
                  color:'#000'
                }
              }
            ]
          },
          calculable : true,
          series : [
            {
              name: '市区',
              type: 'map',
              mapType:  '上海',
              hoverable: false,
              selectedMode : 'single',
              itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:false}},
              },

              // roam: true, //地图拖拽  缩放
              data:[
                {name: '崇明县',value: 2266},
                {name: '宝山区',value: 2832},
                {name: '嘉定区',value: 3336},
                {name: '青浦区',value: 1500},
                {name: '杨浦区',value: 7557},
                {name: '虹口区',value: 1075},
                {name: '闸北区',value: 1183},
                {name: '普陀区',value: 2113},
                {name: '静安区',value: 4876},
                {name: '黄浦区',value: 1972},
                {name: '卢湾区',value: 4412},
                {name: '长宁区',value: 2808},
                {name: '徐汇区',value: 1884},
                {name: '浦东新区',value: 2345},
                {name: '松江区',value: 1245},
                {name: '闵行区',value: 1235},
                {name: '金山区',value: 3456},
                {name: '奉贤区',value: 1245},
                {name: '南汇区',value: 4567}
              ],
            }
          ]
        });
      }
    },
    mounted() {
      this.$nextTick(function() {
        this.draw();
      });
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 8px 0;
  }

  .box-card {
    width: 200px;
    float: left;
    margin-left: 50px;
    margin-top: 50px;
  }
</style>
