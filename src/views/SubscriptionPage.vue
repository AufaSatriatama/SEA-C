<template>

    <div class="form-container">
        <FormSubscription />
    </div>

</template>

<style scoped>

.form-container {
    flex-direction: column;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
    width: 100vw; /* Full viewport width */
    background-color: #807373; /* Light background for contrast */
}

</style>

<script setup>
import { ref } from 'vue';
import FormSubscription from '../components/SubscriptionPage/FormSubscription.vue';
</script>