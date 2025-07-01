<template>
    <div class="page">

        <div v-if="isLogin == true">
            <div class="logged-in-message">Admin's Dashboard</div>

            <div v-if="listSubscription.value?.length === 0" class="color">No active subscriptions found.</div>

            <div v-else>
                <p class="color">List of Subscribers</p>
                <div v-for="subscription in listSubscription" :key="subscription.id">
                    <div class="color">{{ subscription.name }}</div>
                </div>


                <div class="color">Test</div>
            </div>
        </div>

        <div v-else>
            <div class="centerRow">
                <router-link to="/RegisterPage">
                    <button>Register</button>
                </router-link>

                <router-link to="/LoginPage">
                    <button>Login</button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<style scoped>

.logged-in-message {
    color: #333;
    font-size: 1.5rem;
    font-weight: bold;
}

.color {
    color: #333;
    font-size: 1.2rem;
    font-weight: bold;
    background-color: rgb(255, 255, 255);
}


.centerRow {
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: row;
    background-color: rebeccapurple;
    gap: 1rem;
}

.page{
  
  background-color: rgb(255, 255, 255);
  width: 100%; /* w-screen */

  min-height: 100vh; /* h-screen */
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  gap: 2rem; /* space-y-8 */
 
  
}

</style>

<script setup>
import axios from 'axios';
import { ref, reactive, onUnmounted } from 'vue';
import { indexSubscription } from '../globalVariable';

    const listSubscription = ref([]);

    const fetchSubscription = async () => {
       if (!isLogin) return;

       listSubscription.value = []; // Clear previous subscriptions
       try {
           const response = await axios.get('http://localhost:8080/Subscriptions');

           if (indexSubscription.value == 0){
            indexSubscription.value = response.data.length-1;
           }

            for (let i = indexSubscription.value; i < response.data.length; i++) {
                listSubscription.value.push(response.data[i]);
           }

           console.log('List Subscription:', listSubscription);
           console.log('List Subscription length:', listSubscription.value?.length);

           //listSubscription = response.data;
           console.log('Subscriptions fetched:', listSubscription);
       } catch (error) {
           console.error('Error fetching subscriptions:', error);
       }
   };

    import { onMounted } from 'vue';
    import { isLogin } from '../globalVariable';

    onMounted(() => {
        fetchSubscription();
    })



</script>