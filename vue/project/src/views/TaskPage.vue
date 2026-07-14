<template>
  <div class="page">
    <PageHeader title="任务管理" subtitle="维护任务、负责人、状态与截止时间" />

    <div class="page-body">
      <div class="content-card">
        <div class="card-header">
          <span class="card-title">任务列表</span>
          <!-- 对齐官网：按钮点击直接打开弹窗 -->
          <el-button type="primary" @click="dialogFormVisible = true">新建任务</el-button>
        </div>

        <el-table :data="tasks" stripe style="width: 100%">
          <el-table-column prop="title" label="任务标题" min-width="140" />
          <el-table-column prop="projectId" label="项目ID" width="100" />
          <el-table-column prop="assigneeId" label="负责人ID" width="100" />
          <el-table-column prop="status" label="状态" width="90">
            <template #default="{ row }">
              <el-tag :type="statusTagType(row.status)" size="small">{{ row.status }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="priority" label="优先级" width="80">
            <template #default="{ row }">
              <el-tag :type="priorityTagType(row.priority)" size="small" effect="plain">
                {{ row.priority }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="dueDate" label="截止日期" width="160" />
          <el-table-column prop="description" label="任务说明" min-width="200" show-overflow-tooltip />
          <el-table-column label="操作" width="180" fixed="right">
            <template #default="{ row }">
              <el-button link type="primary" @click="handleView(row)">查看</el-button>
              <el-button link type="primary" @click="handleEdit(row)">编辑</el-button>
              <el-button link type="danger" @click="handleDelete(row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>

  <!-- ========== 1. 查看详情弹窗 ========== -->
  <el-dialog
    v-model="dialogDetailVisible"
    title="任务详情"
    width="500"
    :before-close="handleDetailClose"
  >
    <!-- 用 el-form 展示详情，disabled 设为只读 -->
    <el-form :model="detailForm" label-width="100px" disabled>
      <el-form-item label="任务标题">
        <el-input v-model="detailForm.title" />
      </el-form-item>
      <el-form-item label="所属项目">
        <el-input v-model="detailForm.projectId" />
      </el-form-item>
      <el-form-item label="负责人">
        <el-input v-model="detailForm.assigneeId" />
      </el-form-item>
      <el-form-item label="任务状态">
        <el-tag :type="statusTagType(detailForm.status)" size="small">{{ detailForm.status }}</el-tag>
      </el-form-item>
      <el-form-item label="优先级">
        <el-tag :type="priorityTagType(detailForm.priority)" size="small" effect="plain">{{ detailForm.priority }}</el-tag>
      </el-form-item>
      <el-form-item label="截止日期">
        <el-input v-model="detailForm.dueDate" />
      </el-form-item>
      <el-form-item label="任务说明">
        <el-input v-model="detailForm.description" type="textarea" :rows="3" />
      </el-form-item>
    </el-form>

    <!-- 底部插槽 -->
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogDetailVisible = false">关闭</el-button>
      </div>
    </template>
  </el-dialog>

  <!-- ========== 2. 新建任务表单弹窗 ========== -->
<!-- ========== 2. 新建/编辑任务共用表单弹窗 ========== -->
<el-dialog v-model="dialogFormVisible" :title="isEdit ? '编辑任务' : '新建任务'" width="500">
  <el-form :model="form" :label-width="formLabelWidth">
    <el-form-item label="任务标题">
      <el-input v-model="form.title" autocomplete="off" />
    </el-form-item>
    <el-form-item label="所属项目">
      <el-select v-model="form.projectId" placeholder="请选择项目">
        <el-option label="迎新活动项目" :value="1" />
        <el-option label="课程答辩项目" :value="2" />
      </el-select>
    </el-form-item>
    <el-form-item label="负责人">
      <el-select v-model="form.assigneeId" placeholder="请选择负责人">
        <el-option label="张三" :value="2" />
        <el-option label="李四" :value="3" />
      </el-select>
    </el-form-item>

    <el-form-item label="任务状态">
      <el-select v-model="form.status" placeholder="请选择状态">
        <el-option label="未开始" value="未开始" />
        <el-option label="进行中" value="进行中" />
      </el-select>
    </el-form-item>

    <el-form-item label="优先级">
      <el-select v-model="form.priority" placeholder="请选择优先级">
        <el-option label="高" value="高" />
        <el-option label="中" value="中" />
        <el-option label="低" value="低" />
      </el-select>
    </el-form-item>
    <el-form-item label="截止日期">
      <el-date-picker
        v-model="form.dueDate"
        type="date"
        placeholder="选择日期"
        value-format="YYYY-MM-DD"
        style="width: 100%"
      />
    </el-form-item>
    <el-form-item label="任务说明">
      <el-input v-model="form.description" type="textarea" :rows="3" />
    </el-form-item>
  </el-form>

  <template #footer>
    <div class="dialog-footer">
      <el-button @click="resetForm">取消</el-button>
      <el-button type="primary" @click="submitForm">确认</el-button>
    </div>
  </template>
</el-dialog>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import PageHeader from '@/components/PageHeader.vue'
import { statusTagType, priorityTagType } from '@/utils/tags'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { ElMessageBox } from 'element-plus'

// ===================== 数据定义 =====================
const tasks = ref([])

// 1. 详情弹窗相关
const dialogDetailVisible = ref(false)
const detailForm = reactive({
  id: null,
  title: '',
  projectId: '',
  assigneeId: '',
  status: '',
  priority: '',
  dueDate: '',
  description: ''
})

// 2. 表单弹窗相关（新建/编辑共用）
const dialogFormVisible = ref(false)
const formLabelWidth = '100px'
const isEdit = ref(false) // 模式标识：true=编辑，false=新建

// 表单初始默认值（统一管理，重置时复用）
const defaultForm = {
  id: null,
  title: '',
  projectId: '',
  assigneeId: '',
  status: '未开始',
  priority: '',
  dueDate: '',
  description: ''
}
const form = reactive({ ...defaultForm })

// ===================== 方法 =====================
// 加载任务列表
const load = () => {
  axios.post('/api/task/list').then((res) => {
    if (res.data.success) {
      tasks.value = res.data.data
    } else {
      ElMessage.error('加载任务失败！')
    }
  }).catch(() => {
    ElMessage.error('加载任务失败！')
  })
}

// 查看详情
const handleView = (row) => {
  Object.assign(detailForm, row)
  dialogDetailVisible.value = true
}

const handleDetailClose = () => {
  dialogDetailVisible.value = false
  Object.keys(detailForm).forEach(key => detailForm[key] = '')
}

// 编辑任务：回填数据 + 切换模式 + 打开弹窗
const handleEdit = (row) => {
  // 深拷贝行数据到表单，避免直接修改表格原数据
  Object.assign(form, row)
  isEdit.value = true
  dialogFormVisible.value = true
}

// 重置表单并关闭弹窗（新建/编辑通用）
const resetForm = () => {
  dialogFormVisible.value = false
  // 恢复为初始默认值
  Object.assign(form, defaultForm)
  // 清除编辑模式
  isEdit.value = false
}

// 提交表单（新建/编辑通用入口）
const submitForm = () => {
  if (!form.title.trim()) {
    ElMessage.warning('请输入任务标题')
    return
  }

  // 根据模式选择接口地址
  const apiUrl = isEdit.value ? '/api/task/update' : '/api/task/save'
  // 编辑模式必须携带id，后端通过id定位更新数据
  const requestData = isEdit.value ? { ...form } : form

  axios.post(apiUrl, requestData)
    .then((res) => {
      if (res.data.success) {
        ElMessage.success(isEdit.value ? '编辑任务成功' : '新建任务成功')
        resetForm()
        load() // 刷新列表
      } else {
        ElMessage.error(res.data.message || '操作失败')
      }
    })
    .catch(() => {
      ElMessage.error('操作失败，请检查网络或服务状态')
    })
}

// 删除任务
const handleDelete = (row) => {
  ElMessageBox.confirm(`确定要删除任务「${row.title}」吗？`, '删除确认', {
    confirmButtonText: '确定删除',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    axios.get(`/api/task/delete/${row.id}`).then((res) => {
      if (res.data.success) {
        ElMessage.success('删除成功')
        load()
      } else {
        ElMessage.error('删除失败')
      }
    }).catch(() => {
      ElMessage.error('删除失败')
    })
  }).catch(() => {})
}

onMounted(() => {
  load()
})
</script>

<style scoped>
.page {
  min-height: 100%;
  display: flex;
  flex-direction: column;
}

.page-body {
  flex: 1;
  padding: 24px 32px;
  background: #f3f4f6;
}

.content-card {
  background: #fff;
  border-radius: 12px;
  padding: 20px 24px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}

.card-title {
  font-size: 16px;
  font-weight: 600;
  color: #111827;
}
</style>