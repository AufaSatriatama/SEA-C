<template>
    <button @click="handleClickImage" class="imgFit"><img :src="imageSrc" class="imgFit" alt=""></button>
    <p class="menuTitle">{{ namaMenu }}</p>
</template>

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
  background-color: rgb(255, 255, 255);
}

</style>


<script setup>


defineProps({
  namaMenu: String,
  imageSrc: String
})

</script>