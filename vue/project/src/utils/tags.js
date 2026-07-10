export function statusTagType(status) {
  if (status === '进行中') return 'primary'
  if (status === '已完成') return 'success'
  return 'info'
}

export function priorityTagType(priority) {
  if (priority === '高') return 'danger'
  if (priority === '中') return 'warning'
  return 'info'
}
