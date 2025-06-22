

<script setup>

</script>

<template>
  <div>
    <router-view />
  </div>

  <nav class="nav-wrapper">
    <div class="nav-div">
      <div class="nav-title">SEA Catering</div>
      <ul class="nav-links">
        <li ><router-link to="/" class="nav-subtitle">Home</router-link></li>
        <li><router-link to="/meal-plans" class="nav-subtitle">Meal Plans</router-link></li>
        <li><router-link to="/subscription" class="nav-subtitle">Subscription</router-link></li>
        <li><router-link to="/contact-us" class="nav-subtitle">Contact Us</router-link></li>
      </ul>
    </div>
  </nav>
  
  <!--<HelloWorld msg="Vite + Vue" />-->
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