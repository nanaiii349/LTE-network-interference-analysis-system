<template>
  <div>
    <div class="fileway" style="text-align: center">
      <p>
        导出文件路径
        <el-input
          class="search-input"
          type="text"
          placeholder="输入文件路径"
          v-model="filepath"
          style="width: 200px; height: 20px"
        />
        <el-button @click="generate">导出</el-button>
      </p>
    </div>
    <div class="search" style="text-align: center">
      基站名称
      <el-input
        class="search-input"
        type="text"
        placeholder="输入网元"
        v-model="info.ENode"
        style="width: 200px; height: 20px"
      />
      序号
      <el-input
        class="search-input2"
        type="text"
        placeholder="序号"
        v-model="info.t"
        style="width: 200px; height: 20px"
      />
      存储路径
      <el-input
        class="search-input3"
        type="text"
        placeholder="存储路径"
        v-model="info.filename"
        style="width: 200px; height: 20px"
      />
      <el-button @click="search">查询</el-button>
    </div>
    <div class="space" style="height: 10px">
      <p></p>
    </div>
    <div class="time" style="text-align: center">
      开始时间
      <el-date-picker
        v-model="info.start"
        type="datetime"
        placeholder="选择日期时间"
        value-format="MM%2Fdd%2Fyyyy HH:mm:ss"
      >
      </el-date-picker>

      结束时间
      <el-date-picker
        v-model="info.end"
        type="datetime"
        placeholder="选择日期时间"
        value-format="MM%2Fdd%2Fyyyy HH:mm:ss"
      >
      </el-date-picker>
    </div>
    <div class="run" style="text-align: center">
      <el-button @click="painted">绘图</el-button>
    </div>
    <div
      id="picture"
      style="width: 1200px; height: 800px; text-align: center"
    ></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import searchPrb from '@/api/prb'
export default
  {
    data () {
      return {
        filepath: '',
        info: {
          ENode: '',
          t: '',
          start: '',
          end: '',
          filename: '',
          day: ''
        },
        timelist: [],
        vallist: [],
        enodeName: ''
      }
    },
    methods:
    {
      dataSearch () {
        this.getListByDay()
      },
      async initData (data) {
        //获取当前时间
        var now = new Date()
        var monthn = now.getMonth() + 1
        var yearn = now.getFullYear()
        var dayn = now.getDate()
        this.selectDay = yearn + "-" + monthn + "-" + dayn

        this.selectUser = parseInt(sessionStorage.getItem("userid"))
        this.getListByDay()
      },
      async getListByDay (data) {

      },
      generate () {
        searchPrb.generate(this.filepath)
          .then(response => {
            console.log(response)
          })
      },
      search () {
        searchPrb.searchenodeb(this.info)
          .then(response => {
            console.log(response)
            this.enodeName = response.data.data.tbprbNewList[1].enode
            for (var index = 0; index < response.data.data.tbprbNewList.length; index++) {
              this.timelist[index] = response.data.data.tbprbNewList[index].startTime
            }
            for (var index = 0; index < response.data.data.tbprbNewList.length; index++) {
              this.vallist[index] = response.data.data.tbprbNewList[index].t
            }
          })
      },
      painted () {
        // alert(this.vallist[1])
        this.chartLine = echarts.init(document.getElementById('picture'))

        // 指定图表的配置项和数据
        var option = {
          tooltip: {              //设置tip提示
            trigger: 'axis'
          },

          legend: {               //设置区分（哪条线属于什么）
            data: ['第' + this.t + '个PRB上检测到的干扰噪声的平均值 (毫瓦分贝)']
          },
          color: ['#8AE09F'],       //设置区分（每条线是什么颜色，和 legend 一一对应）
          xAxis: {                //设置x轴
            type: 'category',
            boundaryGap: false,     //坐标轴两边不留白
            data: this.timelist,
            name: 'DATE',           //X轴 name
            nameTextStyle: {        //坐标轴名称的文字样式
              color: '#FA6F53',
              fontSize: 18,
              padding: [0, 0, 0, 20]
            },
            axisLine: {             //坐标轴轴线相关设置。
              lineStyle: {
                color: '#FA6F53',
              }
            }
          },
          yAxis: {
            name: '数值',
            nameTextStyle: {
              color: '#FA6F53',
              fontSize: 18,
              padding: [0, 0, 10, 0]
            },
            axisLine: {
              lineStyle: {
                color: '#FA6F53',
              }
            },
            type: 'value'
          },
          series: [
            {

              data: this.vallist,
              type: 'line',               // 类型为折线图
              lineStyle: {                // 线条样式 => 必须使用normal属性
                normal: {
                  color: '#8AE09F',
                }
              },
            },
          ]
        }

        // 使用刚指定的配置项和数据显示图表。
        this.chartLine.setOption(option)
      },
    },
    //从后台请求的数据

  }
</script>




