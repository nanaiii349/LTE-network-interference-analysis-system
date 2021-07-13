<template>
  <div class="main">
    <el-container style="height: 700px; border: 1px solid #eee">
      <el-aside
        width="300px"
        style="background-color: rgb(238, 241, 246); margin-left: 0px"
      >
        <el-menu :default-openeds="[]">
          <el-menu-item-group style="background-color: rgb(238, 241, 246)">
            <el-button type="primary" icon="el-icon-edit" @click="usercontrol()"
              >用户管理</el-button
            >
          </el-menu-item-group>
          <el-menu-item-group style="background-color: rgb(238, 241, 246)">
            <el-button type="primary" icon="el-icon-edit" @click="datain()"
              >数据导入</el-button
            >
          </el-menu-item-group>
          <el-menu-item-group style="background-color: rgb(238, 241, 246)">
            <el-button type="primary" icon="el-icon-edit" @click="dataout()"
              >数据导出</el-button
            >
          </el-menu-item-group>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header
          style="text-align: center; font-size: 12px; background-color: #b3c0d1"
        >
          <el-tag style="text-align: center; font-size: 20px">用户管理</el-tag>
        </el-header>

        <el-main style="width: 800px">
          <el-table :data="tableData" style="width: 800px" max-height="800">
            <el-table-column fixed prop="phone" label="手机号" width="300">
            </el-table-column>
            <el-table-column prop="id" label="ID" width="300">
            </el-table-column>
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
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>



<script>
import dbApi from "@/api/database"

export default {
  // layout: '@/components/layout/side',
  inject: ["reload"],
  created () {
    //console.log("here");
    if (!localStorage.getItem('user')) {
      this.$router.push('/login')
    }
    else {
      dbApi.getNewcustomer().then((response) => {
        //console.log("here");
        console.log(response)
        response.data.data.aclCustomerList.forEach((item, index) => {
          var single = new Object()
          single.phone = item.mobile
          single.id = item.id
          this.tableData.push(single)
        })
      })

    }
  },
  data () {
    // request 函数 查询所有用户
    return {
      tableData: [],
      input: "",
    }
  },
  methods: {
    usercontrol () {
      window.location.href = "/#/db_usercontrol"
    },
    datain () {
      window.location.href = "/#/db_main"
    },
    dataout () {
      window.location.href = "/#/db_out"
    },
    assign_right (index, row) {
      //localStorage.removeItem('user')
      console.log(row)
      dbApi.assign_right(row.id).then((response) => {
        console.log(response)
        if (response.data.success === true) {
          alert("授权成功")
          this.reload()
        } else {
          aleret("授权失败")
        }
      })
    },
  },
};
</script>


<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
