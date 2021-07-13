<template>
  <div>
    <div class="users">
        <div id="1" style="height:40px;">
          <p style="font-size: 1.35rem;">删除用户</p>
        </div>
        <div id="2">
          <el-table
            :data="tableData"
            style="width: 100%"
            max-height="250">
            <el-table-column
            fixed
            prop="phone"
            label="手机号"
            width="150">
            </el-table-column>
            <el-table-column
            prop="password"
            label="密码"
            width="120">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            width="120">
            <template slot-scope="scope">
                <el-button
                @click.native.prevent="delete(scope.$index, tableData)"
                type="text"
                size="small">
                移除
                </el-button>
            </template>
            </el-table-column>
          </el-table>
        </div>
        <div id="3" style="height:40px;">
          <p style="font-size: 1.35rem;">授权用户</p>
        </div>
        <div id="4">
          <el-table
            :data="tableData1"
            style="width: 100%"
            max-height="250">
            <el-table-column
            fixed
            prop="phone"
            label="手机号"
            width="150">
            </el-table-column>
            <el-table-column
            prop="password"
            label="密码"
            width="120">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            width="120">
            <template slot-scope="scope">
                <el-button
                @click.native.prevent="delete(scope.$index, tableData1)"
                type="text"
                size="small">
                授权
                </el-button>
            </template>
            </el-table-column>
          </el-table>
        </div>
    </div>
    <div class="time" style="text-align:center">
      <p style="font-size: 1.35rem;">允许使用时长为<el-input type="number" style="width:200px;height:60px" v-model="input"></el-input>分钟</p>
    </div>
  </div>
</template>

<script>
  export default {
    methods: {
      // delete(index,rows){
      //   rows.delete(index)
      // },
      deleteRow(index, rows) {
        rows.splice(index, 1);
      }
    },
    data() {
      return {
        tableData: [{
          phone: '2016-05-03',
          password: '王小虎',
          
        },
        {
          phone: '2016-05-03',
          password: '王小虎',
          
        }],
        tableData1: [{
          phone: '2016-05-03',
          password: '王小虎',
          
        },
        {
          phone: '2016-05-03',
          password: '王小虎',
          
        }],
        input:'',
      }
    }
  }
</script>