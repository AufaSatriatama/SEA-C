<template>

  <div class="scrollable">
    <router-link to="/">Kembali ke Home</router-link>
    <div class="page">
      <!-- First Row -->
      <div class="row">
        <!---->
        <div class="mealPlanCard">
          <ImageCard namaMenu="Healthy Plan" :imageSrc="Menu1" />
        </div>

        <div class="mealPlanCard">
          <ImageCard namaMenu="Royal Plan" :imageSrc="Menu2" />
        </div>

        <div class="mealPlanCard">
          <ImageCard namaMenu="Protein Plan" :imageSrc="Menu3" />
        </div>
      </div>  


    </div>

    <div class="page">
      <!-- Untuk bikin testimoni-->
      <div class="title2">Write Your Testimonial Here!</div>

      <FormTestimonials></FormTestimonials>

    </div>

  </div>
</template>

<script setup>
  import { ref } from 'vue'
  import ImageCard from '../components/MealPlansPage/ImageCard.vue';
  import Menu1 from '../assets/Menu1.jpeg'
  import Menu2 from '../assets/Menu2.jpeg'
  import Menu3 from '../assets/Menu3.jpeg'
  import FormTestimonials from '../components/MealPlansPage/FormTestimonials.vue';



</script>

<style scoped>

.title2{
  font-weight: bold;
  font-family: poppins, sans-serif;
  font-size: 2.3rem; /* text-4xl */
  color: #333; /* text-gray-800 */
  text-align: center;
  justify-content: center;
  align-items: center;
}


.menuTitle {
  background-color: rgba(255, 255, 255, 0.7);
  color: black;
  margin-top: 0.5rem; /* opsional */
  text-align: center;
}


.imgFit {

  object-fit: cover;
  width: 100%;
  height: 90%;
  border-radius: 1rem;
  background-color: rgb(255, 255, 255);
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

.mealPlanCard{
  overflow: hidden;
  width: 70vw;
  height: 80vh;
  border-radius: 1rem;
  background-color: rgb(255, 255, 255);
}

.row{
  gap: 1rem;
  position: relative;
  padding-left: 1rem;
  padding-right: 1rem;
  display: flex;
  background-color: rgb(255, 255, 255);
  justify-content: space-between;
  align-items: center;
  height: 70vh;
  width: 80vw;
  flex-direction: row;
}

.page{
  
  background-color: rgb(255, 255, 255);
  width: 100vw; /* w-screen */

  min-height: 100vh; /* h-screen */
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  gap: 1rem; /* space-y-8 */
 
  
}
</style>


