<template>
  <div class="main">
    <el-container>
      <el-header style="text-align: center; font-size: 12px">
        <el-tag style="text-align: center; font-size: 20px"
          >用户设置阈值</el-tag
        >
      </el-header>
      <el-main>
        <el-form :model="input">
          <el-form-item style="text-align: center">
            <el-input
              v-model="input.x"
              style="width: 200px"
              placeholder="输入x   (格式：x%)"
            >
            </el-input>
            <el-button @click="handleclick()">生成</el-button>
            <el-dialog
              title="重叠覆盖干扰小区三元组分析"
              :visible.sync="checkDialog"
              width="30%"
              center
              @close="closeclick()"
            >
              <el-table :data="tableData" width="100%" v-loading="loading">
                <el-table-column
                  prop="A"
                  label="A小区"
                  width="130"
                ></el-table-column>
                <el-table-column
                  prop="B"
                  label="B小区"
                  width="130"
                ></el-table-column>
                <el-table-column
                  prop="C"
                  label="C小区"
                  width="120"
                ></el-table-column>
              </el-table>
            </el-dialog>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import dbApi from '@/api/data_analyse'

export default {
  data () {
    return {
      input: {
        x: "",
      },
      tableData: [],
      checkDialog: false,
      loading: true
    }
  },
  methods: {
    handleclick () {
      this.checkDialog = true
      dbApi.getc2i_3(this.input.x).then(
        (response) => {
          console.log(response)
          if (response.data.success === true) {
            response.data.data.tbc2i3List.forEach((item, index) => {
              var single = new Object()
              single.A = item.cella
              single.B = item.cellb
              single.C = item.cellc
              this.tableData.push(single)
            })
            this.loading = false
          }
          else {
            alert("数据分析失败")
          }
        }
      )
    },
    closeclick () {
      this.tableData.length = 0
      this.loading = true
    }
  },
};
</script>