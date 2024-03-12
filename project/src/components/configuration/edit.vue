<template>
  <div>

  <el-form class="form">
    <el-select v-model="op" multiple placeholder="操作类型">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <br>
      <el-form-item>
        <el-input type="input" v-model="id"
                  auto-complete="off" placeholder="请输入需要修改的device id"></el-input><!-- 双向数据绑定 -->
      </el-form-item>
      <el-form-item>
        <el-input type="input" v-model="content"
                  auto-complete="off" placeholder="输入修改后的值"></el-input><!-- 双向数据绑定 -->
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="edit">提交</el-button>
      </el-form-item>
    <p>{{message}}</p>
  </el-form>
  </div>
</template>

<script>
export default {
  name: "edit",
  data(){
    return{
      options: [
        {
        value: "name",
        label: 'name'
      },
        {
          value:"type",
          label: 'type'
        },
        {
          value:"username",
          label: 'username'
        }],
      "op":"",
      "id":"",
      "content":"",
      message:""
    }
  },
  methods: {  //方法对象。包括本方法
    edit() {
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      //console.log(this.$store.state)  //打印state对象，观察现在state状态
      // console.log(this.op);
      // console.log(this.id);
      // console.log(this.content);
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/edit', { //发送到后端的edit接口，并传送两个参数
            "op":this.op[0],
            "id":this.id,
            "content":this.content
          })
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            if (successResponse.data.code === 200/*状态码*/) {
              this.message="修改成功"
            } else if (successResponse.data.code === 400) {
              this.message = "修改失败，找不到设备"
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