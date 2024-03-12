
<template>
  <body id ="poster">
<!--    <el-select v-model="op" multiple placeholder="操作类型">-->
<!--      <el-option-->
<!--          v-for="item in options"-->
<!--          :key="item.value"-->
<!--          :label="item.label"-->
<!--          :value="item.value">-->
<!--      </el-option>-->

<!--    </el-select>-->
<!--    <el-form-item>-->
<!--      <el-input type="device id" v-model="device_id"-->
<!--                auto-complete="off" placeholder=op==“edit”?"请输入修改后的设备号":"请输入要新建的设备号"></el-input>&lt;!&ndash; 双向数据绑定 &ndash;&gt;-->
<!--    </el-form-item>-->
<!--    <el-form-item>-->
<!--      <el-input type="name" v-model="name"-->
<!--                auto-complete="off" placeholder="none essential"></el-input>&lt;!&ndash; 双向数据绑定 &ndash;&gt;-->
<!--    </el-form-item>-->
<!--    <el-form-item>-->
<!--      <el-input type="type" v-model="type"-->
<!--                auto-complete="off" placeholder="none essential"></el-input>&lt;!&ndash; 双向数据绑定 &ndash;&gt;-->
<!--    </el-form-item>-->
<!--    <el-form-item style="width: 100%">-->
<!--      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="configuration">submit</el-button>-->
<!--    </el-form-item>-->
    <el-menu
        :default-active="'/configuration'"
        router
        mode="horizontal"
        background-color=#e3b4b8
        text-color="#222"
        active-text-color="red"
        style="min-width: 1300px">
      <el-menu-item class="nav_text" v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
    </el-menu>
    <router-view/>
  </body>
</template>

<script>
export default {
  data() {
    return {
      navList: [
        {name: '/configuration/edit', navItem: '修改信息'},
        {name: '/configuration/create', navItem: '新建设备'}
      ]
    //   op:"",
    //   device_id:"",
    //   name:"",
    //   type:"",
    //   message:""
    }
  },
  // methods: {  //方法对象。包括本方法
  //   configuration() {
  //     var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
  //     //console.log(this.$store.state)  //打印state对象，观察现在state状态
  //     this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
  //         .post('/configuration', { //发送到后端的login接口，并传送两个参数
  //           op: this.op,
  //           device_id: this.device_id,
  //           name:this.name,
  //           type:this.type
  //         })
  //         .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
  //           if (successResponse.data.code === 200/*状态码*/) {
  //             this.message=(op==edit)?"edit successful":"create successful"
  //           } else if (successResponse.data.code === 400) {
  //             this.message = "can't find the device to edit"
  //           } else if(successResponse.data.code === 401){
  //             this.message = "device id exist"
  //           }
  //         })
  //
  //         .catch(failResponse => {
  //             }
  //         )
  //   }
  // }
}
</script>
<style scoped>

</style>