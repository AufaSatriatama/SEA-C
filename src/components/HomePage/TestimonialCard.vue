<template class="template">
    <div class="center">
        <div class="divColumn">
            <div class="name">{{ testimonial.name }}</div>
            <div class="message">{{ testimonial.message }}</div>
            <div class="rating">{{ testimonial.rating }} stars</div>
        </div>
    </div>
</template>

<style scoped>

.center {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%; /* Ensure it fills the container */
  background-color: rgb(255, 255, 255); /* Light background for contrast */
  border: solid 1px wheat; /* Border for visibility */
  border-radius: 8px; /* Rounded corners */
}   

.template {
  width: 100%;
  max-width: 500px;
  height: 100%; /* Ensure it fills the container */
  overflow: hidden;
  align-items: center;
  justify-content: center;
  display: flex;
  padding: 1rem;
  background: white;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  border: 1px solid #000000;
  border-radius: 8px;
}

.divColumn {
    width: 100%;
    justify-content: center;
    align-items: center;
    display: flex;
    flex-direction: column;

}

.name {
    font-weight: bold;
    color: #000000;

    
}

.message {
    color: #000000;
}

.rating {
    color: #000000;
}

</style>

<script setup>
   
import { ref } from 'vue'

defineProps({
    testimonial: {
        type: Object,
        required: true
    }
})

</script>