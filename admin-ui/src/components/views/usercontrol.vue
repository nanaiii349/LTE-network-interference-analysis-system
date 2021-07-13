<template>
  <div>
    <div class="users">
      <div id="1" style="height: 120px">
        <p style="font-size: 2rem; margin-left: -20px">授权用户</p>
      </div>
      <div id="2">
        <el-table :data="tableData" style="width: 800px" max-height="500">
          <el-table-column fixed prop="phone" label="手机号" width="300">
          </el-table-column>
          <el-table-column prop="id" label="ID" width="300"> </el-table-column>
          <el-table-column fixed="right" label="操作" width="120">
            <template slot-scope="scope">
              <el-button
                @click="assign_right(scope.index, scope.row)"
                type="text"
                size="small"
              >
                授权
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import dbApi from '@/api/database'
//import { observable } from 'vue/types/umd';

export default {
  created () {
    //console.log("here");
    dbApi.getNewcustomer().then(
      (response) => {
        //console.log("here");
        console.log(response)
        response.data.data.aclCustomerList.forEach(
          (item, index) => {
            var single = new Object()
            single.phone = item.mobile
            single.id = item.id
            this.tableData.push(single)
          })
      }
    )
  },
  inject: ['reload'],
  methods: {
    assign_right (index, row) {
      console.log(row)
      dbApi.assign_right(row.id).then(
        (response) => {
          console.log(response)
          if (response.data.success === true) {
            alert("授权成功")
            this.reload()
          }
          else {
            aleret("授权失败")
          }
        }
      )

    }
  },
  data () {
    return {
      tableData: [],
      input: '',
    }
  }
}
</script>