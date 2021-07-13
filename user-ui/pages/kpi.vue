<template>
    <div>
        <div class="in" style="text-align:center">
          <el-input v-model="info.input1" placeholder="小区名称" style="width:400px;height:80px">
            </el-input>
            <el-input v-model="info.fileway1" placeholder="文件路径" style="width:400px;height:80px" type="text">
            </el-input>
          <el-button @click="submitinfo" style="width:70px;height:40px">查询</el-button>
        </div><!--输入和查询按钮-->
        <div class="time" style="text-align:center">
          <p>开始时间
          <el-date-picker
          id="1" 
          v-model="info.start" 
          type="date" 
          placeholder="选择日" 
          @change="dataSearch" 
          value-format="MM%2Fdd%2Fyyyy">
          </el-date-picker>
          结束时间
          <el-date-picker
          id="2" 
          v-model="info.end" 
          type="date" 
          placeholder="选择日" 
          @change="dataSearch" 
          value-format="MM%2Fdd%2Fyyyy">
          </el-date-picker>
          </p>
        </div>
        <div class="list" style="text-align:center">
          <el-table
            ref="singleTable"
            :data="tableData"
            highlight-current-row
            @current-change="handleCurrentChange"
            style="width: 100%">
            <el-table-column type="expand">
              <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand">
                  <el-form-item label="起始时间：">
                  <span>{{ props.row.startTime }}</span>
                  </el-form-item>
                  <el-form-item label="网元/基站名称：">
                  <span>{{ props.row.nodeName }}</span>
                  </el-form-item>
                  <el-form-item label="小区：">
                  <span>{{ props.row.sector }}</span>
                  </el-form-item>
                  <el-form-item label="小区名称：">
                  <span>{{ props.row.sectorName }}</span>
                  </el-form-item>
                  <el-form-item label="RRC连接建立完成次数 (无)：">
                  <span>{{ props.row.rrcConnectTimes }}</span>
                  </el-form-item>
                  <el-form-item label="RRC连接请求次数（包括重发） (无)：">
                  <span>{{ props.row.rrcConnectRequestTimes }}</span>
                  </el-form-item>
                  <el-form-item label="RRC建立成功率qf (%)：">
                  <span>{{ props.row.rrcConSucRate }}</span>
                  </el-form-item>
                  <el-form-item label="E-RAB建立成功总次数 (无)：">
                  <span>{{props.row.e_rabConSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="E-RAB建立尝试总次数 (无)：">
                  <span>{{props.row.e_rabConTryTimes}}</span>
                  </el-form-item>
                  <el-form-item label="E-RAB建立成功率2 (%)：">
                  <span>{{props.row.e_rabConSucRate2}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB触发的E-RAB异常释放总次数 (无)：">
                  <span>{{props.row.enodebE_rabWrongTimes}}</span>
                  </el-form-item>
                  <el-form-item label="小区切换出E-RAB异常释放总次数 (无)：">
                  <span>{{props.row.sectorSwitchE_rabWrongTimes}}</span>
                  </el-form-item>
                  <el-form-item label="E-RAB掉线率(新) (%)：">
                  <span>{{props.row.e_rabOutlineRate}}</span>
                  </el-form-item>
                  <el-form-item label="无线接通率ay (%)：">
                  <span>{{props.row.wirelessConRate}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB发起的S1 RESET导致的UE Context释放次数 (无)：">
                  <span>{{props.row.enodeb2S1_resetUe_contextTimes}}</span>
                  </el-form-item>
                  <el-form-item label="UE Context异常释放次数 (无)：">
                  <span>{{props.row.ue_contextWrongTimes}}</span>
                  </el-form-item>
                  <el-form-item label="UE Context建立成功总次数 (无)：">
                  <span>{{props.row.ue_contextConSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="无线掉线率 (%)：">
                  <span>{{props.row.wirelessOutlineRate}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB内异频切换出成功次数 (无):">
                  <span>{{props.row.enodebInDifSwiSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB内异频切换出尝试次数 (无)：">
                  <span>{{props.row.enodebInDifSwiTryTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB内同频切换出成功次数 (无)：">
                  <span>{{props.row.enodebInSameSwiSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB内同频切换出尝试次数 (无)：">
                  <span>{{props.row.enodebInSameSwiTryTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB间异频切换出成功次数 (无)：">
                  <span>{{props.row.enodebAmoDifSwiSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB间异频切换出尝试次数 (无)：">
                  <span>{{props.row.enodebAmoDifSwiTryTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB间同频切换出成功次数 (无)：">
                  <span>{{props.row.enodebAmoSameSwiSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNodeB间同频切换出尝试次数 (无)：">
                  <span>{{props.row.enodebAmoSameSwiTryTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNB内切换成功率 (%)：">
                  <span>{{props.row.enbInSwiSucRate}}</span>
                  </el-form-item>
                  <el-form-item label="eNB间切换成功率 (%)：">
                  <span>{{props.row.enbAmonSwiSucRate}}</span>
                  </el-form-item>
                  <el-form-item label="同频切换成功率zsp (%)：">
                  <span>{{props.row.sameSwiSucRateZsp}}</span>
                  </el-form-item>
                  <el-form-item label="异频切换成功率zsp (%)：">
                  <span>{{props.row.difSwiSucRateZsp}}</span>
                  </el-form-item>
                  <el-form-item label="切换成功率 (%)：">
                  <span>{{props.row.switchSucRate}}</span>
                  </el-form-item>
                  <el-form-item label="小区PDCP层所接收到的上行数据的总吞吐量 (比特)：">
                  <span>{{props.row.pdcpUpThroughput}}</span>
                  </el-form-item>
                  <el-form-item label="小区PDCP层所发送的下行数据的总吞吐量 (比特)：">
                  <span>{{props.row.pdcpDownThroughput}}</span>
                  </el-form-item>
                  <el-form-item label="RRC重建请求次数 (无)：">
                  <span>{{props.row.rrcReconTimes}}</span>
                  </el-form-item>
                  <el-form-item label="RRC连接重建比率 (%)：">
                  <span>{{props.row.rrcReconRate}}</span>
                  </el-form-item>
                  <el-form-item label="通过重建回源小区的eNodeB间同频切换出执行成功次数 (无)：">
                  <span>{{props.row.byEnodebAmonSameExeSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="通过重建回源小区的eNodeB间异频切换出执行成功次数 (无)：">
                  <span>{{props.row.byEnodebAmonDifExeSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="通过重建回源小区的eNodeB内同频切换出执行成功次数 (无)：">
                  <span>{{props.row.byEnodebInSameExeSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="通过重建回源小区的eNodeB内异频切换出执行成功次数 (无)：">
                  <span>{{props.row.byEnodebInDifExeSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNB内切换出成功次数 (次)：">
                  <span>{{props.row.enbInSucTimes}}</span>
                  </el-form-item>
                  <el-form-item label="eNB内切换出请求次数 (次)：">
                  <span>{{props.row.enbInReqTimes}}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column
              type="index"
              label="序号"
              width="300"
            >
            </el-table-column>
            <el-table-column
              property="sectorName"
              label="小区名称"
              width="600">
            </el-table-column>
          </el-table>

          
        </div>
        <!-- <div class="paint" style="text-align:center">
          属性一
          <el-input v-model="attribute" placeholder="属性名" style="width:240px;height:80px"></el-input>
          属性二
          <el-input v-model="attribute2" placeholder="属性名" style="width:240px;height:80px"></el-input>
          <el-button @click="painted">画图</el-button>
        </div> -->
        <div class="box" style="text-align:center">
          <el-select v-model="val" multiple placeholder="请选择">
            <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            />
          </el-select>
          <el-button @click="painted">画图</el-button>
        </div>
        <div id="picture" style="width:1200px;height:800px;text-align:center">
          
        </div>
        
    </div>
</template>

<script>
  import * as echarts from 'echarts'
  import searchApi from '@/api/kpi'
  export default {
    data() {
      return {
        info:{
          start:'',
          end:'',
          input1:'',
          fileway1:''
        },
        dataget:[],
        tableData: [],
        daylist:[],
        vallist:[],
        vallist2:[],
        currentRow: null,
        // attribute:'',
        // attribute2:'',
        options: [{
          value: 'RRC连接建立完成次数',
          label: 'RRC连接建立完成次数'
        }, {
          value: 'RRC连接请求次数',
          label: 'RRC连接请求次数'
        }, {
          value: 'RRC建立成功率',
          label: 'RRC建立成功率'
        }, {
          value: '无线接通率ay',
          label: '无线接通率ay'
        }, {
          value: '无线掉线率',
          label: '无线掉线率'
        }],
        val:['RRC连接建立完成次数','RRC连接请求次数']
      };
    },
    methods:{
      // test(){
      //   for(var index=0;index<this.val.length;index++)
      //   {
      //     alert(index)
      //     alert(this.val[index])
      //   }
      // },
       setCurrent(row) {
        this.$refs.singleTable.setCurrentRow(row);
      },
      handleCurrentChange(val) {
        this.currentRow = val;
      },
      submitinfo(){
        this.info.start+=' 00%3A00%3A00'
        this.info.end+=' 00%3A00%3A00'
        searchApi.searchkpi(this.info)
          .then(response=>{
            console.log(response)
            this.tableData=response.data.data.rows
          })
      },
      dataSearch() {
      this.getListByDay();
      },
      async initData(data) {
      //获取当前时间
      var now   = new Date();
      var monthn = now.getMonth()+1;
      var yearn  = now.getFullYear();
      var dayn = now.getDate();
      this.selectDay = monthn+"/"+dayn+"/"+yearn;

      this.selectUser = parseInt(sessionStorage.getItem("userid"));
      this.getListByDay();
      },
      async getListByDay(data) {

      },
      painted()
      {
        this.getx()
        if(this.val.length==1)
        {
          this.gety(this.val[0])
        }
        if(this.val.length==2)
        {
          this.gety(this.val[0])
          this.gety2(this.val[1])
        }
        this.chartLine = echarts.init(document.getElementById('picture'));
  
        // 指定图表的配置项和数据
        var option = {
          tooltip: {              //设置tip提示
            trigger: 'axis'
          },
              
          legend: {               //设置区分（哪条线属于什么）
            data:[this.val[0],this.val[1]]
          },
          color: ['#8AE09F','rgb(209, 17, 17)'],       //设置区分（每条线是什么颜色，和 legend 一一对应）
          xAxis: {                //设置x轴
            type: 'category',
            boundaryGap: false,     //坐标轴两边不留白
            data: this.daylist,
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
            name: '属性',
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
              name: this.val[0],
              data:  this.vallist,
              type: 'line',               // 类型为折线图
              lineStyle: {                // 线条样式 => 必须使用normal属性
                normal: {
                  color: '#8AE09F',
                }
              },
            },
            {
              name: this.val[1],
              data:  this.vallist2,
              type: 'line',               // 类型为折线图
              lineStyle: {                // 线条样式 => 必须使用normal属性
                normal: {
                  color: 'rgb(209, 17, 17)',
                }
              },
            }
          ]
        };
  
          // 使用刚指定的配置项和数据显示图表。
        this.chartLine.setOption(option);
      },
      getx(){
        for(var index=0;index<this.tableData.length;index++)
        {
          this.daylist[index]=this.tableData[index].startTime
        }
      },
      gety(name){
        if(name == 'RRC连接建立完成次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].rrcConnectTimes
          }
        }
        else if(name == 'RRC连接请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].rrcConnectRequestTimes
          }
        }
        else if(name == 'RRC建立成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].rrcConSucRate
          }
        }
        else if(name == 'E-RAB建立成功总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].e_rabConSucTimes
          }
        }
        else if(name == 'E-RAB建立尝试总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].e_rabConTryTimes
          }
        }
        else if(name == 'E-RAB建立成功率2')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].e_rabConSucRate2
          }
        }
        else if(name == 'eNodeB触发的E-RAB异常释放总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebE_rabWrongTimes
          }
        }
        else if(name == '小区切换出E-RAB异常释放总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].sectorSwitchE_rabWrongTimes
          }
        }
        else if(name == 'E-RAB掉线率(新)')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].e_rabOutlineRate
          }
        }
        else if(name == '无线接通率ay')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].wirelessConRate
          }
        }
        else if(name == 'eNodeB发起的S1 RESET导致的UE Context释放次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodeb2S1_resetUe_contextTimes
          }
        }
        else if(name == 'UE Context异常释放次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].ue_contextWrongTimes
          }
        }
        else if(name == 'UE Context建立成功总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].ue_contextConSucTimes
          }
        }
        else if(name == '无线掉线率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].wirelessOutlineRate
          }
        }
        else if(name == 'eNodeB内异频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebInDifSwiSucTimes
          }
        }
        else if(name == 'eNodeB内异频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebInDifSwiTryTimes
          }
        }
        else if(name == 'eNodeB内同频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebInSameSwiSucTimes
          }
        }
        else if(name == 'eNodeB内同频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebInSameSwiTryTimes
          }
        }
        else if(name == 'eNodeB间异频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebAmoDifSwiSucTimes
          }
        }
        else if(name == 'eNodeB间异频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebAmoDifSwiTryTimes
          }
        }
        else if(name == 'eNodeB间同频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebAmoSameSwiSucTimes
          }
        }
        else if(name == 'eNodeB间同频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enodebAmoSameSwiTryTimes
          }
        }
        else if(name == 'eNB内切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enbInSwiSucRate
          }
        }
        else if(name == 'eNB间切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enbAmonSwiSucRate
          }
        }
        else if(name == '同频切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].sameSwiSucRateZsp
          }
        }
        else if(name == '异频切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].difSwiSucRateZsp
          }
        }
        else if(name == '切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].switchSucRate
          }
        }
        else if(name == '小区PDCP层所接收到的上行数据的总吞吐量')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].pdcpUpThroughput
          }
        }
        else if(name == '小区PDCP层所发送的下行数据的总吞吐量')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].pdcpDownThroughput
          }
        }
        else if(name == 'RRC重建请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].rrcReconTimes
          }
        }
        else if(name == 'RRC连接重建比率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].rrcReconRate
          }
        }
        else if(name == '通过重建回源小区的eNodeB间同频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].byEnodebAmonSameExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB间异频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].byEnodebAmonDifExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB内同频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].byEnodebInSameExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB内异频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].byEnodebInDifExeSucTimes
          }
        }
        else if(name == 'eNB内切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enbInSucTimes
          }
        }
        else if(name == 'eNB内切换出请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist[index]=this.tableData[index].enbInReqTimes
          }
        }
        else
        {
            alert("没有该属性，请检查输入")
        }
      },
      gety2(name){
        if(name == 'RRC连接建立完成次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].rrcConnectTimes
          }
        }
        else if(name == 'RRC连接请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].rrcConnectRequestTimes
          }
        }
        else if(name == 'RRC建立成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].rrcConSucRate
          }
        }
        else if(name == 'E-RAB建立成功总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].e_rabConSucTimes
          }
        }
        else if(name == 'E-RAB建立尝试总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].e_rabConTryTimes
          }
        }
        else if(name == 'E-RAB建立成功率2')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].e_rabConSucRate2
          }
        }
        else if(name == 'eNodeB触发的E-RAB异常释放总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebE_rabWrongTimes
          }
        }
        else if(name == '小区切换出E-RAB异常释放总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].sectorSwitchE_rabWrongTimes
          }
        }
        else if(name == 'E-RAB掉线率(新)')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].e_rabOutlineRate
          }
        }
        else if(name == '无线接通率ay')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].wirelessConRate
          }
        }
        else if(name == 'eNodeB发起的S1 RESET导致的UE Context释放次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodeb2S1_resetUe_contextTimes
          }
        }
        else if(name == 'UE Context异常释放次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].ue_contextWrongTimes
          }
        }
        else if(name == 'UE Context建立成功总次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].ue_contextConSucTimes
          }
        }
        else if(name == '无线掉线率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].wirelessOutlineRate
          }
        }
        else if(name == 'eNodeB内异频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebInDifSwiSucTimes
          }
        }
        else if(name == 'eNodeB内异频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebInDifSwiTryTimes
          }
        }
        else if(name == 'eNodeB内同频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebInSameSwiSucTimes
          }
        }
        else if(name == 'eNodeB内同频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebInSameSwiTryTimes
          }
        }
        else if(name == 'eNodeB间异频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebAmoDifSwiSucTimes
          }
        }
        else if(name == 'eNodeB间异频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebAmoDifSwiTryTimes
          }
        }
        else if(name == 'eNodeB间同频切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebAmoSameSwiSucTimes
          }
        }
        else if(name == 'eNodeB间同频切换出尝试次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enodebAmoSameSwiTryTimes
          }
        }
        else if(name == 'eNB内切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enbInSwiSucRate
          }
        }
        else if(name == 'eNB间切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enbAmonSwiSucRate
          }
        }
        else if(name == '同频切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].sameSwiSucRateZsp
          }
        }
        else if(name == '异频切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].difSwiSucRateZsp
          }
        }
        else if(name == '切换成功率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].switchSucRate
          }
        }
        else if(name == '小区PDCP层所接收到的上行数据的总吞吐量')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].pdcpUpThroughput
          }
        }
        else if(name == '小区PDCP层所发送的下行数据的总吞吐量')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].pdcpDownThroughput
          }
        }
        else if(name == 'RRC重建请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].rrcReconTimes
          }
        }
        else if(name == 'RRC连接重建比率')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].rrcReconRate
          }
        }
        else if(name == '通过重建回源小区的eNodeB间同频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].byEnodebAmonSameExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB间异频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].byEnodebAmonDifExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB内同频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].byEnodebInSameExeSucTimes
          }
        }
        else if(name == '通过重建回源小区的eNodeB内异频切换出执行成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].byEnodebInDifExeSucTimes
          }
        }
        else if(name == 'eNB内切换出成功次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enbInSucTimes
          }
        }
        else if(name == 'eNB内切换出请求次数')
        {
          for(var index=0;index<this.tableData.length;index++)
          {
            this.vallist2[index]=this.tableData[index].enbInReqTimes
          }
        }
        else
        {
            alert("没有该属性，请检查输入")
        }
      }
    }
  }
</script>

<style>
.main{
  color: rgb(209, 17, 17);
}
</style>

