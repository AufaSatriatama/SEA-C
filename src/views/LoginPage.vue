<template>
    <div class="login-page">
        <form @submit.prevent="handleSubmit" class="centerColumn">
            <input type="email" v-model="email" placeholder="Email" required />
            <input type="password" v-model="password" placeholder="Password" required />
            <button type="submit">Login</button>
        </form>
    </div>
</template>

<script setup>

    const email = ref('');
    const password = ref('');

    import { computed, ref } from 'vue';
    import axios from 'axios';
    import { isLogin } from '../globalVariable';
    import { useRouter } from 'vue-router';

    const router = useRouter();

    const userRepository = ref([]);

    const getUserRepository = async () => {
        try {
            const response = await axios.get('http://localhost:8080/User');
            userRepository.value = []
            response.data.forEach(user => {
                if (user.email && user.password) { // Ensure email and password exist
                    userRepository.value.push({
                        username: user.username,
                        email: user.email,
                        password: user.password
                    });
                }
            });

            console.log('User repository[0] email:', userRepository.value[0].email);
        } catch (error) {
            console.error('Error fetching user repository:', error);
        }
    };

    getUserRepository();

    const handleSubmit = async () => {
        for (let i = 0; i < userRepository.value.length; i++){
            const currentUser = userRepository.value[i];

            if (currentUser.email == email.value && currentUser.password == password.value){
                isLogin.value = true;
                console.log('Login successful:', currentUser);
                router.push('/dashboard'); 
            }else{
                isLogin.value = false;
                fetchData();
                console.log('Login failed: Invalid email or password');
              
                console.log('Current username:', currentUser.username);
                console.log('Current password:', currentUser.password);
                console.log('Current email:', email.value);
                console.log('Current password:', password.value);
            }
        }
    }

    const fetchData = async () => {
        const res = await axios.get('http://localhost:8080/User')
      console.log('DATA DARI BACKEND:', res.data)
      console.log('User repository:', userRepository.value);
    console.log('User repository[0] email:', userRepository.value[0].email);

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

.login-page {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
    width: 100vw; /* Full viewport width */
    background-color: #b7d485; /* Light background for contrast */
}

</style>