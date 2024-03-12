<<template>
  <div>
  <el-form class="form">
    <el-form-item >
      <el-input type="input" v-model="id"
                auto-complete="off" placeholder="设备ID"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item>
      <el-input type="input" v-model="name"
                auto-complete="off" placeholder="设备名"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item>
      <el-input type="input" v-model="type"
                auto-complete="off" placeholder="设备类型"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item>
      <el-input type="input" v-model="username"
                auto-complete="off" placeholder="用户名"></el-input><!-- 双向数据绑定 -->
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="create">提交</el-button>
    </el-form-item>
    <p>{{message}}</p>
  </el-form>
  </div>
</template>

<script>
export default {
  name: "create",
  data(){
    return{
      id:"",
      name:"",
      type:"",
      username:"",
      message:""

    }
  },
  methods: {  //方法对象。包括本方法
    create() {
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      //console.log(this.$store.state)  //打印state对象，观察现在state状态
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/create', { //发送到后端的edit接口，并传送两个参数
            id:this.id,
            name:this.name,
            type:this.type,
            username:this.username
          })
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            if (successResponse.data.code === 200/*状态码*/) {
              this.message="新建成功"
            } else if (successResponse.data.code === 400) {
              this.message = "新建失败，设备已存在"
            }
          })

          .catch(failResponse => {
              }
          )
    }
  }
}
</script>

<style scoped>
.form {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
</style>