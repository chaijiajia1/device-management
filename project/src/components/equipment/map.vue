<script>
import L from 'leaflet'
import 'leaflet/dist/leaflet.css'
import icon from 'leaflet/dist/images/marker-icon.png';
import iconShadow from 'leaflet/dist/images/marker-shadow.png';
let DefaultIcon = L.icon({
  iconUrl: icon,
  shadowUrl: iconShadow
});
L.Marker.prototype.options.icon = DefaultIcon;
export default {
  data(){
    return {
      device:[],
      "id":"",
      jsonList:[],
      map:null,
      points:[]
    }

  },
  mounted() {
    this.map = L.map('map').setView([34.341574, 108.93977], 4) // 设定一个默认的视图，这里是中国的大致中心点。

    L.tileLayer('https://webst{s}.is.autonavi.com/appmaptile?style=7&x={x}&y={y}&z={z}&key=59bb314f571ae17e64f6fa07a515b2e6', {
      maxZoom: 18,
      minZoom: 1,
      subdomains: ['01', '02', '03', '04'],  // 高德地图的子域名
      attribution: '© OpenStreetMap contributors & © AMap'
    }).addTo(this.map);
     // var marker = L.marker([120.0,30.0]).addTo(this.map);
     // marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();


  },
  methods: {
    GetDeviceAddr() {
      var _this = this;  //将当前的实例赋给_this,以便回调函数使用this（this的指向会改变）
      //console.log(this.$store.state)  //打印state对象，观察现在state状态
      //console.log("111");
      this.$axios  // $axios方法发送post请求到服务器（HTTP请求）
          .post('/querymessage', {"id": this.id})
          .then(successResponse => {  //请求成功的回调函数，服务器返回成功时执行， successResponse是成功响应对象
            this.device = []
            //console.log(successResponse.data);
            successResponse.data.forEach(item => {
              //console.log(item); // This will log each item in the 'result' array.
              this.device.push(item)
              var jsonObject = JSON.parse(item)//解析为json
              this.jsonList.push(jsonObject)
              this.points.push({
                latLng: [jsonObject.location.latitude, jsonObject.location.longitude],
                timestamp: jsonObject.timestamp
              });//用于后续的排序和画历史轨迹
              var marker=L.marker([jsonObject.location.latitude,jsonObject.location.longitude]).addTo(this.map);
              marker.bindPopup("<b>device:"+this.id+"</b></br>status:"+jsonObject.status+"<br>").openPopup();
              // console.log("item:" )
              // console.log(item)
              // console.log("jsonObject:");
               //console.log(jsonObject.location.longitude);//longitude是经度
              // 按时间戳排序轨迹点
              this.points.sort((a, b) => new Date(a.timestamp) - new Date(b.timestamp));

              // 从排序后的轨迹点中提取经纬度坐标
              var sortedLatLngs = this.points.map(point => point.latLng);

              // 绘制轨迹
              var polyline = L.polyline(sortedLatLngs, {color: 'red'}).addTo(this.map);
              //this.map.fitBounds(polyline.getBounds());
            });

          })
          .catch(failResponse => {
              }
          );
    }
  }
}
</script>

<template>
  <div id="map">

    <el-form class="form">
      <el-form-item>
        <el-input type="input" v-model="id"
                  auto-complete="off" placeholder="请输入需要查看的device id"></el-input><!-- 双向数据绑定 -->
      </el-form-item>
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="GetDeviceAddr">查看设备</el-button>

    </el-form>


  </div>
</template>

<style scoped>
#map  {
  height: 100vh;
  width: 100vw;
  z-index: -1;
  position:absolute;
}
.form{
  z-index: 9999;
  position: relative;
}
</style>
