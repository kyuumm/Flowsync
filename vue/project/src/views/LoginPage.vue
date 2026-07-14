<template>
  <div class="login-container">
    <div class="login-box">
      <div class="logo">FlowSync</div>
      <div class="title">智能任务编排与协同执行平台</div>

      <div class="form-item">
        <label>用户名</label>
        <!-- 和老师对齐：绑定 data.user 下的字段 -->
        <input type="text" v-model="data.user.username">
      </div>

      <div class="form-item">
        <label>密码</label>
        <div class="pwd-wrap">
          <input :type="data.showPwd ? 'text' : 'password'" v-model="data.user.password">
          <span class="pwd-eye" @click="data.showPwd = !data.showPwd">
            {{ data.showPwd ? '🙈' : '👁' }}
          </span>
        </div>
      </div>

      <button class="login-btn" @click="handleLogin">登录系统</button>
      <div class="tip">测试账号：`leader / 123456`、`member1 / 123456`</div>
    </div>
  </div>
</template>

<!-- 和老师对齐：使用 script setup 组合式语法 -->
<script setup>
import { reactive } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'

// 路由实例，替代选项式里的 this.$router
const router = useRouter()

// 响应式数据，和老师的结构完全一致
const data = reactive({
  user: {
    username: 'leader',
    password: '123456'
  },
  showPwd: false
})

// 登录方法
const handleLogin = () => {
  // 非空校验
  if (!data.user.username.trim() || !data.user.password.trim()) {
    ElMessage.warning('请输入用户名和密码')
    return
  }

  // 调用后端登录接口，和老师写法完全对齐
  axios.post('/api/user/login', data.user).then((res) => {
    console.log(res.data)
    if (res.data.success) {
      // 登录成功，跳转到布局主页面
      router.push('/layout')
    } else {
      ElMessage.error('登录失败！')
    }
  })
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