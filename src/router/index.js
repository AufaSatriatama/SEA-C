import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import MealPlansPage from '../views/MealPlansPage.vue'
import SubscriptionPage from '../views/SubscriptionPage.vue'
import ContactPage from '../views/ContactPage.vue'
import Dashboard from '../views/Dashboard.vue'
import DashboardAdminPage from '../views/DashboardAdminPage.vue'
import LoginPage from '../views/LoginPage.vue'
import RegisterPage from '../views/RegisterPage.vue'

const routes = [
  { path: '/', component: HomePage },
  { path: '/meal-plans', component: MealPlansPage },
  { path: '/subscription', component: SubscriptionPage },
  { path: '/contact', component: ContactPage },
  { path: '/dashboard', component: Dashboard },
  { path: '/dashboardAdmin', component: DashboardAdminPage },
  { path: '/loginPage', component: LoginPage },
  { path: '/registerPage', component: RegisterPage },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
