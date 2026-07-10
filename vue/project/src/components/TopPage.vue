<template>
  <div class="top" >
    <div class="title">XX管理系统</div>
    <div style="flex: 1;"></div>
    <div class="welcome">
      <el-dropdown :hide-on-click="false">
    <span class="el-dropdown-link">
      欢迎   登录<el-icon class="el-icon--right"><arrow-down /></el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>


  </div>
</template>

<style scoped>
.top{
  background-color: darkcyan;
  width: 100%;
  height: 80px;
  display: flex;
}
.title{
  margin-left: 30px;
  font-size: 40px;
  font-weight: bold;
  color: white;
  font-family: 华文楷体;
  justify-content: center;
  align-items: center;
  display: flex;
  text-shadow: 2px 2px #000;
}
.welcome{
  justify-content: center;
  align-items: center;
  color: white;
  width: 150px;
  display: flex;
}
.el-dropdown{
  color: white;
  cursor: pointer;
}
</style>
