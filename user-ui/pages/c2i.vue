<template>
  
    <el-container>
        <el-header style="text-align: center; font-size: 12px">
        <el-tag style="text-align: center; font-size: 20px"
          >输入参数</el-tag
        >
      </el-header>
      <el-main>
        <el-form :model="input" >
          <el-form-item   style="text-align: center" >
            <el-input placeholder="请输入servingSector" v-model="input.s_id" style="width: 200px" ></el-input>
          </el-form-item>
          <el-form-item  style="text-align: center">
            <el-input placeholder="请输入InterferingSector" v-model="input.i_id" style="width: 200px"></el-input>
          </el-form-item>
          <el-button
            style="margin-left:720px"
            type="primary"
            size="small"
            @click="handleclick()"
            >查询</el-button
          >
          <el-dialog
            title="C2I干扰分析结果"
            :visible.sync="checkDialog"
            width="30%"
            center
          >
            <el-form :model="form">
              <el-form-item
                label="servingSector:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.servingSector }}
              </el-form-item>
              <el-form-item
                label="interferingSecor:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.interferingSecor }}
              </el-form-item>
              <el-form-item
                label="平均值:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.avg }}
              </el-form-item>
              <el-form-item
                label="标准差:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.std }}
              </el-form-item>
              <el-form-item
                label="prbABS6:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.prbABS6 }}
              </el-form-item>
              <el-form-item
                label="prbC2I9:"
                label-width="130px"
                style="text-align: center"
              >
                {{ this.form.prbC2I9 }}
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="checkDialog = false">取 消</el-button>
              <el-button type="primary" @click="checkDialog = false"
                >确 定</el-button
              >
            </div>
          </el-dialog>
        </el-form>
        <el-divider></el-divider>
      </el-main>
    </el-container>
</template>



<script>
import dbApi from "@/api/data_analyse";

export default {
  data() {
    return {
      checkDialog: false,
      input: {
        s_id: "",
        i_id: "",
      },
      form: {
        servingSector: "",
        interferingSecor: "",
        std: "",
        avg: "",
        prbABS6: "",
        prbC2I9: "",
      },
    };
  },
  methods: {
    handleclick() {
      this.checkDialog = true;
      dbApi.getc2i(this.input).then((response) => {
        console.log(response);
        if (response.data.success === true) {
          this.form.servingSector = response.data.data.tbc2inew.scell;
          this.form.interferingSecor = response.data.data.tbc2inew.ncell;
          this.form.std = response.data.data.tbc2inew.std;
          this.form.avg = response.data.data.tbc2inew.avg;
          this.form.prbABS6 = response.data.data.tbc2inew.prbABS6;
          this.form.prbC2I9 = response.data.data.tbc2inew.prbC2I9;
        } else {
          alert("查询失败");
        }
      });
    },
  },
};
</script>

