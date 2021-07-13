<template>
    <div>
        <div class="list">
            <el-table
                ref="multipleTable"
                :data="json_data"
                tooltip-effect="dark"
                style="width: 100%"
                @selection-change="handleSelectionChange">
                <el-table-column
                type="selection"
                width="55">
                </el-table-column>
                <el-table-column
                prop="name"
                label="表名"
                width="120">
                </el-table-column>
            </el-table>
        </div>
        
        <div class="download">
          <download-excel class = "export-excel-wrapper"
            :data = "json_data"    
            :fields = "json_fields"
            name = "远程诊断报告导出.xls">
            <el-button type="primary" style="width:160px">导出excel表格</el-button>
            <el-button @click="toggleSelection()" style="width:160px">取消选择</el-button>
          </download-excel>
          
        </div>
    </div>
</template>

<script>
  
  export default {
    data() {
      return {
        json_fields: 
      {
     //设置列的title，可使用常规字段也可以使用嵌套属性
       "故障时间": "faultTime",
       "故障原因": "faultReason",
       "维修日期": "faultRepair",
       "维修员": "faultWorker",
       //自定义回调函数
       "状态": {
         field: "faultState",
         callback: value => {
           if(value === true){
           return `已处理`}
           else{
           	return `未处理`}
         }}
     },
     json_data: [
       {
         faultTime: "2020-01-01 12:12:12",
         name: "压缩机故障1",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "张三",
         faultState: false,
       },
       {
         faultTime: "2020-02-01 12:12:12",
         name: "压缩机故障2",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "李四",
         faultState: true,
       },
       {
         faultTime: "2020-01-04 12:13:12",
         name: "压缩机故障3",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "王五",
         faultState: true,
       },
       {
         faultTime: "2020-11-01 12:12:12",
         name: "压缩机故障4",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "小六",
         faultState: false,
       },
       {
         faultTime: "2020-04-03 22:12:12",
         name: "压缩机故障5",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "阿七",
         faultState: false,
       },
       {
         faultTime: "2020-05-05 12:02:12",
         name: "压缩机故障6",
         faultRepair: "2020-01-02 15:00:00",
         faultWorker: "老八",
         faultState: true,
       },
     ],
        multipleSelection: []
      }
    },

    methods: {
      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
    }
  }
</script>

