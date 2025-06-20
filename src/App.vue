<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <nav class="nav-wrapper">
    <div class="nav-div">
      <div class="nav-title">SEA Catering</div>
      <ul class="nav-links">
        <li ><a href="#home" class="nav-subtitle">Home</a></li>
        <li ><a href="#MealPlan" class="nav-subtitle">Meal Plan</a></li>
        <li ><a href="#Subscription" class="nav-subtitle">Subscription</a></li>
        <li> <a href="#ContactUs" class="nav-subtitle">Contact Us</a></li>
      </ul>
    </div>
  </nav>

  <div>
    <a href="https://vite.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <HelloWorld msg="Vite + Vue" />
</template>

<style scoped>



.nav-subtitle {
  font-size: 2xl; /* text-xl */
  color: #000000; /* text-gray-600 */
  align-items: center;
  justify-content: space-between;
  font-family: 'Poppins', sans-serif;
}

.nav-title {
  position: relative;
  
  left: 0;
  font-size: 1.5rem; /* text-2xl */
  gap: 1.5rem;
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