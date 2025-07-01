<template>
    <button @click="showModal = true" class="imgFit"><img :src="imageSrc" class="imgFit" alt=""></button>
    <p class="menuTitle">{{ namaMenu }}</p>



    <div v-if="showModal" class="modal-overlay">
      <div class="modal">
        <h2 class="modal-title">Healthy Plan</h2>
        <div class="modal-image-container">
          <img :src="imageSrc" class="imgFit" alt="">
        </div>
        <p class="modal-content">This plan is good for you!</p>
        <button @click="showModal = false" class="modal-close-button">Tutup</button>
      </div>
    </div>



</template>

<style scoped> 

.modal-close-button {

  bottom: 1rem;
  position: absolute;
  background-color: #ffffff; 
  color: rgb(0, 0, 0);
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.modal-image-container {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 30vh;
}

.modal-title {
  position: relative;
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
  color: #333;
}

.modal-content {
  position: relative;
  font-size: 1rem;
  margin-bottom: 3rem;
  color: #333;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  justify-content: center;
  align-items: center;
  display: flex;
  top:7%;
  flex-direction: column;
  height: 75vh;
  position: relative;
  background-color: white;
  padding: 1.5rem;
  border-radius: 8px;
  width: 300px;
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

</style>


<script setup>

import { ref } from 'vue'
import { showModal } from '../../globalVariable';

defineProps({
  namaMenu: String,
  imageSrc: String
})

</script>