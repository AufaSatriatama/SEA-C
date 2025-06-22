<template>

  <div class="scrollable">
    <router-link to="/">Kembali ke Home</router-link>
    <div class="page">
      <!-- First Row -->
      <div class="row">
        <!---->
        <div class="mealPlanCard">
          <img src="../assets/Menu1.jpeg" class="imgFit" alt="">
          <p class="menuTitle">Menu 1</p>
        </div>

        <div class="mealPlanCard">
          <img src="../assets/Menu2.jpeg" class="imgFit" alt="">
          <p class="menuTitle">Menu 2</p>
        </div>

        <div class="mealPlanCard">
          <img src="../assets/Menu3.jpeg" class="imgFit" alt="">
          <p class="menuTitle">Menu 3</p>
        </div>
      </div>  
    </div>

  </div>
</template>

<script>
  import { ref } from 'vue'
</script>

<style scoped>

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
  gap: 2rem; /* space-y-8 */
 
  
}
</style>


