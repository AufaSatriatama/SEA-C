<template>
      <!--Untuk Nama-->
      <form @submit.prevent="handleSubmit">
        <div class="">
          <input type="text" v-model="nama" placeholder="Masukkan Nama" class="input" />
        </div>

        <!-- Pesan -->
        <div class="">
          <textarea v-model="pesan" placeholder="Masukkan Pesan" class="input"></textarea>
        </div>

        <!-- Bintang -->
         <p class="setWarnaHitam">Masukkan Bintang</p>
        <div class="setWarnaHitam">
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

        <button type="submit">Submit</button>
      </form>


</template>

<style scoped>
.input {
  width: 100%;
  padding: 0.5rem;
  margin-bottom: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.setWarnaHitam {
  color: black;
}

</style>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
const rating = ref(null);


const nama = ref('');
const pesan = ref('');
const handleSubmit = async () => {
  try {
    const response = await axios.post('http://localhost:8080/Testimonials', {
      name: nama.value,
      message: pesan.value,
      rating: rating.value
    }, {withCredentials: true});
    console.log('Testimonial submitted:', response.data);

    //Clear the form
    nama.value = '';
    pesan.value = '';
    rating.value = null;
  } catch (error) {
    console.error('Error submitting testimonial:', error);
  }
}

</script>