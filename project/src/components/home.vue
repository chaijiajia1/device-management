<template>
  <body id="poster">
      <el-menu
          :default-active="'/index'"
          router
          mode="horizontal"
          background-color=#e3b4b8
          text-color="#222"
          active-text-color="red"
          style="min-width: 1300px">
        <el-menu-item class="nav_text" v-for="(item,i) in navList" :key="i" :index="item.name">
          {{ item.navItem }}
        </el-menu-item>

        <span style="position: absolute;padding-top: 10px;right: 30%;font-size: 1.5em;font-weight: bold">物联网设备管理——方便你我生活</span>
        <el-menu-item class="nav_text" index="/logout" @click="handleLogout">登出</el-menu-item>
      </el-menu>
      <router-view/>
    </body>
</template>

<script>
export default {
  name: "home",
  data () {
    return {
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/configuration', navItem: '设备配置'},
        {name: '/statistics', navItem: '查询统计'},
        {name: '/equipment', navItem: '设备信息'}
      ]
    }
  },
  methods:{
      handleLogout() {
        // 你的登出逻辑，例如清除用户数据、调用API等
        this.$store.commit('logout');
        this.$router.push('/login');
      }

  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}

#poster {
  background: url("../assets/background.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
  //opacity:0.8;
}
.nav_text{
  font-size: 1.5em;
}
</style>

