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
    import { currentUser, isLogin } from '../globalVariable';
    import { useRouter } from 'vue-router';

    const router = useRouter();

    const userRepository = ref([]);

    let dehashedPassword = "";


    function hash(password, offset = 5) {
    let result = "";
    for (let i = 0; i < password.length; i++) {
        const charCode = password.charCodeAt(i);
        result += String.fromCharCode(charCode + offset);
    }
    return result;
    }

    const getUserRepository = async () => {
        try {
            const response = await axios.get('http://localhost:8080/User');
            userRepository.value = []
            response.data.forEach(user => {
                
                if (user.email && user.password) { // Ensure email and password exist
                    userRepository.value.push({
                        username: user.username,
                        email: user.email,
                        password: user.password,
                        role: user.role
                    
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
            const thisUser = userRepository.value[i];

            let hashedPassword = hash(password.value);

            if (thisUser.email == email.value && hashedPassword == thisUser.password){
                isLogin.value = true;
                console.log('Login successful:', thisUser);

                //Salin value ke currentUser
                currentUser.value = { ...thisUser };

                if (thisUser.role == "admin"){
                    router.push('/dashboardAdmin');
                }else{
                    router.push('/dashboard');
                }

                break;

                 
            }else if (i == userRepository.value.length - 1) {
                isLogin.value = false;
                

                if (email.value === '' || password.value === '') {
                    alert('Email and password cannot be empty');
                } else if (currentUser.email !== email.value) {
                    alert('Email not found');
                } else if (hashedPassword !== currentUser.password) {
                    alert('Incorrect password');
                    console.log('Password submitted:', password.value);
                    console.log('Hashed password:', hashedPassword);
                    console.log('Password in repository:', currentUser.password);
                }else {
                    alert('Login failed: Error tidak diketahui');
                }
               
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