<template>
  <div class="scrollable">
    <!--Halaman 1-->
    <div class="page">
      <div class="title">Healthy Meals, Anytime, Anywhere</div>
    </div>
    <!--Halaman 2-->
    <div class="page">
      <!--Bikin div di center-->
      <p class="title2">Why Us?</p>
      <div class="centerRow">
        <SisiKiri :items="items" @hover-item="setHovered" />
        
      </div>
    </div>

    <!--Halaman 3 (Untuk testimoni) -->
    <div class="page">
      <div class="centerColumn">
        <div class="title2">Testimonials</div>
        
          <!--Isinya: Bintang, komen, nama pengguna -->
        <Testimonials></Testimonials>
       
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

.centerColumn {
  display: flex;
  width: 50vw;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
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
  position: relative;
  background-color: wheat;
  width: 100vw; /* w-screen */
  height: 30vh; /* h-screen */
  bottom: 0;
  align-items: center;
  justify-content: space-between;
  padding-left: 20px;
  display: flex;
  margin-top: auto;
  flex-direction: row;
}

.page{
  
  background-color: rgb(255, 255, 255);
  width: 100%; /* w-screen */

  min-height: 100vh; /* h-screen */
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
  
  width: 100%; /* w-screen */
  min-height: 100vh;
  overflow-y: auto;
  overflow-x: hidden;
      
  
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
      
}

.link {
  color: rgb(0, 0, 0);
  text-decoration: underline;
  background-color: aqua;
}

.bb {
  color: rgb(0, 0, 0);
  font-size: 2rem;
}
</style>

<script setup>
import { ref } from 'vue'
import SisiKiri from '../components/HomePage/SisiKiri.vue';
import Testimonials from '../components/HomePage/Testimonials.vue';

const items = ['Meal Customization', 
                'Delivery to Major Cities', 
                'Detailed Nutritional Information']
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

