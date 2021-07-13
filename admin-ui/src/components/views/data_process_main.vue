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
          <el-tag style="text-align: center; font-size: 20px">数据导入</el-tag>
        </el-header>

        <el-main style="width: 800px">
          <el-table :data="tableData">
            <el-table-column
              prop="filename"
              label="表名"
              width="200"
            ></el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
              <template slot-scope="scope">
                <el-button
                  @click="handleclick(scope.$index, scope.row)"
                  type="text"
                  size="small"
                  >导入</el-button
                >
                <el-dialog
                  title="选取导入文件"
                  :visible.sync="dialogFormVisible"
                  :modal-append-to-body="false"
                  width="500px"
                  top="200px"
                >
                  <el-form :model="form" label-width="80px">
                    <input
                      id="fileinput"
                      type="file"
                      @change="getfile($event)"
                    />
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false"
                      >取 消</el-button
                    >
                    <el-button type="primary" @click="handleSet()"
                      >确 定</el-button
                    >
                  </div>
                </el-dialog>
              </template>
            </el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>



<script>
import dbApi from "@/api/database";
import "@/assets/css/sign.css";

export default {
  inject: ["reload"],
  created(){
    if(!localStorage.getItem('user')){
      this.$router.push('/login')
    }
  },
  data() {
    // request 函数 查询所有用户
    return {
      modify_info: {
        index: "",
        row: "",
      },
      // return 用户列表 格式和下面相同
      tableData: [
        {
          filename: "tbcell-controller",
        },
        {
          filename: "tbcellkpi-controller",
        },
        {
          filename: "tbprb-controller",
        },
      ],
      dialogFormVisible: false, //弹出层默认为关闭
      //弹出层中的表单
      form: {
        path: "",
      },
      file: "",
    };
  },
  methods: {
    usercontrol() {
      window.location.href = "/#/db_usercontrol";
    },
    datain() {
      window.location.href = "/#/db_main";
    },
    dataout() {
      window.location.href = "/#/db_out";
    },
    handleclick(index, row) {
      this.dialogFormVisible = true;
      this.modify_info.index = index;
      this.modify_info.row = row;
    },
    handleSet() {
      this.dialogFormVisible = false;
      console.log(this.modify_info.index);
      var formdata = new FormData();
      console.log(this.file);
      formdata.append("file", this.file);
      if (this.modify_info.index == 0) {
        //console.log(formdata);
        dbApi.datain_tbcell(formdata).then((response) => {
          console.log(response);
          if (response.data.success === true) {
            alert("导入成功");
          } else {
            alert("导入失败");
          }
        });
      } else if (this.modify_info.index == 1) {
        console.log("here");
        dbApi.datain_tbcellkpi(formdata).then((response) => {
          console.log(response);
          if (response.data.success === true) {
            alert("导入成功");
          } else {
            alert("导入失败");
          }
        });
      } else if (this.modify_info.index == 2) {
        dbApi.datain_tbprb(formdata).then((response) => {
          console.log(response);
          if (response.data.success === true) {
            alert("导入成功");
          } else {
            alert("导入失败");
          }
        });
      }
    },
    getfile(event) {
      this.file = event.target.files[0];
      //console.log(this.file);
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
