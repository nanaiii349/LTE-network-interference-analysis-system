
<template>
    
  <div class="main">
        
    <div class="title">      <a class="active">管理员登录界面</a>     </div>
    <div class="sign-up-container">
            <el-form ref="userForm" :model="user">
                <el-form-item class="input-prepend restyle" prop="mobile">
                    
          <div>
                        <el-input
              type="text"
              placeholder="账户名"
              v-model="user.username"
            />
                        <i class="iconfont icon-phone" />           
          </div>
                  </el-form-item
        >

                <el-form-item
          class="input-prepend"
          prop="password"
          :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]"
        >
                    
          <div>
                        <el-input
              type="password"
              placeholder="密码"
              v-model="user.password"
            />
                        <i class="iconfont icon-password" />           
          </div>
                  </el-form-item
        >

          <el-row>
          <el-button-group
            >         
            <el-button align="left" class="btn1">
                        <input
                type="button"
                class="sign-in-button"
                value="登录"
                @click="submitLogin()"
              />
                      
            </el-button>
          </el-button-group>
            </el-row
        >
              </el-form
      >
  </div>
   
         
  <div> <a href="http://101.200.171.172:10000/nacos/#/login" title="百度一下" target="_blank" class='link'>系统管理</a></div>
            
          
      
  </div>
</template>

<script>
import "@/assets/css/sign.css";
//import "~/assets/css/iconfont.css";

import cookie from "js-cookie";
import loginApi from "@/api/database";
//import regApi from "@/api/reg"

export default {
  layout: "sign",

  data() {
    return {
      user: {
        username: "",
        password: "",
      }, //用户信息
      loginInfo: {},
      regInfo: {},
    };
  },
  mounted() {
    this.getCookie();
  },
  methods: {
    //登录的方法
    submitLogin() {
      loginApi.login(this.user).then((response) => {
        console.log(response);
        //console.log(Object.values(response.data)[0]);
        if (Object.values(response.data)[0] === true) {
          this.loginInfo = response.data.data.user;
          this.setCookie(this.user.username, this.user.password, 7);
          //cookie.set("guli_ucenter", "Done", { domain: "localhost" }); // TODO 将用户信息导入cookie // console.log('&&&&&&&&&&&&&&' + this.loginInfo) // console.log('************Done..........' + cookie.get('guli_ucenter')) // 跳转页面
          //alert("登录成功");
          localStorage.setItem('user', this.user.username);
          console.log(this.$route);
          if (this.$route.query.redirect) {
            let redirect = decodeURIComponent(this.$route.query.redirect);
            this.$router.push(redirect);
          } else {
            this.$router.push("/db_usercontrol");
          }
          //console.log(redirect)
          //this.$router.push({path:redirect})
          //window.location.href = '/#/db_usercontrol'
        } else {
          alert("登录失败");
        }
      });
    },

    setCookie(c_name, c_pwd, exdays) {
      var exdate = new Date(); //获取时间
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
      //字符串拼接cookie
      window.document.cookie =
        "username" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString();
      window.document.cookie =
        "password" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString();
      //window.document.cookie.setCookie(c_name,c_pwd,exdays,true);
    },
    getCookie: function () {
      if (document.cookie.length > 0) {
        console.log(document.cookie);
        var arr = document.cookie.split("; ");
        console.log(arr);
        for (var i = 0; i < arr.length; i++) {
          var arr2 = arr[i].split("="); //再次切割
          //判断查找相对应的值
          if (arr2[0] == "username") {
            this.user.username = arr2[1];
          } else if (arr2[0] == "password") {
            this.user.password = arr2[1];
          }
        }
      }
    },
    clearCookie: function () {
      this.setCookie("", "", -1); //修改2值都为空，天数为负1天就好了
    },
  },
};
</script>

<style>
/* .el-form-item__error  {
    z-index: 9999999;
} */
.btn1 {
  text-align: center;
}
.btn2 {
  text-align: center;
}
.title {
  margin-top: -100px;
  font-size: 10;
}
</style>