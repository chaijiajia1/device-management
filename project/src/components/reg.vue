<template>
  <body id="poster">
  <el-form class="register-container" label-position="left"
           label-width="0px">
    <h3 class="register_title">系统注册</h3>
    <el-form-item>
      <el-input type="text" v-model="registerForm.email"
                auto-complete="off" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.username"
                auto-complete="off" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="registerForm.password"
                auto-complete="off" placeholder="密码"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="registerForm.passwordRe"
                auto-complete="off" placeholder="验证密码"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="register">确认</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="$router.push('/Login')">返回登录</el-button>
    </el-form-item>
    <p>{{message}}</p>
  </el-form>
  </body>
</template>

<!--<el-card>  &lt;!&ndash; 容器标签，包含了登陆表单元素,用element的el-card美化 &ndash;&gt;-->
<!--username:<input type="text" v-model="loginForm.username" placeholder="please enter username"/>-->
<!--&lt;!&ndash; username:标签文本，显示再输入框前面的信息  input:输入框标签，创建一个输入框元素  v-model:Vue.js指令，实现双向数据绑定 placeholder:占位符，输入前的提示 &ndash;&gt;-->
<!--<br><br>  &lt;!&ndash; 换行 &ndash;&gt;-->
<!--password:<input type="password" v-model="loginForm.password" placeholder="please enter password"/>-->
<!--<br><br>-->
<!--<button v-on:click="login">login</button>  &lt;!&ndash; 监听click事件，调用 login方法 &ndash;&gt;-->

<!--</el-card>-->

<script>
export default {  //导出组件对象
  name: "reg",
  data() { //数据对象，包括登录对象和结果对象
    return {
      registerForm: {
        email:'',
        username: '',
        password: '',
        passwordRe:''
      },
      //responseResult: [],
      message:''
    }
  },
  methods: {  //方法对象。包括login方法
    register() {
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      console.log(this.$store.state)  //打印state对象，观察现在state状态
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/register', { //发送到后端的login接口，并传送两个参数
            "user":{email:this.registerForm.email,
            username: this.registerForm.username,
            password: this.registerForm.password},
            passwordRe:this.registerForm.passwordRe
          })
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            if (successResponse.data.code === 200/*状态码*/) {
              this.$router.replace('/login')//路径或者是根目录，则重定向到/index路径
              //this.$router.replace({path: '/index'})  //用Vue.js的router方法跳转到/index路由
            }
            else if(successResponse.data.code===400){
              this.message='邮箱格式不正确'
            }
            else if(successResponse.data.code===401){
              this.message='邮箱已存在'
            }
            else if(successResponse.data.code===402){
              this.message='用户名需要六位以上'
            }
            else if(successResponse.data.code===403){
              this.message='用户名已存在'
            }
            else if(successResponse.data.code===404){
              this.message='密码需要六位以上'
            }
            else if(successResponse.data.code===405){
              this.message='密码错误'
            }
            else{
              this.message='注册成功!'
            }
          })

          .catch(failResponse => {}
          )
    }
  }
}
</script>


<style>
.register-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.register_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
#poster {
  background: url("../assets/1.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: 0px;
}
</style>