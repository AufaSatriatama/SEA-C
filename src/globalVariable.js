import { ref } from "vue";

import axios from "axios";
export let indexDb = ref(0);
export let isLogin = ref(false);
export let indexSubscription = ref(0);
export let showModal = ref(false);

const username = ref('');
const email = ref('');
const password = ref('');
let passwordHashed = "";
let role = "";

export let currentUser = ref({
    username: '',
    email: '',
    password: '',
    role: ''
});

function hash(password, offset = 5) {
  
  for (let i = 0; i < password.length; i++) {
    const charCode = password.charCodeAt(i);
    passwordHashed += String.fromCharCode(charCode + offset);
  }
  return passwordHashed;
}

export const initAdminAccount = async () => {
    try{
        const newUser = {
            username: 'Admin',
            email: 'admin@example.com',
            password: hash('admin123'),
            role: "admin"
        };
        await axios.post('http://localhost:8080/User', newUser);

        username.value = '';
        email.value = '';
        password.value = '';
        console.log('User created successfully:', newUser);
    }catch (error){
        console.error('Error occurred while creating user:', error);
    }
}