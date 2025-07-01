

<script setup>
  import { useRoute } from 'vue-router';
  import { currentUser, isLogin } from './globalVariable';


  const route = useRoute()
</script>

<template>
  <div>
    <router-view />
  </div>

  <nav class="nav-wrapper">
    <div class="nav-div">
      <div class="nav-title">SEA Catering</div>
      <ul class="nav-links">
        <li v-if="route.path === '/'"><router-link to="/" class="nav-subtitle active">Home</router-link></li>
        <li v-else><router-link to="/" class="nav-subtitle">Home</router-link></li>
        <li v-if="route.path === '/meal-plans'"><router-link to="/meal-plans" class="nav-subtitle active">Meal Plans</router-link></li>
        <li v-else><router-link to="/meal-plans" class="nav-subtitle">Meal Plans</router-link></li>
        <li v-if="route.path === '/subscription'"><router-link to="/subscription" class="nav-subtitle active">Subscription</router-link></li>
        <li v-else><router-link to="/subscription" class="nav-subtitle">Subscription</router-link></li>
        <li v-if="route.path === '/contact-us'"><router-link to="/contact-us" class="nav-subtitle active">Contact Us</router-link></li>
        <li v-else><router-link to="/contact-us" class="nav-subtitle">Contact Us</router-link></li>
        <li v-if="route.path === '/dashboardAdmin' && currentUser.role === 'admin'"><router-link to="/dashboardAdmin" class="nav-subtitle active">Dashboard</router-link></li>
        <li v-else-if="route.path === '/dashboard' && currentUser.role === 'user'"><router-link to="/dashboard" class="nav-subtitle active">Dashboard</router-link></li>
        <li v-else-if="route.path !== '/dashboardAdmin' && currentUser.role === 'admin'"><router-link to="/dashboardAdmin" class="nav-subtitle">Dashboard</router-link></li>
        <li v-else-if="route.path !== '/dashboard' && currentUser.role === 'user'"><router-link to="/dashboard" class="nav-subtitle">Dashboard</router-link></li>
        <li v-else><router-link to="/dashboard" class="nav-subtitle">Dashboard</router-link></li>
      </ul>
    </div>
  </nav>
  
  <!--<HelloWorld msg="Vite + Vue" />-->
</template>

<style scoped>


.active {
  
  background-color: rgb(255, 255, 255); /* text-blue-600 */
  
  border-bottom: 2px solid #646cff; /* border-b-2 */
}



.nav-subtitle {
  font-size: 2xl; /* text-xl */
  color: #000000; /* text-gray-600 */
  align-items: center;
  justify-content: space-between;
  font-family: 'Poppins', sans-serif;
}

.nav-title {
  position: relative;
  display: flex;
  left: 0;
  font-size: 1.5rem; /* text-2xl */
  gap: 0.5rem; /* space-x-2 */
  font-weight: bold; /* font-bold */
  color: #333; /* text-gray-800 */
}

.nav-links {
  display: flex;
  position: relative;
  gap: 1.5rem; /* space-x-6 */
  right: 0;
  align-items: center;
  justify-content: space-between;
}


.nav-div{
  position: absolute;
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 72rem;  /* max-w-6xl = 1152px = 72rem */
  margin-left: auto; /* mx-auto: auto horizontal margin */
  margin-right: auto;
  top: 0;
  left: 0;
  right: 0;
  width: 100%; /* w-full */
  height: 100%;
}

.nav-wrapper {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw; /* w-screen */
  background-color: rgb(255, 255, 255);
  padding: 1.5rem; /* p-6 = 1.5rem */
  margin-right: 1rem; /* mr-4 = 1rem */
  z-index: 10;
  height: 1vw;
  justify-content: space-between;
  align-items: center;
  display: flex;
}


.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #41ab7baa);
}


</style>