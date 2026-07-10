import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginPage')
  },
  {
    path: '/layout',
    name: 'layout',
    component: () => import('../views/LayoutPage'),
    children: [
      {
        path: '',
        name: 'welcome',
        component: () => import('../views/WelcomePage')
      },
      {
        path: 'project',
        name: 'project',
        component: () => import('../views/ProjectPage')
      },
      {
        path: 'decompose',
        name: 'decompose',
        component: () => import('../views/DecomposePage')
      },
      {
        path: 'task',
        name: 'task',
        component: () => import('../views/TaskPage')
      },
      {
        path: 'progress',
        name: 'progress',
        component: () => import('../views/ProgressPage')
      },
      {
        path: 'summary',
        name: 'summary',
        component: () => import('../views/SummaryPage')
      },
      {
        path: 'members',
        name: 'members',
        component: () => import('../views/MembersPage')
      },
      {
        path: 'profile',
        name: 'profile',
        component: () => import('../views/ProfilePage')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
