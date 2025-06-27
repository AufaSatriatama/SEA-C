<template>
    <div class="register-page">
        <form @submit.prevent="handleSubmit" class="centerColumn">
            <input type="text" v-model="username" placeholder="Full name" required />
            <input type="email" v-model="email" placeholder="Email" required />
            <input type="password" v-model="password" placeholder="Password" required />
            <p>minimum 8 characters, must include uppercase, lowercase, number, and special character</p>
            <button type="submit">Register</button>
        </form>
    </div>

    <div>
        <button @click="fetchData">Fetch Data</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { isLogin } from '../globalVariable';


const username = ref('');
const email = ref('');
const password = ref('');




const handleSubmit = async () => {
    // Handle form submission
    console.log('Form submitted:', { username, email, password });

    try{
        const newUser = {
            username: username.value,
            email: email.value,
            password: password.value
        };
        await axios.post('http://localhost:8080/User', newUser);

        username.value = '';
        email.value = '';
        password.value = '';
        console.log('User created successfully:', newUser);
    }catch (error){
        console.error('Error occurred while creating user:', error);
    }
};

    const fetchData = async () => {
        const res = await axios.get('http://localhost:8080/User')
      console.log('DATA DARI BACKEND:', res.data)
    }
</script>

<style scoped>

.centerColumn {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    gap: 1rem; /* Space between elements */
}

.register-page {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
    width: 100vw; /* Full viewport width */
    background-color: #8d5353; /* Light background for contrast */
}

</style>