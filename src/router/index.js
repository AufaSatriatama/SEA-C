import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import MealPlansPage from '../views/MealPlansPage.vue'
import SubscriptionPage from '../views/SubscriptionPage.vue'
import ContactPage from '../views/ContactPage.vue'
import DashboardPage from '../views/DashboardPage.vue'

const routes = [
  { path: '/', component: HomePage },
  { path: '/meal-plans', component: MealPlansPage },
  { path: '/subscription', component: SubscriptionPage },
  { path: '/contact', component: ContactPage },
  { path: '/dashboard', component: DashboardPage }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
