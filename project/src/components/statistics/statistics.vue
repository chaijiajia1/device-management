<template>
  <div>
    <el-form class="form" label-position="left">
      <el-form-item >
        <el-input type="input" v-model="id"
                  auto-complete="off" placeholder="请输入需要查询的device id"></el-input><!-- 双向数据绑定 -->
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="querymessage">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table class="table"
        :data="DeviceData"
        stripe
        >
      <el-table-column prop="timestamp" label="时间" width="180">
      </el-table-column>
      <el-table-column prop="location.latitude" label="经度" width="180">
      </el-table-column>
      <el-table-column prop="location.longitude" label="纬度" width="180">
      </el-table-column>
      <el-table-column prop="status" label="信息类型" width="180">
      </el-table-column>
      <el-table-column prop="data" label="信息内容" width="180">
      </el-table-column>
      <el-table-column prop="active" label="设备是否活跃" width="180">
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
export default {
  name: "statistics",
  data(){
    return {
      id:"",
      DeviceData:[],
      cnt:""
    }
  },
  methods: {  //方法对象。包括本方法
    querymessage() {
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      //console.log(this.$store.state)  //打印state对象，观察现在state状态
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/querymessage', //发送到后端的edit接口，并传送两个参数
              {"id": this.id}
          )
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            this.DeviceData=[];
            successResponse.data.forEach(item => {
              //console.log(item); // This will log each item in the 'result' array.
              var jsonObject = JSON.parse(item)//解析为json
              this.DeviceData.push(jsonObject);
            });

            // Or if you want to store the result in your Vue data:
            console.log(this.DeviceData);
          })
          .catch(failResponse => {
              }
          )}
    }
}
</script>

<style>

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

.table {
  border-radius: 15px;
  margin: auto auto ;
  padding: 35px 35px 15px 35px;
  opacity: 90;
}
</style>