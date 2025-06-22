import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import MealPlansPage from '../views/MealPlansPage.vue'

const routes = [
  { path: '/', component: HomePage },
  { path: '/meal-plans', component: MealPlansPage },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
