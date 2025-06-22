<template>
  <div class="sisi-kanan">
    <p v-if="text" class="textSetting">{{ text }}</p>
    <p v-else class="textSetting">Kami adalah penyedia jasa katering professional, melayani dengan penuh tanggung jawab</p>
  </div>
</template>

<script setup>
defineProps(['text'])
</script>

<style>


.textSetting {
  color: #000000;
  font-size: 1rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
  font-weight: bold;
  font-family: poppins, sans-serif;
  position: absolute;
}

.sisi-kanan{
  justify-content: center;
  align-items: center;
  position: relative;
  text-align: center;
  height: 19vh;
  width: 60vw;
  background-color: #ffffff;
  padding: 1rem;
}
</style>
