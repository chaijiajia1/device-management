const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    proxy: {
      '/api': {
        target: 'localhost:8443',//这里填入你要请求的接口的前缀
        changeOrigin:true,//虚拟的站点需要更管origin
        pathRewrite:{
          '^/api':''//重写路径
        }
      }
    }
  }
})

