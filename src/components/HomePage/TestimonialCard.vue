<template>
    <div class="divColumn">
        <div class="name">{{ testimonial.name }}</div>
        <div class="message">{{ testimonial.message }}</div>
        <div class="rating">{{ testimonial.rating }} stars</div>
    </div>
</template>

<style scoped>

.divColumn {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    font-weight: bold;
    font-family: poppins, sans-serif;
    width: 50vw;
    border-width: 0.1rem;
    border-radius: 1rem;
    border-style: solid;
    border-color: rgb(200, 200, 200);
    gap: 1rem;
    background-color: rgb(255, 255, 255);
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