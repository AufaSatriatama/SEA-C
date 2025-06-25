<template>
      <!--Untuk Nama-->
      <div class="">
        <input type="text" v-model="nama" placeholder="Masukkan Nama" class="input" />
      </div>

      <!-- Pesan -->
      <div class="">
        <textarea v-model="pesan" placeholder="Masukkan Pesan" class="input"></textarea>
      </div>

      <!-- Bintang -->
      <div class="">
        <label>
          <input type="radio" :value="1" v-model="rating" /> 1 Star
        </label>
        <label>
          <input type="radio" :value="2" v-model="rating" /> 2 Stars
        </label>
        <label>
          <input type="radio" :value="3" v-model="rating" /> 3 Stars
        </label>
        <label>
          <input type="radio" :value="4" v-model="rating" /> 4 Stars
        </label>
        <label>
          <input type="radio" :value="5" v-model="rating" /> 5 Stars
        </label>
      </div>
</template>

<style scoped>

</style>

<script setup>
import { ref } from 'vue';
const rating = ref(null);

</script>