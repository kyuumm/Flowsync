<template>
  <div class="login-container">
    <div class="login-box">
      <div class="logo">FlowSync</div>
      <div class="title">智能任务编排与协同执行平台</div>

      <div class="form-item">
        <label>用户名</label>
        <input type="text" v-model="username">
      </div>

      <div class="form-item">
        <label>密码</label>
        <div class="pwd-wrap">
          <input :type="showPwd ? 'text' : 'password'" v-model="password">
          <span class="pwd-eye" @click="showPwd = !showPwd">
            {{ showPwd ? '🙈' : '👁' }}
          </span>
        </div>
      </div>

      <button class="login-btn" @click="handleLogin">登录系统</button>
      <div class="tip">测试账号：`leader / 123456`、`member1 / 123456`</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      username: 'admin',
      password: '123456',
      showPwd: false
    }
  },
  methods: {
    handleLogin() {
      // 简单非空校验
      if (!this.username.trim() || !this.password.trim()) {
        alert('请输入用户名和密码')
        return
      }
      
      console.log('获取到的账号：', this.username)
      console.log('获取到的密码：', this.password)
      
      // 登录成功，跳转到布局主页面
      this.$router.push('/layout')
    }
  }
}
</script>

<style scoped>
.login-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #e1edf9 0%, #ffffff 50%, #e5e7eb 100%);
}

.login-box {
  width: 450px;
  background: #fff;
  padding: 40px;
  border-radius: 18px;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.08);
}

.logo {
  color: #606b7c;
  font-size: 16px;
  margin-bottom: 22px;
  font-weight: 800;
}

.title {
  font-size: 28px;
  font-weight: 700;
  color: #1f2937;
  margin-bottom: 24px;
}

.form-item {
  margin-bottom: 20px;
}

.form-item label {
  display: block;
  color: #4b5563;
  font-size: 14px;
  margin-bottom: 8px;
}

.form-item input {
  width: 100%;
  height: 38px;
  padding: 0 12px;
  border: 1px solid #d1d5db;
  border-radius: 6px;
  font-size: 14px;
  outline: none;
  box-sizing: border-box;
}

.form-item input:focus {
  border-color: #3b82f6;
}

.pwd-wrap {
  position: relative;
}

.pwd-eye {
  position: absolute;
  right: 12px;
  top: 50%;
  transform: translateY(-50%);
  color: #9ca3af;
  cursor: pointer;
  font-size: 16px;
}

.login-btn {
  width: 100%;
  height: 40px;
  background: #3b82f6;
  color: #fff;
  border: none;
  border-radius: 6px;
  font-size: 15px;
  cursor: pointer;
  margin-bottom: 20px;
}

.login-btn:hover {
  background: #2563eb;
}

.tip {
  color: #6b7280;
  font-size: 13px;
}
</style>