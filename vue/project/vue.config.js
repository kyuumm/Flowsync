module.exports = {
  devServer: {
    port: 8080, // 保持你当前的前端端口
    proxy: {
      // 匹配所有以 /api 开头的请求
      '/api': {
        target: 'http://localhost:8888', // 转发到后端 8888 端口
        changeOrigin: true,              // 允许跨域
        pathRewrite: {
          '^/api': ''  // 关键：把请求路径里的 /api 前缀去掉
        }
      }
    }
  }
}