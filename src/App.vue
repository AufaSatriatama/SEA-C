

<script setup>
import { ref } from 'vue'
import HelloWorld from './components/HelloWorld.vue'
import SisiKanan from './components/SisiKanan.vue';
import SisiKiri from './components/SisiKiri.vue';

const items = ['Meal Customization', 
                'Delivery Service', 
                'Nutritional Information']
const descriptions = [
  'Berbagai pilihan menu sehat yang dapat disesuaikan dengan kebutuhan diet Anda.',
  'Dari Banda Aceh hingga Jayapura, kami siap mengantarkan makanan sehat ke seluruh Indonesia.',
  'Dapatkan informasi lengkap tentang kandungan gizi setiap hidangan yang kami tawarkan.'
]

const hoveredIndex = ref(null)
function setHovered(index) {
  hoveredIndex.value = index
}

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

  <div class="scrollable">
    <!--Halaman 1-->
    <div class="page">
      <div class="title">Healthy Meals, Anytime, Anywhere</div>
    </div>
    <!--Halaman 2-->
    <div class="page">
      <!--Bikin div di center-->
      <p class="title2">Our Services</p>
      <div class="centerRow">
        <SisiKiri :items="items" @hover-item="setHovered" />
        <SisiKanan :text="descriptions[hoveredIndex]" />
      </div>
      

    </div>
    <!--Bagian Kontak-->
    <div class="kontak">
      <!--Ini untuk nama dan nomor telepon-->
      <div class="subtitle">
        <ul class="listKontak">
          <li>Contact Us</li>
          <li>Brian</li>
          <li>081234567890</li>
          
        </ul>
      </div>
      <!--Ini untuk logo-->
      <div></div>
    </div>
    
  </div>



  
  <!--<HelloWorld msg="Vite + Vue" />-->
</template>

<style scoped>

.abc{
  color: black;
  font-size: 2rem; /* text-2xl */
}

.centerRow {
  display: flex;
  width: 50vw;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: row;
}

.listKontak{
  list-style: none;
  display: flex;
  flex-direction: column;
  gap: 1rem; /* space-y-4 */
  padding: 10px;
  margin: 0;
}

.subtitle{
  font-size: 2xl; /* text-2xl */
  color: #000000; /* text-gray-600 */
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  text-align: center;
  justify-content: center;
  align-items: center;
  display: flex;
}

.kontak{
  background-color: wheat;
  width: 100vw; /* w-screen */
  height: 30vh; /* h-screen */
  align-items: center;
  justify-content: space-between;
  padding-left: 20px;
  display: flex;
  flex-direction: row;
}

.page{
  
  background-color: rgb(255, 255, 255);
  width: 100vw; /* w-screen */

  height: 100vh; /* h-screen */
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  gap: 2rem; /* space-y-8 */
 
  
}

.title2{
  font-weight: bold;
  font-family: poppins, sans-serif;
  font-size: 2.3rem; /* text-4xl */
  color: #333; /* text-gray-800 */
  text-align: center;
  justify-content: center;
  align-items: center;
}


.title{
  display: flex;
  font-weight: bold;
  font-family: poppins, sans-serif;
  font-size: 3rem; /* text-4xl */
  color: #333; /* text-gray-800 */
  text-align: center;
  justify-content: center;
  align-items: center;
}



.scrollable {
  position: relative;

  left: 0;
  right: 0;
  
  width: 100vw; /* w-screen */
  overflow-y: hidden;
  overflow-x: hidden;
      
  
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
      
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