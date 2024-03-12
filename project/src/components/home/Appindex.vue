<template>
  <div>
    <br>
    <h1>关于本网站</h1>
    <p class="card_head">
      欢迎来到物联网设备管理平台<br>
      在这里您将享受到更为简单的设备管理<br>
      您可以尽情使用以下功能：<br><br>
    </p>
  <div class="container1">
      <el-card class="box-card">
        <div slot="header" class="card_head">
          <span>功能列表</span>
        </div>
        <div class="card_text">
          设备配置：<br>创建或修改设备信息<br><br>
          查询统计：<br>提供设备上报数据的查询统计界面<br><br>
          设备信息：<br>提供地图界面展示设备信息，区分正常和告警信息，设备类型的历史数据可以展示成历史轨迹<br>
        </div>
      </el-card>
    <div class="container">
      <canvas id="myChart" ref="myChart" ></canvas>
      <canvas id="myChart1" ref="myChart1" ></canvas>
    </div>
  </div>
  </div>

</template>

<script >

import { Chart, BarController, LineController, LineElement, PointElement, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

//一开始只import了chart，一直提示用不了

Chart.register(LineController, LineElement, PointElement,BarController,CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);
//import { Chart, LineController, LineElement, PointElement, LinearScale, CategoryScale, Title, Tooltip, Legend } from 'chart.js';

//Chart.register(LineController, LineElement, PointElement, LinearScale, CategoryScale, Title, Tooltip, Legend);

export default {
  name: "Appindex",
  data(){
    return{
      num:[],
      messagenum:[]
  }
  },
  mounted() {//mounted 是一个生命周期钩子，它在组件的模板和DOM已经挂载（即被创建和插入到它的父节点中）完成后被调用。这个生命周期钩子是实例化过程中的一部分，通常用来执行那些依赖于DOM节点的操作，例如初始化第三方库（像 Chart.js）、操作DOM或者执行异步操作（如发起API请求）。
    this.getnum();//得到设备总量，在线总量，接受的数据量
    this.initChart();
    this.getMessageNum();
    this.initChart1();
  },
  methods: {
    getnum(){
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/queryDevice')
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            //console.log(successResponse)
            successResponse.data.forEach(item=>{
                  this.num.push(item);
                  //console.log(item);
                })
          })
          .catch(failResponse => {
              }
          );
    },
    getMessageNum(){
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/queryMessageNum')
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            console.log(successResponse)
            successResponse.data.forEach(item=>{
              this.messagenum.push(item);
              //console.log(item);
            })
          })
          .catch(failResponse => {
              }
          );
    },
    initChart() {
      console.log(this.num[0]);
      const ctx = this.$refs.myChart.getContext('2d');
      new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['设备总量', '在线总量', '接受的数据量'],
          datasets: [{
            label: '数量',
            data: this.num,
            borderWidth: 2,
            backgroundColor: 'rgba(196, 90, 101, 2)',//柱状图填充颜色
            borderColor: 'rgba(124, 24, 35, 1)', //边框颜色
          }]
        },
        options: {
          scales: {
            y: {
              type: 'linear', //指定一个轴的缩放类型，使均匀分布
              beginAtZero: true
            }
          }
        }
      });
    },
    initChart1() {
      //console.log(this.num[0]);
      const ctx = this.$refs.myChart1.getContext('2d');
      new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['上上上周','上上周', '上周', '本周'],
          datasets: [{
            label: '数量',
            data: this.messagenum,
            borderWidth: 5,
            borderColor: 'rgba(124, 24, 35, 1)', //边框颜色
          }]
        },
        options: {
          scales: {
            y: {
              type: 'linear', //指定一个轴的缩放类型，使均匀分布
              beginAtZero: true
            }
          }
        }
      });
    }
  }

}

</script>

<style>
.text {
  font-size: 14px;
  text-align: center;
}

.item {
  margin-bottom: 18px;
}
.box-card{
  background-color: transparent !important; /* 使用 !important 确保覆盖默认样式 */
  height:350px;
  width:450px;
  margin: auto 15px;
  opacity: 0.8;
  overflow: auto;
}



.card_text{
  text-align: left;
  font-size: 1.2em;
}
.card_head{
  font-size:1.5em;
  font-weight: bold;
}
.container{
  display: flex; /*把两个元素包裹在一个容器中水平排列*/
  width:900px;
  justify-content: space-between;
  height:350px;
  overflow: auto;
}
.container1{
  display: flex; /*把两个元素包裹在一个容器中水平排列*/
  justify-content: space-between;
}
#myChart{
  height:350px;
  width:300px;


}
#myChart{
  height:350px;
  width:300px;
}
</style>