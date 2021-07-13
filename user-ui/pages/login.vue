<template>
  <div class="main">
    <!-- <div class="title">
      <a class="active" href="/login">登录</a>
      <span>·</span>
      <a href="/register">注册</a>
    </div> -->

    <div class="sign-up-container">
      <el-form ref="userForm" :model="user">
        <el-form-item
          class="input-prepend restyle"
          prop="mobile"
          :rules="[
            { required: true, message: '请输入手机号码', trigger: 'blur' },
            { validator: checkPhone, trigger: 'blur' },
          ]"
        >
          <div>
            <el-input type="text" placeholder="手机号" v-model="user.mobile" />
            <i class="iconfont icon-phone" />
          </div>
        </el-form-item>

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
        </el-form-item>

        <div class="btn">
          <input
            type="button"
            class="sign-in-button"
            value="登录"
            @click="submitLogin()"
          />
        </div>
      </el-form>
      <!-- 更多登录方式 -->
      <!-- <div class="more-sign">
        <h6>社交帐号登录</h6>
        <ul>
          <li>
            <a
              id="weixin"
              class="weixin"
              target="_blank"
              href="http://qy.free.idcfengye.com/api/ucenter/weixinLogin/login"
              ><i class="iconfont icon-weixin"
            /></a>
          </li>
          <li>
            <a id="qq" class="qq" target="_blank" href="#"
              ><i class="iconfont icon-qq"
            /></a>
          </li>
        </ul>
      </div> -->
    </div>
  </div>
</template>

<script>
import '~/assets/css/sign.css'
import '~/assets/css/iconfont.css'

import cookie from 'js-cookie'
import loginApi from '@/api/login'

export default {
  layout: 'sign',
  mounted () {
    this.getCookie()
  },
  data () {
    return {
      //封装登录手机号和密码对象
      user: {
        mobile: '',
        password: ''
      },
      //用户信息
      loginInfo: {}
    }
  },

  methods: {
    //登录的方法
    submitLogin () {
      //第一步 调用接口进行登录，返回token字符串
      loginApi.submitLoginUser(this.user)
        .then(response => {
          console.log(response.data.success)
          if (response.data.success === false) {
            alert("登陆失败")
          }
          else {
            console.log("DONE\n\n")
            // cookie.set('guli_token', response.data.data.aclCustomer, { domain: 'localhost' })
            // window.location.href = "/"
            // cookie.set('guli_token', response.data.data.token, { domain: 'localhost' })
            // window.location.href = "/"
            //第四步 调用接口 根据token获取用户信息，为了首页面显示
            alert(this.user.mobile + "登录")
            // cookie.set('guli_ucenter', this.user.mobile, { domain: 'localhost' })
            this.setCookie(this.user.mobile, this.user.password, 7)
            localStorage.setItem('user', this.user.mobile)

            //跳转页面
            window.location.href = "/"
            // loginApi.getLoginUserInfo()
            //   .then(response => {
            //     // this.loginInfo = response.data.data.userInfo
            //     //获取返回用户信息，放到cookie里面
            //   })
          }
        })
    },
    checkPhone (rule, value, callback) {
      //debugger
      if (!(/^1[123456789]\d{9}$/.test(value))) {
        return callback(new Error('手机号码格式不正确'))
      }
      return callback()
    },
    setCookie (c_name, c_pwd, exdays) {
      var exdate = new Date() //获取时间
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays) //保存的天数
      //字符串拼接cookie
      window.document.cookie =
        "username" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString()
      window.document.cookie =
        "password" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString()
      //window.document.cookie.setCookie(c_name,c_pwd,exdays,true);
    },
    getCookie: function () {
      if (document.cookie.length > 0) {
        console.log(document.cookie)
        var arr = document.cookie.split("; ")
        console.log(arr)
        for (var i = 0; i < arr.length; i++) {
          var arr2 = arr[i].split("=") //再次切割
          //判断查找相对应的值
          if (arr2[0] == "username") {
            this.user.username = arr2[1]
          } else if (arr2[0] == "password") {
            this.user.password = arr2[1]
          }
        }
      }
    },
    clearCookie: function () {
      this.setCookie("", "", -1) //修改2值都为空，天数为负1天就好了
    },
  }
}
</script>
<style>
.el-form-item__error {
  z-index: 9999999;
}
</style>